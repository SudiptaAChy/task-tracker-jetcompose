package com.example.task.ui.AddTask

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.ui.theme.GreenColor
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AddTask(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 15.dp, end = 15.dp, top = 5.dp)
    ) {
        DateContainer()
        TaskContainer()
        TasksList(getTasksList())
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun DateContainer() {
    val mCalendar = Calendar.getInstance()

    val mYear = mCalendar.get(Calendar.YEAR)
    val mMonth = mCalendar.get(Calendar.MONTH)
    val mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()

    val mDate = remember { mutableStateOf("$mYear-${mMonth+1}-$mDay") }

    val mDatePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mYear-${mMonth+1}-$mDayOfMonth"
        }, mYear, mMonth, mDay
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text("Date", style = TextStyle(fontSize = 20.sp))
        Row (
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(mDate.value)
            IconButton(onClick = {mDatePickerDialog.show()}) {
                Icon(Icons.Filled.ArrowDropDown, contentDescription = "Calender")
            }
        }
    }
}

@Composable
fun TaskContainer() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text("Tasks", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
        IconButton(
            onClick = {}
        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Add task",
                tint = GreenColor,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Composable
fun TasksList(tasks: List<tasks>) {
    LazyColumn (modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
        items(tasks) { task ->
            TaskItem(Modifier, task)
        }
    }
}

@Composable
fun TaskItem(
    modifier: Modifier = Modifier,
    task: tasks
) {
    Card(
        modifier = modifier.padding(top = 5.dp),
        shape = RoundedCornerShape(0.dp),
        colors = CardDefaults.cardColors(
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
            Text(
                text = task.description,
                fontSize = 14.sp,
                modifier = modifier.padding(5.dp))
            Text(
                text = task.hour.toString()+"h "+ task.minute.toString()+"m",
                fontSize = 14.sp,
                modifier = modifier.padding(5.dp))
        }
    }
}