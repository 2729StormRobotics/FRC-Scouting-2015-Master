package org.lrhsd.storm.frc_scouting_2015_master.databaseHandler;

/**
 * Created by Tommy on 1/16/2015.
 */
public class RecycleRush {
    //Data from teams
    private String columnNames[] = {"team_num", //Team number
            "match_num", //match number
            "is_red",  //Alliance
            "robot_auto", //If robot does autonomous
            "totes_num_auto", //Number of totes stacked in auto
            "container_num_auto", //Number of containers in auto
            "stack_num", //Number of stacks in auto
            "tote_level_one", //Tote levels
            "tote_level_two",
            "tote_level_three",
            "tote_level_four",
            "tote_level_five",
            "tote_level_six",
            "container_level_one", //Container level
            "container_level_two",
            "container_level_three",
            "container_level_four",
            "container_level_five",
            "container_level_six",
            "noodle", //Noodle variable
            "coopertition"// If team performs co-opertition
    };
    //Non-Boolean values
    private int team_num = 0, match_num = 0, stack_num = 0, totes_num_auto = 0, tote_level_one = 0, tote_level_two = 0, tote_level_three = 0, tote_level_four = 0,
            tote_level_five = 0, tote_level_six = 0, container_num_auto = 0, container_level_one = 0, container_level_two = 0, container_level_three = 0,
            container_level_four = 0, container_level_five = 0, container_level_six = 0;

    //Ints to hold boolean variables
    private int is_red = 0, robot_auto = 0, noodle = 0, coopertition = 0;

    private int row_id;

