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

    //DC Flywheel Powers
    double DC_FLYWHEEL_POWER;
    double DC_FLYWHEEL_OFF = 0;
    double DC_FLYWHEEL_BIG_BALL = 1; //placeholder
    double DC_FLYWHEEL_SMALL_BALL = 1; //placeholder
    boolean BALL_SIZE;


    //Advancement Servo Powers
    double ADVANCEMENT_SERVO_POWER = 0;
    double ADVANCEMENT_SERVO_INTAKE = 1;
    double ADVANCEMENT_SERVO_OUTTAKE = -1;
    double ADVANCEMENT_SERVO_OFF = 0;
    //endregion

    //Yaw Servo Angles
    double YAW_SERVO_ANGLE;
    double YAW_SERVO_NEEDED_ANGLE; //the Servo angle to point towards the bucket
    //endregion

    //Hood servo Angles
    double HOOD_SERVO_ANGLE;
    double HOOD_SERVO_NEEDED_ANGLE; //the Servo angle to from the needed shooting trajectory


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
    public void updateArm(ArmState armState, double YAW_SERVO_NEEDED_ANGLE, double HOOD_SERVO_NEEDED_ANGLE, boolean BALL_SIZE){
        //switch case that takes
        switch (armState){
            case Intake:
                DC_ROLLER_INTAKE_POWER = DC_ROLLER_INTAKE_INTAKE;
                DC_MAIN_INTAKE_POWER = DC_MAIN_INTAKE_INTAKE;
                DC_FLYWHEEL_POWER = DC_FLYWHEEL_OFF;
                ADVANCEMENT_SERVO_POWER = ADVANCEMENT_SERVO_OFF;
                break;
            case Outtake:
                DC_ROLLER_INTAKE_POWER = DC_ROLLER_INTAKE_OUTTAKE;
                DC_MAIN_INTAKE_POWER = DC_MAIN_INTAKE_OUTTAKE;
                DC_FLYWHEEL_POWER = DC_FLYWHEEL_OFF;
                ADVANCEMENT_SERVO_POWER = ADVANCEMENT_SERVO_OUTTAKE;
                break;
            case Shooting:
                DC_ROLLER_INTAKE_POWER = DC_ROLLER_INTAKE_OFF;
                DC_MAIN_INTAKE_POWER = DC_MAIN_INTAKE_INTAKE;
                if (BALL_SIZE) { DC_FLYWHEEL_POWER = DC_FLYWHEEL_BIG_BALL; }
                else{ DC_FLYWHEEL_POWER = DC_FLYWHEEL_SMALL_BALL; }
                YAW_SERVO_ANGLE = YAW_SERVO_NEEDED_ANGLE;
                HOOD_SERVO_ANGLE = HOOD_SERVO_NEEDED_ANGLE;
                break;

        }
        //setting powers from switch case
        rollerDcMotor.setVelocity(DC_ROLLER_INTAKE_POWER);
        mainIntakeDcMotor.setVelocity(DC_MAIN_INTAKE_POWER);
        flywheelDcMotor.setVelocity(DC_FLYWHEEL_POWER);

        advancementServo.setPower(ADVANCEMENT_SERVO_POWER);

        yawServo.setPosition(YAW_SERVO_ANGLE);
        hoodServo.setPosition(HOOD_SERVO_ANGLE);
    }
}
