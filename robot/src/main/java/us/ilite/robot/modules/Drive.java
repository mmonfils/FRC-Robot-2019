package us.ilite.robot.modules;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Joystick;

public class Drive extends Module {

    private TalonSRX rightMaster = new TalonSRX(7);
    private TalonSRX rightMiddle = new TalonSRX(6);
    private TalonSRX rightBack =  new TalonSRX(5);
    private TalonSRX leftMaster = new TalonSRX(10);
    private TalonSRX leftMiddle = new TalonSRX(11);
    private TalonSRX leftBack = new TalonSRX(12);

    private Joystick joystick = new Joystick(0);

    @Override
    public void powerOnInit(double pNow) {
        
    }

    @Override
    public void modeInit(double pNow) {
        leftBack.follow(leftMaster);
        leftMiddle.follow(leftMaster);
        rightBack.follow(rightMaster);
        rightMiddle.follow(rightMaster);

        leftMaster.setInverted(false);
        leftMiddle.setInverted(false);
        leftBack.setInverted(false);

        rightMaster.setInverted(true);
        rightMiddle.setInverted(true);
        rightBack.setInverted(true);

        rightMaster.configOpenLoopRamp(0.1, 50);
        leftMaster.configOpenLoopRamp(0.1, 50);
    }

    @Override
    public void update(double pNow) {
        double throttle = -joystick.getRawAxis(1);
        double turn = joystick.getRawAxis(4);
        leftMaster.set( ControlMode.PercentOutput, throttle + turn );
        rightMaster.set( ControlMode.PercentOutput, throttle - turn );
    }

    @Override
    public void shutdown(double pNow) {

    }

    @Override
    public void checkModule(double pNow) {

    }
}
