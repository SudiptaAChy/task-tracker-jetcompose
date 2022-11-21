package com.example.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.Home.dummyTasks
import com.example.task.Home.task

@Composable
fun Home(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .width(1000.dp)
        .padding(20.dp)) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(Color(R.color.grey)),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = "Date",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = modifier.padding(10.dp))
            Text(
                text = "Total hour",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = modifier.padding(10.dp))
        }
        taskList(dummyTasks())
    }
}

@Composable
fun taskList(tasks: List<task>) {
    LazyColumn {
        items(tasks) { task ->
            taskItem(Modifier, task.date, task.time)
        }
    }
}

@Composable
fun taskItem(
    modifier: Modifier = Modifier,
    date: String = "22-09-22",
    time: String = "2h 20m",
) {
    Card(
        modifier = Modifier.padding(top = 5.dp),
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors (
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp,
        ),
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = date,
                fontSize = 14.sp,
                modifier = modifier.padding(5.dp))
            Text(
                text = time,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = modifier.padding(5.dp))
        }
    }
}