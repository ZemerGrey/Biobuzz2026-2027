package org.firstinspires.ftc.teamcode.Monroe.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.pedropathing.follower.Follower;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;

import org.firstinspires.ftc.teamcode.pedro.Constants;

public class RedAuto extends OpMode {
    private Follower follower;
    private final PoseFactory p = PoseFactory.degrees();

    //Game Poses p.of(x value, y value, heading in degrees);
    private final Pose startPose = p.of(24,24,0);
    private final Pose park = p.of(48,48,90);

    @Override
    public void init() {
        follower = Constants.create(hardwareMap);
    }
    @Override
    public void start(){

    }

    @Override
    public void loop() {

    }
}
