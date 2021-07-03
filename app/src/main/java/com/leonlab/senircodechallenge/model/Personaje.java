package com.leonlab.senircodechallenge.model;

public class Personaje {

    private int char_id;
    private String name,brythday,img,status,nickname,portrayed,category;
    private String[] occupation;
    private int[] appearance,better_call_saul_appearance;
    private boolean favorito;

    public Personaje(int char_id, String name, String brythday, String img, String status, String nickname, String portrayed, String category, String[] occupation, int[] appearance, int[] better_call_saul_appearance) {
        this.char_id = char_id;
        this.name = name;
        this.brythday = brythday;
        this.img = img;
        this.status = status;
        this.nickname = nickname;
        this.portrayed = portrayed;
        this.category = category;
        this.occupation = occupation;
        this.appearance = appearance;
        this.better_call_saul_appearance = better_call_saul_appearance;
    }

    public int getChar_id() {
        return char_id;
    }

    public void setChar_id(int char_id) {
        this.char_id = char_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrythday() {
        return brythday;
    }

    public void setBrythday(String brythday) {
        this.brythday = brythday;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPortrayed() {
        return portrayed;
    }

    public void setPortrayed(String portrayed) {
        this.portrayed = portrayed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String[] getOccupation() {
        return occupation;
    }

    public void setOccupation(String[] occupation) {
        this.occupation = occupation;
    }

    public int[] getAppearance() {
        return appearance;
    }

    public void setAppearance(int[] appearance) {
        this.appearance = appearance;
    }

    public int[] getBetter_call_saul_appearance() {
        return better_call_saul_appearance;
    }

    public void setBetter_call_saul_appearance(int[] better_call_saul_appearance) {
        this.better_call_saul_appearance = better_call_saul_appearance;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
}
