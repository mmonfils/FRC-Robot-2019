package us.ilite.robot.modules;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.sun.javafx.tk.quantum.MasterTimer;
import edu.wpi.first.wpilibj.Joystick;

public class Drive extends Module {

    private TalonSRX rightMaster = new TalonSRX(0);
    private TalonSRX rightMiddle = new TalonSRX(0);
    private TalonSRX rightBack =  new TalonSRX(0);
    private TalonSRX leftMaster = new TalonSRX(0);
    private TalonSRX leftMiddle = new TalonSRX(0);
    private TalonSRX leftBack = new TalonSRX(0);

    private Joystick leftStick = new Joystick(0);
    private Joystick rightStick = new Joystick(1);

    @Override
    public void powerOnInit(double pNow) {
        leftBack.follow(leftMaster);
        leftMiddle.follow(leftMaster);
        rightBack.follow(rightMaster);
        rightMiddle.follow(rightMaster);
    }

    @Override
    public void modeInit(double pNow) {

    }

    @Override
    public void update(double pNow) {
        double throttle = leftStick.getRawAxis(1);
        double turn = rightStick.getRawAxis(4);
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
