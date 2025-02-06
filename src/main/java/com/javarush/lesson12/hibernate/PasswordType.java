package com.javarush.lesson12.hibernate;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordType implements UserType<Password> {
    @Override
    public int getSqlType() {
        return 0;
    }

    @Override
    public Class<Password> returnedClass() {
        return null;
    }

    @Override
    public boolean equals(Password x, Password y) {
        return false;
    }

    @Override
    public int hashCode(Password x) {
        return 0;
    }

    @Override
    public Password nullSafeGet(ResultSet rs, int position, SharedSessionContractImplementor session, Object owner) throws SQLException {
        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Password value, int index, SharedSessionContractImplementor session) throws SQLException {

    }

    @Override
    public Password deepCopy(Password value) {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Password value) {
        return null;
    }

    @Override
    public Password assemble(Serializable cached, Object owner) {
        return null;
    }
}
