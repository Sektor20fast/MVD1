package com.example.mvd1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;

public class FaqExpandableAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> questions;
    private HashMap<String, String> answers;

    public FaqExpandableAdapter(Context context, List<String> questions, HashMap<String, String> answers) {
        this.context = context;
        this.questions = questions;
        this.answers = answers;
    }

    @Override
    public int getGroupCount() { return questions.size(); }
    @Override
    public int getChildrenCount(int groupPosition) { return 1; }
    @Override
    public Object getGroup(int groupPosition) { return questions.get(groupPosition); }
    @Override
    public Object getChild(int groupPosition, int childPosition) { return answers.get(questions.get(groupPosition)); }
    @Override
    public long getGroupId(int groupPosition) { return groupPosition; }
    @Override
    public long getChildId(int groupPosition, int childPosition) { return childPosition; }
    @Override
    public boolean hasStableIds() { return false; }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String question = (String) getGroup(groupPosition);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_expandable_list_item_1, parent, false);
        }
        ((TextView) convertView).setText(question);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String answer = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        ((TextView) convertView).setText(answer);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) { return true; }
}