    public RecycleRush(int team_num, int match_num, int is_red, int robot_auto, int totes_num_auto, int container_num_auto, int stack_num,
                       int tote_level_one, int tote_level_two, int tote_level_three, int tote_level_four, int tote_level_five, int tote_level_six,
                       int container_level_one, int container_level_two, int container_level_three, int container_level_four, int container_level_five, int container_level_six,
                       int noodle, int coopertition) {
        //Adds values to proper variables
        this.team_num = team_num;
        this.match_num = match_num;
        this.is_red = is_red;
        this.robot_auto = robot_auto;
        this.totes_num_auto = totes_num_auto;
        this.container_num_auto = container_num_auto;
        this.stack_num = stack_num;
        this.tote_level_one = tote_level_one;
        this.tote_level_two = tote_level_two;
        this.tote_level_three = tote_level_three;
        this.tote_level_four = tote_level_four;
        this.tote_level_five = tote_level_five;
        this.tote_level_six = tote_level_six;
        this.container_level_one = container_level_one;
        this.container_level_two = container_level_two;
        this.container_level_three = container_level_three;
        this.container_level_four = container_level_four;
        this.container_level_five = container_level_five;
        this.container_level_six = container_level_six;
        this.noodle = noodle;
        this.coopertition = coopertition;
    }
    //Takes QRCode data and properly splits them
    public RecycleRush(String input) {
        String[] decodeData = new String[this.columnNames.length];
        int commalocation = input.indexOf(",");
        for (int i = 0; i < decodeData.length; ++i) {
            decodeData[i] = input.substring(0, commalocation);
            input = input.substring(commalocation + 1, input.length());
            commalocation = input.indexOf(",");
        }
        try {
            this.team_num = Integer.parseInt(decodeData[0]);
            this.match_num = Integer.parseInt(decodeData[1]);
            this.is_red = Integer.parseInt(decodeData[2]);
            this.robot_auto = Integer.parseInt(decodeData[3]);
            this.totes_num_auto = Integer.parseInt(decodeData[4]);
            this.container_num_auto = Integer.parseInt(decodeData[5]);
            this.stack_num = Integer.parseInt(decodeData[6]);
            this.tote_level_one = Integer.parseInt(decodeData[7]);
            this.tote_level_two = Integer.parseInt(decodeData[8]);
            this.tote_level_three = Integer.parseInt(decodeData[9]);
            this.tote_level_four = Integer.parseInt(decodeData[10]);
            this.tote_level_five = Integer.parseInt(decodeData[11]);
            this.tote_level_six = Integer.parseInt(decodeData[12]);
            this.container_level_one = Integer.parseInt(decodeData[13]);
            this.container_level_two = Integer.parseInt(decodeData[14]);
            this.container_level_three = Integer.parseInt(decodeData[15]);
            this.container_level_four = Integer.parseInt(decodeData[16]);
            this.container_level_five = Integer.parseInt(decodeData[17]);
            this.container_level_six = Integer.parseInt(decodeData[18]);
            this.noodle = Integer.parseInt(decodeData[19]);
            this.coopertition = Integer.parseInt(decodeData[20]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Getters
    public int getCoopertition() {
        return coopertition;
    }

    public int getNoodle() {
        return noodle;
    }

    public int getRobot_auto() {
        return robot_auto;
    }

    public int getIs_red() {
        return is_red;
    }

    public int getContainer_level_six() {
        return container_level_six;
    }

    public int getContainer_level_five() {
        return container_level_five;
    }

    public int getContainer_level_four() {
        return container_level_four;
    }

    public int getContainer_level_three() {
        return container_level_three;
    }

    public int getContainer_level_two() {
        return container_level_two;
    }

    public int getContainer_level_one() {
        return container_level_one;
    }

    public int getContainer_num_auto() {
        return container_num_auto;
    }

    public int getTote_level_six() {
        return tote_level_six;
    }

    public int getTote_level_five() {
        return tote_level_five;
    }

    public int getTote_level_four() {
        return tote_level_four;
    }

    public int getTote_level_three() {
        return tote_level_three;
    }

    public int getTote_level_two() {
        return tote_level_two;
    }

    public int getTote_level_one() {
        return tote_level_one;
    }

    public int getTotes_num_auto() {
        return totes_num_auto;
    }

    public int getStack_num() {
        return stack_num;
    }

    public int getMatch_num() {
        return match_num;
    }

    public int getTeam_num() {
        return team_num;
    }


    //Auto XML data
    public String getAutoXMLData() {
     String record = "<record>";
     record += "<TeamNumber>"+getTeam_num()+"</TeamNumber>"+
               "<MatchNumber>"+getMatch_num()+"</MatchNumber>"+
               "<Alliance>"+getIs_red()+"<//Alliance>"+
               "<RobotAuto>"+getRobot_auto()+"</RobotAuto>"+
               "<ToteNumber>"+getTotes_num_auto()+"</ToteNumber>"+
               "<ContainerNumber>"+getContainer_num_auto()+"</ContainerNumber>"+
               "<StackNum>"+getStack_num()+"</StackNum>" +
               "</record";
        return record;


    }
    //Tele XML data
    public String getTeleXmlData(){
        String record = "<record>";
        record += "<TeamNumber>"+getTeam_num()+"</TeamNumber>"+
                  "<MatchNumber>"+getMatch_num()+"</MatchNumber>"+
                  "<Alliance>"+getIs_red()+"<//Alliance>"+
                  "<ToteLevelOne"+getTote_level_one()+"</ToteLevelOne>"+
                  "<ToteLevelTwo>"+getTote_level_two()+"</ToteLevelTwo>"+
                  "<ToteLevelThree>"+getTote_level_three()+"</ToteLevelThree>"+
                  "<ToteLevelFour>"+getTote_level_four()+"</ToteLevelFour>"+
                  "<ToteLevelFive>"+getTote_level_five()+"</ToteLevelFive>"+
                  "<ToteLevelSix>"+getTote_level_six()+"</ToteLevelSix>"+
                  "<ContainerLevelOne"+getContainer_level_one()+"</ContainerLevelOne>"+
                  "<ContainerLevelTwo>"+getContainer_level_two()+"</ContainerLevelTwo>"+
                  "<ContainerLevelThree>"+getContainer_level_three()+"</ContainerLevelThree>"+
                  "<ContainerLevelFour>"+getContainer_level_four()+"</ContainerLevelFour>"+
                  "<ContainerLevelFive>"+getContainer_level_five()+"</ContainerLevelFive>"+
                  "<ContainerLevelSix>"+getContainer_level_six()+"</ContainerLevelSix>"+
                  "<Noodle>"+getNoodle()+"</Noodle>"+
                  "<Co-Opertition>"+getCoopertition()+"</Co-Opertition>"+
                  "</record>";
        return record;

    }
    public String getTextData(){
        String record = "";
        record += getTeam_num() + "," + getMatch_num() + "," + getIs_red() + "," + getRobot_auto() + ","+
                getTotes_num_auto() + "," + getContainer_num_auto() + "," + getStack_num() + "," + getTote_level_one() + "," + getTote_level_two() + ","+
                getTote_level_three() + "," + getTote_level_four() + "," + getTote_level_five() + "," + getTote_level_six() + "," +
                getContainer_level_one() + "," + getContainer_level_two() + ","+
                getContainer_level_three() + "," + getContainer_level_four() + "," + getContainer_level_five() + "," + getContainer_level_six() + "," +
                getNoodle() + "," + getCoopertition() + ";";
        return record;

    }

}