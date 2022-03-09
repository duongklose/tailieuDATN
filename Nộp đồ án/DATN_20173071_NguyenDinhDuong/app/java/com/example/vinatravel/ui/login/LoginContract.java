package com.example.vinatravel.ui.login;

import com.example.vinatravel.data.model.user.User;

public interface LoginContract {
    interface View {
        void showPhoneError(int msgResId);

        void showPasswordError(int msgResId);

        void showError(int msgResId);

        void nextHome(User account);
    }

    interface Presenter {
        void handleLogin(String phone, String password);

        void checkInputPhoneEmail(String phoneEmail);

        void checkInputPassword(String password, String phone);
    }
}
