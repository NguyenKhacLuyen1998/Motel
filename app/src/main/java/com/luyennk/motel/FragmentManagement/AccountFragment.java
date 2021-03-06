package com.luyennk.motel.FragmentManagement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.luyennk.motel.Activity_Management.EditAccountActivity;
import com.luyennk.motel.Activity_Management.LoginActivity;
import com.luyennk.motel.R;

public class AccountFragment extends Fragment{

    private static final String TAG="AccountFragment";

    private TextView txtFullName;
    private TextView txtPhoneNumber;
    private TextView txtEmail;

    private ImageView btnMenu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_account, container, false);

        txtFullName = RootView.findViewById(R.id.txtNameAccount);
        txtPhoneNumber =RootView.findViewById(R.id.txtPhoneNumBer);
        txtEmail = RootView.findViewById(R.id.txtEmail);

        getDataSharedPreferences();

        return RootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
    }

    private void initView(){
        btnMenu = getView().findViewById(R.id.btnMenu);

        registerForContextMenu(btnMenu);
    }

    private void getDataSharedPreferences(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserInfor", Context.MODE_PRIVATE);

        String id=sharedPreferences.getString("idUser","id Use");
        String fullName=sharedPreferences.getString("fullName","Full Name");
        String pasWord=sharedPreferences.getString("passWord","PassWord");
        String nameUse=sharedPreferences.getString("nameUse","idUse");
        String address=sharedPreferences.getString("address","address");
        String idCard=sharedPreferences.getString("idCard","idCard");
        String phoneNumber=sharedPreferences.getString("phoneNumber","phoneNumber");
        String job=sharedPreferences.getString("job","job");
        String mail=sharedPreferences.getString("mail","mail");
        String permission=sharedPreferences.getString("permission","permission");

        txtFullName.setText(fullName);
        txtPhoneNumber.setText(phoneNumber);
        txtEmail.setText(mail);
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        getActivity().getMenuInflater().inflate(R.menu.menu_item_account,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuLogout:
                Intent intent=new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.mnuEditAccount:
                Intent intent1=new Intent(getContext(), EditAccountActivity.class);
                startActivity(intent1);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
