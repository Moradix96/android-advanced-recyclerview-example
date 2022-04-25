package ir.samiantec.advancedrecyclerviewexample.Model;

import androidx.annotation.NonNull;

import java.util.List;

public class Section {
    private final String title;
    private final List<String> list;

    public Section(String title, List<String> list) {
        this.title = title;
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getList() {
        return list;
    }

    @NonNull
    @Override
    public String toString() {
        return "Section{" +
                "title='" + title + '\'' +
                ", list=" + list +
                '}';
    }
}