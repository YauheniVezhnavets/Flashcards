/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        if ("MAX".equals(operator)) {
            int maxValue = Integer.parseInt(args[1]);
            for (int i = 2; i < args.length; i++) {
                if (Integer.parseInt(args[i]) > maxValue) {
                    maxValue = Integer.parseInt(args[i]);
                }
            }
            System.out.println(maxValue);
        }
        if ("MIN".equals(operator)) {
            int minValue = Integer.parseInt(args[1]);
            for (int i = 2; i < args.length; i++) {
                if (Integer.parseInt(args[i]) < minValue) {
                    minValue = Integer.parseInt(args[i]);
                }
            }
            System.out.println(minValue);
        }
        if ("SUM".equals(operator)) {
            int sum = 0;
            for (int i = 1; i < args.length; i++) {
                sum += Integer.parseInt(args[i]);
            }
            System.out.println(sum);
        }
    }
}