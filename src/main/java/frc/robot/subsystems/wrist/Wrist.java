package frc.robot.subsystems.wrist;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Wrist extends SubsystemBase {
  // For instructions on how to implement this class, refer to the README.md file
  private WristIO m_wristIO;

  public final WristInputsAutoLogged m_wristInputs;

  private PIDController m_controller;

  public Wrist(WristIO io, PIDController controller) {
    // TODO: Implement the constructor

    m_wristIO = io;
    m_wristInputs = new WristInputsAutoLogged();
    m_controller = controller;
  }

  @Override
  public void periodic() {
    // TODO: Implement this method
    m_wristIO.updateInputs(m_wristInputs);
    double PidVoltage = m_controller.calculate(m_wristInputs.angleRad);
    m_wristIO.setVoltage(PidVoltage);
  }

  public void setDesiredAngle(Rotation2d angle) {
    // TODO: Implement this method
    m_controller.setSetpoint(angle.getRadians());
  }

  public Command setDesiredAngleCommand(Rotation2d angle) {
    // TODO: Implement this method
    return Commands.runOnce(() -> m_controller.setSetpoint(angle.getRadians()));
  }

  public boolean withinTolerance() {
    // TODO: Implement this method
    return m_controller.atSetpoint();
  }

  public WristInputsAutoLogged getInputs() {
    // TODO: Implement this method
    return m_wristInputs;
  }
}
