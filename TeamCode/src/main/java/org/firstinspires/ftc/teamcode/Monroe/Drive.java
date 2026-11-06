package org.firstinspires.ftc.teamcode.Monroe;
import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Monroe.Util.ArmController;
import org.firstinspires.ftc.teamcode.pedro.Constants;
@TeleOp(name = "Example TeleOp")
public class Drive extends OpMode {

    ArmController armController;

    double drivingPower = 0.8;
    double forwardPower;
    double lateralPower;
    double turnPower;

    private Follower follower;

    @Override
    public void init() {
        follower = Constants.create(hardwareMap);

        armController.init(hardwareMap);
    }
    @Override
    public void loop() {
        //Driving
        forwardPower = -gamepad1.left_stick_y * drivingPower;
        lateralPower = -gamepad1.left_stick_x * drivingPower;
        turnPower = -gamepad1.right_stick_x * drivingPower;

        //Actions



        follower.manual(forwardPower, lateralPower, turnPower);
        follower.update();
    }
}