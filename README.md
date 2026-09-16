# Student Management System (Java, Console-Based)

A console-based Student Management System I built in core Java for my "Build Your Own Project" submission. It's a single menu-driven terminal app that lets a school admin manage students, courses, enrollments, grades, and attendance, with everything saved to disk between runs.

## Why I built it this way

Most beginner student-management projects I looked at before starting this one stop at basic add/view/delete for a single entity, like a plain list of students you can edit. I wanted the modules to actually connect, so once a student exists in the system you can enroll them in a course, give them marks, track their attendance, and pull a report out of all of it, from the same terminal session.

Everything is stored as plain CSV files in a `data/` folder that gets created the first time you run the program. No database, no setup beyond having a JDK installed.

## Features

- **Login** — you can't do anything until you log in. A default `admin / admin123` account is created automatically on first run, and passwords are hashed (SHA-256 + salt) before they're ever written to disk.
- **Students** — add, view, search by name, update, delete, with validation on each field so bad data can't be saved.
- **Courses** — add, view, delete (ID, name, credits, instructor).
- **Enrollment & grades** — enroll a student in a course and record their marks; the app works out the letter grade automatically.
- **Attendance** — mark present/absent for a student, course, and date, and check their running attendance percentage.
- **Reports** — a system-wide summary, a per-course report (class average + top scorer), a per-student report card, and a class roster.
- **Logging** — logins, edits, deletions, and failures are timestamped and appended to `data/app.log`.
- **Validation** — a bad email, an out-of-range mark, or a duplicate ID gets caught with a proper error message instead of crashing the program.

## Built with

- Java 21 — core Java only, no external libraries or frameworks
- Plain CSV files for storage (`java.io`)
- Git/GitHub for version control

## Project Structure

```
StudentManagementSystem/
├── src/com/smsapp/
│   ├── Main.java                 # Console UI / entry point
│   ├── model/                    # Student, Course, Enrollment, Attendance, User
│   ├── service/                  # Business logic for each module
│   ├── dao/                      # FileStorageManager (persistence layer)
│   ├── util/                     # Validation, logging, password hashing
│   └── exception/                # Custom checked exceptions
├── test/com/smsapp/test/
│   └── ValidationTest.java       # Self-contained test suite (no framework needed)
├── docs/                         # Design diagrams and project report
├── data/                         # Created automatically at runtime (CSV files + log)
├── README.md
└── statement.md
```

## Setting It Up

You'll need JDK 17 or later on your `PATH`. (I built and tested this on 21, but it should run fine on 17+ since I didn't use anything newer.)

1. Clone the repo and move into it:
   ```bash
   git clone https://github.com/<your-username>/<your-repo-name>.git
   cd StudentManagementSystem
   ```

2. Compile everything into an `out/` folder:
   ```bash
   javac -d out $(find src -name "*.java")
   ```
   (On Windows PowerShell: `javac -d out (Get-ChildItem -Recurse -Filter *.java src).FullName`)

3. Run it:
   ```bash
   java -cp out com.smsapp.Main
   ```

4. Log in with the default account:
   ```
   Username: admin
   Password: admin123
   ```

5. From there, just use the numbered menus to move between Student Management, Course Management, Enrollment & Grades, Attendance, and Reports.

Everything you enter is saved automatically to `data/`, so it'll still be there the next time you run the program.

## Testing

There's a small, dependency-free test suite that checks the core validation and business rules — email format, duplicate detection, password hashing, mark range checks, and so on.

1. Compile including the test folder:
   ```bash
   javac -d out $(find src test -name "*.java")
   ```

2. Run it:
   ```bash
   java -cp out com.smsapp.test.ValidationTest
   ```

3. You should see a `PASS` line for each check, followed by a summary like `13 passed, 0 failed.` It exits with a non-zero status if anything fails, in case this ever gets wired into a CI pipeline.

The tests write to their own throwaway `test-data-*` folders, so running them won't touch your real `data/` folder.

## Screenshots
<img width="1000" height="980" alt="Screenshot 2026-09-16 180043" src="https://github.com/user-attachments/assets/2101e09a-d46f-4b82-9424-5363550111b2" />
<img width="930" height="377" alt="Screenshot 2026-09-16 180334" src="https://github.com/user-attachments/assets/e752f32c-ef6e-4366-a3bf-1c5263305c68" />
<img width="930" height="410" alt="Screenshot 2026-09-16 180359" src="https://github.com/user-attachments/assets/23a25ad2-95eb-44cb-afc2-974637fb45b2" />
<img width="508" height="401" alt="Screenshot 2026-09-16 180744" src="https://github.com/user-attachments/assets/e0ac81ed-7906-4488-b0a6-65a5cb124603" />
<img width="777" height="371" alt="Screenshot 2026-09-16 180808" src="https://github.com/user-attachments/assets/aef5faf5-07a7-4116-8f60-180143b0ee1b" />
<img width="372" height="397" alt="Screenshot 2026-09-16 180824" src="https://github.com/user-attachments/assets/d2192ab5-62cb-4860-b93b-87e6be7338f4" />

<img width="1375" height="348" alt="Screenshot 2026-09-16 180837" src="https://github.com/user-attachments/assets/08c70391-1db1-4b32-860f-68c5dfb5ff10" />
<img width="447" height="412" alt="Screenshot 2026-09-16 180858" src="https://github.com/user-attachments/assets/0e80f284-7163-44a3-b9fa-e1948b3c4f8f" />

<img width="487" height="407" alt="Screenshot 2026-09-16 180917" src="https://github.com/user-attachments/assets/35fa8fde-adb9-4e3f-9793-fe6ff869038f" />

<img width="395" height="432" alt="Screenshot 2026-09-16 180925" src="https://github.com/user-attachments/assets/71c139dc-bffc-46dd-a5d9-13b37a6003e1" />

<img width="488" height="366" alt="Screenshot 2026-09-16 180932" src="https://github.com/user-attachments/assets/58b7ce14-cbce-422c-8974-b0671f1fa0e6" />





