����Ϊdata�ļ�
������ʱ����¶ȵļ�¼
�������yyyy-MM-dd HH:mm:ss����������Ʊ��tab

�������
1949-1951 ��֮�䣬ÿ���¶���ߵ�ǰK�죨����k=5��

˼·��
1.���������������ͬһ���У��ٰ����¶Ƚ�������
2.������ݷ��飬ÿ����ݶ�Ӧһ��reduce����

map����� keyΪ��װ���󣬷�װ��ݺ��¶�Ϊһ��������ΪKeyֵ����keyPair�ࡣ

Ŀ�ģ�
1.��ϰ�Զ�������
2.��ϰ�Զ������
3.��ϰ�Զ������
//��������壺
�ο���http://www.linuxidc.com/Linux/2013-08/88603.htm
//�����dadoop�й��ڸ�������SecondarySort����ʵ�֣�˵������������Ҫ���ã�1. partioner��2. Key Comparator��
//3. Group Comparator��ǰ�������Ƚ�������⣬���ǹ���group�ĸ�����һֱ��ⲻ�ˣ�
//һ������partioner�����е�key�Ѿ��ŵ�һ�������ˣ�ÿ��������Ӧһ��reducer������keyҲ���������ˣ�
//��ô����ʵ�����������ݼ���ȫ�������𣿵ڶ���mapper�������м�������shuffle��sort��ÿ��key���ϳ�һ����¼��
//ÿ��reduce�������ô���һ����¼������group��Ŀ������һ��reduce���ô��������¼���ⲻ��ì����
//���˺þ�һֱ��û�ҵ����������������͡�
//�����ҵ�һ���飬��Pro Hadoop����������һ����������ϸ������������⣬�������������ˣ��ʹ�ҷ���һ�¡�reduce����ÿ���Ƕ�һ����¼��
//������Ӧ��key�����Ǵ���value����ʱ�������굱ǰ��¼��values�󣬻����ж���һ����¼�ǲ��Ǻ͵�ǰ��key�ǲ���ͬһ���飬
//����ǵĻ����������ȡ��Щ��¼��ֵ���������¼Ҳ�ᱻ��Ϊ�Ѿ������ˣ�ֱ����¼���ǵ�ǰ�飬���reduce���òŽ�����
//����һ��reduce���þͻᴦ���һ�����е����м�¼������������һ���ˡ�
//�����ʲô���أ�������÷��飬��ôͬһ��ļ�¼��Ҫ�ڶ��reduce�����ж���������ô��Щ״̬���ݾ�Ҫ�����ˣ��ͻ����Ӹ��Ӷȣ�
//��һ�ε����д���Ļ�����Щ״ֻ̬Ҫ�÷����ڵı����Ϳ��Եġ�����������ֵ��ֻҪ����һ��ֵ�Ϳ����ˡ�

�ο��� http://blog.csdn.net/zuochanxiaoheshang/article/details/8986114
Hadoop����ν���������أ����ݱ��ߵ���⣬MapReduce��������̷�Ϊ�������裬һ������Key��������һ���ǰ���Key���з��顣
�������ֱַ���SortComparator��GroupingComparator����ɡ���������������������ʾ��
job.setPartitionerClass(FirstPartitioner.class);
job.setSortComparatorClass(KeyComparator.class);
job.setGroupingComparatorClass(GroupComparator.class);


�ο��� http://blog.sina.com.cn/s/blog_7581a4c30102veem.html
reduce�׶�
1. shuffle�׶�
reducer��ʼfetch����ӳ�䵽���reducer��map�����

2.1 sort�׶�
�ٴε���job.setSortComparatorClass()���õ�key�ȽϺ�������������ݶ�����(��Ϊһ��reducer���ܶ��mappers����Ҫ��������)��
2.2 secondary sort�׶�
Ȼ��ʼ����һ��key��Ӧ��value����������ʱ��Ҫ�õ����飬ʹ��jobjob.setGroupingComparatorClass()���õķ��麯���ࡣ
ֻҪ����Ƚ����Ƚϵ�����key��ͬ�����Ǿ�����ͬһ���飬���ǵ�value����һ��value��������
�������������keyʹ������ͬһ���������key�ĵ�һ��key��