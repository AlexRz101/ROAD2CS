export const ResolveCourse = (course, geSelections) => {
  const swapped = geSelections?.[course.courseId];

  if (!swapped) return course;

  return {
    ...course,
    courseId: swapped.courseId,
    name: swapped.name,
    credits: swapped.credits,
    courseType: swapped.courseType
  };
};