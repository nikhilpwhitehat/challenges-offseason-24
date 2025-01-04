package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  // For instructions on how to implement this class, refer to the README.md file
  private IntakeIO m_franklinIntakeIO;
  private IntakeInputsAutoLogged m_franklinIntakeInputsAutoLogged;

  public Intake(IntakeIO io) {
    // TODO: Implement the constructor
    m_franklinIntakeIO = io;
    m_franklinIntakeInputsAutoLogged = new IntakeInputsAutoLogged();
  }

  @Override
  public void periodic() {
    // TODO: Implement this method
    m_franklinIntakeIO.updateInputs(m_franklinIntakeInputsAutoLogged);
  }

  public void setRollerVoltage(double voltage) {
    // TODO: Implement this method
    m_franklinIntakeIO.setRollerVoltage(voltage);
  }

  public Command setVoltageCommand(double voltage) {
    // TODO: Implement this method
    return Commands.runOnce(() -> m_franklinIntakeIO.setRollerVoltage(voltage));
  }

  public IntakeInputsAutoLogged getInputs() {
    // TODO: Implement this method
    return m_franklinIntakeInputsAutoLogged;
  }
}
