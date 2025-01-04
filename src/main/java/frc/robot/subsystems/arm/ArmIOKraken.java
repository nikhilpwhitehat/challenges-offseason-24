package frc.robot.subsystems.arm;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;

public class ArmIOKraken implements ArmIO {
  // For instructions on how to implement this class, refer to the README.md file
  private TalonFX m_motor;

  public ArmIOKraken(int port) {
    // TODO: Implement this method
    m_motor = new TalonFX(port);
  }

  @Override
  public void setVoltage(double voltage) {
    // TODO: Implement this method
    m_motor.setVoltage(voltage);
  }

  @Override
  public double getVoltage() {
    // TODO: Implement this method
    return m_motor.getMotorVoltage().getValueAsDouble();
  }

  @Override
  public double getVelocityRadiansPerSecond() {
    // TODO: Implement this method
    return Units.rotationsToRadians(m_motor.getVelocity().getValueAsDouble());
  }

  @Override
  public Rotation2d getPosition() {
    // TODO: Implement this method
    // Rotation2d rot = Rotation2d.fromRadians();
    return Rotation2d.fromRotations(m_motor.getPosition().getValueAsDouble());
  }

  @Override
  public Object getMotor() {
    // DO NOT MODIFY THIS METHOD
    return m_motor;
  }
}
