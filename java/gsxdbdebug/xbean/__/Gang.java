/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import ppbio.Message;
/*      */ import xbean.Pod;
/*      */ import xdb.Bean;
/*      */ import xdb.Consts;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.Listenable;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.ListenableMap;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.logs.LogString;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class Gang
/*      */   extends XBean
/*      */   implements xbean.Gang
/*      */ {
/*      */   private String name;
/*      */   private int level;
/*      */   private long createtime;
/*      */   private String purpose;
/*      */   private long bangzhuid;
/*      */   private int designtitlecaseid;
/*      */   private int vitality;
/*      */   private long leveluptime;
/*      */   private ArrayList<xbean.GangAnnouncement> announcementhistorylist;
/*      */   private int apprenticemaxlv;
/*      */   private long timestamp;
/*      */   private long lastrename;
/*      */   private int forbiddentalkcount;
/*      */   private long tanheroleid;
/*      */   private long tanheendtime;
/*      */   private int juanzhongnum;
/*      */   private long nextid;
/*      */   private int publishtime;
/*      */   private LinkedList<xbean.GangHelper> ganghelperlist;
/*      */   private xbean.XiangFang xiangfang;
/*      */   private xbean.JinKu jinku;
/*      */   private xbean.YaoDian yaodian;
/*      */   private xbean.CangKu cangku;
/*      */   private xbean.ShuYuan shuyuan;
/*      */   private HashMap<Integer, xbean.GangDutyMembers> duty2members;
/*      */   private int periodmoney;
/*      */   private long grouproleid;
/*      */   private String groupopenid;
/*      */   private long displayid;
/*      */   private HashMap<Long, xbean.GangTeam> teams;
/*      */   private HashMap<Long, Long> member2teamid;
/*      */   private long next_teamid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   80 */     this.name = "";
/*   81 */     this.level = 0;
/*   82 */     this.createtime = 0L;
/*   83 */     this.purpose = "";
/*   84 */     this.bangzhuid = 0L;
/*   85 */     this.designtitlecaseid = 0;
/*   86 */     this.vitality = 0;
/*   87 */     this.leveluptime = 0L;
/*   88 */     this.announcementhistorylist.clear();
/*   89 */     this.apprenticemaxlv = 0;
/*   90 */     this.timestamp = 0L;
/*   91 */     this.lastrename = 0L;
/*   92 */     this.forbiddentalkcount = 0;
/*   93 */     this.tanheroleid = 0L;
/*   94 */     this.tanheendtime = 0L;
/*   95 */     this.juanzhongnum = 0;
/*   96 */     this.nextid = 0L;
/*   97 */     this.publishtime = 0;
/*   98 */     this.ganghelperlist.clear();
/*   99 */     this.xiangfang._reset_unsafe_();
/*  100 */     this.jinku._reset_unsafe_();
/*  101 */     this.yaodian._reset_unsafe_();
/*  102 */     this.cangku._reset_unsafe_();
/*  103 */     this.shuyuan._reset_unsafe_();
/*  104 */     this.duty2members.clear();
/*  105 */     this.periodmoney = 0;
/*  106 */     this.grouproleid = 0L;
/*  107 */     this.groupopenid = "";
/*  108 */     this.displayid = 0L;
/*  109 */     this.teams.clear();
/*  110 */     this.member2teamid.clear();
/*  111 */     this.next_teamid = 0L;
/*      */   }
/*      */   
/*      */   Gang(int __, XBean _xp_, String _vn_)
/*      */   {
/*  116 */     super(_xp_, _vn_);
/*  117 */     this.name = "";
/*  118 */     this.purpose = "";
/*  119 */     this.announcementhistorylist = new ArrayList();
/*  120 */     this.ganghelperlist = new LinkedList();
/*  121 */     this.xiangfang = new XiangFang(0, this, "xiangfang");
/*  122 */     this.jinku = new JinKu(0, this, "jinku");
/*  123 */     this.yaodian = new YaoDian(0, this, "yaodian");
/*  124 */     this.cangku = new CangKu(0, this, "cangku");
/*  125 */     this.shuyuan = new ShuYuan(0, this, "shuyuan");
/*  126 */     this.duty2members = new HashMap();
/*  127 */     this.groupopenid = "";
/*  128 */     this.teams = new HashMap();
/*  129 */     this.member2teamid = new HashMap();
/*  130 */     this.next_teamid = 0L;
/*      */   }
/*      */   
/*      */   public Gang()
/*      */   {
/*  135 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Gang(Gang _o_)
/*      */   {
/*  140 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Gang(xbean.Gang _o1_, XBean _xp_, String _vn_)
/*      */   {
/*  145 */     super(_xp_, _vn_);
/*  146 */     if ((_o1_ instanceof Gang)) { assign((Gang)_o1_);
/*  147 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  148 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  149 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Gang _o_) {
/*  154 */     _o_._xdb_verify_unsafe_();
/*  155 */     this.name = _o_.name;
/*  156 */     this.level = _o_.level;
/*  157 */     this.createtime = _o_.createtime;
/*  158 */     this.purpose = _o_.purpose;
/*  159 */     this.bangzhuid = _o_.bangzhuid;
/*  160 */     this.designtitlecaseid = _o_.designtitlecaseid;
/*  161 */     this.vitality = _o_.vitality;
/*  162 */     this.leveluptime = _o_.leveluptime;
/*  163 */     this.announcementhistorylist = new ArrayList();
/*  164 */     for (xbean.GangAnnouncement _v_ : _o_.announcementhistorylist)
/*  165 */       this.announcementhistorylist.add(new GangAnnouncement(_v_, this, "announcementhistorylist"));
/*  166 */     this.apprenticemaxlv = _o_.apprenticemaxlv;
/*  167 */     this.timestamp = _o_.timestamp;
/*  168 */     this.lastrename = _o_.lastrename;
/*  169 */     this.forbiddentalkcount = _o_.forbiddentalkcount;
/*  170 */     this.tanheroleid = _o_.tanheroleid;
/*  171 */     this.tanheendtime = _o_.tanheendtime;
/*  172 */     this.juanzhongnum = _o_.juanzhongnum;
/*  173 */     this.nextid = _o_.nextid;
/*  174 */     this.publishtime = _o_.publishtime;
/*  175 */     this.ganghelperlist = new LinkedList();
/*  176 */     for (xbean.GangHelper _v_ : _o_.ganghelperlist)
/*  177 */       this.ganghelperlist.add(new GangHelper(_v_, this, "ganghelperlist"));
/*  178 */     this.xiangfang = new XiangFang(_o_.xiangfang, this, "xiangfang");
/*  179 */     this.jinku = new JinKu(_o_.jinku, this, "jinku");
/*  180 */     this.yaodian = new YaoDian(_o_.yaodian, this, "yaodian");
/*  181 */     this.cangku = new CangKu(_o_.cangku, this, "cangku");
/*  182 */     this.shuyuan = new ShuYuan(_o_.shuyuan, this, "shuyuan");
/*  183 */     this.duty2members = new HashMap();
/*  184 */     for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : _o_.duty2members.entrySet())
/*  185 */       this.duty2members.put(_e_.getKey(), new GangDutyMembers((xbean.GangDutyMembers)_e_.getValue(), this, "duty2members"));
/*  186 */     this.periodmoney = _o_.periodmoney;
/*  187 */     this.grouproleid = _o_.grouproleid;
/*  188 */     this.groupopenid = _o_.groupopenid;
/*  189 */     this.displayid = _o_.displayid;
/*  190 */     this.teams = new HashMap();
/*  191 */     for (Map.Entry<Long, xbean.GangTeam> _e_ : _o_.teams.entrySet())
/*  192 */       this.teams.put(_e_.getKey(), new GangTeam((xbean.GangTeam)_e_.getValue(), this, "teams"));
/*  193 */     this.member2teamid = new HashMap();
/*  194 */     for (Map.Entry<Long, Long> _e_ : _o_.member2teamid.entrySet())
/*  195 */       this.member2teamid.put(_e_.getKey(), _e_.getValue());
/*  196 */     this.next_teamid = _o_.next_teamid;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  201 */     this.name = _o_.name;
/*  202 */     this.level = _o_.level;
/*  203 */     this.createtime = _o_.createtime;
/*  204 */     this.purpose = _o_.purpose;
/*  205 */     this.bangzhuid = _o_.bangzhuid;
/*  206 */     this.designtitlecaseid = _o_.designtitlecaseid;
/*  207 */     this.vitality = _o_.vitality;
/*  208 */     this.leveluptime = _o_.leveluptime;
/*  209 */     this.announcementhistorylist = new ArrayList();
/*  210 */     for (xbean.GangAnnouncement _v_ : _o_.announcementhistorylist)
/*  211 */       this.announcementhistorylist.add(new GangAnnouncement(_v_, this, "announcementhistorylist"));
/*  212 */     this.apprenticemaxlv = _o_.apprenticemaxlv;
/*  213 */     this.timestamp = _o_.timestamp;
/*  214 */     this.lastrename = _o_.lastrename;
/*  215 */     this.forbiddentalkcount = _o_.forbiddentalkcount;
/*  216 */     this.tanheroleid = _o_.tanheroleid;
/*  217 */     this.tanheendtime = _o_.tanheendtime;
/*  218 */     this.juanzhongnum = _o_.juanzhongnum;
/*  219 */     this.nextid = _o_.nextid;
/*  220 */     this.publishtime = _o_.publishtime;
/*  221 */     this.ganghelperlist = new LinkedList();
/*  222 */     for (xbean.GangHelper _v_ : _o_.ganghelperlist)
/*  223 */       this.ganghelperlist.add(new GangHelper(_v_, this, "ganghelperlist"));
/*  224 */     this.xiangfang = new XiangFang(_o_.xiangfang, this, "xiangfang");
/*  225 */     this.jinku = new JinKu(_o_.jinku, this, "jinku");
/*  226 */     this.yaodian = new YaoDian(_o_.yaodian, this, "yaodian");
/*  227 */     this.cangku = new CangKu(_o_.cangku, this, "cangku");
/*  228 */     this.shuyuan = new ShuYuan(_o_.shuyuan, this, "shuyuan");
/*  229 */     this.duty2members = new HashMap();
/*  230 */     for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : _o_.duty2members.entrySet())
/*  231 */       this.duty2members.put(_e_.getKey(), new GangDutyMembers((xbean.GangDutyMembers)_e_.getValue(), this, "duty2members"));
/*  232 */     this.periodmoney = _o_.periodmoney;
/*  233 */     this.grouproleid = _o_.grouproleid;
/*  234 */     this.groupopenid = _o_.groupopenid;
/*  235 */     this.displayid = _o_.displayid;
/*  236 */     this.teams = new HashMap();
/*  237 */     for (Map.Entry<Long, xbean.GangTeam> _e_ : _o_.teams.entrySet())
/*  238 */       this.teams.put(_e_.getKey(), new GangTeam((xbean.GangTeam)_e_.getValue(), this, "teams"));
/*  239 */     this.member2teamid = new HashMap();
/*  240 */     for (Map.Entry<Long, Long> _e_ : _o_.member2teamid.entrySet())
/*  241 */       this.member2teamid.put(_e_.getKey(), _e_.getValue());
/*  242 */     this.next_teamid = _o_.next_teamid;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  248 */     _xdb_verify_unsafe_();
/*  249 */     _os_.marshal(this.name, "UTF-16LE");
/*  250 */     _os_.marshal(this.level);
/*  251 */     _os_.marshal(this.createtime);
/*  252 */     _os_.marshal(this.purpose, "UTF-16LE");
/*  253 */     _os_.marshal(this.bangzhuid);
/*  254 */     _os_.marshal(this.designtitlecaseid);
/*  255 */     _os_.marshal(this.vitality);
/*  256 */     _os_.marshal(this.leveluptime);
/*  257 */     _os_.compact_uint32(this.announcementhistorylist.size());
/*  258 */     for (xbean.GangAnnouncement _v_ : this.announcementhistorylist)
/*      */     {
/*  260 */       _v_.marshal(_os_);
/*      */     }
/*  262 */     _os_.marshal(this.apprenticemaxlv);
/*  263 */     _os_.marshal(this.timestamp);
/*  264 */     _os_.marshal(this.lastrename);
/*  265 */     _os_.marshal(this.forbiddentalkcount);
/*  266 */     _os_.marshal(this.tanheroleid);
/*  267 */     _os_.marshal(this.tanheendtime);
/*  268 */     _os_.marshal(this.juanzhongnum);
/*  269 */     _os_.marshal(this.nextid);
/*  270 */     _os_.marshal(this.publishtime);
/*  271 */     _os_.compact_uint32(this.ganghelperlist.size());
/*  272 */     for (xbean.GangHelper _v_ : this.ganghelperlist)
/*      */     {
/*  274 */       _v_.marshal(_os_);
/*      */     }
/*  276 */     this.xiangfang.marshal(_os_);
/*  277 */     this.jinku.marshal(_os_);
/*  278 */     this.yaodian.marshal(_os_);
/*  279 */     this.cangku.marshal(_os_);
/*  280 */     this.shuyuan.marshal(_os_);
/*  281 */     _os_.compact_uint32(this.duty2members.size());
/*  282 */     for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : this.duty2members.entrySet())
/*      */     {
/*  284 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  285 */       ((xbean.GangDutyMembers)_e_.getValue()).marshal(_os_);
/*      */     }
/*  287 */     _os_.marshal(this.periodmoney);
/*  288 */     _os_.marshal(this.grouproleid);
/*  289 */     _os_.marshal(this.groupopenid, "UTF-16LE");
/*  290 */     _os_.marshal(this.displayid);
/*  291 */     _os_.compact_uint32(this.teams.size());
/*  292 */     for (Map.Entry<Long, xbean.GangTeam> _e_ : this.teams.entrySet())
/*      */     {
/*  294 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  295 */       ((xbean.GangTeam)_e_.getValue()).marshal(_os_);
/*      */     }
/*  297 */     _os_.compact_uint32(this.member2teamid.size());
/*  298 */     for (Map.Entry<Long, Long> _e_ : this.member2teamid.entrySet())
/*      */     {
/*  300 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  301 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */     }
/*  303 */     _os_.marshal(this.next_teamid);
/*  304 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*  311 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  312 */     this.level = _os_.unmarshal_int();
/*  313 */     this.createtime = _os_.unmarshal_long();
/*  314 */     this.purpose = _os_.unmarshal_String("UTF-16LE");
/*  315 */     this.bangzhuid = _os_.unmarshal_long();
/*  316 */     this.designtitlecaseid = _os_.unmarshal_int();
/*  317 */     this.vitality = _os_.unmarshal_int();
/*  318 */     this.leveluptime = _os_.unmarshal_long();
/*  319 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  321 */       xbean.GangAnnouncement _v_ = new GangAnnouncement(0, this, "announcementhistorylist");
/*  322 */       _v_.unmarshal(_os_);
/*  323 */       this.announcementhistorylist.add(_v_);
/*      */     }
/*  325 */     this.apprenticemaxlv = _os_.unmarshal_int();
/*  326 */     this.timestamp = _os_.unmarshal_long();
/*  327 */     this.lastrename = _os_.unmarshal_long();
/*  328 */     this.forbiddentalkcount = _os_.unmarshal_int();
/*  329 */     this.tanheroleid = _os_.unmarshal_long();
/*  330 */     this.tanheendtime = _os_.unmarshal_long();
/*  331 */     this.juanzhongnum = _os_.unmarshal_int();
/*  332 */     this.nextid = _os_.unmarshal_long();
/*  333 */     this.publishtime = _os_.unmarshal_int();
/*  334 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  336 */       xbean.GangHelper _v_ = new GangHelper(0, this, "ganghelperlist");
/*  337 */       _v_.unmarshal(_os_);
/*  338 */       this.ganghelperlist.add(_v_);
/*      */     }
/*  340 */     this.xiangfang.unmarshal(_os_);
/*  341 */     this.jinku.unmarshal(_os_);
/*  342 */     this.yaodian.unmarshal(_os_);
/*  343 */     this.cangku.unmarshal(_os_);
/*  344 */     this.shuyuan.unmarshal(_os_);
/*      */     
/*  346 */     int size = _os_.uncompact_uint32();
/*  347 */     if (size >= 12)
/*      */     {
/*  349 */       this.duty2members = new HashMap(size * 2);
/*      */     }
/*  351 */     for (; size > 0; size--)
/*      */     {
/*  353 */       int _k_ = 0;
/*  354 */       _k_ = _os_.unmarshal_int();
/*  355 */       xbean.GangDutyMembers _v_ = new GangDutyMembers(0, this, "duty2members");
/*  356 */       _v_.unmarshal(_os_);
/*  357 */       this.duty2members.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  360 */     this.periodmoney = _os_.unmarshal_int();
/*  361 */     this.grouproleid = _os_.unmarshal_long();
/*  362 */     this.groupopenid = _os_.unmarshal_String("UTF-16LE");
/*  363 */     this.displayid = _os_.unmarshal_long();
/*      */     
/*  365 */     int size = _os_.uncompact_uint32();
/*  366 */     if (size >= 12)
/*      */     {
/*  368 */       this.teams = new HashMap(size * 2);
/*      */     }
/*  370 */     for (; size > 0; size--)
/*      */     {
/*  372 */       long _k_ = 0L;
/*  373 */       _k_ = _os_.unmarshal_long();
/*  374 */       xbean.GangTeam _v_ = new GangTeam(0, this, "teams");
/*  375 */       _v_.unmarshal(_os_);
/*  376 */       this.teams.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  380 */     int size = _os_.uncompact_uint32();
/*  381 */     if (size >= 12)
/*      */     {
/*  383 */       this.member2teamid = new HashMap(size * 2);
/*      */     }
/*  385 */     for (; size > 0; size--)
/*      */     {
/*  387 */       long _k_ = 0L;
/*  388 */       _k_ = _os_.unmarshal_long();
/*  389 */       long _v_ = 0L;
/*  390 */       _v_ = _os_.unmarshal_long();
/*  391 */       this.member2teamid.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*      */     }
/*      */     
/*  394 */     this.next_teamid = _os_.unmarshal_long();
/*  395 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  401 */     _xdb_verify_unsafe_();
/*  402 */     int _size_ = 0;
/*      */     try
/*      */     {
/*  405 */       _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  409 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  411 */     _size_ += CodedOutputStream.computeInt32Size(2, this.level);
/*  412 */     _size_ += CodedOutputStream.computeInt64Size(3, this.createtime);
/*      */     try
/*      */     {
/*  415 */       _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.purpose, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  419 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  421 */     _size_ += CodedOutputStream.computeInt64Size(5, this.bangzhuid);
/*  422 */     _size_ += CodedOutputStream.computeInt32Size(6, this.designtitlecaseid);
/*  423 */     _size_ += CodedOutputStream.computeInt32Size(7, this.vitality);
/*  424 */     _size_ += CodedOutputStream.computeInt64Size(8, this.leveluptime);
/*  425 */     for (xbean.GangAnnouncement _v_ : this.announcementhistorylist)
/*      */     {
/*  427 */       _size_ += CodedOutputStream.computeMessageSize(9, _v_);
/*      */     }
/*  429 */     _size_ += CodedOutputStream.computeInt32Size(10, this.apprenticemaxlv);
/*  430 */     _size_ += CodedOutputStream.computeInt64Size(12, this.timestamp);
/*  431 */     _size_ += CodedOutputStream.computeInt64Size(13, this.lastrename);
/*  432 */     _size_ += CodedOutputStream.computeInt32Size(14, this.forbiddentalkcount);
/*  433 */     _size_ += CodedOutputStream.computeInt64Size(15, this.tanheroleid);
/*  434 */     _size_ += CodedOutputStream.computeInt64Size(16, this.tanheendtime);
/*  435 */     _size_ += CodedOutputStream.computeInt32Size(17, this.juanzhongnum);
/*  436 */     _size_ += CodedOutputStream.computeInt64Size(18, this.nextid);
/*  437 */     _size_ += CodedOutputStream.computeInt32Size(19, this.publishtime);
/*  438 */     for (xbean.GangHelper _v_ : this.ganghelperlist)
/*      */     {
/*  440 */       _size_ += CodedOutputStream.computeMessageSize(20, _v_);
/*      */     }
/*  442 */     _size_ += CodedOutputStream.computeMessageSize(21, this.xiangfang);
/*  443 */     _size_ += CodedOutputStream.computeMessageSize(22, this.jinku);
/*  444 */     _size_ += CodedOutputStream.computeMessageSize(23, this.yaodian);
/*  445 */     _size_ += CodedOutputStream.computeMessageSize(24, this.cangku);
/*  446 */     _size_ += CodedOutputStream.computeMessageSize(25, this.shuyuan);
/*  447 */     for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : this.duty2members.entrySet())
/*      */     {
/*  449 */       _size_ += CodedOutputStream.computeInt32Size(26, ((Integer)_e_.getKey()).intValue());
/*  450 */       _size_ += CodedOutputStream.computeMessageSize(26, (Message)_e_.getValue());
/*      */     }
/*  452 */     _size_ += CodedOutputStream.computeInt32Size(27, this.periodmoney);
/*  453 */     _size_ += CodedOutputStream.computeInt64Size(28, this.grouproleid);
/*      */     try
/*      */     {
/*  456 */       _size_ += CodedOutputStream.computeBytesSize(30, ByteString.copyFrom(this.groupopenid, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  460 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  462 */     _size_ += CodedOutputStream.computeInt64Size(32, this.displayid);
/*  463 */     for (Map.Entry<Long, xbean.GangTeam> _e_ : this.teams.entrySet())
/*      */     {
/*  465 */       _size_ += CodedOutputStream.computeInt64Size(33, ((Long)_e_.getKey()).longValue());
/*  466 */       _size_ += CodedOutputStream.computeMessageSize(33, (Message)_e_.getValue());
/*      */     }
/*  468 */     for (Map.Entry<Long, Long> _e_ : this.member2teamid.entrySet())
/*      */     {
/*  470 */       _size_ += CodedOutputStream.computeInt64Size(34, ((Long)_e_.getKey()).longValue());
/*  471 */       _size_ += CodedOutputStream.computeInt64Size(34, ((Long)_e_.getValue()).longValue());
/*      */     }
/*  473 */     _size_ += CodedOutputStream.computeInt64Size(35, this.next_teamid);
/*  474 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  480 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  483 */       _output_.writeBytes(1, ByteString.copyFrom(this.name, "UTF-16LE"));
/*  484 */       _output_.writeInt32(2, this.level);
/*  485 */       _output_.writeInt64(3, this.createtime);
/*  486 */       _output_.writeBytes(4, ByteString.copyFrom(this.purpose, "UTF-16LE"));
/*  487 */       _output_.writeInt64(5, this.bangzhuid);
/*  488 */       _output_.writeInt32(6, this.designtitlecaseid);
/*  489 */       _output_.writeInt32(7, this.vitality);
/*  490 */       _output_.writeInt64(8, this.leveluptime);
/*  491 */       for (xbean.GangAnnouncement _v_ : this.announcementhistorylist)
/*      */       {
/*  493 */         _output_.writeMessage(9, _v_);
/*      */       }
/*  495 */       _output_.writeInt32(10, this.apprenticemaxlv);
/*  496 */       _output_.writeInt64(12, this.timestamp);
/*  497 */       _output_.writeInt64(13, this.lastrename);
/*  498 */       _output_.writeInt32(14, this.forbiddentalkcount);
/*  499 */       _output_.writeInt64(15, this.tanheroleid);
/*  500 */       _output_.writeInt64(16, this.tanheendtime);
/*  501 */       _output_.writeInt32(17, this.juanzhongnum);
/*  502 */       _output_.writeInt64(18, this.nextid);
/*  503 */       _output_.writeInt32(19, this.publishtime);
/*  504 */       for (xbean.GangHelper _v_ : this.ganghelperlist)
/*      */       {
/*  506 */         _output_.writeMessage(20, _v_);
/*      */       }
/*  508 */       _output_.writeMessage(21, this.xiangfang);
/*  509 */       _output_.writeMessage(22, this.jinku);
/*  510 */       _output_.writeMessage(23, this.yaodian);
/*  511 */       _output_.writeMessage(24, this.cangku);
/*  512 */       _output_.writeMessage(25, this.shuyuan);
/*  513 */       for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : this.duty2members.entrySet())
/*      */       {
/*  515 */         _output_.writeInt32(26, ((Integer)_e_.getKey()).intValue());
/*  516 */         _output_.writeMessage(26, (Message)_e_.getValue());
/*      */       }
/*  518 */       _output_.writeInt32(27, this.periodmoney);
/*  519 */       _output_.writeInt64(28, this.grouproleid);
/*  520 */       _output_.writeBytes(30, ByteString.copyFrom(this.groupopenid, "UTF-16LE"));
/*  521 */       _output_.writeInt64(32, this.displayid);
/*  522 */       for (Map.Entry<Long, xbean.GangTeam> _e_ : this.teams.entrySet())
/*      */       {
/*  524 */         _output_.writeInt64(33, ((Long)_e_.getKey()).longValue());
/*  525 */         _output_.writeMessage(33, (Message)_e_.getValue());
/*      */       }
/*  527 */       for (Map.Entry<Long, Long> _e_ : this.member2teamid.entrySet())
/*      */       {
/*  529 */         _output_.writeInt64(34, ((Long)_e_.getKey()).longValue());
/*  530 */         _output_.writeInt64(34, ((Long)_e_.getValue()).longValue());
/*      */       }
/*  532 */       _output_.writeInt64(35, this.next_teamid);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  536 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  538 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  544 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  547 */       boolean done = false;
/*  548 */       while (!done)
/*      */       {
/*  550 */         int tag = _input_.readTag();
/*  551 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  555 */           done = true;
/*  556 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  560 */           this.name = _input_.readBytes().toString("UTF-16LE");
/*  561 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  565 */           this.level = _input_.readInt32();
/*  566 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  570 */           this.createtime = _input_.readInt64();
/*  571 */           break;
/*      */         
/*      */ 
/*      */         case 34: 
/*  575 */           this.purpose = _input_.readBytes().toString("UTF-16LE");
/*  576 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  580 */           this.bangzhuid = _input_.readInt64();
/*  581 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  585 */           this.designtitlecaseid = _input_.readInt32();
/*  586 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  590 */           this.vitality = _input_.readInt32();
/*  591 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  595 */           this.leveluptime = _input_.readInt64();
/*  596 */           break;
/*      */         
/*      */ 
/*      */         case 74: 
/*  600 */           xbean.GangAnnouncement _v_ = new GangAnnouncement(0, this, "announcementhistorylist");
/*  601 */           _input_.readMessage(_v_);
/*  602 */           this.announcementhistorylist.add(_v_);
/*  603 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  607 */           this.apprenticemaxlv = _input_.readInt32();
/*  608 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  612 */           this.timestamp = _input_.readInt64();
/*  613 */           break;
/*      */         
/*      */ 
/*      */         case 104: 
/*  617 */           this.lastrename = _input_.readInt64();
/*  618 */           break;
/*      */         
/*      */ 
/*      */         case 112: 
/*  622 */           this.forbiddentalkcount = _input_.readInt32();
/*  623 */           break;
/*      */         
/*      */ 
/*      */         case 120: 
/*  627 */           this.tanheroleid = _input_.readInt64();
/*  628 */           break;
/*      */         
/*      */ 
/*      */         case 128: 
/*  632 */           this.tanheendtime = _input_.readInt64();
/*  633 */           break;
/*      */         
/*      */ 
/*      */         case 136: 
/*  637 */           this.juanzhongnum = _input_.readInt32();
/*  638 */           break;
/*      */         
/*      */ 
/*      */         case 144: 
/*  642 */           this.nextid = _input_.readInt64();
/*  643 */           break;
/*      */         
/*      */ 
/*      */         case 152: 
/*  647 */           this.publishtime = _input_.readInt32();
/*  648 */           break;
/*      */         
/*      */ 
/*      */         case 162: 
/*  652 */           xbean.GangHelper _v_ = new GangHelper(0, this, "ganghelperlist");
/*  653 */           _input_.readMessage(_v_);
/*  654 */           this.ganghelperlist.add(_v_);
/*  655 */           break;
/*      */         
/*      */ 
/*      */         case 170: 
/*  659 */           _input_.readMessage(this.xiangfang);
/*  660 */           break;
/*      */         
/*      */ 
/*      */         case 178: 
/*  664 */           _input_.readMessage(this.jinku);
/*  665 */           break;
/*      */         
/*      */ 
/*      */         case 186: 
/*  669 */           _input_.readMessage(this.yaodian);
/*  670 */           break;
/*      */         
/*      */ 
/*      */         case 194: 
/*  674 */           _input_.readMessage(this.cangku);
/*  675 */           break;
/*      */         
/*      */ 
/*      */         case 202: 
/*  679 */           _input_.readMessage(this.shuyuan);
/*  680 */           break;
/*      */         
/*      */ 
/*      */         case 208: 
/*  684 */           int _k_ = 0;
/*  685 */           _k_ = _input_.readInt32();
/*  686 */           int readTag = _input_.readTag();
/*  687 */           if (210 != readTag)
/*      */           {
/*  689 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  691 */           xbean.GangDutyMembers _v_ = new GangDutyMembers(0, this, "duty2members");
/*  692 */           _input_.readMessage(_v_);
/*  693 */           this.duty2members.put(Integer.valueOf(_k_), _v_);
/*  694 */           break;
/*      */         
/*      */ 
/*      */         case 216: 
/*  698 */           this.periodmoney = _input_.readInt32();
/*  699 */           break;
/*      */         
/*      */ 
/*      */         case 224: 
/*  703 */           this.grouproleid = _input_.readInt64();
/*  704 */           break;
/*      */         
/*      */ 
/*      */         case 242: 
/*  708 */           this.groupopenid = _input_.readBytes().toString("UTF-16LE");
/*  709 */           break;
/*      */         
/*      */ 
/*      */         case 256: 
/*  713 */           this.displayid = _input_.readInt64();
/*  714 */           break;
/*      */         
/*      */ 
/*      */         case 264: 
/*  718 */           long _k_ = 0L;
/*  719 */           _k_ = _input_.readInt64();
/*  720 */           int readTag = _input_.readTag();
/*  721 */           if (266 != readTag)
/*      */           {
/*  723 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  725 */           xbean.GangTeam _v_ = new GangTeam(0, this, "teams");
/*  726 */           _input_.readMessage(_v_);
/*  727 */           this.teams.put(Long.valueOf(_k_), _v_);
/*  728 */           break;
/*      */         
/*      */ 
/*      */         case 272: 
/*  732 */           long _k_ = 0L;
/*  733 */           _k_ = _input_.readInt64();
/*  734 */           int readTag = _input_.readTag();
/*  735 */           if (272 != readTag)
/*      */           {
/*  737 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  739 */           long _v_ = 0L;
/*  740 */           _v_ = _input_.readInt64();
/*  741 */           this.member2teamid.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*  742 */           break;
/*      */         
/*      */ 
/*      */         case 280: 
/*  746 */           this.next_teamid = _input_.readInt64();
/*  747 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  751 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  753 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  762 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  766 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  768 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Gang copy()
/*      */   {
/*  774 */     _xdb_verify_unsafe_();
/*  775 */     return new Gang(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Gang toData()
/*      */   {
/*  781 */     _xdb_verify_unsafe_();
/*  782 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Gang toBean()
/*      */   {
/*  787 */     _xdb_verify_unsafe_();
/*  788 */     return new Gang(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Gang toDataIf()
/*      */   {
/*  794 */     _xdb_verify_unsafe_();
/*  795 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Gang toBeanIf()
/*      */   {
/*  800 */     _xdb_verify_unsafe_();
/*  801 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  807 */     _xdb_verify_unsafe_();
/*  808 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getName()
/*      */   {
/*  815 */     _xdb_verify_unsafe_();
/*  816 */     return this.name;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getNameOctets()
/*      */   {
/*  823 */     _xdb_verify_unsafe_();
/*  824 */     return Octets.wrap(getName(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLevel()
/*      */   {
/*  831 */     _xdb_verify_unsafe_();
/*  832 */     return this.level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCreatetime()
/*      */   {
/*  839 */     _xdb_verify_unsafe_();
/*  840 */     return this.createtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getPurpose()
/*      */   {
/*  847 */     _xdb_verify_unsafe_();
/*  848 */     return this.purpose;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getPurposeOctets()
/*      */   {
/*  855 */     _xdb_verify_unsafe_();
/*  856 */     return Octets.wrap(getPurpose(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBangzhuid()
/*      */   {
/*  863 */     _xdb_verify_unsafe_();
/*  864 */     return this.bangzhuid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDesigntitlecaseid()
/*      */   {
/*  871 */     _xdb_verify_unsafe_();
/*  872 */     return this.designtitlecaseid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getVitality()
/*      */   {
/*  879 */     _xdb_verify_unsafe_();
/*  880 */     return this.vitality;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLeveluptime()
/*      */   {
/*  887 */     _xdb_verify_unsafe_();
/*  888 */     return this.leveluptime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.GangAnnouncement> getAnnouncementhistorylist()
/*      */   {
/*  895 */     _xdb_verify_unsafe_();
/*  896 */     return Logs.logList(new LogKey(this, "announcementhistorylist"), this.announcementhistorylist);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.GangAnnouncement> getAnnouncementhistorylistAsData()
/*      */   {
/*  902 */     _xdb_verify_unsafe_();
/*      */     
/*  904 */     Gang _o_ = this;
/*  905 */     List<xbean.GangAnnouncement> announcementhistorylist = new ArrayList();
/*  906 */     for (xbean.GangAnnouncement _v_ : _o_.announcementhistorylist)
/*  907 */       announcementhistorylist.add(new GangAnnouncement.Data(_v_));
/*  908 */     return announcementhistorylist;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getApprenticemaxlv()
/*      */   {
/*  915 */     _xdb_verify_unsafe_();
/*  916 */     return this.apprenticemaxlv;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTimestamp()
/*      */   {
/*  923 */     _xdb_verify_unsafe_();
/*  924 */     return this.timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLastrename()
/*      */   {
/*  931 */     _xdb_verify_unsafe_();
/*  932 */     return this.lastrename;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getForbiddentalkcount()
/*      */   {
/*  939 */     _xdb_verify_unsafe_();
/*  940 */     return this.forbiddentalkcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTanheroleid()
/*      */   {
/*  947 */     _xdb_verify_unsafe_();
/*  948 */     return this.tanheroleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTanheendtime()
/*      */   {
/*  955 */     _xdb_verify_unsafe_();
/*  956 */     return this.tanheendtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getJuanzhongnum()
/*      */   {
/*  963 */     _xdb_verify_unsafe_();
/*  964 */     return this.juanzhongnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getNextid()
/*      */   {
/*  971 */     _xdb_verify_unsafe_();
/*  972 */     return this.nextid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPublishtime()
/*      */   {
/*  979 */     _xdb_verify_unsafe_();
/*  980 */     return this.publishtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.GangHelper> getGanghelperlist()
/*      */   {
/*  987 */     _xdb_verify_unsafe_();
/*  988 */     return Logs.logList(new LogKey(this, "ganghelperlist"), this.ganghelperlist);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.GangHelper> getGanghelperlistAsData()
/*      */   {
/*  994 */     _xdb_verify_unsafe_();
/*      */     
/*  996 */     Gang _o_ = this;
/*  997 */     List<xbean.GangHelper> ganghelperlist = new LinkedList();
/*  998 */     for (xbean.GangHelper _v_ : _o_.ganghelperlist)
/*  999 */       ganghelperlist.add(new GangHelper.Data(_v_));
/* 1000 */     return ganghelperlist;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.XiangFang getXiangfang()
/*      */   {
/* 1007 */     _xdb_verify_unsafe_();
/* 1008 */     return this.xiangfang;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.JinKu getJinku()
/*      */   {
/* 1015 */     _xdb_verify_unsafe_();
/* 1016 */     return this.jinku;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.YaoDian getYaodian()
/*      */   {
/* 1023 */     _xdb_verify_unsafe_();
/* 1024 */     return this.yaodian;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.CangKu getCangku()
/*      */   {
/* 1031 */     _xdb_verify_unsafe_();
/* 1032 */     return this.cangku;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.ShuYuan getShuyuan()
/*      */   {
/* 1039 */     _xdb_verify_unsafe_();
/* 1040 */     return this.shuyuan;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.GangDutyMembers> getDuty2members()
/*      */   {
/* 1047 */     _xdb_verify_unsafe_();
/* 1048 */     return Logs.logMap(new LogKey(this, "duty2members"), this.duty2members);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.GangDutyMembers> getDuty2membersAsData()
/*      */   {
/* 1055 */     _xdb_verify_unsafe_();
/*      */     
/* 1057 */     Gang _o_ = this;
/* 1058 */     Map<Integer, xbean.GangDutyMembers> duty2members = new HashMap();
/* 1059 */     for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : _o_.duty2members.entrySet())
/* 1060 */       duty2members.put(_e_.getKey(), new GangDutyMembers.Data((xbean.GangDutyMembers)_e_.getValue()));
/* 1061 */     return duty2members;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPeriodmoney()
/*      */   {
/* 1068 */     _xdb_verify_unsafe_();
/* 1069 */     return this.periodmoney;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getGrouproleid()
/*      */   {
/* 1076 */     _xdb_verify_unsafe_();
/* 1077 */     return this.grouproleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getGroupopenid()
/*      */   {
/* 1084 */     _xdb_verify_unsafe_();
/* 1085 */     return this.groupopenid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getGroupopenidOctets()
/*      */   {
/* 1092 */     _xdb_verify_unsafe_();
/* 1093 */     return Octets.wrap(getGroupopenid(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getDisplayid()
/*      */   {
/* 1100 */     _xdb_verify_unsafe_();
/* 1101 */     return this.displayid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.GangTeam> getTeams()
/*      */   {
/* 1108 */     _xdb_verify_unsafe_();
/* 1109 */     return Logs.logMap(new LogKey(this, "teams"), this.teams);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.GangTeam> getTeamsAsData()
/*      */   {
/* 1116 */     _xdb_verify_unsafe_();
/*      */     
/* 1118 */     Gang _o_ = this;
/* 1119 */     Map<Long, xbean.GangTeam> teams = new HashMap();
/* 1120 */     for (Map.Entry<Long, xbean.GangTeam> _e_ : _o_.teams.entrySet())
/* 1121 */       teams.put(_e_.getKey(), new GangTeam.Data((xbean.GangTeam)_e_.getValue()));
/* 1122 */     return teams;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Long> getMember2teamid()
/*      */   {
/* 1129 */     _xdb_verify_unsafe_();
/* 1130 */     return Logs.logMap(new LogKey(this, "member2teamid"), this.member2teamid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Long> getMember2teamidAsData()
/*      */   {
/* 1137 */     _xdb_verify_unsafe_();
/*      */     
/* 1139 */     Gang _o_ = this;
/* 1140 */     Map<Long, Long> member2teamid = new HashMap();
/* 1141 */     for (Map.Entry<Long, Long> _e_ : _o_.member2teamid.entrySet())
/* 1142 */       member2teamid.put(_e_.getKey(), _e_.getValue());
/* 1143 */     return member2teamid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getNext_teamid()
/*      */   {
/* 1150 */     _xdb_verify_unsafe_();
/* 1151 */     return this.next_teamid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName(String _v_)
/*      */   {
/* 1158 */     _xdb_verify_unsafe_();
/* 1159 */     if (null == _v_)
/* 1160 */       throw new NullPointerException();
/* 1161 */     Logs.logIf(new LogKey(this, "name")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1165 */         new LogString(this, Gang.this.name)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1169 */             Gang.this.name = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1173 */     });
/* 1174 */     this.name = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNameOctets(Octets _v_)
/*      */   {
/* 1181 */     _xdb_verify_unsafe_();
/* 1182 */     setName(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLevel(int _v_)
/*      */   {
/* 1189 */     _xdb_verify_unsafe_();
/* 1190 */     Logs.logIf(new LogKey(this, "level")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1194 */         new LogInt(this, Gang.this.level)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1198 */             Gang.this.level = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1202 */     });
/* 1203 */     this.level = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCreatetime(long _v_)
/*      */   {
/* 1210 */     _xdb_verify_unsafe_();
/* 1211 */     Logs.logIf(new LogKey(this, "createtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1215 */         new LogLong(this, Gang.this.createtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1219 */             Gang.this.createtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1223 */     });
/* 1224 */     this.createtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPurpose(String _v_)
/*      */   {
/* 1231 */     _xdb_verify_unsafe_();
/* 1232 */     if (null == _v_)
/* 1233 */       throw new NullPointerException();
/* 1234 */     Logs.logIf(new LogKey(this, "purpose")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1238 */         new LogString(this, Gang.this.purpose)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1242 */             Gang.this.purpose = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1246 */     });
/* 1247 */     this.purpose = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPurposeOctets(Octets _v_)
/*      */   {
/* 1254 */     _xdb_verify_unsafe_();
/* 1255 */     setPurpose(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBangzhuid(long _v_)
/*      */   {
/* 1262 */     _xdb_verify_unsafe_();
/* 1263 */     Logs.logIf(new LogKey(this, "bangzhuid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1267 */         new LogLong(this, Gang.this.bangzhuid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1271 */             Gang.this.bangzhuid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1275 */     });
/* 1276 */     this.bangzhuid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDesigntitlecaseid(int _v_)
/*      */   {
/* 1283 */     _xdb_verify_unsafe_();
/* 1284 */     Logs.logIf(new LogKey(this, "designtitlecaseid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1288 */         new LogInt(this, Gang.this.designtitlecaseid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1292 */             Gang.this.designtitlecaseid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1296 */     });
/* 1297 */     this.designtitlecaseid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setVitality(int _v_)
/*      */   {
/* 1304 */     _xdb_verify_unsafe_();
/* 1305 */     Logs.logIf(new LogKey(this, "vitality")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1309 */         new LogInt(this, Gang.this.vitality)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1313 */             Gang.this.vitality = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1317 */     });
/* 1318 */     this.vitality = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLeveluptime(long _v_)
/*      */   {
/* 1325 */     _xdb_verify_unsafe_();
/* 1326 */     Logs.logIf(new LogKey(this, "leveluptime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1330 */         new LogLong(this, Gang.this.leveluptime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1334 */             Gang.this.leveluptime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1338 */     });
/* 1339 */     this.leveluptime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setApprenticemaxlv(int _v_)
/*      */   {
/* 1346 */     _xdb_verify_unsafe_();
/* 1347 */     Logs.logIf(new LogKey(this, "apprenticemaxlv")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1351 */         new LogInt(this, Gang.this.apprenticemaxlv)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1355 */             Gang.this.apprenticemaxlv = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1359 */     });
/* 1360 */     this.apprenticemaxlv = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTimestamp(long _v_)
/*      */   {
/* 1367 */     _xdb_verify_unsafe_();
/* 1368 */     Logs.logIf(new LogKey(this, "timestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1372 */         new LogLong(this, Gang.this.timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1376 */             Gang.this.timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1380 */     });
/* 1381 */     this.timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLastrename(long _v_)
/*      */   {
/* 1388 */     _xdb_verify_unsafe_();
/* 1389 */     Logs.logIf(new LogKey(this, "lastrename")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1393 */         new LogLong(this, Gang.this.lastrename)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1397 */             Gang.this.lastrename = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1401 */     });
/* 1402 */     this.lastrename = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setForbiddentalkcount(int _v_)
/*      */   {
/* 1409 */     _xdb_verify_unsafe_();
/* 1410 */     Logs.logIf(new LogKey(this, "forbiddentalkcount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1414 */         new LogInt(this, Gang.this.forbiddentalkcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1418 */             Gang.this.forbiddentalkcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1422 */     });
/* 1423 */     this.forbiddentalkcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTanheroleid(long _v_)
/*      */   {
/* 1430 */     _xdb_verify_unsafe_();
/* 1431 */     Logs.logIf(new LogKey(this, "tanheroleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1435 */         new LogLong(this, Gang.this.tanheroleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1439 */             Gang.this.tanheroleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1443 */     });
/* 1444 */     this.tanheroleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTanheendtime(long _v_)
/*      */   {
/* 1451 */     _xdb_verify_unsafe_();
/* 1452 */     Logs.logIf(new LogKey(this, "tanheendtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1456 */         new LogLong(this, Gang.this.tanheendtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1460 */             Gang.this.tanheendtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1464 */     });
/* 1465 */     this.tanheendtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setJuanzhongnum(int _v_)
/*      */   {
/* 1472 */     _xdb_verify_unsafe_();
/* 1473 */     Logs.logIf(new LogKey(this, "juanzhongnum")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1477 */         new LogInt(this, Gang.this.juanzhongnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1481 */             Gang.this.juanzhongnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1485 */     });
/* 1486 */     this.juanzhongnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNextid(long _v_)
/*      */   {
/* 1493 */     _xdb_verify_unsafe_();
/* 1494 */     Logs.logIf(new LogKey(this, "nextid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1498 */         new LogLong(this, Gang.this.nextid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1502 */             Gang.this.nextid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1506 */     });
/* 1507 */     this.nextid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPublishtime(int _v_)
/*      */   {
/* 1514 */     _xdb_verify_unsafe_();
/* 1515 */     Logs.logIf(new LogKey(this, "publishtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1519 */         new LogInt(this, Gang.this.publishtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1523 */             Gang.this.publishtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1527 */     });
/* 1528 */     this.publishtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPeriodmoney(int _v_)
/*      */   {
/* 1535 */     _xdb_verify_unsafe_();
/* 1536 */     Logs.logIf(new LogKey(this, "periodmoney")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1540 */         new LogInt(this, Gang.this.periodmoney)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1544 */             Gang.this.periodmoney = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1548 */     });
/* 1549 */     this.periodmoney = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGrouproleid(long _v_)
/*      */   {
/* 1556 */     _xdb_verify_unsafe_();
/* 1557 */     Logs.logIf(new LogKey(this, "grouproleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1561 */         new LogLong(this, Gang.this.grouproleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1565 */             Gang.this.grouproleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1569 */     });
/* 1570 */     this.grouproleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGroupopenid(String _v_)
/*      */   {
/* 1577 */     _xdb_verify_unsafe_();
/* 1578 */     if (null == _v_)
/* 1579 */       throw new NullPointerException();
/* 1580 */     Logs.logIf(new LogKey(this, "groupopenid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1584 */         new LogString(this, Gang.this.groupopenid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1588 */             Gang.this.groupopenid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1592 */     });
/* 1593 */     this.groupopenid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGroupopenidOctets(Octets _v_)
/*      */   {
/* 1600 */     _xdb_verify_unsafe_();
/* 1601 */     setGroupopenid(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDisplayid(long _v_)
/*      */   {
/* 1608 */     _xdb_verify_unsafe_();
/* 1609 */     Logs.logIf(new LogKey(this, "displayid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1613 */         new LogLong(this, Gang.this.displayid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1617 */             Gang.this.displayid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1621 */     });
/* 1622 */     this.displayid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNext_teamid(long _v_)
/*      */   {
/* 1629 */     _xdb_verify_unsafe_();
/* 1630 */     Logs.logIf(new LogKey(this, "next_teamid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1634 */         new LogLong(this, Gang.this.next_teamid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1638 */             Gang.this.next_teamid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1642 */     });
/* 1643 */     this.next_teamid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/* 1649 */     _xdb_verify_unsafe_();
/* 1650 */     Gang _o_ = null;
/* 1651 */     if ((_o1_ instanceof Gang)) { _o_ = (Gang)_o1_;
/* 1652 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 1653 */       return false;
/* 1654 */     if (!this.name.equals(_o_.name)) return false;
/* 1655 */     if (this.level != _o_.level) return false;
/* 1656 */     if (this.createtime != _o_.createtime) return false;
/* 1657 */     if (!this.purpose.equals(_o_.purpose)) return false;
/* 1658 */     if (this.bangzhuid != _o_.bangzhuid) return false;
/* 1659 */     if (this.designtitlecaseid != _o_.designtitlecaseid) return false;
/* 1660 */     if (this.vitality != _o_.vitality) return false;
/* 1661 */     if (this.leveluptime != _o_.leveluptime) return false;
/* 1662 */     if (!this.announcementhistorylist.equals(_o_.announcementhistorylist)) return false;
/* 1663 */     if (this.apprenticemaxlv != _o_.apprenticemaxlv) return false;
/* 1664 */     if (this.timestamp != _o_.timestamp) return false;
/* 1665 */     if (this.lastrename != _o_.lastrename) return false;
/* 1666 */     if (this.forbiddentalkcount != _o_.forbiddentalkcount) return false;
/* 1667 */     if (this.tanheroleid != _o_.tanheroleid) return false;
/* 1668 */     if (this.tanheendtime != _o_.tanheendtime) return false;
/* 1669 */     if (this.juanzhongnum != _o_.juanzhongnum) return false;
/* 1670 */     if (this.nextid != _o_.nextid) return false;
/* 1671 */     if (this.publishtime != _o_.publishtime) return false;
/* 1672 */     if (!this.ganghelperlist.equals(_o_.ganghelperlist)) return false;
/* 1673 */     if (!this.xiangfang.equals(_o_.xiangfang)) return false;
/* 1674 */     if (!this.jinku.equals(_o_.jinku)) return false;
/* 1675 */     if (!this.yaodian.equals(_o_.yaodian)) return false;
/* 1676 */     if (!this.cangku.equals(_o_.cangku)) return false;
/* 1677 */     if (!this.shuyuan.equals(_o_.shuyuan)) return false;
/* 1678 */     if (!this.duty2members.equals(_o_.duty2members)) return false;
/* 1679 */     if (this.periodmoney != _o_.periodmoney) return false;
/* 1680 */     if (this.grouproleid != _o_.grouproleid) return false;
/* 1681 */     if (!this.groupopenid.equals(_o_.groupopenid)) return false;
/* 1682 */     if (this.displayid != _o_.displayid) return false;
/* 1683 */     if (!this.teams.equals(_o_.teams)) return false;
/* 1684 */     if (!this.member2teamid.equals(_o_.member2teamid)) return false;
/* 1685 */     if (this.next_teamid != _o_.next_teamid) return false;
/* 1686 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/* 1692 */     _xdb_verify_unsafe_();
/* 1693 */     int _h_ = 0;
/* 1694 */     _h_ += this.name.hashCode();
/* 1695 */     _h_ += this.level;
/* 1696 */     _h_ = (int)(_h_ + this.createtime);
/* 1697 */     _h_ += this.purpose.hashCode();
/* 1698 */     _h_ = (int)(_h_ + this.bangzhuid);
/* 1699 */     _h_ += this.designtitlecaseid;
/* 1700 */     _h_ += this.vitality;
/* 1701 */     _h_ = (int)(_h_ + this.leveluptime);
/* 1702 */     _h_ += this.announcementhistorylist.hashCode();
/* 1703 */     _h_ += this.apprenticemaxlv;
/* 1704 */     _h_ = (int)(_h_ + this.timestamp);
/* 1705 */     _h_ = (int)(_h_ + this.lastrename);
/* 1706 */     _h_ += this.forbiddentalkcount;
/* 1707 */     _h_ = (int)(_h_ + this.tanheroleid);
/* 1708 */     _h_ = (int)(_h_ + this.tanheendtime);
/* 1709 */     _h_ += this.juanzhongnum;
/* 1710 */     _h_ = (int)(_h_ + this.nextid);
/* 1711 */     _h_ += this.publishtime;
/* 1712 */     _h_ += this.ganghelperlist.hashCode();
/* 1713 */     _h_ += this.xiangfang.hashCode();
/* 1714 */     _h_ += this.jinku.hashCode();
/* 1715 */     _h_ += this.yaodian.hashCode();
/* 1716 */     _h_ += this.cangku.hashCode();
/* 1717 */     _h_ += this.shuyuan.hashCode();
/* 1718 */     _h_ += this.duty2members.hashCode();
/* 1719 */     _h_ += this.periodmoney;
/* 1720 */     _h_ = (int)(_h_ + this.grouproleid);
/* 1721 */     _h_ += this.groupopenid.hashCode();
/* 1722 */     _h_ = (int)(_h_ + this.displayid);
/* 1723 */     _h_ += this.teams.hashCode();
/* 1724 */     _h_ += this.member2teamid.hashCode();
/* 1725 */     _h_ = (int)(_h_ + this.next_teamid);
/* 1726 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/* 1732 */     _xdb_verify_unsafe_();
/* 1733 */     StringBuilder _sb_ = new StringBuilder();
/* 1734 */     _sb_.append("(");
/* 1735 */     _sb_.append("'").append(this.name).append("'");
/* 1736 */     _sb_.append(",");
/* 1737 */     _sb_.append(this.level);
/* 1738 */     _sb_.append(",");
/* 1739 */     _sb_.append(this.createtime);
/* 1740 */     _sb_.append(",");
/* 1741 */     _sb_.append("'").append(this.purpose).append("'");
/* 1742 */     _sb_.append(",");
/* 1743 */     _sb_.append(this.bangzhuid);
/* 1744 */     _sb_.append(",");
/* 1745 */     _sb_.append(this.designtitlecaseid);
/* 1746 */     _sb_.append(",");
/* 1747 */     _sb_.append(this.vitality);
/* 1748 */     _sb_.append(",");
/* 1749 */     _sb_.append(this.leveluptime);
/* 1750 */     _sb_.append(",");
/* 1751 */     _sb_.append(this.announcementhistorylist);
/* 1752 */     _sb_.append(",");
/* 1753 */     _sb_.append(this.apprenticemaxlv);
/* 1754 */     _sb_.append(",");
/* 1755 */     _sb_.append(this.timestamp);
/* 1756 */     _sb_.append(",");
/* 1757 */     _sb_.append(this.lastrename);
/* 1758 */     _sb_.append(",");
/* 1759 */     _sb_.append(this.forbiddentalkcount);
/* 1760 */     _sb_.append(",");
/* 1761 */     _sb_.append(this.tanheroleid);
/* 1762 */     _sb_.append(",");
/* 1763 */     _sb_.append(this.tanheendtime);
/* 1764 */     _sb_.append(",");
/* 1765 */     _sb_.append(this.juanzhongnum);
/* 1766 */     _sb_.append(",");
/* 1767 */     _sb_.append(this.nextid);
/* 1768 */     _sb_.append(",");
/* 1769 */     _sb_.append(this.publishtime);
/* 1770 */     _sb_.append(",");
/* 1771 */     _sb_.append(this.ganghelperlist);
/* 1772 */     _sb_.append(",");
/* 1773 */     _sb_.append(this.xiangfang);
/* 1774 */     _sb_.append(",");
/* 1775 */     _sb_.append(this.jinku);
/* 1776 */     _sb_.append(",");
/* 1777 */     _sb_.append(this.yaodian);
/* 1778 */     _sb_.append(",");
/* 1779 */     _sb_.append(this.cangku);
/* 1780 */     _sb_.append(",");
/* 1781 */     _sb_.append(this.shuyuan);
/* 1782 */     _sb_.append(",");
/* 1783 */     _sb_.append(this.duty2members);
/* 1784 */     _sb_.append(",");
/* 1785 */     _sb_.append(this.periodmoney);
/* 1786 */     _sb_.append(",");
/* 1787 */     _sb_.append(this.grouproleid);
/* 1788 */     _sb_.append(",");
/* 1789 */     _sb_.append("'").append(this.groupopenid).append("'");
/* 1790 */     _sb_.append(",");
/* 1791 */     _sb_.append(this.displayid);
/* 1792 */     _sb_.append(",");
/* 1793 */     _sb_.append(this.teams);
/* 1794 */     _sb_.append(",");
/* 1795 */     _sb_.append(this.member2teamid);
/* 1796 */     _sb_.append(",");
/* 1797 */     _sb_.append(this.next_teamid);
/* 1798 */     _sb_.append(")");
/* 1799 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/* 1805 */     ListenableBean lb = new ListenableBean();
/* 1806 */     lb.add(new ListenableChanged().setVarName("name"));
/* 1807 */     lb.add(new ListenableChanged().setVarName("level"));
/* 1808 */     lb.add(new ListenableChanged().setVarName("createtime"));
/* 1809 */     lb.add(new ListenableChanged().setVarName("purpose"));
/* 1810 */     lb.add(new ListenableChanged().setVarName("bangzhuid"));
/* 1811 */     lb.add(new ListenableChanged().setVarName("designtitlecaseid"));
/* 1812 */     lb.add(new ListenableChanged().setVarName("vitality"));
/* 1813 */     lb.add(new ListenableChanged().setVarName("leveluptime"));
/* 1814 */     lb.add(new ListenableChanged().setVarName("announcementhistorylist"));
/* 1815 */     lb.add(new ListenableChanged().setVarName("apprenticemaxlv"));
/* 1816 */     lb.add(new ListenableChanged().setVarName("timestamp"));
/* 1817 */     lb.add(new ListenableChanged().setVarName("lastrename"));
/* 1818 */     lb.add(new ListenableChanged().setVarName("forbiddentalkcount"));
/* 1819 */     lb.add(new ListenableChanged().setVarName("tanheroleid"));
/* 1820 */     lb.add(new ListenableChanged().setVarName("tanheendtime"));
/* 1821 */     lb.add(new ListenableChanged().setVarName("juanzhongnum"));
/* 1822 */     lb.add(new ListenableChanged().setVarName("nextid"));
/* 1823 */     lb.add(new ListenableChanged().setVarName("publishtime"));
/* 1824 */     lb.add(new ListenableChanged().setVarName("ganghelperlist"));
/* 1825 */     lb.add(new ListenableChanged().setVarName("xiangfang"));
/* 1826 */     lb.add(new ListenableChanged().setVarName("jinku"));
/* 1827 */     lb.add(new ListenableChanged().setVarName("yaodian"));
/* 1828 */     lb.add(new ListenableChanged().setVarName("cangku"));
/* 1829 */     lb.add(new ListenableChanged().setVarName("shuyuan"));
/* 1830 */     lb.add(new ListenableMap().setVarName("duty2members"));
/* 1831 */     lb.add(new ListenableChanged().setVarName("periodmoney"));
/* 1832 */     lb.add(new ListenableChanged().setVarName("grouproleid"));
/* 1833 */     lb.add(new ListenableChanged().setVarName("groupopenid"));
/* 1834 */     lb.add(new ListenableChanged().setVarName("displayid"));
/* 1835 */     lb.add(new ListenableMap().setVarName("teams"));
/* 1836 */     lb.add(new ListenableMap().setVarName("member2teamid"));
/* 1837 */     lb.add(new ListenableChanged().setVarName("next_teamid"));
/* 1838 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Gang {
/*      */     private Const() {}
/*      */     
/*      */     Gang nThis() {
/* 1845 */       return Gang.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1851 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Gang copy()
/*      */     {
/* 1857 */       return Gang.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Gang toData()
/*      */     {
/* 1863 */       return Gang.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Gang toBean()
/*      */     {
/* 1868 */       return Gang.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Gang toDataIf()
/*      */     {
/* 1874 */       return Gang.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Gang toBeanIf()
/*      */     {
/* 1879 */       return Gang.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName()
/*      */     {
/* 1886 */       Gang.this._xdb_verify_unsafe_();
/* 1887 */       return Gang.this.name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNameOctets()
/*      */     {
/* 1894 */       Gang.this._xdb_verify_unsafe_();
/* 1895 */       return Gang.this.getNameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/* 1902 */       Gang.this._xdb_verify_unsafe_();
/* 1903 */       return Gang.this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreatetime()
/*      */     {
/* 1910 */       Gang.this._xdb_verify_unsafe_();
/* 1911 */       return Gang.this.createtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getPurpose()
/*      */     {
/* 1918 */       Gang.this._xdb_verify_unsafe_();
/* 1919 */       return Gang.this.purpose;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getPurposeOctets()
/*      */     {
/* 1926 */       Gang.this._xdb_verify_unsafe_();
/* 1927 */       return Gang.this.getPurposeOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBangzhuid()
/*      */     {
/* 1934 */       Gang.this._xdb_verify_unsafe_();
/* 1935 */       return Gang.this.bangzhuid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDesigntitlecaseid()
/*      */     {
/* 1942 */       Gang.this._xdb_verify_unsafe_();
/* 1943 */       return Gang.this.designtitlecaseid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVitality()
/*      */     {
/* 1950 */       Gang.this._xdb_verify_unsafe_();
/* 1951 */       return Gang.this.vitality;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLeveluptime()
/*      */     {
/* 1958 */       Gang.this._xdb_verify_unsafe_();
/* 1959 */       return Gang.this.leveluptime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.GangAnnouncement> getAnnouncementhistorylist()
/*      */     {
/* 1966 */       Gang.this._xdb_verify_unsafe_();
/* 1967 */       return Consts.constList(Gang.this.announcementhistorylist);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.GangAnnouncement> getAnnouncementhistorylistAsData()
/*      */     {
/* 1973 */       Gang.this._xdb_verify_unsafe_();
/*      */       
/* 1975 */       Gang _o_ = Gang.this;
/* 1976 */       List<xbean.GangAnnouncement> announcementhistorylist = new ArrayList();
/* 1977 */       for (xbean.GangAnnouncement _v_ : _o_.announcementhistorylist)
/* 1978 */         announcementhistorylist.add(new GangAnnouncement.Data(_v_));
/* 1979 */       return announcementhistorylist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getApprenticemaxlv()
/*      */     {
/* 1986 */       Gang.this._xdb_verify_unsafe_();
/* 1987 */       return Gang.this.apprenticemaxlv;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTimestamp()
/*      */     {
/* 1994 */       Gang.this._xdb_verify_unsafe_();
/* 1995 */       return Gang.this.timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastrename()
/*      */     {
/* 2002 */       Gang.this._xdb_verify_unsafe_();
/* 2003 */       return Gang.this.lastrename;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getForbiddentalkcount()
/*      */     {
/* 2010 */       Gang.this._xdb_verify_unsafe_();
/* 2011 */       return Gang.this.forbiddentalkcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTanheroleid()
/*      */     {
/* 2018 */       Gang.this._xdb_verify_unsafe_();
/* 2019 */       return Gang.this.tanheroleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTanheendtime()
/*      */     {
/* 2026 */       Gang.this._xdb_verify_unsafe_();
/* 2027 */       return Gang.this.tanheendtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getJuanzhongnum()
/*      */     {
/* 2034 */       Gang.this._xdb_verify_unsafe_();
/* 2035 */       return Gang.this.juanzhongnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getNextid()
/*      */     {
/* 2042 */       Gang.this._xdb_verify_unsafe_();
/* 2043 */       return Gang.this.nextid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPublishtime()
/*      */     {
/* 2050 */       Gang.this._xdb_verify_unsafe_();
/* 2051 */       return Gang.this.publishtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.GangHelper> getGanghelperlist()
/*      */     {
/* 2058 */       Gang.this._xdb_verify_unsafe_();
/* 2059 */       return Consts.constList(Gang.this.ganghelperlist);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.GangHelper> getGanghelperlistAsData()
/*      */     {
/* 2065 */       Gang.this._xdb_verify_unsafe_();
/*      */       
/* 2067 */       Gang _o_ = Gang.this;
/* 2068 */       List<xbean.GangHelper> ganghelperlist = new LinkedList();
/* 2069 */       for (xbean.GangHelper _v_ : _o_.ganghelperlist)
/* 2070 */         ganghelperlist.add(new GangHelper.Data(_v_));
/* 2071 */       return ganghelperlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.XiangFang getXiangfang()
/*      */     {
/* 2078 */       Gang.this._xdb_verify_unsafe_();
/* 2079 */       return (xbean.XiangFang)Consts.toConst(Gang.this.xiangfang);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.JinKu getJinku()
/*      */     {
/* 2086 */       Gang.this._xdb_verify_unsafe_();
/* 2087 */       return (xbean.JinKu)Consts.toConst(Gang.this.jinku);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.YaoDian getYaodian()
/*      */     {
/* 2094 */       Gang.this._xdb_verify_unsafe_();
/* 2095 */       return (xbean.YaoDian)Consts.toConst(Gang.this.yaodian);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.CangKu getCangku()
/*      */     {
/* 2102 */       Gang.this._xdb_verify_unsafe_();
/* 2103 */       return (xbean.CangKu)Consts.toConst(Gang.this.cangku);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.ShuYuan getShuyuan()
/*      */     {
/* 2110 */       Gang.this._xdb_verify_unsafe_();
/* 2111 */       return (xbean.ShuYuan)Consts.toConst(Gang.this.shuyuan);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.GangDutyMembers> getDuty2members()
/*      */     {
/* 2118 */       Gang.this._xdb_verify_unsafe_();
/* 2119 */       return Consts.constMap(Gang.this.duty2members);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.GangDutyMembers> getDuty2membersAsData()
/*      */     {
/* 2126 */       Gang.this._xdb_verify_unsafe_();
/*      */       
/* 2128 */       Gang _o_ = Gang.this;
/* 2129 */       Map<Integer, xbean.GangDutyMembers> duty2members = new HashMap();
/* 2130 */       for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : _o_.duty2members.entrySet())
/* 2131 */         duty2members.put(_e_.getKey(), new GangDutyMembers.Data((xbean.GangDutyMembers)_e_.getValue()));
/* 2132 */       return duty2members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPeriodmoney()
/*      */     {
/* 2139 */       Gang.this._xdb_verify_unsafe_();
/* 2140 */       return Gang.this.periodmoney;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGrouproleid()
/*      */     {
/* 2147 */       Gang.this._xdb_verify_unsafe_();
/* 2148 */       return Gang.this.grouproleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getGroupopenid()
/*      */     {
/* 2155 */       Gang.this._xdb_verify_unsafe_();
/* 2156 */       return Gang.this.groupopenid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getGroupopenidOctets()
/*      */     {
/* 2163 */       Gang.this._xdb_verify_unsafe_();
/* 2164 */       return Gang.this.getGroupopenidOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getDisplayid()
/*      */     {
/* 2171 */       Gang.this._xdb_verify_unsafe_();
/* 2172 */       return Gang.this.displayid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GangTeam> getTeams()
/*      */     {
/* 2179 */       Gang.this._xdb_verify_unsafe_();
/* 2180 */       return Consts.constMap(Gang.this.teams);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GangTeam> getTeamsAsData()
/*      */     {
/* 2187 */       Gang.this._xdb_verify_unsafe_();
/*      */       
/* 2189 */       Gang _o_ = Gang.this;
/* 2190 */       Map<Long, xbean.GangTeam> teams = new HashMap();
/* 2191 */       for (Map.Entry<Long, xbean.GangTeam> _e_ : _o_.teams.entrySet())
/* 2192 */         teams.put(_e_.getKey(), new GangTeam.Data((xbean.GangTeam)_e_.getValue()));
/* 2193 */       return teams;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getMember2teamid()
/*      */     {
/* 2200 */       Gang.this._xdb_verify_unsafe_();
/* 2201 */       return Consts.constMap(Gang.this.member2teamid);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getMember2teamidAsData()
/*      */     {
/* 2208 */       Gang.this._xdb_verify_unsafe_();
/*      */       
/* 2210 */       Gang _o_ = Gang.this;
/* 2211 */       Map<Long, Long> member2teamid = new HashMap();
/* 2212 */       for (Map.Entry<Long, Long> _e_ : _o_.member2teamid.entrySet())
/* 2213 */         member2teamid.put(_e_.getKey(), _e_.getValue());
/* 2214 */       return member2teamid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getNext_teamid()
/*      */     {
/* 2221 */       Gang.this._xdb_verify_unsafe_();
/* 2222 */       return Gang.this.next_teamid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName(String _v_)
/*      */     {
/* 2229 */       Gang.this._xdb_verify_unsafe_();
/* 2230 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNameOctets(Octets _v_)
/*      */     {
/* 2237 */       Gang.this._xdb_verify_unsafe_();
/* 2238 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/* 2245 */       Gang.this._xdb_verify_unsafe_();
/* 2246 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreatetime(long _v_)
/*      */     {
/* 2253 */       Gang.this._xdb_verify_unsafe_();
/* 2254 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPurpose(String _v_)
/*      */     {
/* 2261 */       Gang.this._xdb_verify_unsafe_();
/* 2262 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPurposeOctets(Octets _v_)
/*      */     {
/* 2269 */       Gang.this._xdb_verify_unsafe_();
/* 2270 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBangzhuid(long _v_)
/*      */     {
/* 2277 */       Gang.this._xdb_verify_unsafe_();
/* 2278 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDesigntitlecaseid(int _v_)
/*      */     {
/* 2285 */       Gang.this._xdb_verify_unsafe_();
/* 2286 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVitality(int _v_)
/*      */     {
/* 2293 */       Gang.this._xdb_verify_unsafe_();
/* 2294 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLeveluptime(long _v_)
/*      */     {
/* 2301 */       Gang.this._xdb_verify_unsafe_();
/* 2302 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setApprenticemaxlv(int _v_)
/*      */     {
/* 2309 */       Gang.this._xdb_verify_unsafe_();
/* 2310 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTimestamp(long _v_)
/*      */     {
/* 2317 */       Gang.this._xdb_verify_unsafe_();
/* 2318 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastrename(long _v_)
/*      */     {
/* 2325 */       Gang.this._xdb_verify_unsafe_();
/* 2326 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setForbiddentalkcount(int _v_)
/*      */     {
/* 2333 */       Gang.this._xdb_verify_unsafe_();
/* 2334 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTanheroleid(long _v_)
/*      */     {
/* 2341 */       Gang.this._xdb_verify_unsafe_();
/* 2342 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTanheendtime(long _v_)
/*      */     {
/* 2349 */       Gang.this._xdb_verify_unsafe_();
/* 2350 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setJuanzhongnum(int _v_)
/*      */     {
/* 2357 */       Gang.this._xdb_verify_unsafe_();
/* 2358 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNextid(long _v_)
/*      */     {
/* 2365 */       Gang.this._xdb_verify_unsafe_();
/* 2366 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPublishtime(int _v_)
/*      */     {
/* 2373 */       Gang.this._xdb_verify_unsafe_();
/* 2374 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPeriodmoney(int _v_)
/*      */     {
/* 2381 */       Gang.this._xdb_verify_unsafe_();
/* 2382 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrouproleid(long _v_)
/*      */     {
/* 2389 */       Gang.this._xdb_verify_unsafe_();
/* 2390 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGroupopenid(String _v_)
/*      */     {
/* 2397 */       Gang.this._xdb_verify_unsafe_();
/* 2398 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGroupopenidOctets(Octets _v_)
/*      */     {
/* 2405 */       Gang.this._xdb_verify_unsafe_();
/* 2406 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDisplayid(long _v_)
/*      */     {
/* 2413 */       Gang.this._xdb_verify_unsafe_();
/* 2414 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNext_teamid(long _v_)
/*      */     {
/* 2421 */       Gang.this._xdb_verify_unsafe_();
/* 2422 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 2428 */       Gang.this._xdb_verify_unsafe_();
/* 2429 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 2435 */       Gang.this._xdb_verify_unsafe_();
/* 2436 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 2442 */       return Gang.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2448 */       return Gang.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2454 */       Gang.this._xdb_verify_unsafe_();
/* 2455 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 2461 */       return Gang.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2467 */       return Gang.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2473 */       Gang.this._xdb_verify_unsafe_();
/* 2474 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 2480 */       return Gang.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2486 */       return Gang.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 2492 */       return Gang.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 2498 */       return Gang.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 2504 */       return Gang.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 2510 */       return Gang.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 2516 */       return Gang.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Gang
/*      */   {
/*      */     private String name;
/*      */     
/*      */     private int level;
/*      */     
/*      */     private long createtime;
/*      */     
/*      */     private String purpose;
/*      */     
/*      */     private long bangzhuid;
/*      */     
/*      */     private int designtitlecaseid;
/*      */     
/*      */     private int vitality;
/*      */     
/*      */     private long leveluptime;
/*      */     
/*      */     private ArrayList<xbean.GangAnnouncement> announcementhistorylist;
/*      */     
/*      */     private int apprenticemaxlv;
/*      */     
/*      */     private long timestamp;
/*      */     
/*      */     private long lastrename;
/*      */     
/*      */     private int forbiddentalkcount;
/*      */     
/*      */     private long tanheroleid;
/*      */     
/*      */     private long tanheendtime;
/*      */     
/*      */     private int juanzhongnum;
/*      */     
/*      */     private long nextid;
/*      */     
/*      */     private int publishtime;
/*      */     
/*      */     private LinkedList<xbean.GangHelper> ganghelperlist;
/*      */     
/*      */     private xbean.XiangFang xiangfang;
/*      */     
/*      */     private xbean.JinKu jinku;
/*      */     
/*      */     private xbean.YaoDian yaodian;
/*      */     
/*      */     private xbean.CangKu cangku;
/*      */     
/*      */     private xbean.ShuYuan shuyuan;
/*      */     
/*      */     private HashMap<Integer, xbean.GangDutyMembers> duty2members;
/*      */     
/*      */     private int periodmoney;
/*      */     
/*      */     private long grouproleid;
/*      */     
/*      */     private String groupopenid;
/*      */     
/*      */     private long displayid;
/*      */     
/*      */     private HashMap<Long, xbean.GangTeam> teams;
/*      */     
/*      */     private HashMap<Long, Long> member2teamid;
/*      */     
/*      */     private long next_teamid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 2590 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 2595 */       this.name = "";
/* 2596 */       this.purpose = "";
/* 2597 */       this.announcementhistorylist = new ArrayList();
/* 2598 */       this.ganghelperlist = new LinkedList();
/* 2599 */       this.xiangfang = new XiangFang.Data();
/* 2600 */       this.jinku = new JinKu.Data();
/* 2601 */       this.yaodian = new YaoDian.Data();
/* 2602 */       this.cangku = new CangKu.Data();
/* 2603 */       this.shuyuan = new ShuYuan.Data();
/* 2604 */       this.duty2members = new HashMap();
/* 2605 */       this.groupopenid = "";
/* 2606 */       this.teams = new HashMap();
/* 2607 */       this.member2teamid = new HashMap();
/* 2608 */       this.next_teamid = 0L;
/*      */     }
/*      */     
/*      */     Data(xbean.Gang _o1_)
/*      */     {
/* 2613 */       if ((_o1_ instanceof Gang)) { assign((Gang)_o1_);
/* 2614 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 2615 */       } else if ((_o1_ instanceof Gang.Const)) assign(((Gang.Const)_o1_).nThis()); else {
/* 2616 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Gang _o_) {
/* 2621 */       this.name = _o_.name;
/* 2622 */       this.level = _o_.level;
/* 2623 */       this.createtime = _o_.createtime;
/* 2624 */       this.purpose = _o_.purpose;
/* 2625 */       this.bangzhuid = _o_.bangzhuid;
/* 2626 */       this.designtitlecaseid = _o_.designtitlecaseid;
/* 2627 */       this.vitality = _o_.vitality;
/* 2628 */       this.leveluptime = _o_.leveluptime;
/* 2629 */       this.announcementhistorylist = new ArrayList();
/* 2630 */       for (xbean.GangAnnouncement _v_ : _o_.announcementhistorylist)
/* 2631 */         this.announcementhistorylist.add(new GangAnnouncement.Data(_v_));
/* 2632 */       this.apprenticemaxlv = _o_.apprenticemaxlv;
/* 2633 */       this.timestamp = _o_.timestamp;
/* 2634 */       this.lastrename = _o_.lastrename;
/* 2635 */       this.forbiddentalkcount = _o_.forbiddentalkcount;
/* 2636 */       this.tanheroleid = _o_.tanheroleid;
/* 2637 */       this.tanheendtime = _o_.tanheendtime;
/* 2638 */       this.juanzhongnum = _o_.juanzhongnum;
/* 2639 */       this.nextid = _o_.nextid;
/* 2640 */       this.publishtime = _o_.publishtime;
/* 2641 */       this.ganghelperlist = new LinkedList();
/* 2642 */       for (xbean.GangHelper _v_ : _o_.ganghelperlist)
/* 2643 */         this.ganghelperlist.add(new GangHelper.Data(_v_));
/* 2644 */       this.xiangfang = new XiangFang.Data(_o_.xiangfang);
/* 2645 */       this.jinku = new JinKu.Data(_o_.jinku);
/* 2646 */       this.yaodian = new YaoDian.Data(_o_.yaodian);
/* 2647 */       this.cangku = new CangKu.Data(_o_.cangku);
/* 2648 */       this.shuyuan = new ShuYuan.Data(_o_.shuyuan);
/* 2649 */       this.duty2members = new HashMap();
/* 2650 */       for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : _o_.duty2members.entrySet())
/* 2651 */         this.duty2members.put(_e_.getKey(), new GangDutyMembers.Data((xbean.GangDutyMembers)_e_.getValue()));
/* 2652 */       this.periodmoney = _o_.periodmoney;
/* 2653 */       this.grouproleid = _o_.grouproleid;
/* 2654 */       this.groupopenid = _o_.groupopenid;
/* 2655 */       this.displayid = _o_.displayid;
/* 2656 */       this.teams = new HashMap();
/* 2657 */       for (Map.Entry<Long, xbean.GangTeam> _e_ : _o_.teams.entrySet())
/* 2658 */         this.teams.put(_e_.getKey(), new GangTeam.Data((xbean.GangTeam)_e_.getValue()));
/* 2659 */       this.member2teamid = new HashMap();
/* 2660 */       for (Map.Entry<Long, Long> _e_ : _o_.member2teamid.entrySet())
/* 2661 */         this.member2teamid.put(_e_.getKey(), _e_.getValue());
/* 2662 */       this.next_teamid = _o_.next_teamid;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 2667 */       this.name = _o_.name;
/* 2668 */       this.level = _o_.level;
/* 2669 */       this.createtime = _o_.createtime;
/* 2670 */       this.purpose = _o_.purpose;
/* 2671 */       this.bangzhuid = _o_.bangzhuid;
/* 2672 */       this.designtitlecaseid = _o_.designtitlecaseid;
/* 2673 */       this.vitality = _o_.vitality;
/* 2674 */       this.leveluptime = _o_.leveluptime;
/* 2675 */       this.announcementhistorylist = new ArrayList();
/* 2676 */       for (xbean.GangAnnouncement _v_ : _o_.announcementhistorylist)
/* 2677 */         this.announcementhistorylist.add(new GangAnnouncement.Data(_v_));
/* 2678 */       this.apprenticemaxlv = _o_.apprenticemaxlv;
/* 2679 */       this.timestamp = _o_.timestamp;
/* 2680 */       this.lastrename = _o_.lastrename;
/* 2681 */       this.forbiddentalkcount = _o_.forbiddentalkcount;
/* 2682 */       this.tanheroleid = _o_.tanheroleid;
/* 2683 */       this.tanheendtime = _o_.tanheendtime;
/* 2684 */       this.juanzhongnum = _o_.juanzhongnum;
/* 2685 */       this.nextid = _o_.nextid;
/* 2686 */       this.publishtime = _o_.publishtime;
/* 2687 */       this.ganghelperlist = new LinkedList();
/* 2688 */       for (xbean.GangHelper _v_ : _o_.ganghelperlist)
/* 2689 */         this.ganghelperlist.add(new GangHelper.Data(_v_));
/* 2690 */       this.xiangfang = new XiangFang.Data(_o_.xiangfang);
/* 2691 */       this.jinku = new JinKu.Data(_o_.jinku);
/* 2692 */       this.yaodian = new YaoDian.Data(_o_.yaodian);
/* 2693 */       this.cangku = new CangKu.Data(_o_.cangku);
/* 2694 */       this.shuyuan = new ShuYuan.Data(_o_.shuyuan);
/* 2695 */       this.duty2members = new HashMap();
/* 2696 */       for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : _o_.duty2members.entrySet())
/* 2697 */         this.duty2members.put(_e_.getKey(), new GangDutyMembers.Data((xbean.GangDutyMembers)_e_.getValue()));
/* 2698 */       this.periodmoney = _o_.periodmoney;
/* 2699 */       this.grouproleid = _o_.grouproleid;
/* 2700 */       this.groupopenid = _o_.groupopenid;
/* 2701 */       this.displayid = _o_.displayid;
/* 2702 */       this.teams = new HashMap();
/* 2703 */       for (Map.Entry<Long, xbean.GangTeam> _e_ : _o_.teams.entrySet())
/* 2704 */         this.teams.put(_e_.getKey(), new GangTeam.Data((xbean.GangTeam)_e_.getValue()));
/* 2705 */       this.member2teamid = new HashMap();
/* 2706 */       for (Map.Entry<Long, Long> _e_ : _o_.member2teamid.entrySet())
/* 2707 */         this.member2teamid.put(_e_.getKey(), _e_.getValue());
/* 2708 */       this.next_teamid = _o_.next_teamid;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2714 */       _os_.marshal(this.name, "UTF-16LE");
/* 2715 */       _os_.marshal(this.level);
/* 2716 */       _os_.marshal(this.createtime);
/* 2717 */       _os_.marshal(this.purpose, "UTF-16LE");
/* 2718 */       _os_.marshal(this.bangzhuid);
/* 2719 */       _os_.marshal(this.designtitlecaseid);
/* 2720 */       _os_.marshal(this.vitality);
/* 2721 */       _os_.marshal(this.leveluptime);
/* 2722 */       _os_.compact_uint32(this.announcementhistorylist.size());
/* 2723 */       for (xbean.GangAnnouncement _v_ : this.announcementhistorylist)
/*      */       {
/* 2725 */         _v_.marshal(_os_);
/*      */       }
/* 2727 */       _os_.marshal(this.apprenticemaxlv);
/* 2728 */       _os_.marshal(this.timestamp);
/* 2729 */       _os_.marshal(this.lastrename);
/* 2730 */       _os_.marshal(this.forbiddentalkcount);
/* 2731 */       _os_.marshal(this.tanheroleid);
/* 2732 */       _os_.marshal(this.tanheendtime);
/* 2733 */       _os_.marshal(this.juanzhongnum);
/* 2734 */       _os_.marshal(this.nextid);
/* 2735 */       _os_.marshal(this.publishtime);
/* 2736 */       _os_.compact_uint32(this.ganghelperlist.size());
/* 2737 */       for (xbean.GangHelper _v_ : this.ganghelperlist)
/*      */       {
/* 2739 */         _v_.marshal(_os_);
/*      */       }
/* 2741 */       this.xiangfang.marshal(_os_);
/* 2742 */       this.jinku.marshal(_os_);
/* 2743 */       this.yaodian.marshal(_os_);
/* 2744 */       this.cangku.marshal(_os_);
/* 2745 */       this.shuyuan.marshal(_os_);
/* 2746 */       _os_.compact_uint32(this.duty2members.size());
/* 2747 */       for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : this.duty2members.entrySet())
/*      */       {
/* 2749 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2750 */         ((xbean.GangDutyMembers)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2752 */       _os_.marshal(this.periodmoney);
/* 2753 */       _os_.marshal(this.grouproleid);
/* 2754 */       _os_.marshal(this.groupopenid, "UTF-16LE");
/* 2755 */       _os_.marshal(this.displayid);
/* 2756 */       _os_.compact_uint32(this.teams.size());
/* 2757 */       for (Map.Entry<Long, xbean.GangTeam> _e_ : this.teams.entrySet())
/*      */       {
/* 2759 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 2760 */         ((xbean.GangTeam)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2762 */       _os_.compact_uint32(this.member2teamid.size());
/* 2763 */       for (Map.Entry<Long, Long> _e_ : this.member2teamid.entrySet())
/*      */       {
/* 2765 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 2766 */         _os_.marshal(((Long)_e_.getValue()).longValue());
/*      */       }
/* 2768 */       _os_.marshal(this.next_teamid);
/* 2769 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2775 */       this.name = _os_.unmarshal_String("UTF-16LE");
/* 2776 */       this.level = _os_.unmarshal_int();
/* 2777 */       this.createtime = _os_.unmarshal_long();
/* 2778 */       this.purpose = _os_.unmarshal_String("UTF-16LE");
/* 2779 */       this.bangzhuid = _os_.unmarshal_long();
/* 2780 */       this.designtitlecaseid = _os_.unmarshal_int();
/* 2781 */       this.vitality = _os_.unmarshal_int();
/* 2782 */       this.leveluptime = _os_.unmarshal_long();
/* 2783 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 2785 */         xbean.GangAnnouncement _v_ = Pod.newGangAnnouncementData();
/* 2786 */         _v_.unmarshal(_os_);
/* 2787 */         this.announcementhistorylist.add(_v_);
/*      */       }
/* 2789 */       this.apprenticemaxlv = _os_.unmarshal_int();
/* 2790 */       this.timestamp = _os_.unmarshal_long();
/* 2791 */       this.lastrename = _os_.unmarshal_long();
/* 2792 */       this.forbiddentalkcount = _os_.unmarshal_int();
/* 2793 */       this.tanheroleid = _os_.unmarshal_long();
/* 2794 */       this.tanheendtime = _os_.unmarshal_long();
/* 2795 */       this.juanzhongnum = _os_.unmarshal_int();
/* 2796 */       this.nextid = _os_.unmarshal_long();
/* 2797 */       this.publishtime = _os_.unmarshal_int();
/* 2798 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 2800 */         xbean.GangHelper _v_ = Pod.newGangHelperData();
/* 2801 */         _v_.unmarshal(_os_);
/* 2802 */         this.ganghelperlist.add(_v_);
/*      */       }
/* 2804 */       this.xiangfang.unmarshal(_os_);
/* 2805 */       this.jinku.unmarshal(_os_);
/* 2806 */       this.yaodian.unmarshal(_os_);
/* 2807 */       this.cangku.unmarshal(_os_);
/* 2808 */       this.shuyuan.unmarshal(_os_);
/*      */       
/* 2810 */       int size = _os_.uncompact_uint32();
/* 2811 */       if (size >= 12)
/*      */       {
/* 2813 */         this.duty2members = new HashMap(size * 2);
/*      */       }
/* 2815 */       for (; size > 0; size--)
/*      */       {
/* 2817 */         int _k_ = 0;
/* 2818 */         _k_ = _os_.unmarshal_int();
/* 2819 */         xbean.GangDutyMembers _v_ = Pod.newGangDutyMembersData();
/* 2820 */         _v_.unmarshal(_os_);
/* 2821 */         this.duty2members.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 2824 */       this.periodmoney = _os_.unmarshal_int();
/* 2825 */       this.grouproleid = _os_.unmarshal_long();
/* 2826 */       this.groupopenid = _os_.unmarshal_String("UTF-16LE");
/* 2827 */       this.displayid = _os_.unmarshal_long();
/*      */       
/* 2829 */       int size = _os_.uncompact_uint32();
/* 2830 */       if (size >= 12)
/*      */       {
/* 2832 */         this.teams = new HashMap(size * 2);
/*      */       }
/* 2834 */       for (; size > 0; size--)
/*      */       {
/* 2836 */         long _k_ = 0L;
/* 2837 */         _k_ = _os_.unmarshal_long();
/* 2838 */         xbean.GangTeam _v_ = Pod.newGangTeamData();
/* 2839 */         _v_.unmarshal(_os_);
/* 2840 */         this.teams.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 2844 */       int size = _os_.uncompact_uint32();
/* 2845 */       if (size >= 12)
/*      */       {
/* 2847 */         this.member2teamid = new HashMap(size * 2);
/*      */       }
/* 2849 */       for (; size > 0; size--)
/*      */       {
/* 2851 */         long _k_ = 0L;
/* 2852 */         _k_ = _os_.unmarshal_long();
/* 2853 */         long _v_ = 0L;
/* 2854 */         _v_ = _os_.unmarshal_long();
/* 2855 */         this.member2teamid.put(Long.valueOf(_k_), Long.valueOf(_v_));
/*      */       }
/*      */       
/* 2858 */       this.next_teamid = _os_.unmarshal_long();
/* 2859 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 2865 */       int _size_ = 0;
/*      */       try
/*      */       {
/* 2868 */         _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 2872 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 2874 */       _size_ += CodedOutputStream.computeInt32Size(2, this.level);
/* 2875 */       _size_ += CodedOutputStream.computeInt64Size(3, this.createtime);
/*      */       try
/*      */       {
/* 2878 */         _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.purpose, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 2882 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 2884 */       _size_ += CodedOutputStream.computeInt64Size(5, this.bangzhuid);
/* 2885 */       _size_ += CodedOutputStream.computeInt32Size(6, this.designtitlecaseid);
/* 2886 */       _size_ += CodedOutputStream.computeInt32Size(7, this.vitality);
/* 2887 */       _size_ += CodedOutputStream.computeInt64Size(8, this.leveluptime);
/* 2888 */       for (xbean.GangAnnouncement _v_ : this.announcementhistorylist)
/*      */       {
/* 2890 */         _size_ += CodedOutputStream.computeMessageSize(9, _v_);
/*      */       }
/* 2892 */       _size_ += CodedOutputStream.computeInt32Size(10, this.apprenticemaxlv);
/* 2893 */       _size_ += CodedOutputStream.computeInt64Size(12, this.timestamp);
/* 2894 */       _size_ += CodedOutputStream.computeInt64Size(13, this.lastrename);
/* 2895 */       _size_ += CodedOutputStream.computeInt32Size(14, this.forbiddentalkcount);
/* 2896 */       _size_ += CodedOutputStream.computeInt64Size(15, this.tanheroleid);
/* 2897 */       _size_ += CodedOutputStream.computeInt64Size(16, this.tanheendtime);
/* 2898 */       _size_ += CodedOutputStream.computeInt32Size(17, this.juanzhongnum);
/* 2899 */       _size_ += CodedOutputStream.computeInt64Size(18, this.nextid);
/* 2900 */       _size_ += CodedOutputStream.computeInt32Size(19, this.publishtime);
/* 2901 */       for (xbean.GangHelper _v_ : this.ganghelperlist)
/*      */       {
/* 2903 */         _size_ += CodedOutputStream.computeMessageSize(20, _v_);
/*      */       }
/* 2905 */       _size_ += CodedOutputStream.computeMessageSize(21, this.xiangfang);
/* 2906 */       _size_ += CodedOutputStream.computeMessageSize(22, this.jinku);
/* 2907 */       _size_ += CodedOutputStream.computeMessageSize(23, this.yaodian);
/* 2908 */       _size_ += CodedOutputStream.computeMessageSize(24, this.cangku);
/* 2909 */       _size_ += CodedOutputStream.computeMessageSize(25, this.shuyuan);
/* 2910 */       for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : this.duty2members.entrySet())
/*      */       {
/* 2912 */         _size_ += CodedOutputStream.computeInt32Size(26, ((Integer)_e_.getKey()).intValue());
/* 2913 */         _size_ += CodedOutputStream.computeMessageSize(26, (Message)_e_.getValue());
/*      */       }
/* 2915 */       _size_ += CodedOutputStream.computeInt32Size(27, this.periodmoney);
/* 2916 */       _size_ += CodedOutputStream.computeInt64Size(28, this.grouproleid);
/*      */       try
/*      */       {
/* 2919 */         _size_ += CodedOutputStream.computeBytesSize(30, ByteString.copyFrom(this.groupopenid, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 2923 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 2925 */       _size_ += CodedOutputStream.computeInt64Size(32, this.displayid);
/* 2926 */       for (Map.Entry<Long, xbean.GangTeam> _e_ : this.teams.entrySet())
/*      */       {
/* 2928 */         _size_ += CodedOutputStream.computeInt64Size(33, ((Long)_e_.getKey()).longValue());
/* 2929 */         _size_ += CodedOutputStream.computeMessageSize(33, (Message)_e_.getValue());
/*      */       }
/* 2931 */       for (Map.Entry<Long, Long> _e_ : this.member2teamid.entrySet())
/*      */       {
/* 2933 */         _size_ += CodedOutputStream.computeInt64Size(34, ((Long)_e_.getKey()).longValue());
/* 2934 */         _size_ += CodedOutputStream.computeInt64Size(34, ((Long)_e_.getValue()).longValue());
/*      */       }
/* 2936 */       _size_ += CodedOutputStream.computeInt64Size(35, this.next_teamid);
/* 2937 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2945 */         _output_.writeBytes(1, ByteString.copyFrom(this.name, "UTF-16LE"));
/* 2946 */         _output_.writeInt32(2, this.level);
/* 2947 */         _output_.writeInt64(3, this.createtime);
/* 2948 */         _output_.writeBytes(4, ByteString.copyFrom(this.purpose, "UTF-16LE"));
/* 2949 */         _output_.writeInt64(5, this.bangzhuid);
/* 2950 */         _output_.writeInt32(6, this.designtitlecaseid);
/* 2951 */         _output_.writeInt32(7, this.vitality);
/* 2952 */         _output_.writeInt64(8, this.leveluptime);
/* 2953 */         for (xbean.GangAnnouncement _v_ : this.announcementhistorylist)
/*      */         {
/* 2955 */           _output_.writeMessage(9, _v_);
/*      */         }
/* 2957 */         _output_.writeInt32(10, this.apprenticemaxlv);
/* 2958 */         _output_.writeInt64(12, this.timestamp);
/* 2959 */         _output_.writeInt64(13, this.lastrename);
/* 2960 */         _output_.writeInt32(14, this.forbiddentalkcount);
/* 2961 */         _output_.writeInt64(15, this.tanheroleid);
/* 2962 */         _output_.writeInt64(16, this.tanheendtime);
/* 2963 */         _output_.writeInt32(17, this.juanzhongnum);
/* 2964 */         _output_.writeInt64(18, this.nextid);
/* 2965 */         _output_.writeInt32(19, this.publishtime);
/* 2966 */         for (xbean.GangHelper _v_ : this.ganghelperlist)
/*      */         {
/* 2968 */           _output_.writeMessage(20, _v_);
/*      */         }
/* 2970 */         _output_.writeMessage(21, this.xiangfang);
/* 2971 */         _output_.writeMessage(22, this.jinku);
/* 2972 */         _output_.writeMessage(23, this.yaodian);
/* 2973 */         _output_.writeMessage(24, this.cangku);
/* 2974 */         _output_.writeMessage(25, this.shuyuan);
/* 2975 */         for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : this.duty2members.entrySet())
/*      */         {
/* 2977 */           _output_.writeInt32(26, ((Integer)_e_.getKey()).intValue());
/* 2978 */           _output_.writeMessage(26, (Message)_e_.getValue());
/*      */         }
/* 2980 */         _output_.writeInt32(27, this.periodmoney);
/* 2981 */         _output_.writeInt64(28, this.grouproleid);
/* 2982 */         _output_.writeBytes(30, ByteString.copyFrom(this.groupopenid, "UTF-16LE"));
/* 2983 */         _output_.writeInt64(32, this.displayid);
/* 2984 */         for (Map.Entry<Long, xbean.GangTeam> _e_ : this.teams.entrySet())
/*      */         {
/* 2986 */           _output_.writeInt64(33, ((Long)_e_.getKey()).longValue());
/* 2987 */           _output_.writeMessage(33, (Message)_e_.getValue());
/*      */         }
/* 2989 */         for (Map.Entry<Long, Long> _e_ : this.member2teamid.entrySet())
/*      */         {
/* 2991 */           _output_.writeInt64(34, ((Long)_e_.getKey()).longValue());
/* 2992 */           _output_.writeInt64(34, ((Long)_e_.getValue()).longValue());
/*      */         }
/* 2994 */         _output_.writeInt64(35, this.next_teamid);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2998 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 3000 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 3008 */         boolean done = false;
/* 3009 */         while (!done)
/*      */         {
/* 3011 */           int tag = _input_.readTag();
/* 3012 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 3016 */             done = true;
/* 3017 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/* 3021 */             this.name = _input_.readBytes().toString("UTF-16LE");
/* 3022 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 3026 */             this.level = _input_.readInt32();
/* 3027 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 3031 */             this.createtime = _input_.readInt64();
/* 3032 */             break;
/*      */           
/*      */ 
/*      */           case 34: 
/* 3036 */             this.purpose = _input_.readBytes().toString("UTF-16LE");
/* 3037 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 3041 */             this.bangzhuid = _input_.readInt64();
/* 3042 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 3046 */             this.designtitlecaseid = _input_.readInt32();
/* 3047 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 3051 */             this.vitality = _input_.readInt32();
/* 3052 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 3056 */             this.leveluptime = _input_.readInt64();
/* 3057 */             break;
/*      */           
/*      */ 
/*      */           case 74: 
/* 3061 */             xbean.GangAnnouncement _v_ = Pod.newGangAnnouncementData();
/* 3062 */             _input_.readMessage(_v_);
/* 3063 */             this.announcementhistorylist.add(_v_);
/* 3064 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 3068 */             this.apprenticemaxlv = _input_.readInt32();
/* 3069 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 3073 */             this.timestamp = _input_.readInt64();
/* 3074 */             break;
/*      */           
/*      */ 
/*      */           case 104: 
/* 3078 */             this.lastrename = _input_.readInt64();
/* 3079 */             break;
/*      */           
/*      */ 
/*      */           case 112: 
/* 3083 */             this.forbiddentalkcount = _input_.readInt32();
/* 3084 */             break;
/*      */           
/*      */ 
/*      */           case 120: 
/* 3088 */             this.tanheroleid = _input_.readInt64();
/* 3089 */             break;
/*      */           
/*      */ 
/*      */           case 128: 
/* 3093 */             this.tanheendtime = _input_.readInt64();
/* 3094 */             break;
/*      */           
/*      */ 
/*      */           case 136: 
/* 3098 */             this.juanzhongnum = _input_.readInt32();
/* 3099 */             break;
/*      */           
/*      */ 
/*      */           case 144: 
/* 3103 */             this.nextid = _input_.readInt64();
/* 3104 */             break;
/*      */           
/*      */ 
/*      */           case 152: 
/* 3108 */             this.publishtime = _input_.readInt32();
/* 3109 */             break;
/*      */           
/*      */ 
/*      */           case 162: 
/* 3113 */             xbean.GangHelper _v_ = Pod.newGangHelperData();
/* 3114 */             _input_.readMessage(_v_);
/* 3115 */             this.ganghelperlist.add(_v_);
/* 3116 */             break;
/*      */           
/*      */ 
/*      */           case 170: 
/* 3120 */             _input_.readMessage(this.xiangfang);
/* 3121 */             break;
/*      */           
/*      */ 
/*      */           case 178: 
/* 3125 */             _input_.readMessage(this.jinku);
/* 3126 */             break;
/*      */           
/*      */ 
/*      */           case 186: 
/* 3130 */             _input_.readMessage(this.yaodian);
/* 3131 */             break;
/*      */           
/*      */ 
/*      */           case 194: 
/* 3135 */             _input_.readMessage(this.cangku);
/* 3136 */             break;
/*      */           
/*      */ 
/*      */           case 202: 
/* 3140 */             _input_.readMessage(this.shuyuan);
/* 3141 */             break;
/*      */           
/*      */ 
/*      */           case 208: 
/* 3145 */             int _k_ = 0;
/* 3146 */             _k_ = _input_.readInt32();
/* 3147 */             int readTag = _input_.readTag();
/* 3148 */             if (210 != readTag)
/*      */             {
/* 3150 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 3152 */             xbean.GangDutyMembers _v_ = Pod.newGangDutyMembersData();
/* 3153 */             _input_.readMessage(_v_);
/* 3154 */             this.duty2members.put(Integer.valueOf(_k_), _v_);
/* 3155 */             break;
/*      */           
/*      */ 
/*      */           case 216: 
/* 3159 */             this.periodmoney = _input_.readInt32();
/* 3160 */             break;
/*      */           
/*      */ 
/*      */           case 224: 
/* 3164 */             this.grouproleid = _input_.readInt64();
/* 3165 */             break;
/*      */           
/*      */ 
/*      */           case 242: 
/* 3169 */             this.groupopenid = _input_.readBytes().toString("UTF-16LE");
/* 3170 */             break;
/*      */           
/*      */ 
/*      */           case 256: 
/* 3174 */             this.displayid = _input_.readInt64();
/* 3175 */             break;
/*      */           
/*      */ 
/*      */           case 264: 
/* 3179 */             long _k_ = 0L;
/* 3180 */             _k_ = _input_.readInt64();
/* 3181 */             int readTag = _input_.readTag();
/* 3182 */             if (266 != readTag)
/*      */             {
/* 3184 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 3186 */             xbean.GangTeam _v_ = Pod.newGangTeamData();
/* 3187 */             _input_.readMessage(_v_);
/* 3188 */             this.teams.put(Long.valueOf(_k_), _v_);
/* 3189 */             break;
/*      */           
/*      */ 
/*      */           case 272: 
/* 3193 */             long _k_ = 0L;
/* 3194 */             _k_ = _input_.readInt64();
/* 3195 */             int readTag = _input_.readTag();
/* 3196 */             if (272 != readTag)
/*      */             {
/* 3198 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 3200 */             long _v_ = 0L;
/* 3201 */             _v_ = _input_.readInt64();
/* 3202 */             this.member2teamid.put(Long.valueOf(_k_), Long.valueOf(_v_));
/* 3203 */             break;
/*      */           
/*      */ 
/*      */           case 280: 
/* 3207 */             this.next_teamid = _input_.readInt64();
/* 3208 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 3212 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 3214 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 3223 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 3227 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 3229 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Gang copy()
/*      */     {
/* 3235 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Gang toData()
/*      */     {
/* 3241 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Gang toBean()
/*      */     {
/* 3246 */       return new Gang(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Gang toDataIf()
/*      */     {
/* 3252 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Gang toBeanIf()
/*      */     {
/* 3257 */       return new Gang(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 3263 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 3267 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 3271 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 3275 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 3279 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 3283 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 3287 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName()
/*      */     {
/* 3294 */       return this.name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNameOctets()
/*      */     {
/* 3301 */       return Octets.wrap(getName(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/* 3308 */       return this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreatetime()
/*      */     {
/* 3315 */       return this.createtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getPurpose()
/*      */     {
/* 3322 */       return this.purpose;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getPurposeOctets()
/*      */     {
/* 3329 */       return Octets.wrap(getPurpose(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBangzhuid()
/*      */     {
/* 3336 */       return this.bangzhuid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDesigntitlecaseid()
/*      */     {
/* 3343 */       return this.designtitlecaseid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVitality()
/*      */     {
/* 3350 */       return this.vitality;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLeveluptime()
/*      */     {
/* 3357 */       return this.leveluptime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.GangAnnouncement> getAnnouncementhistorylist()
/*      */     {
/* 3364 */       return this.announcementhistorylist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.GangAnnouncement> getAnnouncementhistorylistAsData()
/*      */     {
/* 3371 */       return this.announcementhistorylist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getApprenticemaxlv()
/*      */     {
/* 3378 */       return this.apprenticemaxlv;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTimestamp()
/*      */     {
/* 3385 */       return this.timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastrename()
/*      */     {
/* 3392 */       return this.lastrename;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getForbiddentalkcount()
/*      */     {
/* 3399 */       return this.forbiddentalkcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTanheroleid()
/*      */     {
/* 3406 */       return this.tanheroleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTanheendtime()
/*      */     {
/* 3413 */       return this.tanheendtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getJuanzhongnum()
/*      */     {
/* 3420 */       return this.juanzhongnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getNextid()
/*      */     {
/* 3427 */       return this.nextid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPublishtime()
/*      */     {
/* 3434 */       return this.publishtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.GangHelper> getGanghelperlist()
/*      */     {
/* 3441 */       return this.ganghelperlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.GangHelper> getGanghelperlistAsData()
/*      */     {
/* 3448 */       return this.ganghelperlist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.XiangFang getXiangfang()
/*      */     {
/* 3455 */       return this.xiangfang;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.JinKu getJinku()
/*      */     {
/* 3462 */       return this.jinku;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.YaoDian getYaodian()
/*      */     {
/* 3469 */       return this.yaodian;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.CangKu getCangku()
/*      */     {
/* 3476 */       return this.cangku;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.ShuYuan getShuyuan()
/*      */     {
/* 3483 */       return this.shuyuan;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.GangDutyMembers> getDuty2members()
/*      */     {
/* 3490 */       return this.duty2members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.GangDutyMembers> getDuty2membersAsData()
/*      */     {
/* 3497 */       return this.duty2members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPeriodmoney()
/*      */     {
/* 3504 */       return this.periodmoney;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGrouproleid()
/*      */     {
/* 3511 */       return this.grouproleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getGroupopenid()
/*      */     {
/* 3518 */       return this.groupopenid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getGroupopenidOctets()
/*      */     {
/* 3525 */       return Octets.wrap(getGroupopenid(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getDisplayid()
/*      */     {
/* 3532 */       return this.displayid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GangTeam> getTeams()
/*      */     {
/* 3539 */       return this.teams;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.GangTeam> getTeamsAsData()
/*      */     {
/* 3546 */       return this.teams;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getMember2teamid()
/*      */     {
/* 3553 */       return this.member2teamid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Long> getMember2teamidAsData()
/*      */     {
/* 3560 */       return this.member2teamid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getNext_teamid()
/*      */     {
/* 3567 */       return this.next_teamid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName(String _v_)
/*      */     {
/* 3574 */       if (null == _v_)
/* 3575 */         throw new NullPointerException();
/* 3576 */       this.name = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNameOctets(Octets _v_)
/*      */     {
/* 3583 */       setName(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/* 3590 */       this.level = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreatetime(long _v_)
/*      */     {
/* 3597 */       this.createtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPurpose(String _v_)
/*      */     {
/* 3604 */       if (null == _v_)
/* 3605 */         throw new NullPointerException();
/* 3606 */       this.purpose = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPurposeOctets(Octets _v_)
/*      */     {
/* 3613 */       setPurpose(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBangzhuid(long _v_)
/*      */     {
/* 3620 */       this.bangzhuid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDesigntitlecaseid(int _v_)
/*      */     {
/* 3627 */       this.designtitlecaseid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVitality(int _v_)
/*      */     {
/* 3634 */       this.vitality = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLeveluptime(long _v_)
/*      */     {
/* 3641 */       this.leveluptime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setApprenticemaxlv(int _v_)
/*      */     {
/* 3648 */       this.apprenticemaxlv = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTimestamp(long _v_)
/*      */     {
/* 3655 */       this.timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastrename(long _v_)
/*      */     {
/* 3662 */       this.lastrename = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setForbiddentalkcount(int _v_)
/*      */     {
/* 3669 */       this.forbiddentalkcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTanheroleid(long _v_)
/*      */     {
/* 3676 */       this.tanheroleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTanheendtime(long _v_)
/*      */     {
/* 3683 */       this.tanheendtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setJuanzhongnum(int _v_)
/*      */     {
/* 3690 */       this.juanzhongnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNextid(long _v_)
/*      */     {
/* 3697 */       this.nextid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPublishtime(int _v_)
/*      */     {
/* 3704 */       this.publishtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPeriodmoney(int _v_)
/*      */     {
/* 3711 */       this.periodmoney = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrouproleid(long _v_)
/*      */     {
/* 3718 */       this.grouproleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGroupopenid(String _v_)
/*      */     {
/* 3725 */       if (null == _v_)
/* 3726 */         throw new NullPointerException();
/* 3727 */       this.groupopenid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGroupopenidOctets(Octets _v_)
/*      */     {
/* 3734 */       setGroupopenid(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDisplayid(long _v_)
/*      */     {
/* 3741 */       this.displayid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNext_teamid(long _v_)
/*      */     {
/* 3748 */       this.next_teamid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 3754 */       if (!(_o1_ instanceof Data)) return false;
/* 3755 */       Data _o_ = (Data)_o1_;
/* 3756 */       if (!this.name.equals(_o_.name)) return false;
/* 3757 */       if (this.level != _o_.level) return false;
/* 3758 */       if (this.createtime != _o_.createtime) return false;
/* 3759 */       if (!this.purpose.equals(_o_.purpose)) return false;
/* 3760 */       if (this.bangzhuid != _o_.bangzhuid) return false;
/* 3761 */       if (this.designtitlecaseid != _o_.designtitlecaseid) return false;
/* 3762 */       if (this.vitality != _o_.vitality) return false;
/* 3763 */       if (this.leveluptime != _o_.leveluptime) return false;
/* 3764 */       if (!this.announcementhistorylist.equals(_o_.announcementhistorylist)) return false;
/* 3765 */       if (this.apprenticemaxlv != _o_.apprenticemaxlv) return false;
/* 3766 */       if (this.timestamp != _o_.timestamp) return false;
/* 3767 */       if (this.lastrename != _o_.lastrename) return false;
/* 3768 */       if (this.forbiddentalkcount != _o_.forbiddentalkcount) return false;
/* 3769 */       if (this.tanheroleid != _o_.tanheroleid) return false;
/* 3770 */       if (this.tanheendtime != _o_.tanheendtime) return false;
/* 3771 */       if (this.juanzhongnum != _o_.juanzhongnum) return false;
/* 3772 */       if (this.nextid != _o_.nextid) return false;
/* 3773 */       if (this.publishtime != _o_.publishtime) return false;
/* 3774 */       if (!this.ganghelperlist.equals(_o_.ganghelperlist)) return false;
/* 3775 */       if (!this.xiangfang.equals(_o_.xiangfang)) return false;
/* 3776 */       if (!this.jinku.equals(_o_.jinku)) return false;
/* 3777 */       if (!this.yaodian.equals(_o_.yaodian)) return false;
/* 3778 */       if (!this.cangku.equals(_o_.cangku)) return false;
/* 3779 */       if (!this.shuyuan.equals(_o_.shuyuan)) return false;
/* 3780 */       if (!this.duty2members.equals(_o_.duty2members)) return false;
/* 3781 */       if (this.periodmoney != _o_.periodmoney) return false;
/* 3782 */       if (this.grouproleid != _o_.grouproleid) return false;
/* 3783 */       if (!this.groupopenid.equals(_o_.groupopenid)) return false;
/* 3784 */       if (this.displayid != _o_.displayid) return false;
/* 3785 */       if (!this.teams.equals(_o_.teams)) return false;
/* 3786 */       if (!this.member2teamid.equals(_o_.member2teamid)) return false;
/* 3787 */       if (this.next_teamid != _o_.next_teamid) return false;
/* 3788 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 3794 */       int _h_ = 0;
/* 3795 */       _h_ += this.name.hashCode();
/* 3796 */       _h_ += this.level;
/* 3797 */       _h_ = (int)(_h_ + this.createtime);
/* 3798 */       _h_ += this.purpose.hashCode();
/* 3799 */       _h_ = (int)(_h_ + this.bangzhuid);
/* 3800 */       _h_ += this.designtitlecaseid;
/* 3801 */       _h_ += this.vitality;
/* 3802 */       _h_ = (int)(_h_ + this.leveluptime);
/* 3803 */       _h_ += this.announcementhistorylist.hashCode();
/* 3804 */       _h_ += this.apprenticemaxlv;
/* 3805 */       _h_ = (int)(_h_ + this.timestamp);
/* 3806 */       _h_ = (int)(_h_ + this.lastrename);
/* 3807 */       _h_ += this.forbiddentalkcount;
/* 3808 */       _h_ = (int)(_h_ + this.tanheroleid);
/* 3809 */       _h_ = (int)(_h_ + this.tanheendtime);
/* 3810 */       _h_ += this.juanzhongnum;
/* 3811 */       _h_ = (int)(_h_ + this.nextid);
/* 3812 */       _h_ += this.publishtime;
/* 3813 */       _h_ += this.ganghelperlist.hashCode();
/* 3814 */       _h_ += this.xiangfang.hashCode();
/* 3815 */       _h_ += this.jinku.hashCode();
/* 3816 */       _h_ += this.yaodian.hashCode();
/* 3817 */       _h_ += this.cangku.hashCode();
/* 3818 */       _h_ += this.shuyuan.hashCode();
/* 3819 */       _h_ += this.duty2members.hashCode();
/* 3820 */       _h_ += this.periodmoney;
/* 3821 */       _h_ = (int)(_h_ + this.grouproleid);
/* 3822 */       _h_ += this.groupopenid.hashCode();
/* 3823 */       _h_ = (int)(_h_ + this.displayid);
/* 3824 */       _h_ += this.teams.hashCode();
/* 3825 */       _h_ += this.member2teamid.hashCode();
/* 3826 */       _h_ = (int)(_h_ + this.next_teamid);
/* 3827 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 3833 */       StringBuilder _sb_ = new StringBuilder();
/* 3834 */       _sb_.append("(");
/* 3835 */       _sb_.append("'").append(this.name).append("'");
/* 3836 */       _sb_.append(",");
/* 3837 */       _sb_.append(this.level);
/* 3838 */       _sb_.append(",");
/* 3839 */       _sb_.append(this.createtime);
/* 3840 */       _sb_.append(",");
/* 3841 */       _sb_.append("'").append(this.purpose).append("'");
/* 3842 */       _sb_.append(",");
/* 3843 */       _sb_.append(this.bangzhuid);
/* 3844 */       _sb_.append(",");
/* 3845 */       _sb_.append(this.designtitlecaseid);
/* 3846 */       _sb_.append(",");
/* 3847 */       _sb_.append(this.vitality);
/* 3848 */       _sb_.append(",");
/* 3849 */       _sb_.append(this.leveluptime);
/* 3850 */       _sb_.append(",");
/* 3851 */       _sb_.append(this.announcementhistorylist);
/* 3852 */       _sb_.append(",");
/* 3853 */       _sb_.append(this.apprenticemaxlv);
/* 3854 */       _sb_.append(",");
/* 3855 */       _sb_.append(this.timestamp);
/* 3856 */       _sb_.append(",");
/* 3857 */       _sb_.append(this.lastrename);
/* 3858 */       _sb_.append(",");
/* 3859 */       _sb_.append(this.forbiddentalkcount);
/* 3860 */       _sb_.append(",");
/* 3861 */       _sb_.append(this.tanheroleid);
/* 3862 */       _sb_.append(",");
/* 3863 */       _sb_.append(this.tanheendtime);
/* 3864 */       _sb_.append(",");
/* 3865 */       _sb_.append(this.juanzhongnum);
/* 3866 */       _sb_.append(",");
/* 3867 */       _sb_.append(this.nextid);
/* 3868 */       _sb_.append(",");
/* 3869 */       _sb_.append(this.publishtime);
/* 3870 */       _sb_.append(",");
/* 3871 */       _sb_.append(this.ganghelperlist);
/* 3872 */       _sb_.append(",");
/* 3873 */       _sb_.append(this.xiangfang);
/* 3874 */       _sb_.append(",");
/* 3875 */       _sb_.append(this.jinku);
/* 3876 */       _sb_.append(",");
/* 3877 */       _sb_.append(this.yaodian);
/* 3878 */       _sb_.append(",");
/* 3879 */       _sb_.append(this.cangku);
/* 3880 */       _sb_.append(",");
/* 3881 */       _sb_.append(this.shuyuan);
/* 3882 */       _sb_.append(",");
/* 3883 */       _sb_.append(this.duty2members);
/* 3884 */       _sb_.append(",");
/* 3885 */       _sb_.append(this.periodmoney);
/* 3886 */       _sb_.append(",");
/* 3887 */       _sb_.append(this.grouproleid);
/* 3888 */       _sb_.append(",");
/* 3889 */       _sb_.append("'").append(this.groupopenid).append("'");
/* 3890 */       _sb_.append(",");
/* 3891 */       _sb_.append(this.displayid);
/* 3892 */       _sb_.append(",");
/* 3893 */       _sb_.append(this.teams);
/* 3894 */       _sb_.append(",");
/* 3895 */       _sb_.append(this.member2teamid);
/* 3896 */       _sb_.append(",");
/* 3897 */       _sb_.append(this.next_teamid);
/* 3898 */       _sb_.append(")");
/* 3899 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Gang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */