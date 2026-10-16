package org.firstinspires.ftc.teamcode.Monroe.Util;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

public class ArmController {



    public enum ArmState { //States that the robot could be in for logic use
        Intake,
        Outtake,
        Shooting,

    }


    //Motors
    public DcMotorEx rollerDcMotor;
    public DcMotorEx mainDcMotor;
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


}
