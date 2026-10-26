package org.firstinspires.ftc.teamcode.Monroe.Util;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ArmController {

    public ArmController (HardwareMap hardwareMap){
        this.hardwareMap = hardwareMap;
    }
    HardwareMap hardwareMap;



    public enum ArmState { //States that the robot could be in for logic use
        Intake,
        Outtake,
        Shooting,
    }
    ArmState armState;

    //Motors
    public DcMotorEx rollerDcMotor;
    public DcMotorEx mainIntakeDcMotor;
    public DcMotorEx flywheelDcMotor;
    Servo yawServo;
    Servo hoodServo;
    CRServo advancementServo;
    //Endregion

    //Angles and powers

    //DC Main Intake Powers
    double DC_MAIN_INTAKE_POWER = 0;
    double DC_MAIN_INTAKE_INTAKE = .5;
    double DC_MAIN_INTAKE_OUTTAKE = -.5;
    double DC_MAIN_INTAKE_OFF = 0;
    //endregion

    //DC Roller Intake Powers
    double DC_ROLLER_INTAKE_POWER = 0;
    double DC_ROLLER_INTAKE_INTAKE = .5;
    double DC_ROLLER_INTAKE_OUTTAKE = -.5;
    double DC_ROLLER_INTAKE_OFF = 0;
    //endregion

    //Advancement Servo Powers
    double ADVANCEMENT_SERVO_POWER = 0; //stores power of
    double ADVANCEMENT_SERVO_INTAKE = 1;
    double ADVANCEMENT_SERVO_OUTTAKE = -1;
    double ADVANCEMENT_SERVO_OFF = 0;
    //endregion

    //Yaw Servo Angles
    double YAW_SERVO_ANGLE;
    //endregion

    //Hood servo Angles
    double HOOD_SERVO_ANGLE;


    public void init(HardwareMap hardwareMap){
        rollerDcMotor = hardwareMap.get(DcMotorEx.class, "rollerDcMotor");
        mainIntakeDcMotor = hardwareMap.get(DcMotorEx.class, "mainIntakeDcMotor");
        flywheelDcMotor = hardwareMap.get(DcMotorEx.class, "flywheelDcMotor");

        yawServo = hardwareMap.get(Servo.class, "yawServo");
        hoodServo = hardwareMap.get(Servo.class, "hoodServo");

        advancementServo = hardwareMap.get(CRServo.class, "advancementServo");

        rollerDcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        mainIntakeDcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheelDcMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rollerDcMotor.setDirection(DcMotorSimple.Direction.FORWARD);//placeholder
        mainIntakeDcMotor.setDirection(DcMotorSimple.Direction.FORWARD);//placeholder
        flywheelDcMotor.setDirection(DcMotorSimple.Direction.FORWARD);//placeholder




    }
    public void updateArm(){
        switch (armState){
            case Intake:
                //stuff
                break;
            case Outtake:
                //stuff
                break;
            case Shooting:
                //stuff
                break;

        }
    }


}
