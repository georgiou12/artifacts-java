///////
class askisijava{
    public static void main(String[] args){
        int N=Integer.parseInt(args[0]);            //put first argument in N
        String movement=args[1];                    //put second argument in movement
        artifact[] artiarray=new artifact[N];       //create the array of artifacts
        int randomInt=0,randomYear=0,randomCond=0,randomMove=0,randomTech=0,randomMat=0;
        String mymovement="",mycondition="",mytech="",mymat="";
        int leng=0,wid=0,vol=0;
        for(int i=0;i<N;i++){
            randomInt=(int)Math.floor(Math.random()*(2)+1);         //pick random between 1 and 2
            randomYear=(int)Math.floor(Math.random()*(40)+1980);    //between 1980 and 2020
            randomCond=(int)Math.floor(Math.random()*(3)+1);        //between 1 and 3
            if(randomCond==1){                 //choose for condition
                mycondition="bad";
            }
            else if(randomCond==2){
                mycondition="good";
            }
            else{
                mycondition="excellent";
            }
            randomMove=(int)Math.floor(Math.random()*(3)+1);    //pick random between 1 and 3
            if(randomMove==1){                 //choose for movement
                mymovement="impressionism";
            }
            else if(randomMove==2){
                mymovement="expressionism";
            }
            else{
                mymovement="naturalism";
            }
            if(randomInt==1){
                randomTech=(int)Math.floor(Math.random()*(3)+1);    //to create painting pick a technique
                if(randomTech==1){
                    mytech="oil";
                }
                else if(randomTech==2){
                    mytech="aquarelle";
                }
                else{
                    mytech="tempera";
                }
                leng=(int)Math.floor(Math.random()*(100)+1);    //and length and  width
                wid=(int)Math.floor(Math.random()*(100)+1);
                artiarray[i]=new painting(i,2002,mymovement,mycondition,leng,wid,mytech);   //create a painting
            }
            else{
                if(randomMat==1){           //else pick a material to create a sculpture
                    mymat="iron";
                }
                else if(randomMat==2){
                    mymat="stone";
                }
                else{
                    mymat="wood";
                }
                vol=(int)Math.floor(Math.random()*(100)+1);
                artiarray[i]=new sculpture(i,randomYear,mymovement,mycondition,vol,mymat);
            }
        }
        if(args.length>2){                  //if cmd has 3 arguments then put third in condition
            String condition=args[2];
            auction(artiarray,movement,condition,N);    //call auction with 4 arguments wich 3 from cmd
        }
        else{
            auction(artiarray,movement, N);     //call auction with 3 arguments wich 2 ar from cmd
        }
    }

    //////////artifact//////////

    public static class artifact{           
        protected 
            int index;
            String creator="Creator";
            int year;
        public artifact(){};
        public void getInfo(){System.out.print(creator+index + " the year:" + year);};
        public void getIndex(){System.out.println("Index:"+index);};
        public boolean evaluate(String move,String cond){return false;}; //one evaluate to use on 4 arguments auction
        public boolean evaluate(String move){return false;};        //and another one to use on 3 arguments auction
    }

    //////////masterpiece//////////

    public static class masterpiece extends artifact{
        protected
            String movement;
            String condition;
        public masterpiece(){};
        public void getInfo(){
            super.getInfo();            //call the get info of artifact
            System.out.print(" movement:"+movement+" condition:"+condition);};
        public boolean evaluate(String move,String cond){return false;};    //here we override the two evaluate
        public boolean evaluate(String move){return false;};
    }

    //////////painting//////////
    
    final public static class painting extends masterpiece{
        protected
            int length;
            int width;
            int surface=0;
            String technique;
        public painting(int number,int myear,String move,String cond,int leng,int wid,String tech){
            index=number; year=myear; movement=move; condition=cond;
            length=leng; width=wid; technique=tech; surface=length*width;
            System.out.println("Creating an instance of painting");
        };
        public void getInfo(){
            super.getInfo();        //call getInfo of masterpiece that calls getInfo of artifact
            System.out.println(" surface:"+length*width);
        };
        public boolean evaluate(String move,String cond){       //evaluate with 2 arguments for
            if(cond.equals("good")){                            //auction with 4
                if(condition.equals("good") || condition.equals("excellent")){
                    if(movement.equals(move)){
                        return true;
                    }
                }
            }
            else if(cond.equals("excelent")){
                if(condition.equals("excellent") && move.equals(movement)){
                    return true;    
                }
            }
            return false;
        };
        public boolean evaluate(String move){          //evaluate with 1 argument for auction with 3
            //we take as default that cond="good" as deafault so:
            if (move.equals(movement)){
                if(condition.equals("good") || condition.equals("excellent")){
                    return true;
                }
            }
            return false;
        };
    }

    //////////sculpture//////////

    final public static class sculpture extends masterpiece{
        protected
            int volume;
            String material;
        public sculpture(int number,int myear,String move,String cond,int vol,String mat){
            index=number; year=myear; movement=move; condition=cond; 
            volume=vol; material=mat;
            System.out.println("Creating an instance of sculpture");
        };
        public void getInfo(){
            super.getInfo();        //same:calls getInfo of masterpiece that calls getInfo from artifact
            System.out.println(" volume:"+volume);
        };
        public boolean evaluate(String move,String cond){   //again declare two evaluate but with different 
            if(move.equals(movement)){                      //condtions for acceptance now
                if(cond.equals("excellent") && condition.equals(cond)){
                    return true;
                }
                else{
                    if(cond.equals("good") && cond.equals(condition)){
                        return true;
                    }
                }
            }    
            return false;
        };
        public boolean evaluate(String move){       //thios evaluate for 3 arguments auction
            //we take as deafault that cond="excellent" so:
            if(condition.equals("excellent")){
                if(move.equals(movement)){
                    return true;
                }
            }    
            return false;
        };
    }

    //////////fuction:auction of class main//////////

    public static void auction(artifact[] artiarray,String move,String cond,int N){
        int i=0;            //similar behavior but  this one calls 2 arguments evaluate
        while(i<N){
            artiarray[i].getIndex();
            artiarray[i].getInfo();
            if(artiarray[i].evaluate(move,cond)==true){
                System.out.println("It is acceptable by evaluation");
            }
            else{
                System.out.println("It is not acceptable");
            }
            i++;
        }
    }

    public static void auction(artifact[] artiarray,String move,int N){
        int i=0;            //and this one calls 1 argument evaluate
        while(i<N){
            artiarray[i].getIndex();
            artiarray[i].getInfo();
            if(artiarray[i].evaluate(move)==true){
                System.out.println("It is acceptable by evaluation");
            }
            else{
                System.out.println("It is not acceptable");
            }
            i++;
        }
    }
}