# Problem Statement

Schools, especially at the primary and secondary level, often still keep student information scattered — personal details in one place, marks somewhere else, attendance in a paper register, course lists in a spreadsheet nobody updates consistently. Answering something as simple as "how is this student doing across all their subjects" ends up taking more digging than it should, and the records drift out of sync with each other over time.

That's the problem this project tries to solve on a small scale: one command-line app where student records, courses, enrollments, marks, and attendance all live in the same place and can be cross-referenced through built-in reports, instead of sitting in separate files.

## Scope

This is a single-user, console-based Student Management System — a learning-level project meant to demonstrate core Java, OOP design, and file-based persistence, not a production system. What it actually does:

- Manage student and course records (add/view/update/delete)
- Enroll students in courses and record their marks
- Record daily attendance and work out attendance percentage
- Generate summary reports — course performance, student report cards, class roster, system totals
- Basic login so data can't be touched without authenticating

What it doesn't do (for now — listed under Future Enhancements in the project report): no GUI, no multi-user or concurrent access, no relational database backend, no network access.

## Target Users

- **School admins or class teachers** who want a quick way to track student, course, enrollment, and attendance records for a single class or school without setting up a full database system.
- **Other students learning Java**, who want a realistic (if small) example of a layered application — models, services, persistence, and a console UI — to read through or build on.

## What It Does, In More Detail

1. Login gate before any data can be viewed or edited.
2. Full CRUD for student records, validated on every field.
3. Course management — add, view, delete.
4. Enrollment with mark entry and automatic letter-grade calculation.
5. Attendance marking per student, per course, per date, plus a percentage calculation.
6. Reporting: system summary, per-course performance, per-student report card, class roster.
7. Everything saved automatically to CSV files, so nothing's lost between runs.
8. Action logging (logins, additions, edits, deletions, failures) to a plain-text log for basic auditability.
