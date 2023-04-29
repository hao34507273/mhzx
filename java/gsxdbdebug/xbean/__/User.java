/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
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
/*      */ import xdb.logs.ListenableSet;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.logs.LogObject;
/*      */ import xdb.logs.LogString;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class User extends XBean implements xbean.User
/*      */ {
/*      */   private LinkedList<Long> roleids;
/*      */   private boolean activated;
/*      */   private long lastlogintime;
/*      */   private long last_login_roleid;
/*      */   private long max_fighting_capacity;
/*      */   private long max_fighting_capacity_roleid;
/*      */   private int grc_friends_count;
/*      */   private int grc_friends_count_award_serial_no;
/*      */   private int sn;
/*      */   private String final_success_order_id;
/*      */   private long final_transfer_success_time;
/*      */   private SetX<Long> compensates;
/*      */   private HashMap<Integer, xbean.PrivilegeAwardInfo> privilege_award_infos;
/*      */   private int invitee_status;
/*      */   private String invitee_code;
/*      */   private long invitee_total_present_rebate_bind_yuanbao;
/*      */   private String inviter_code;
/*      */   private long inviter_total_rebate_bind_yuanbao;
/*      */   private long inviter_total_gift_times;
/*      */   private long invitee_save_amt;
/*      */   private long register_time;
/*      */   private long invitee_confirm_total_present_rebate_bind_yuanbao;
/*      */   private int invitee_done_shimen_total_days;
/*      */   private long invitee_done_shimen_timestamp;
/*      */   private xbean.RecallFriendBackGame recall_friend_back_game;
/*      */   private String figure_url;
/*      */   private String nick_name;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   70 */     this.roleids.clear();
/*   71 */     this.activated = false;
/*   72 */     this.lastlogintime = 0L;
/*   73 */     this.last_login_roleid = 0L;
/*   74 */     this.max_fighting_capacity = 0L;
/*   75 */     this.max_fighting_capacity_roleid = 0L;
/*   76 */     this.grc_friends_count = 0;
/*   77 */     this.grc_friends_count_award_serial_no = 0;
/*   78 */     this.sn = 0;
/*   79 */     this.final_success_order_id = "";
/*   80 */     this.final_transfer_success_time = 0L;
/*   81 */     this.compensates.clear();
/*   82 */     this.privilege_award_infos.clear();
/*   83 */     this.invitee_status = 0;
/*   84 */     this.invitee_code = "";
/*   85 */     this.invitee_total_present_rebate_bind_yuanbao = 0L;
/*   86 */     this.inviter_code = "";
/*   87 */     this.inviter_total_rebate_bind_yuanbao = 0L;
/*   88 */     this.inviter_total_gift_times = 0L;
/*   89 */     this.invitee_save_amt = 0L;
/*   90 */     this.register_time = 0L;
/*   91 */     this.invitee_confirm_total_present_rebate_bind_yuanbao = 0L;
/*   92 */     this.invitee_done_shimen_total_days = 0;
/*   93 */     this.invitee_done_shimen_timestamp = 0L;
/*   94 */     this.recall_friend_back_game._reset_unsafe_();
/*   95 */     this.figure_url = "";
/*   96 */     this.nick_name = "";
/*      */   }
/*      */   
/*      */   User(int __, XBean _xp_, String _vn_)
/*      */   {
/*  101 */     super(_xp_, _vn_);
/*  102 */     this.roleids = new LinkedList();
/*  103 */     this.lastlogintime = 0L;
/*  104 */     this.last_login_roleid = 0L;
/*  105 */     this.max_fighting_capacity = 0L;
/*  106 */     this.max_fighting_capacity_roleid = 0L;
/*  107 */     this.grc_friends_count = 0;
/*  108 */     this.grc_friends_count_award_serial_no = 0;
/*  109 */     this.sn = 0;
/*  110 */     this.final_success_order_id = "";
/*  111 */     this.compensates = new SetX();
/*  112 */     this.privilege_award_infos = new HashMap();
/*  113 */     this.invitee_status = 0;
/*  114 */     this.invitee_code = "";
/*  115 */     this.invitee_total_present_rebate_bind_yuanbao = 0L;
/*  116 */     this.inviter_code = "";
/*  117 */     this.inviter_total_rebate_bind_yuanbao = 0L;
/*  118 */     this.inviter_total_gift_times = 0L;
/*  119 */     this.invitee_save_amt = 0L;
/*  120 */     this.register_time = 0L;
/*  121 */     this.invitee_confirm_total_present_rebate_bind_yuanbao = 0L;
/*  122 */     this.invitee_done_shimen_total_days = 0;
/*  123 */     this.invitee_done_shimen_timestamp = 0L;
/*  124 */     this.recall_friend_back_game = new RecallFriendBackGame(0, this, "recall_friend_back_game");
/*  125 */     this.figure_url = "";
/*  126 */     this.nick_name = "";
/*      */   }
/*      */   
/*      */   public User()
/*      */   {
/*  131 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public User(User _o_)
/*      */   {
/*  136 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   User(xbean.User _o1_, XBean _xp_, String _vn_)
/*      */   {
/*  141 */     super(_xp_, _vn_);
/*  142 */     if ((_o1_ instanceof User)) { assign((User)_o1_);
/*  143 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  144 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  145 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(User _o_) {
/*  150 */     _o_._xdb_verify_unsafe_();
/*  151 */     this.roleids = new LinkedList();
/*  152 */     this.roleids.addAll(_o_.roleids);
/*  153 */     this.activated = _o_.activated;
/*  154 */     this.lastlogintime = _o_.lastlogintime;
/*  155 */     this.last_login_roleid = _o_.last_login_roleid;
/*  156 */     this.max_fighting_capacity = _o_.max_fighting_capacity;
/*  157 */     this.max_fighting_capacity_roleid = _o_.max_fighting_capacity_roleid;
/*  158 */     this.grc_friends_count = _o_.grc_friends_count;
/*  159 */     this.grc_friends_count_award_serial_no = _o_.grc_friends_count_award_serial_no;
/*  160 */     this.sn = _o_.sn;
/*  161 */     this.final_success_order_id = _o_.final_success_order_id;
/*  162 */     this.final_transfer_success_time = _o_.final_transfer_success_time;
/*  163 */     this.compensates = new SetX();
/*  164 */     this.compensates.addAll(_o_.compensates);
/*  165 */     this.privilege_award_infos = new HashMap();
/*  166 */     for (Map.Entry<Integer, xbean.PrivilegeAwardInfo> _e_ : _o_.privilege_award_infos.entrySet())
/*  167 */       this.privilege_award_infos.put(_e_.getKey(), new PrivilegeAwardInfo((xbean.PrivilegeAwardInfo)_e_.getValue(), this, "privilege_award_infos"));
/*  168 */     this.invitee_status = _o_.invitee_status;
/*  169 */     this.invitee_code = _o_.invitee_code;
/*  170 */     this.invitee_total_present_rebate_bind_yuanbao = _o_.invitee_total_present_rebate_bind_yuanbao;
/*  171 */     this.inviter_code = _o_.inviter_code;
/*  172 */     this.inviter_total_rebate_bind_yuanbao = _o_.inviter_total_rebate_bind_yuanbao;
/*  173 */     this.inviter_total_gift_times = _o_.inviter_total_gift_times;
/*  174 */     this.invitee_save_amt = _o_.invitee_save_amt;
/*  175 */     this.register_time = _o_.register_time;
/*  176 */     this.invitee_confirm_total_present_rebate_bind_yuanbao = _o_.invitee_confirm_total_present_rebate_bind_yuanbao;
/*  177 */     this.invitee_done_shimen_total_days = _o_.invitee_done_shimen_total_days;
/*  178 */     this.invitee_done_shimen_timestamp = _o_.invitee_done_shimen_timestamp;
/*  179 */     this.recall_friend_back_game = new RecallFriendBackGame(_o_.recall_friend_back_game, this, "recall_friend_back_game");
/*  180 */     this.figure_url = _o_.figure_url;
/*  181 */     this.nick_name = _o_.nick_name;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  186 */     this.roleids = new LinkedList();
/*  187 */     this.roleids.addAll(_o_.roleids);
/*  188 */     this.activated = _o_.activated;
/*  189 */     this.lastlogintime = _o_.lastlogintime;
/*  190 */     this.last_login_roleid = _o_.last_login_roleid;
/*  191 */     this.max_fighting_capacity = _o_.max_fighting_capacity;
/*  192 */     this.max_fighting_capacity_roleid = _o_.max_fighting_capacity_roleid;
/*  193 */     this.grc_friends_count = _o_.grc_friends_count;
/*  194 */     this.grc_friends_count_award_serial_no = _o_.grc_friends_count_award_serial_no;
/*  195 */     this.sn = _o_.sn;
/*  196 */     this.final_success_order_id = _o_.final_success_order_id;
/*  197 */     this.final_transfer_success_time = _o_.final_transfer_success_time;
/*  198 */     this.compensates = new SetX();
/*  199 */     this.compensates.addAll(_o_.compensates);
/*  200 */     this.privilege_award_infos = new HashMap();
/*  201 */     for (Map.Entry<Integer, xbean.PrivilegeAwardInfo> _e_ : _o_.privilege_award_infos.entrySet())
/*  202 */       this.privilege_award_infos.put(_e_.getKey(), new PrivilegeAwardInfo((xbean.PrivilegeAwardInfo)_e_.getValue(), this, "privilege_award_infos"));
/*  203 */     this.invitee_status = _o_.invitee_status;
/*  204 */     this.invitee_code = _o_.invitee_code;
/*  205 */     this.invitee_total_present_rebate_bind_yuanbao = _o_.invitee_total_present_rebate_bind_yuanbao;
/*  206 */     this.inviter_code = _o_.inviter_code;
/*  207 */     this.inviter_total_rebate_bind_yuanbao = _o_.inviter_total_rebate_bind_yuanbao;
/*  208 */     this.inviter_total_gift_times = _o_.inviter_total_gift_times;
/*  209 */     this.invitee_save_amt = _o_.invitee_save_amt;
/*  210 */     this.register_time = _o_.register_time;
/*  211 */     this.invitee_confirm_total_present_rebate_bind_yuanbao = _o_.invitee_confirm_total_present_rebate_bind_yuanbao;
/*  212 */     this.invitee_done_shimen_total_days = _o_.invitee_done_shimen_total_days;
/*  213 */     this.invitee_done_shimen_timestamp = _o_.invitee_done_shimen_timestamp;
/*  214 */     this.recall_friend_back_game = new RecallFriendBackGame(_o_.recall_friend_back_game, this, "recall_friend_back_game");
/*  215 */     this.figure_url = _o_.figure_url;
/*  216 */     this.nick_name = _o_.nick_name;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  222 */     _xdb_verify_unsafe_();
/*  223 */     _os_.compact_uint32(this.roleids.size());
/*  224 */     for (Long _v_ : this.roleids)
/*      */     {
/*  226 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  228 */     _os_.marshal(this.activated);
/*  229 */     _os_.marshal(this.lastlogintime);
/*  230 */     _os_.marshal(this.last_login_roleid);
/*  231 */     _os_.marshal(this.max_fighting_capacity);
/*  232 */     _os_.marshal(this.max_fighting_capacity_roleid);
/*  233 */     _os_.marshal(this.grc_friends_count);
/*  234 */     _os_.marshal(this.grc_friends_count_award_serial_no);
/*  235 */     _os_.marshal(this.sn);
/*  236 */     _os_.marshal(this.final_success_order_id, "UTF-16LE");
/*  237 */     _os_.marshal(this.final_transfer_success_time);
/*  238 */     _os_.compact_uint32(this.compensates.size());
/*  239 */     for (Long _v_ : this.compensates)
/*      */     {
/*  241 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  243 */     _os_.compact_uint32(this.privilege_award_infos.size());
/*  244 */     for (Map.Entry<Integer, xbean.PrivilegeAwardInfo> _e_ : this.privilege_award_infos.entrySet())
/*      */     {
/*  246 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  247 */       ((xbean.PrivilegeAwardInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  249 */     _os_.marshal(this.invitee_status);
/*  250 */     _os_.marshal(this.invitee_code, "UTF-16LE");
/*  251 */     _os_.marshal(this.invitee_total_present_rebate_bind_yuanbao);
/*  252 */     _os_.marshal(this.inviter_code, "UTF-16LE");
/*  253 */     _os_.marshal(this.inviter_total_rebate_bind_yuanbao);
/*  254 */     _os_.marshal(this.inviter_total_gift_times);
/*  255 */     _os_.marshal(this.invitee_save_amt);
/*  256 */     _os_.marshal(this.register_time);
/*  257 */     _os_.marshal(this.invitee_confirm_total_present_rebate_bind_yuanbao);
/*  258 */     _os_.marshal(this.invitee_done_shimen_total_days);
/*  259 */     _os_.marshal(this.invitee_done_shimen_timestamp);
/*  260 */     this.recall_friend_back_game.marshal(_os_);
/*  261 */     _os_.marshal(this.figure_url, "UTF-16LE");
/*  262 */     _os_.marshal(this.nick_name, "UTF-16LE");
/*  263 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  269 */     _xdb_verify_unsafe_();
/*  270 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  272 */       long _v_ = 0L;
/*  273 */       _v_ = _os_.unmarshal_long();
/*  274 */       this.roleids.add(Long.valueOf(_v_));
/*      */     }
/*  276 */     this.activated = _os_.unmarshal_boolean();
/*  277 */     this.lastlogintime = _os_.unmarshal_long();
/*  278 */     this.last_login_roleid = _os_.unmarshal_long();
/*  279 */     this.max_fighting_capacity = _os_.unmarshal_long();
/*  280 */     this.max_fighting_capacity_roleid = _os_.unmarshal_long();
/*  281 */     this.grc_friends_count = _os_.unmarshal_int();
/*  282 */     this.grc_friends_count_award_serial_no = _os_.unmarshal_int();
/*  283 */     this.sn = _os_.unmarshal_int();
/*  284 */     this.final_success_order_id = _os_.unmarshal_String("UTF-16LE");
/*  285 */     this.final_transfer_success_time = _os_.unmarshal_long();
/*  286 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  288 */       long _v_ = 0L;
/*  289 */       _v_ = _os_.unmarshal_long();
/*  290 */       this.compensates.add(Long.valueOf(_v_));
/*      */     }
/*      */     
/*  293 */     int size = _os_.uncompact_uint32();
/*  294 */     if (size >= 12)
/*      */     {
/*  296 */       this.privilege_award_infos = new HashMap(size * 2);
/*      */     }
/*  298 */     for (; size > 0; size--)
/*      */     {
/*  300 */       int _k_ = 0;
/*  301 */       _k_ = _os_.unmarshal_int();
/*  302 */       xbean.PrivilegeAwardInfo _v_ = new PrivilegeAwardInfo(0, this, "privilege_award_infos");
/*  303 */       _v_.unmarshal(_os_);
/*  304 */       this.privilege_award_infos.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  307 */     this.invitee_status = _os_.unmarshal_int();
/*  308 */     this.invitee_code = _os_.unmarshal_String("UTF-16LE");
/*  309 */     this.invitee_total_present_rebate_bind_yuanbao = _os_.unmarshal_long();
/*  310 */     this.inviter_code = _os_.unmarshal_String("UTF-16LE");
/*  311 */     this.inviter_total_rebate_bind_yuanbao = _os_.unmarshal_long();
/*  312 */     this.inviter_total_gift_times = _os_.unmarshal_long();
/*  313 */     this.invitee_save_amt = _os_.unmarshal_long();
/*  314 */     this.register_time = _os_.unmarshal_long();
/*  315 */     this.invitee_confirm_total_present_rebate_bind_yuanbao = _os_.unmarshal_long();
/*  316 */     this.invitee_done_shimen_total_days = _os_.unmarshal_int();
/*  317 */     this.invitee_done_shimen_timestamp = _os_.unmarshal_long();
/*  318 */     this.recall_friend_back_game.unmarshal(_os_);
/*  319 */     this.figure_url = _os_.unmarshal_String("UTF-16LE");
/*  320 */     this.nick_name = _os_.unmarshal_String("UTF-16LE");
/*  321 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*  328 */     int _size_ = 0;
/*  329 */     for (Long _v_ : this.roleids)
/*      */     {
/*  331 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*      */     }
/*  333 */     _size_ += CodedOutputStream.computeBoolSize(2, this.activated);
/*  334 */     _size_ += CodedOutputStream.computeInt64Size(3, this.lastlogintime);
/*  335 */     _size_ += CodedOutputStream.computeInt64Size(4, this.last_login_roleid);
/*  336 */     _size_ += CodedOutputStream.computeInt64Size(5, this.max_fighting_capacity);
/*  337 */     _size_ += CodedOutputStream.computeInt64Size(6, this.max_fighting_capacity_roleid);
/*  338 */     _size_ += CodedOutputStream.computeInt32Size(7, this.grc_friends_count);
/*  339 */     _size_ += CodedOutputStream.computeInt32Size(8, this.grc_friends_count_award_serial_no);
/*  340 */     _size_ += CodedOutputStream.computeInt32Size(9, this.sn);
/*      */     try
/*      */     {
/*  343 */       _size_ += CodedOutputStream.computeBytesSize(10, ByteString.copyFrom(this.final_success_order_id, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  347 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  349 */     _size_ += CodedOutputStream.computeInt64Size(11, this.final_transfer_success_time);
/*  350 */     for (Long _v_ : this.compensates)
/*      */     {
/*  352 */       _size_ += CodedOutputStream.computeInt64Size(12, _v_.longValue());
/*      */     }
/*  354 */     for (Map.Entry<Integer, xbean.PrivilegeAwardInfo> _e_ : this.privilege_award_infos.entrySet())
/*      */     {
/*  356 */       _size_ += CodedOutputStream.computeInt32Size(13, ((Integer)_e_.getKey()).intValue());
/*  357 */       _size_ += CodedOutputStream.computeMessageSize(13, (Message)_e_.getValue());
/*      */     }
/*  359 */     _size_ += CodedOutputStream.computeInt32Size(14, this.invitee_status);
/*      */     try
/*      */     {
/*  362 */       _size_ += CodedOutputStream.computeBytesSize(15, ByteString.copyFrom(this.invitee_code, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  366 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  368 */     _size_ += CodedOutputStream.computeInt64Size(16, this.invitee_total_present_rebate_bind_yuanbao);
/*      */     try
/*      */     {
/*  371 */       _size_ += CodedOutputStream.computeBytesSize(17, ByteString.copyFrom(this.inviter_code, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  375 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  377 */     _size_ += CodedOutputStream.computeInt64Size(18, this.inviter_total_rebate_bind_yuanbao);
/*  378 */     _size_ += CodedOutputStream.computeInt64Size(19, this.inviter_total_gift_times);
/*  379 */     _size_ += CodedOutputStream.computeInt64Size(20, this.invitee_save_amt);
/*  380 */     _size_ += CodedOutputStream.computeInt64Size(21, this.register_time);
/*  381 */     _size_ += CodedOutputStream.computeInt64Size(22, this.invitee_confirm_total_present_rebate_bind_yuanbao);
/*  382 */     _size_ += CodedOutputStream.computeInt32Size(23, this.invitee_done_shimen_total_days);
/*  383 */     _size_ += CodedOutputStream.computeInt64Size(24, this.invitee_done_shimen_timestamp);
/*  384 */     _size_ += CodedOutputStream.computeMessageSize(25, this.recall_friend_back_game);
/*      */     try
/*      */     {
/*  387 */       _size_ += CodedOutputStream.computeBytesSize(26, ByteString.copyFrom(this.figure_url, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  391 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*      */     try
/*      */     {
/*  395 */       _size_ += CodedOutputStream.computeBytesSize(27, ByteString.copyFrom(this.nick_name, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  399 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  401 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  410 */       for (Long _v_ : this.roleids)
/*      */       {
/*  412 */         _output_.writeInt64(1, _v_.longValue());
/*      */       }
/*  414 */       _output_.writeBool(2, this.activated);
/*  415 */       _output_.writeInt64(3, this.lastlogintime);
/*  416 */       _output_.writeInt64(4, this.last_login_roleid);
/*  417 */       _output_.writeInt64(5, this.max_fighting_capacity);
/*  418 */       _output_.writeInt64(6, this.max_fighting_capacity_roleid);
/*  419 */       _output_.writeInt32(7, this.grc_friends_count);
/*  420 */       _output_.writeInt32(8, this.grc_friends_count_award_serial_no);
/*  421 */       _output_.writeInt32(9, this.sn);
/*  422 */       _output_.writeBytes(10, ByteString.copyFrom(this.final_success_order_id, "UTF-16LE"));
/*  423 */       _output_.writeInt64(11, this.final_transfer_success_time);
/*  424 */       for (Long _v_ : this.compensates)
/*      */       {
/*  426 */         _output_.writeInt64(12, _v_.longValue());
/*      */       }
/*  428 */       for (Map.Entry<Integer, xbean.PrivilegeAwardInfo> _e_ : this.privilege_award_infos.entrySet())
/*      */       {
/*  430 */         _output_.writeInt32(13, ((Integer)_e_.getKey()).intValue());
/*  431 */         _output_.writeMessage(13, (Message)_e_.getValue());
/*      */       }
/*  433 */       _output_.writeInt32(14, this.invitee_status);
/*  434 */       _output_.writeBytes(15, ByteString.copyFrom(this.invitee_code, "UTF-16LE"));
/*  435 */       _output_.writeInt64(16, this.invitee_total_present_rebate_bind_yuanbao);
/*  436 */       _output_.writeBytes(17, ByteString.copyFrom(this.inviter_code, "UTF-16LE"));
/*  437 */       _output_.writeInt64(18, this.inviter_total_rebate_bind_yuanbao);
/*  438 */       _output_.writeInt64(19, this.inviter_total_gift_times);
/*  439 */       _output_.writeInt64(20, this.invitee_save_amt);
/*  440 */       _output_.writeInt64(21, this.register_time);
/*  441 */       _output_.writeInt64(22, this.invitee_confirm_total_present_rebate_bind_yuanbao);
/*  442 */       _output_.writeInt32(23, this.invitee_done_shimen_total_days);
/*  443 */       _output_.writeInt64(24, this.invitee_done_shimen_timestamp);
/*  444 */       _output_.writeMessage(25, this.recall_friend_back_game);
/*  445 */       _output_.writeBytes(26, ByteString.copyFrom(this.figure_url, "UTF-16LE"));
/*  446 */       _output_.writeBytes(27, ByteString.copyFrom(this.nick_name, "UTF-16LE"));
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  450 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  452 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  458 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  461 */       boolean done = false;
/*  462 */       while (!done)
/*      */       {
/*  464 */         int tag = _input_.readTag();
/*  465 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  469 */           done = true;
/*  470 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  474 */           long _v_ = 0L;
/*  475 */           _v_ = _input_.readInt64();
/*  476 */           this.roleids.add(Long.valueOf(_v_));
/*  477 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  481 */           this.activated = _input_.readBool();
/*  482 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  486 */           this.lastlogintime = _input_.readInt64();
/*  487 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  491 */           this.last_login_roleid = _input_.readInt64();
/*  492 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  496 */           this.max_fighting_capacity = _input_.readInt64();
/*  497 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  501 */           this.max_fighting_capacity_roleid = _input_.readInt64();
/*  502 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  506 */           this.grc_friends_count = _input_.readInt32();
/*  507 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  511 */           this.grc_friends_count_award_serial_no = _input_.readInt32();
/*  512 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  516 */           this.sn = _input_.readInt32();
/*  517 */           break;
/*      */         
/*      */ 
/*      */         case 82: 
/*  521 */           this.final_success_order_id = _input_.readBytes().toString("UTF-16LE");
/*  522 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  526 */           this.final_transfer_success_time = _input_.readInt64();
/*  527 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  531 */           long _v_ = 0L;
/*  532 */           _v_ = _input_.readInt64();
/*  533 */           this.compensates.add(Long.valueOf(_v_));
/*  534 */           break;
/*      */         
/*      */ 
/*      */         case 104: 
/*  538 */           int _k_ = 0;
/*  539 */           _k_ = _input_.readInt32();
/*  540 */           int readTag = _input_.readTag();
/*  541 */           if (106 != readTag)
/*      */           {
/*  543 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  545 */           xbean.PrivilegeAwardInfo _v_ = new PrivilegeAwardInfo(0, this, "privilege_award_infos");
/*  546 */           _input_.readMessage(_v_);
/*  547 */           this.privilege_award_infos.put(Integer.valueOf(_k_), _v_);
/*  548 */           break;
/*      */         
/*      */ 
/*      */         case 112: 
/*  552 */           this.invitee_status = _input_.readInt32();
/*  553 */           break;
/*      */         
/*      */ 
/*      */         case 122: 
/*  557 */           this.invitee_code = _input_.readBytes().toString("UTF-16LE");
/*  558 */           break;
/*      */         
/*      */ 
/*      */         case 128: 
/*  562 */           this.invitee_total_present_rebate_bind_yuanbao = _input_.readInt64();
/*  563 */           break;
/*      */         
/*      */ 
/*      */         case 138: 
/*  567 */           this.inviter_code = _input_.readBytes().toString("UTF-16LE");
/*  568 */           break;
/*      */         
/*      */ 
/*      */         case 144: 
/*  572 */           this.inviter_total_rebate_bind_yuanbao = _input_.readInt64();
/*  573 */           break;
/*      */         
/*      */ 
/*      */         case 152: 
/*  577 */           this.inviter_total_gift_times = _input_.readInt64();
/*  578 */           break;
/*      */         
/*      */ 
/*      */         case 160: 
/*  582 */           this.invitee_save_amt = _input_.readInt64();
/*  583 */           break;
/*      */         
/*      */ 
/*      */         case 168: 
/*  587 */           this.register_time = _input_.readInt64();
/*  588 */           break;
/*      */         
/*      */ 
/*      */         case 176: 
/*  592 */           this.invitee_confirm_total_present_rebate_bind_yuanbao = _input_.readInt64();
/*  593 */           break;
/*      */         
/*      */ 
/*      */         case 184: 
/*  597 */           this.invitee_done_shimen_total_days = _input_.readInt32();
/*  598 */           break;
/*      */         
/*      */ 
/*      */         case 192: 
/*  602 */           this.invitee_done_shimen_timestamp = _input_.readInt64();
/*  603 */           break;
/*      */         
/*      */ 
/*      */         case 202: 
/*  607 */           _input_.readMessage(this.recall_friend_back_game);
/*  608 */           break;
/*      */         
/*      */ 
/*      */         case 210: 
/*  612 */           this.figure_url = _input_.readBytes().toString("UTF-16LE");
/*  613 */           break;
/*      */         
/*      */ 
/*      */         case 218: 
/*  617 */           this.nick_name = _input_.readBytes().toString("UTF-16LE");
/*  618 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  622 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  624 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  633 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  637 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  639 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.User copy()
/*      */   {
/*  645 */     _xdb_verify_unsafe_();
/*  646 */     return new User(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.User toData()
/*      */   {
/*  652 */     _xdb_verify_unsafe_();
/*  653 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.User toBean()
/*      */   {
/*  658 */     _xdb_verify_unsafe_();
/*  659 */     return new User(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.User toDataIf()
/*      */   {
/*  665 */     _xdb_verify_unsafe_();
/*  666 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.User toBeanIf()
/*      */   {
/*  671 */     _xdb_verify_unsafe_();
/*  672 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  678 */     _xdb_verify_unsafe_();
/*  679 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getRoleids()
/*      */   {
/*  686 */     _xdb_verify_unsafe_();
/*  687 */     return Logs.logList(new LogKey(this, "roleids"), this.roleids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getRoleidsAsData()
/*      */   {
/*  693 */     _xdb_verify_unsafe_();
/*      */     
/*  695 */     User _o_ = this;
/*  696 */     List<Long> roleids = new LinkedList();
/*  697 */     roleids.addAll(_o_.roleids);
/*  698 */     return roleids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getActivated()
/*      */   {
/*  705 */     _xdb_verify_unsafe_();
/*  706 */     return this.activated;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLastlogintime()
/*      */   {
/*  713 */     _xdb_verify_unsafe_();
/*  714 */     return this.lastlogintime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLast_login_roleid()
/*      */   {
/*  721 */     _xdb_verify_unsafe_();
/*  722 */     return this.last_login_roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMax_fighting_capacity()
/*      */   {
/*  729 */     _xdb_verify_unsafe_();
/*  730 */     return this.max_fighting_capacity;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMax_fighting_capacity_roleid()
/*      */   {
/*  737 */     _xdb_verify_unsafe_();
/*  738 */     return this.max_fighting_capacity_roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGrc_friends_count()
/*      */   {
/*  745 */     _xdb_verify_unsafe_();
/*  746 */     return this.grc_friends_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGrc_friends_count_award_serial_no()
/*      */   {
/*  753 */     _xdb_verify_unsafe_();
/*  754 */     return this.grc_friends_count_award_serial_no;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getSn()
/*      */   {
/*  761 */     _xdb_verify_unsafe_();
/*  762 */     return this.sn;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getFinal_success_order_id()
/*      */   {
/*  769 */     _xdb_verify_unsafe_();
/*  770 */     return this.final_success_order_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getFinal_success_order_idOctets()
/*      */   {
/*  777 */     _xdb_verify_unsafe_();
/*  778 */     return Octets.wrap(getFinal_success_order_id(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getFinal_transfer_success_time()
/*      */   {
/*  785 */     _xdb_verify_unsafe_();
/*  786 */     return this.final_transfer_success_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getCompensates()
/*      */   {
/*  793 */     _xdb_verify_unsafe_();
/*  794 */     return Logs.logSet(new LogKey(this, "compensates"), this.compensates);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getCompensatesAsData()
/*      */   {
/*  800 */     _xdb_verify_unsafe_();
/*      */     
/*  802 */     User _o_ = this;
/*  803 */     Set<Long> compensates = new SetX();
/*  804 */     compensates.addAll(_o_.compensates);
/*  805 */     return compensates;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.PrivilegeAwardInfo> getPrivilege_award_infos()
/*      */   {
/*  812 */     _xdb_verify_unsafe_();
/*  813 */     return Logs.logMap(new LogKey(this, "privilege_award_infos"), this.privilege_award_infos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.PrivilegeAwardInfo> getPrivilege_award_infosAsData()
/*      */   {
/*  820 */     _xdb_verify_unsafe_();
/*      */     
/*  822 */     User _o_ = this;
/*  823 */     Map<Integer, xbean.PrivilegeAwardInfo> privilege_award_infos = new HashMap();
/*  824 */     for (Map.Entry<Integer, xbean.PrivilegeAwardInfo> _e_ : _o_.privilege_award_infos.entrySet())
/*  825 */       privilege_award_infos.put(_e_.getKey(), new PrivilegeAwardInfo.Data((xbean.PrivilegeAwardInfo)_e_.getValue()));
/*  826 */     return privilege_award_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getInvitee_status()
/*      */   {
/*  833 */     _xdb_verify_unsafe_();
/*  834 */     return this.invitee_status;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getInvitee_code()
/*      */   {
/*  841 */     _xdb_verify_unsafe_();
/*  842 */     return this.invitee_code;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getInvitee_codeOctets()
/*      */   {
/*  849 */     _xdb_verify_unsafe_();
/*  850 */     return Octets.wrap(getInvitee_code(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getInvitee_total_present_rebate_bind_yuanbao()
/*      */   {
/*  857 */     _xdb_verify_unsafe_();
/*  858 */     return this.invitee_total_present_rebate_bind_yuanbao;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getInviter_code()
/*      */   {
/*  865 */     _xdb_verify_unsafe_();
/*  866 */     return this.inviter_code;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getInviter_codeOctets()
/*      */   {
/*  873 */     _xdb_verify_unsafe_();
/*  874 */     return Octets.wrap(getInviter_code(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getInviter_total_rebate_bind_yuanbao()
/*      */   {
/*  881 */     _xdb_verify_unsafe_();
/*  882 */     return this.inviter_total_rebate_bind_yuanbao;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getInviter_total_gift_times()
/*      */   {
/*  889 */     _xdb_verify_unsafe_();
/*  890 */     return this.inviter_total_gift_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getInvitee_save_amt()
/*      */   {
/*  897 */     _xdb_verify_unsafe_();
/*  898 */     return this.invitee_save_amt;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRegister_time()
/*      */   {
/*  905 */     _xdb_verify_unsafe_();
/*  906 */     return this.register_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getInvitee_confirm_total_present_rebate_bind_yuanbao()
/*      */   {
/*  913 */     _xdb_verify_unsafe_();
/*  914 */     return this.invitee_confirm_total_present_rebate_bind_yuanbao;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getInvitee_done_shimen_total_days()
/*      */   {
/*  921 */     _xdb_verify_unsafe_();
/*  922 */     return this.invitee_done_shimen_total_days;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getInvitee_done_shimen_timestamp()
/*      */   {
/*  929 */     _xdb_verify_unsafe_();
/*  930 */     return this.invitee_done_shimen_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.RecallFriendBackGame getRecall_friend_back_game()
/*      */   {
/*  937 */     _xdb_verify_unsafe_();
/*  938 */     return this.recall_friend_back_game;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getFigure_url()
/*      */   {
/*  945 */     _xdb_verify_unsafe_();
/*  946 */     return this.figure_url;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getFigure_urlOctets()
/*      */   {
/*  953 */     _xdb_verify_unsafe_();
/*  954 */     return Octets.wrap(getFigure_url(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getNick_name()
/*      */   {
/*  961 */     _xdb_verify_unsafe_();
/*  962 */     return this.nick_name;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getNick_nameOctets()
/*      */   {
/*  969 */     _xdb_verify_unsafe_();
/*  970 */     return Octets.wrap(getNick_name(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActivated(boolean _v_)
/*      */   {
/*  977 */     _xdb_verify_unsafe_();
/*  978 */     Logs.logIf(new LogKey(this, "activated")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  982 */         new LogObject(this, Boolean.valueOf(User.this.activated))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  986 */             User.this.activated = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  990 */     });
/*  991 */     this.activated = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLastlogintime(long _v_)
/*      */   {
/*  998 */     _xdb_verify_unsafe_();
/*  999 */     Logs.logIf(new LogKey(this, "lastlogintime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1003 */         new LogLong(this, User.this.lastlogintime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1007 */             User.this.lastlogintime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1011 */     });
/* 1012 */     this.lastlogintime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_login_roleid(long _v_)
/*      */   {
/* 1019 */     _xdb_verify_unsafe_();
/* 1020 */     Logs.logIf(new LogKey(this, "last_login_roleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1024 */         new LogLong(this, User.this.last_login_roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1028 */             User.this.last_login_roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1032 */     });
/* 1033 */     this.last_login_roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMax_fighting_capacity(long _v_)
/*      */   {
/* 1040 */     _xdb_verify_unsafe_();
/* 1041 */     Logs.logIf(new LogKey(this, "max_fighting_capacity")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1045 */         new LogLong(this, User.this.max_fighting_capacity)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1049 */             User.this.max_fighting_capacity = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1053 */     });
/* 1054 */     this.max_fighting_capacity = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMax_fighting_capacity_roleid(long _v_)
/*      */   {
/* 1061 */     _xdb_verify_unsafe_();
/* 1062 */     Logs.logIf(new LogKey(this, "max_fighting_capacity_roleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1066 */         new LogLong(this, User.this.max_fighting_capacity_roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1070 */             User.this.max_fighting_capacity_roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1074 */     });
/* 1075 */     this.max_fighting_capacity_roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGrc_friends_count(int _v_)
/*      */   {
/* 1082 */     _xdb_verify_unsafe_();
/* 1083 */     Logs.logIf(new LogKey(this, "grc_friends_count")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1087 */         new LogInt(this, User.this.grc_friends_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1091 */             User.this.grc_friends_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1095 */     });
/* 1096 */     this.grc_friends_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGrc_friends_count_award_serial_no(int _v_)
/*      */   {
/* 1103 */     _xdb_verify_unsafe_();
/* 1104 */     Logs.logIf(new LogKey(this, "grc_friends_count_award_serial_no")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1108 */         new LogInt(this, User.this.grc_friends_count_award_serial_no)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1112 */             User.this.grc_friends_count_award_serial_no = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1116 */     });
/* 1117 */     this.grc_friends_count_award_serial_no = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSn(int _v_)
/*      */   {
/* 1124 */     _xdb_verify_unsafe_();
/* 1125 */     Logs.logIf(new LogKey(this, "sn")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1129 */         new LogInt(this, User.this.sn)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1133 */             User.this.sn = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1137 */     });
/* 1138 */     this.sn = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFinal_success_order_id(String _v_)
/*      */   {
/* 1145 */     _xdb_verify_unsafe_();
/* 1146 */     if (null == _v_)
/* 1147 */       throw new NullPointerException();
/* 1148 */     Logs.logIf(new LogKey(this, "final_success_order_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1152 */         new LogString(this, User.this.final_success_order_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1156 */             User.this.final_success_order_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1160 */     });
/* 1161 */     this.final_success_order_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFinal_success_order_idOctets(Octets _v_)
/*      */   {
/* 1168 */     _xdb_verify_unsafe_();
/* 1169 */     setFinal_success_order_id(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFinal_transfer_success_time(long _v_)
/*      */   {
/* 1176 */     _xdb_verify_unsafe_();
/* 1177 */     Logs.logIf(new LogKey(this, "final_transfer_success_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1181 */         new LogLong(this, User.this.final_transfer_success_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1185 */             User.this.final_transfer_success_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1189 */     });
/* 1190 */     this.final_transfer_success_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInvitee_status(int _v_)
/*      */   {
/* 1197 */     _xdb_verify_unsafe_();
/* 1198 */     Logs.logIf(new LogKey(this, "invitee_status")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1202 */         new LogInt(this, User.this.invitee_status)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1206 */             User.this.invitee_status = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1210 */     });
/* 1211 */     this.invitee_status = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInvitee_code(String _v_)
/*      */   {
/* 1218 */     _xdb_verify_unsafe_();
/* 1219 */     if (null == _v_)
/* 1220 */       throw new NullPointerException();
/* 1221 */     Logs.logIf(new LogKey(this, "invitee_code")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1225 */         new LogString(this, User.this.invitee_code)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1229 */             User.this.invitee_code = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1233 */     });
/* 1234 */     this.invitee_code = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInvitee_codeOctets(Octets _v_)
/*      */   {
/* 1241 */     _xdb_verify_unsafe_();
/* 1242 */     setInvitee_code(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInvitee_total_present_rebate_bind_yuanbao(long _v_)
/*      */   {
/* 1249 */     _xdb_verify_unsafe_();
/* 1250 */     Logs.logIf(new LogKey(this, "invitee_total_present_rebate_bind_yuanbao")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1254 */         new LogLong(this, User.this.invitee_total_present_rebate_bind_yuanbao)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1258 */             User.this.invitee_total_present_rebate_bind_yuanbao = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1262 */     });
/* 1263 */     this.invitee_total_present_rebate_bind_yuanbao = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInviter_code(String _v_)
/*      */   {
/* 1270 */     _xdb_verify_unsafe_();
/* 1271 */     if (null == _v_)
/* 1272 */       throw new NullPointerException();
/* 1273 */     Logs.logIf(new LogKey(this, "inviter_code")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1277 */         new LogString(this, User.this.inviter_code)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1281 */             User.this.inviter_code = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1285 */     });
/* 1286 */     this.inviter_code = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInviter_codeOctets(Octets _v_)
/*      */   {
/* 1293 */     _xdb_verify_unsafe_();
/* 1294 */     setInviter_code(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInviter_total_rebate_bind_yuanbao(long _v_)
/*      */   {
/* 1301 */     _xdb_verify_unsafe_();
/* 1302 */     Logs.logIf(new LogKey(this, "inviter_total_rebate_bind_yuanbao")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1306 */         new LogLong(this, User.this.inviter_total_rebate_bind_yuanbao)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1310 */             User.this.inviter_total_rebate_bind_yuanbao = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1314 */     });
/* 1315 */     this.inviter_total_rebate_bind_yuanbao = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInviter_total_gift_times(long _v_)
/*      */   {
/* 1322 */     _xdb_verify_unsafe_();
/* 1323 */     Logs.logIf(new LogKey(this, "inviter_total_gift_times")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1327 */         new LogLong(this, User.this.inviter_total_gift_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1331 */             User.this.inviter_total_gift_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1335 */     });
/* 1336 */     this.inviter_total_gift_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInvitee_save_amt(long _v_)
/*      */   {
/* 1343 */     _xdb_verify_unsafe_();
/* 1344 */     Logs.logIf(new LogKey(this, "invitee_save_amt")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1348 */         new LogLong(this, User.this.invitee_save_amt)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1352 */             User.this.invitee_save_amt = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1356 */     });
/* 1357 */     this.invitee_save_amt = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRegister_time(long _v_)
/*      */   {
/* 1364 */     _xdb_verify_unsafe_();
/* 1365 */     Logs.logIf(new LogKey(this, "register_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1369 */         new LogLong(this, User.this.register_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1373 */             User.this.register_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1377 */     });
/* 1378 */     this.register_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInvitee_confirm_total_present_rebate_bind_yuanbao(long _v_)
/*      */   {
/* 1385 */     _xdb_verify_unsafe_();
/* 1386 */     Logs.logIf(new LogKey(this, "invitee_confirm_total_present_rebate_bind_yuanbao")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1390 */         new LogLong(this, User.this.invitee_confirm_total_present_rebate_bind_yuanbao)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1394 */             User.this.invitee_confirm_total_present_rebate_bind_yuanbao = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1398 */     });
/* 1399 */     this.invitee_confirm_total_present_rebate_bind_yuanbao = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInvitee_done_shimen_total_days(int _v_)
/*      */   {
/* 1406 */     _xdb_verify_unsafe_();
/* 1407 */     Logs.logIf(new LogKey(this, "invitee_done_shimen_total_days")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1411 */         new LogInt(this, User.this.invitee_done_shimen_total_days)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1415 */             User.this.invitee_done_shimen_total_days = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1419 */     });
/* 1420 */     this.invitee_done_shimen_total_days = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInvitee_done_shimen_timestamp(long _v_)
/*      */   {
/* 1427 */     _xdb_verify_unsafe_();
/* 1428 */     Logs.logIf(new LogKey(this, "invitee_done_shimen_timestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1432 */         new LogLong(this, User.this.invitee_done_shimen_timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1436 */             User.this.invitee_done_shimen_timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1440 */     });
/* 1441 */     this.invitee_done_shimen_timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFigure_url(String _v_)
/*      */   {
/* 1448 */     _xdb_verify_unsafe_();
/* 1449 */     if (null == _v_)
/* 1450 */       throw new NullPointerException();
/* 1451 */     Logs.logIf(new LogKey(this, "figure_url")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1455 */         new LogString(this, User.this.figure_url)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1459 */             User.this.figure_url = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1463 */     });
/* 1464 */     this.figure_url = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFigure_urlOctets(Octets _v_)
/*      */   {
/* 1471 */     _xdb_verify_unsafe_();
/* 1472 */     setFigure_url(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNick_name(String _v_)
/*      */   {
/* 1479 */     _xdb_verify_unsafe_();
/* 1480 */     if (null == _v_)
/* 1481 */       throw new NullPointerException();
/* 1482 */     Logs.logIf(new LogKey(this, "nick_name")
/*      */     {
/*      */       protected Log create()
/*      */       {
/* 1486 */         new LogString(this, User.this.nick_name)
/*      */         {
/*      */           public void rollback()
/*      */           {
/* 1490 */             User.this.nick_name = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/* 1494 */     });
/* 1495 */     this.nick_name = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNick_nameOctets(Octets _v_)
/*      */   {
/* 1502 */     _xdb_verify_unsafe_();
/* 1503 */     setNick_name(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/* 1509 */     _xdb_verify_unsafe_();
/* 1510 */     User _o_ = null;
/* 1511 */     if ((_o1_ instanceof User)) { _o_ = (User)_o1_;
/* 1512 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 1513 */       return false;
/* 1514 */     if (!this.roleids.equals(_o_.roleids)) return false;
/* 1515 */     if (this.activated != _o_.activated) return false;
/* 1516 */     if (this.lastlogintime != _o_.lastlogintime) return false;
/* 1517 */     if (this.last_login_roleid != _o_.last_login_roleid) return false;
/* 1518 */     if (this.max_fighting_capacity != _o_.max_fighting_capacity) return false;
/* 1519 */     if (this.max_fighting_capacity_roleid != _o_.max_fighting_capacity_roleid) return false;
/* 1520 */     if (this.grc_friends_count != _o_.grc_friends_count) return false;
/* 1521 */     if (this.grc_friends_count_award_serial_no != _o_.grc_friends_count_award_serial_no) return false;
/* 1522 */     if (this.sn != _o_.sn) return false;
/* 1523 */     if (!this.final_success_order_id.equals(_o_.final_success_order_id)) return false;
/* 1524 */     if (this.final_transfer_success_time != _o_.final_transfer_success_time) return false;
/* 1525 */     if (!this.compensates.equals(_o_.compensates)) return false;
/* 1526 */     if (!this.privilege_award_infos.equals(_o_.privilege_award_infos)) return false;
/* 1527 */     if (this.invitee_status != _o_.invitee_status) return false;
/* 1528 */     if (!this.invitee_code.equals(_o_.invitee_code)) return false;
/* 1529 */     if (this.invitee_total_present_rebate_bind_yuanbao != _o_.invitee_total_present_rebate_bind_yuanbao) return false;
/* 1530 */     if (!this.inviter_code.equals(_o_.inviter_code)) return false;
/* 1531 */     if (this.inviter_total_rebate_bind_yuanbao != _o_.inviter_total_rebate_bind_yuanbao) return false;
/* 1532 */     if (this.inviter_total_gift_times != _o_.inviter_total_gift_times) return false;
/* 1533 */     if (this.invitee_save_amt != _o_.invitee_save_amt) return false;
/* 1534 */     if (this.register_time != _o_.register_time) return false;
/* 1535 */     if (this.invitee_confirm_total_present_rebate_bind_yuanbao != _o_.invitee_confirm_total_present_rebate_bind_yuanbao) return false;
/* 1536 */     if (this.invitee_done_shimen_total_days != _o_.invitee_done_shimen_total_days) return false;
/* 1537 */     if (this.invitee_done_shimen_timestamp != _o_.invitee_done_shimen_timestamp) return false;
/* 1538 */     if (!this.recall_friend_back_game.equals(_o_.recall_friend_back_game)) return false;
/* 1539 */     if (!this.figure_url.equals(_o_.figure_url)) return false;
/* 1540 */     if (!this.nick_name.equals(_o_.nick_name)) return false;
/* 1541 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/* 1547 */     _xdb_verify_unsafe_();
/* 1548 */     int _h_ = 0;
/* 1549 */     _h_ += this.roleids.hashCode();
/* 1550 */     _h_ += (this.activated ? 1231 : 1237);
/* 1551 */     _h_ = (int)(_h_ + this.lastlogintime);
/* 1552 */     _h_ = (int)(_h_ + this.last_login_roleid);
/* 1553 */     _h_ = (int)(_h_ + this.max_fighting_capacity);
/* 1554 */     _h_ = (int)(_h_ + this.max_fighting_capacity_roleid);
/* 1555 */     _h_ += this.grc_friends_count;
/* 1556 */     _h_ += this.grc_friends_count_award_serial_no;
/* 1557 */     _h_ += this.sn;
/* 1558 */     _h_ += this.final_success_order_id.hashCode();
/* 1559 */     _h_ = (int)(_h_ + this.final_transfer_success_time);
/* 1560 */     _h_ += this.compensates.hashCode();
/* 1561 */     _h_ += this.privilege_award_infos.hashCode();
/* 1562 */     _h_ += this.invitee_status;
/* 1563 */     _h_ += this.invitee_code.hashCode();
/* 1564 */     _h_ = (int)(_h_ + this.invitee_total_present_rebate_bind_yuanbao);
/* 1565 */     _h_ += this.inviter_code.hashCode();
/* 1566 */     _h_ = (int)(_h_ + this.inviter_total_rebate_bind_yuanbao);
/* 1567 */     _h_ = (int)(_h_ + this.inviter_total_gift_times);
/* 1568 */     _h_ = (int)(_h_ + this.invitee_save_amt);
/* 1569 */     _h_ = (int)(_h_ + this.register_time);
/* 1570 */     _h_ = (int)(_h_ + this.invitee_confirm_total_present_rebate_bind_yuanbao);
/* 1571 */     _h_ += this.invitee_done_shimen_total_days;
/* 1572 */     _h_ = (int)(_h_ + this.invitee_done_shimen_timestamp);
/* 1573 */     _h_ += this.recall_friend_back_game.hashCode();
/* 1574 */     _h_ += this.figure_url.hashCode();
/* 1575 */     _h_ += this.nick_name.hashCode();
/* 1576 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/* 1582 */     _xdb_verify_unsafe_();
/* 1583 */     StringBuilder _sb_ = new StringBuilder();
/* 1584 */     _sb_.append("(");
/* 1585 */     _sb_.append(this.roleids);
/* 1586 */     _sb_.append(",");
/* 1587 */     _sb_.append(this.activated);
/* 1588 */     _sb_.append(",");
/* 1589 */     _sb_.append(this.lastlogintime);
/* 1590 */     _sb_.append(",");
/* 1591 */     _sb_.append(this.last_login_roleid);
/* 1592 */     _sb_.append(",");
/* 1593 */     _sb_.append(this.max_fighting_capacity);
/* 1594 */     _sb_.append(",");
/* 1595 */     _sb_.append(this.max_fighting_capacity_roleid);
/* 1596 */     _sb_.append(",");
/* 1597 */     _sb_.append(this.grc_friends_count);
/* 1598 */     _sb_.append(",");
/* 1599 */     _sb_.append(this.grc_friends_count_award_serial_no);
/* 1600 */     _sb_.append(",");
/* 1601 */     _sb_.append(this.sn);
/* 1602 */     _sb_.append(",");
/* 1603 */     _sb_.append("'").append(this.final_success_order_id).append("'");
/* 1604 */     _sb_.append(",");
/* 1605 */     _sb_.append(this.final_transfer_success_time);
/* 1606 */     _sb_.append(",");
/* 1607 */     _sb_.append(this.compensates);
/* 1608 */     _sb_.append(",");
/* 1609 */     _sb_.append(this.privilege_award_infos);
/* 1610 */     _sb_.append(",");
/* 1611 */     _sb_.append(this.invitee_status);
/* 1612 */     _sb_.append(",");
/* 1613 */     _sb_.append("'").append(this.invitee_code).append("'");
/* 1614 */     _sb_.append(",");
/* 1615 */     _sb_.append(this.invitee_total_present_rebate_bind_yuanbao);
/* 1616 */     _sb_.append(",");
/* 1617 */     _sb_.append("'").append(this.inviter_code).append("'");
/* 1618 */     _sb_.append(",");
/* 1619 */     _sb_.append(this.inviter_total_rebate_bind_yuanbao);
/* 1620 */     _sb_.append(",");
/* 1621 */     _sb_.append(this.inviter_total_gift_times);
/* 1622 */     _sb_.append(",");
/* 1623 */     _sb_.append(this.invitee_save_amt);
/* 1624 */     _sb_.append(",");
/* 1625 */     _sb_.append(this.register_time);
/* 1626 */     _sb_.append(",");
/* 1627 */     _sb_.append(this.invitee_confirm_total_present_rebate_bind_yuanbao);
/* 1628 */     _sb_.append(",");
/* 1629 */     _sb_.append(this.invitee_done_shimen_total_days);
/* 1630 */     _sb_.append(",");
/* 1631 */     _sb_.append(this.invitee_done_shimen_timestamp);
/* 1632 */     _sb_.append(",");
/* 1633 */     _sb_.append(this.recall_friend_back_game);
/* 1634 */     _sb_.append(",");
/* 1635 */     _sb_.append("'").append(this.figure_url).append("'");
/* 1636 */     _sb_.append(",");
/* 1637 */     _sb_.append("'").append(this.nick_name).append("'");
/* 1638 */     _sb_.append(")");
/* 1639 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/* 1645 */     ListenableBean lb = new ListenableBean();
/* 1646 */     lb.add(new ListenableChanged().setVarName("roleids"));
/* 1647 */     lb.add(new ListenableChanged().setVarName("activated"));
/* 1648 */     lb.add(new ListenableChanged().setVarName("lastlogintime"));
/* 1649 */     lb.add(new ListenableChanged().setVarName("last_login_roleid"));
/* 1650 */     lb.add(new ListenableChanged().setVarName("max_fighting_capacity"));
/* 1651 */     lb.add(new ListenableChanged().setVarName("max_fighting_capacity_roleid"));
/* 1652 */     lb.add(new ListenableChanged().setVarName("grc_friends_count"));
/* 1653 */     lb.add(new ListenableChanged().setVarName("grc_friends_count_award_serial_no"));
/* 1654 */     lb.add(new ListenableChanged().setVarName("sn"));
/* 1655 */     lb.add(new ListenableChanged().setVarName("final_success_order_id"));
/* 1656 */     lb.add(new ListenableChanged().setVarName("final_transfer_success_time"));
/* 1657 */     lb.add(new ListenableSet().setVarName("compensates"));
/* 1658 */     lb.add(new ListenableMap().setVarName("privilege_award_infos"));
/* 1659 */     lb.add(new ListenableChanged().setVarName("invitee_status"));
/* 1660 */     lb.add(new ListenableChanged().setVarName("invitee_code"));
/* 1661 */     lb.add(new ListenableChanged().setVarName("invitee_total_present_rebate_bind_yuanbao"));
/* 1662 */     lb.add(new ListenableChanged().setVarName("inviter_code"));
/* 1663 */     lb.add(new ListenableChanged().setVarName("inviter_total_rebate_bind_yuanbao"));
/* 1664 */     lb.add(new ListenableChanged().setVarName("inviter_total_gift_times"));
/* 1665 */     lb.add(new ListenableChanged().setVarName("invitee_save_amt"));
/* 1666 */     lb.add(new ListenableChanged().setVarName("register_time"));
/* 1667 */     lb.add(new ListenableChanged().setVarName("invitee_confirm_total_present_rebate_bind_yuanbao"));
/* 1668 */     lb.add(new ListenableChanged().setVarName("invitee_done_shimen_total_days"));
/* 1669 */     lb.add(new ListenableChanged().setVarName("invitee_done_shimen_timestamp"));
/* 1670 */     lb.add(new ListenableChanged().setVarName("recall_friend_back_game"));
/* 1671 */     lb.add(new ListenableChanged().setVarName("figure_url"));
/* 1672 */     lb.add(new ListenableChanged().setVarName("nick_name"));
/* 1673 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.User {
/*      */     private Const() {}
/*      */     
/*      */     User nThis() {
/* 1680 */       return User.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1686 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.User copy()
/*      */     {
/* 1692 */       return User.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.User toData()
/*      */     {
/* 1698 */       return User.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.User toBean()
/*      */     {
/* 1703 */       return User.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.User toDataIf()
/*      */     {
/* 1709 */       return User.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.User toBeanIf()
/*      */     {
/* 1714 */       return User.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRoleids()
/*      */     {
/* 1721 */       User.this._xdb_verify_unsafe_();
/* 1722 */       return Consts.constList(User.this.roleids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getRoleidsAsData()
/*      */     {
/* 1728 */       User.this._xdb_verify_unsafe_();
/*      */       
/* 1730 */       User _o_ = User.this;
/* 1731 */       List<Long> roleids = new LinkedList();
/* 1732 */       roleids.addAll(_o_.roleids);
/* 1733 */       return roleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getActivated()
/*      */     {
/* 1740 */       User.this._xdb_verify_unsafe_();
/* 1741 */       return User.this.activated;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastlogintime()
/*      */     {
/* 1748 */       User.this._xdb_verify_unsafe_();
/* 1749 */       return User.this.lastlogintime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_login_roleid()
/*      */     {
/* 1756 */       User.this._xdb_verify_unsafe_();
/* 1757 */       return User.this.last_login_roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMax_fighting_capacity()
/*      */     {
/* 1764 */       User.this._xdb_verify_unsafe_();
/* 1765 */       return User.this.max_fighting_capacity;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMax_fighting_capacity_roleid()
/*      */     {
/* 1772 */       User.this._xdb_verify_unsafe_();
/* 1773 */       return User.this.max_fighting_capacity_roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGrc_friends_count()
/*      */     {
/* 1780 */       User.this._xdb_verify_unsafe_();
/* 1781 */       return User.this.grc_friends_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGrc_friends_count_award_serial_no()
/*      */     {
/* 1788 */       User.this._xdb_verify_unsafe_();
/* 1789 */       return User.this.grc_friends_count_award_serial_no;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSn()
/*      */     {
/* 1796 */       User.this._xdb_verify_unsafe_();
/* 1797 */       return User.this.sn;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getFinal_success_order_id()
/*      */     {
/* 1804 */       User.this._xdb_verify_unsafe_();
/* 1805 */       return User.this.final_success_order_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getFinal_success_order_idOctets()
/*      */     {
/* 1812 */       User.this._xdb_verify_unsafe_();
/* 1813 */       return User.this.getFinal_success_order_idOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFinal_transfer_success_time()
/*      */     {
/* 1820 */       User.this._xdb_verify_unsafe_();
/* 1821 */       return User.this.final_transfer_success_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCompensates()
/*      */     {
/* 1828 */       User.this._xdb_verify_unsafe_();
/* 1829 */       return Consts.constSet(User.this.compensates);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getCompensatesAsData()
/*      */     {
/* 1835 */       User.this._xdb_verify_unsafe_();
/*      */       
/* 1837 */       User _o_ = User.this;
/* 1838 */       Set<Long> compensates = new SetX();
/* 1839 */       compensates.addAll(_o_.compensates);
/* 1840 */       return compensates;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.PrivilegeAwardInfo> getPrivilege_award_infos()
/*      */     {
/* 1847 */       User.this._xdb_verify_unsafe_();
/* 1848 */       return Consts.constMap(User.this.privilege_award_infos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.PrivilegeAwardInfo> getPrivilege_award_infosAsData()
/*      */     {
/* 1855 */       User.this._xdb_verify_unsafe_();
/*      */       
/* 1857 */       User _o_ = User.this;
/* 1858 */       Map<Integer, xbean.PrivilegeAwardInfo> privilege_award_infos = new HashMap();
/* 1859 */       for (Map.Entry<Integer, xbean.PrivilegeAwardInfo> _e_ : _o_.privilege_award_infos.entrySet())
/* 1860 */         privilege_award_infos.put(_e_.getKey(), new PrivilegeAwardInfo.Data((xbean.PrivilegeAwardInfo)_e_.getValue()));
/* 1861 */       return privilege_award_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getInvitee_status()
/*      */     {
/* 1868 */       User.this._xdb_verify_unsafe_();
/* 1869 */       return User.this.invitee_status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getInvitee_code()
/*      */     {
/* 1876 */       User.this._xdb_verify_unsafe_();
/* 1877 */       return User.this.invitee_code;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getInvitee_codeOctets()
/*      */     {
/* 1884 */       User.this._xdb_verify_unsafe_();
/* 1885 */       return User.this.getInvitee_codeOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInvitee_total_present_rebate_bind_yuanbao()
/*      */     {
/* 1892 */       User.this._xdb_verify_unsafe_();
/* 1893 */       return User.this.invitee_total_present_rebate_bind_yuanbao;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getInviter_code()
/*      */     {
/* 1900 */       User.this._xdb_verify_unsafe_();
/* 1901 */       return User.this.inviter_code;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getInviter_codeOctets()
/*      */     {
/* 1908 */       User.this._xdb_verify_unsafe_();
/* 1909 */       return User.this.getInviter_codeOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInviter_total_rebate_bind_yuanbao()
/*      */     {
/* 1916 */       User.this._xdb_verify_unsafe_();
/* 1917 */       return User.this.inviter_total_rebate_bind_yuanbao;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInviter_total_gift_times()
/*      */     {
/* 1924 */       User.this._xdb_verify_unsafe_();
/* 1925 */       return User.this.inviter_total_gift_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInvitee_save_amt()
/*      */     {
/* 1932 */       User.this._xdb_verify_unsafe_();
/* 1933 */       return User.this.invitee_save_amt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRegister_time()
/*      */     {
/* 1940 */       User.this._xdb_verify_unsafe_();
/* 1941 */       return User.this.register_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInvitee_confirm_total_present_rebate_bind_yuanbao()
/*      */     {
/* 1948 */       User.this._xdb_verify_unsafe_();
/* 1949 */       return User.this.invitee_confirm_total_present_rebate_bind_yuanbao;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getInvitee_done_shimen_total_days()
/*      */     {
/* 1956 */       User.this._xdb_verify_unsafe_();
/* 1957 */       return User.this.invitee_done_shimen_total_days;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInvitee_done_shimen_timestamp()
/*      */     {
/* 1964 */       User.this._xdb_verify_unsafe_();
/* 1965 */       return User.this.invitee_done_shimen_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.RecallFriendBackGame getRecall_friend_back_game()
/*      */     {
/* 1972 */       User.this._xdb_verify_unsafe_();
/* 1973 */       return (xbean.RecallFriendBackGame)Consts.toConst(User.this.recall_friend_back_game);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getFigure_url()
/*      */     {
/* 1980 */       User.this._xdb_verify_unsafe_();
/* 1981 */       return User.this.figure_url;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getFigure_urlOctets()
/*      */     {
/* 1988 */       User.this._xdb_verify_unsafe_();
/* 1989 */       return User.this.getFigure_urlOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getNick_name()
/*      */     {
/* 1996 */       User.this._xdb_verify_unsafe_();
/* 1997 */       return User.this.nick_name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNick_nameOctets()
/*      */     {
/* 2004 */       User.this._xdb_verify_unsafe_();
/* 2005 */       return User.this.getNick_nameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivated(boolean _v_)
/*      */     {
/* 2012 */       User.this._xdb_verify_unsafe_();
/* 2013 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastlogintime(long _v_)
/*      */     {
/* 2020 */       User.this._xdb_verify_unsafe_();
/* 2021 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_login_roleid(long _v_)
/*      */     {
/* 2028 */       User.this._xdb_verify_unsafe_();
/* 2029 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMax_fighting_capacity(long _v_)
/*      */     {
/* 2036 */       User.this._xdb_verify_unsafe_();
/* 2037 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMax_fighting_capacity_roleid(long _v_)
/*      */     {
/* 2044 */       User.this._xdb_verify_unsafe_();
/* 2045 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrc_friends_count(int _v_)
/*      */     {
/* 2052 */       User.this._xdb_verify_unsafe_();
/* 2053 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrc_friends_count_award_serial_no(int _v_)
/*      */     {
/* 2060 */       User.this._xdb_verify_unsafe_();
/* 2061 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSn(int _v_)
/*      */     {
/* 2068 */       User.this._xdb_verify_unsafe_();
/* 2069 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFinal_success_order_id(String _v_)
/*      */     {
/* 2076 */       User.this._xdb_verify_unsafe_();
/* 2077 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFinal_success_order_idOctets(Octets _v_)
/*      */     {
/* 2084 */       User.this._xdb_verify_unsafe_();
/* 2085 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFinal_transfer_success_time(long _v_)
/*      */     {
/* 2092 */       User.this._xdb_verify_unsafe_();
/* 2093 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitee_status(int _v_)
/*      */     {
/* 2100 */       User.this._xdb_verify_unsafe_();
/* 2101 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitee_code(String _v_)
/*      */     {
/* 2108 */       User.this._xdb_verify_unsafe_();
/* 2109 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitee_codeOctets(Octets _v_)
/*      */     {
/* 2116 */       User.this._xdb_verify_unsafe_();
/* 2117 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitee_total_present_rebate_bind_yuanbao(long _v_)
/*      */     {
/* 2124 */       User.this._xdb_verify_unsafe_();
/* 2125 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInviter_code(String _v_)
/*      */     {
/* 2132 */       User.this._xdb_verify_unsafe_();
/* 2133 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInviter_codeOctets(Octets _v_)
/*      */     {
/* 2140 */       User.this._xdb_verify_unsafe_();
/* 2141 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInviter_total_rebate_bind_yuanbao(long _v_)
/*      */     {
/* 2148 */       User.this._xdb_verify_unsafe_();
/* 2149 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInviter_total_gift_times(long _v_)
/*      */     {
/* 2156 */       User.this._xdb_verify_unsafe_();
/* 2157 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitee_save_amt(long _v_)
/*      */     {
/* 2164 */       User.this._xdb_verify_unsafe_();
/* 2165 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRegister_time(long _v_)
/*      */     {
/* 2172 */       User.this._xdb_verify_unsafe_();
/* 2173 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitee_confirm_total_present_rebate_bind_yuanbao(long _v_)
/*      */     {
/* 2180 */       User.this._xdb_verify_unsafe_();
/* 2181 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitee_done_shimen_total_days(int _v_)
/*      */     {
/* 2188 */       User.this._xdb_verify_unsafe_();
/* 2189 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitee_done_shimen_timestamp(long _v_)
/*      */     {
/* 2196 */       User.this._xdb_verify_unsafe_();
/* 2197 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFigure_url(String _v_)
/*      */     {
/* 2204 */       User.this._xdb_verify_unsafe_();
/* 2205 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFigure_urlOctets(Octets _v_)
/*      */     {
/* 2212 */       User.this._xdb_verify_unsafe_();
/* 2213 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNick_name(String _v_)
/*      */     {
/* 2220 */       User.this._xdb_verify_unsafe_();
/* 2221 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNick_nameOctets(Octets _v_)
/*      */     {
/* 2228 */       User.this._xdb_verify_unsafe_();
/* 2229 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 2235 */       User.this._xdb_verify_unsafe_();
/* 2236 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 2242 */       User.this._xdb_verify_unsafe_();
/* 2243 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 2249 */       return User.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2255 */       return User.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2261 */       User.this._xdb_verify_unsafe_();
/* 2262 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 2268 */       return User.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2274 */       return User.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 2280 */       User.this._xdb_verify_unsafe_();
/* 2281 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 2287 */       return User.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2293 */       return User.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 2299 */       return User.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 2305 */       return User.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 2311 */       return User.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 2317 */       return User.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 2323 */       return User.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.User
/*      */   {
/*      */     private LinkedList<Long> roleids;
/*      */     
/*      */     private boolean activated;
/*      */     
/*      */     private long lastlogintime;
/*      */     
/*      */     private long last_login_roleid;
/*      */     
/*      */     private long max_fighting_capacity;
/*      */     
/*      */     private long max_fighting_capacity_roleid;
/*      */     
/*      */     private int grc_friends_count;
/*      */     
/*      */     private int grc_friends_count_award_serial_no;
/*      */     
/*      */     private int sn;
/*      */     
/*      */     private String final_success_order_id;
/*      */     
/*      */     private long final_transfer_success_time;
/*      */     
/*      */     private HashSet<Long> compensates;
/*      */     
/*      */     private HashMap<Integer, xbean.PrivilegeAwardInfo> privilege_award_infos;
/*      */     
/*      */     private int invitee_status;
/*      */     
/*      */     private String invitee_code;
/*      */     
/*      */     private long invitee_total_present_rebate_bind_yuanbao;
/*      */     
/*      */     private String inviter_code;
/*      */     
/*      */     private long inviter_total_rebate_bind_yuanbao;
/*      */     
/*      */     private long inviter_total_gift_times;
/*      */     
/*      */     private long invitee_save_amt;
/*      */     
/*      */     private long register_time;
/*      */     
/*      */     private long invitee_confirm_total_present_rebate_bind_yuanbao;
/*      */     
/*      */     private int invitee_done_shimen_total_days;
/*      */     
/*      */     private long invitee_done_shimen_timestamp;
/*      */     
/*      */     private xbean.RecallFriendBackGame recall_friend_back_game;
/*      */     
/*      */     private String figure_url;
/*      */     
/*      */     private String nick_name;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 2387 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 2392 */       this.roleids = new LinkedList();
/* 2393 */       this.lastlogintime = 0L;
/* 2394 */       this.last_login_roleid = 0L;
/* 2395 */       this.max_fighting_capacity = 0L;
/* 2396 */       this.max_fighting_capacity_roleid = 0L;
/* 2397 */       this.grc_friends_count = 0;
/* 2398 */       this.grc_friends_count_award_serial_no = 0;
/* 2399 */       this.sn = 0;
/* 2400 */       this.final_success_order_id = "";
/* 2401 */       this.compensates = new HashSet();
/* 2402 */       this.privilege_award_infos = new HashMap();
/* 2403 */       this.invitee_status = 0;
/* 2404 */       this.invitee_code = "";
/* 2405 */       this.invitee_total_present_rebate_bind_yuanbao = 0L;
/* 2406 */       this.inviter_code = "";
/* 2407 */       this.inviter_total_rebate_bind_yuanbao = 0L;
/* 2408 */       this.inviter_total_gift_times = 0L;
/* 2409 */       this.invitee_save_amt = 0L;
/* 2410 */       this.register_time = 0L;
/* 2411 */       this.invitee_confirm_total_present_rebate_bind_yuanbao = 0L;
/* 2412 */       this.invitee_done_shimen_total_days = 0;
/* 2413 */       this.invitee_done_shimen_timestamp = 0L;
/* 2414 */       this.recall_friend_back_game = new RecallFriendBackGame.Data();
/* 2415 */       this.figure_url = "";
/* 2416 */       this.nick_name = "";
/*      */     }
/*      */     
/*      */     Data(xbean.User _o1_)
/*      */     {
/* 2421 */       if ((_o1_ instanceof User)) { assign((User)_o1_);
/* 2422 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 2423 */       } else if ((_o1_ instanceof User.Const)) assign(((User.Const)_o1_).nThis()); else {
/* 2424 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(User _o_) {
/* 2429 */       this.roleids = new LinkedList();
/* 2430 */       this.roleids.addAll(_o_.roleids);
/* 2431 */       this.activated = _o_.activated;
/* 2432 */       this.lastlogintime = _o_.lastlogintime;
/* 2433 */       this.last_login_roleid = _o_.last_login_roleid;
/* 2434 */       this.max_fighting_capacity = _o_.max_fighting_capacity;
/* 2435 */       this.max_fighting_capacity_roleid = _o_.max_fighting_capacity_roleid;
/* 2436 */       this.grc_friends_count = _o_.grc_friends_count;
/* 2437 */       this.grc_friends_count_award_serial_no = _o_.grc_friends_count_award_serial_no;
/* 2438 */       this.sn = _o_.sn;
/* 2439 */       this.final_success_order_id = _o_.final_success_order_id;
/* 2440 */       this.final_transfer_success_time = _o_.final_transfer_success_time;
/* 2441 */       this.compensates = new HashSet();
/* 2442 */       this.compensates.addAll(_o_.compensates);
/* 2443 */       this.privilege_award_infos = new HashMap();
/* 2444 */       for (Map.Entry<Integer, xbean.PrivilegeAwardInfo> _e_ : _o_.privilege_award_infos.entrySet())
/* 2445 */         this.privilege_award_infos.put(_e_.getKey(), new PrivilegeAwardInfo.Data((xbean.PrivilegeAwardInfo)_e_.getValue()));
/* 2446 */       this.invitee_status = _o_.invitee_status;
/* 2447 */       this.invitee_code = _o_.invitee_code;
/* 2448 */       this.invitee_total_present_rebate_bind_yuanbao = _o_.invitee_total_present_rebate_bind_yuanbao;
/* 2449 */       this.inviter_code = _o_.inviter_code;
/* 2450 */       this.inviter_total_rebate_bind_yuanbao = _o_.inviter_total_rebate_bind_yuanbao;
/* 2451 */       this.inviter_total_gift_times = _o_.inviter_total_gift_times;
/* 2452 */       this.invitee_save_amt = _o_.invitee_save_amt;
/* 2453 */       this.register_time = _o_.register_time;
/* 2454 */       this.invitee_confirm_total_present_rebate_bind_yuanbao = _o_.invitee_confirm_total_present_rebate_bind_yuanbao;
/* 2455 */       this.invitee_done_shimen_total_days = _o_.invitee_done_shimen_total_days;
/* 2456 */       this.invitee_done_shimen_timestamp = _o_.invitee_done_shimen_timestamp;
/* 2457 */       this.recall_friend_back_game = new RecallFriendBackGame.Data(_o_.recall_friend_back_game);
/* 2458 */       this.figure_url = _o_.figure_url;
/* 2459 */       this.nick_name = _o_.nick_name;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 2464 */       this.roleids = new LinkedList();
/* 2465 */       this.roleids.addAll(_o_.roleids);
/* 2466 */       this.activated = _o_.activated;
/* 2467 */       this.lastlogintime = _o_.lastlogintime;
/* 2468 */       this.last_login_roleid = _o_.last_login_roleid;
/* 2469 */       this.max_fighting_capacity = _o_.max_fighting_capacity;
/* 2470 */       this.max_fighting_capacity_roleid = _o_.max_fighting_capacity_roleid;
/* 2471 */       this.grc_friends_count = _o_.grc_friends_count;
/* 2472 */       this.grc_friends_count_award_serial_no = _o_.grc_friends_count_award_serial_no;
/* 2473 */       this.sn = _o_.sn;
/* 2474 */       this.final_success_order_id = _o_.final_success_order_id;
/* 2475 */       this.final_transfer_success_time = _o_.final_transfer_success_time;
/* 2476 */       this.compensates = new HashSet();
/* 2477 */       this.compensates.addAll(_o_.compensates);
/* 2478 */       this.privilege_award_infos = new HashMap();
/* 2479 */       for (Map.Entry<Integer, xbean.PrivilegeAwardInfo> _e_ : _o_.privilege_award_infos.entrySet())
/* 2480 */         this.privilege_award_infos.put(_e_.getKey(), new PrivilegeAwardInfo.Data((xbean.PrivilegeAwardInfo)_e_.getValue()));
/* 2481 */       this.invitee_status = _o_.invitee_status;
/* 2482 */       this.invitee_code = _o_.invitee_code;
/* 2483 */       this.invitee_total_present_rebate_bind_yuanbao = _o_.invitee_total_present_rebate_bind_yuanbao;
/* 2484 */       this.inviter_code = _o_.inviter_code;
/* 2485 */       this.inviter_total_rebate_bind_yuanbao = _o_.inviter_total_rebate_bind_yuanbao;
/* 2486 */       this.inviter_total_gift_times = _o_.inviter_total_gift_times;
/* 2487 */       this.invitee_save_amt = _o_.invitee_save_amt;
/* 2488 */       this.register_time = _o_.register_time;
/* 2489 */       this.invitee_confirm_total_present_rebate_bind_yuanbao = _o_.invitee_confirm_total_present_rebate_bind_yuanbao;
/* 2490 */       this.invitee_done_shimen_total_days = _o_.invitee_done_shimen_total_days;
/* 2491 */       this.invitee_done_shimen_timestamp = _o_.invitee_done_shimen_timestamp;
/* 2492 */       this.recall_friend_back_game = new RecallFriendBackGame.Data(_o_.recall_friend_back_game);
/* 2493 */       this.figure_url = _o_.figure_url;
/* 2494 */       this.nick_name = _o_.nick_name;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 2500 */       _os_.compact_uint32(this.roleids.size());
/* 2501 */       for (Long _v_ : this.roleids)
/*      */       {
/* 2503 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 2505 */       _os_.marshal(this.activated);
/* 2506 */       _os_.marshal(this.lastlogintime);
/* 2507 */       _os_.marshal(this.last_login_roleid);
/* 2508 */       _os_.marshal(this.max_fighting_capacity);
/* 2509 */       _os_.marshal(this.max_fighting_capacity_roleid);
/* 2510 */       _os_.marshal(this.grc_friends_count);
/* 2511 */       _os_.marshal(this.grc_friends_count_award_serial_no);
/* 2512 */       _os_.marshal(this.sn);
/* 2513 */       _os_.marshal(this.final_success_order_id, "UTF-16LE");
/* 2514 */       _os_.marshal(this.final_transfer_success_time);
/* 2515 */       _os_.compact_uint32(this.compensates.size());
/* 2516 */       for (Long _v_ : this.compensates)
/*      */       {
/* 2518 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 2520 */       _os_.compact_uint32(this.privilege_award_infos.size());
/* 2521 */       for (Map.Entry<Integer, xbean.PrivilegeAwardInfo> _e_ : this.privilege_award_infos.entrySet())
/*      */       {
/* 2523 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 2524 */         ((xbean.PrivilegeAwardInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/* 2526 */       _os_.marshal(this.invitee_status);
/* 2527 */       _os_.marshal(this.invitee_code, "UTF-16LE");
/* 2528 */       _os_.marshal(this.invitee_total_present_rebate_bind_yuanbao);
/* 2529 */       _os_.marshal(this.inviter_code, "UTF-16LE");
/* 2530 */       _os_.marshal(this.inviter_total_rebate_bind_yuanbao);
/* 2531 */       _os_.marshal(this.inviter_total_gift_times);
/* 2532 */       _os_.marshal(this.invitee_save_amt);
/* 2533 */       _os_.marshal(this.register_time);
/* 2534 */       _os_.marshal(this.invitee_confirm_total_present_rebate_bind_yuanbao);
/* 2535 */       _os_.marshal(this.invitee_done_shimen_total_days);
/* 2536 */       _os_.marshal(this.invitee_done_shimen_timestamp);
/* 2537 */       this.recall_friend_back_game.marshal(_os_);
/* 2538 */       _os_.marshal(this.figure_url, "UTF-16LE");
/* 2539 */       _os_.marshal(this.nick_name, "UTF-16LE");
/* 2540 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 2546 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 2548 */         long _v_ = 0L;
/* 2549 */         _v_ = _os_.unmarshal_long();
/* 2550 */         this.roleids.add(Long.valueOf(_v_));
/*      */       }
/* 2552 */       this.activated = _os_.unmarshal_boolean();
/* 2553 */       this.lastlogintime = _os_.unmarshal_long();
/* 2554 */       this.last_login_roleid = _os_.unmarshal_long();
/* 2555 */       this.max_fighting_capacity = _os_.unmarshal_long();
/* 2556 */       this.max_fighting_capacity_roleid = _os_.unmarshal_long();
/* 2557 */       this.grc_friends_count = _os_.unmarshal_int();
/* 2558 */       this.grc_friends_count_award_serial_no = _os_.unmarshal_int();
/* 2559 */       this.sn = _os_.unmarshal_int();
/* 2560 */       this.final_success_order_id = _os_.unmarshal_String("UTF-16LE");
/* 2561 */       this.final_transfer_success_time = _os_.unmarshal_long();
/* 2562 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 2564 */         long _v_ = 0L;
/* 2565 */         _v_ = _os_.unmarshal_long();
/* 2566 */         this.compensates.add(Long.valueOf(_v_));
/*      */       }
/*      */       
/* 2569 */       int size = _os_.uncompact_uint32();
/* 2570 */       if (size >= 12)
/*      */       {
/* 2572 */         this.privilege_award_infos = new HashMap(size * 2);
/*      */       }
/* 2574 */       for (; size > 0; size--)
/*      */       {
/* 2576 */         int _k_ = 0;
/* 2577 */         _k_ = _os_.unmarshal_int();
/* 2578 */         xbean.PrivilegeAwardInfo _v_ = Pod.newPrivilegeAwardInfoData();
/* 2579 */         _v_.unmarshal(_os_);
/* 2580 */         this.privilege_award_infos.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 2583 */       this.invitee_status = _os_.unmarshal_int();
/* 2584 */       this.invitee_code = _os_.unmarshal_String("UTF-16LE");
/* 2585 */       this.invitee_total_present_rebate_bind_yuanbao = _os_.unmarshal_long();
/* 2586 */       this.inviter_code = _os_.unmarshal_String("UTF-16LE");
/* 2587 */       this.inviter_total_rebate_bind_yuanbao = _os_.unmarshal_long();
/* 2588 */       this.inviter_total_gift_times = _os_.unmarshal_long();
/* 2589 */       this.invitee_save_amt = _os_.unmarshal_long();
/* 2590 */       this.register_time = _os_.unmarshal_long();
/* 2591 */       this.invitee_confirm_total_present_rebate_bind_yuanbao = _os_.unmarshal_long();
/* 2592 */       this.invitee_done_shimen_total_days = _os_.unmarshal_int();
/* 2593 */       this.invitee_done_shimen_timestamp = _os_.unmarshal_long();
/* 2594 */       this.recall_friend_back_game.unmarshal(_os_);
/* 2595 */       this.figure_url = _os_.unmarshal_String("UTF-16LE");
/* 2596 */       this.nick_name = _os_.unmarshal_String("UTF-16LE");
/* 2597 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 2603 */       int _size_ = 0;
/* 2604 */       for (Long _v_ : this.roleids)
/*      */       {
/* 2606 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*      */       }
/* 2608 */       _size_ += CodedOutputStream.computeBoolSize(2, this.activated);
/* 2609 */       _size_ += CodedOutputStream.computeInt64Size(3, this.lastlogintime);
/* 2610 */       _size_ += CodedOutputStream.computeInt64Size(4, this.last_login_roleid);
/* 2611 */       _size_ += CodedOutputStream.computeInt64Size(5, this.max_fighting_capacity);
/* 2612 */       _size_ += CodedOutputStream.computeInt64Size(6, this.max_fighting_capacity_roleid);
/* 2613 */       _size_ += CodedOutputStream.computeInt32Size(7, this.grc_friends_count);
/* 2614 */       _size_ += CodedOutputStream.computeInt32Size(8, this.grc_friends_count_award_serial_no);
/* 2615 */       _size_ += CodedOutputStream.computeInt32Size(9, this.sn);
/*      */       try
/*      */       {
/* 2618 */         _size_ += CodedOutputStream.computeBytesSize(10, ByteString.copyFrom(this.final_success_order_id, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 2622 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 2624 */       _size_ += CodedOutputStream.computeInt64Size(11, this.final_transfer_success_time);
/* 2625 */       for (Long _v_ : this.compensates)
/*      */       {
/* 2627 */         _size_ += CodedOutputStream.computeInt64Size(12, _v_.longValue());
/*      */       }
/* 2629 */       for (Map.Entry<Integer, xbean.PrivilegeAwardInfo> _e_ : this.privilege_award_infos.entrySet())
/*      */       {
/* 2631 */         _size_ += CodedOutputStream.computeInt32Size(13, ((Integer)_e_.getKey()).intValue());
/* 2632 */         _size_ += CodedOutputStream.computeMessageSize(13, (Message)_e_.getValue());
/*      */       }
/* 2634 */       _size_ += CodedOutputStream.computeInt32Size(14, this.invitee_status);
/*      */       try
/*      */       {
/* 2637 */         _size_ += CodedOutputStream.computeBytesSize(15, ByteString.copyFrom(this.invitee_code, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 2641 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 2643 */       _size_ += CodedOutputStream.computeInt64Size(16, this.invitee_total_present_rebate_bind_yuanbao);
/*      */       try
/*      */       {
/* 2646 */         _size_ += CodedOutputStream.computeBytesSize(17, ByteString.copyFrom(this.inviter_code, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 2650 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 2652 */       _size_ += CodedOutputStream.computeInt64Size(18, this.inviter_total_rebate_bind_yuanbao);
/* 2653 */       _size_ += CodedOutputStream.computeInt64Size(19, this.inviter_total_gift_times);
/* 2654 */       _size_ += CodedOutputStream.computeInt64Size(20, this.invitee_save_amt);
/* 2655 */       _size_ += CodedOutputStream.computeInt64Size(21, this.register_time);
/* 2656 */       _size_ += CodedOutputStream.computeInt64Size(22, this.invitee_confirm_total_present_rebate_bind_yuanbao);
/* 2657 */       _size_ += CodedOutputStream.computeInt32Size(23, this.invitee_done_shimen_total_days);
/* 2658 */       _size_ += CodedOutputStream.computeInt64Size(24, this.invitee_done_shimen_timestamp);
/* 2659 */       _size_ += CodedOutputStream.computeMessageSize(25, this.recall_friend_back_game);
/*      */       try
/*      */       {
/* 2662 */         _size_ += CodedOutputStream.computeBytesSize(26, ByteString.copyFrom(this.figure_url, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 2666 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */       try
/*      */       {
/* 2670 */         _size_ += CodedOutputStream.computeBytesSize(27, ByteString.copyFrom(this.nick_name, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 2674 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 2676 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2684 */         for (Long _v_ : this.roleids)
/*      */         {
/* 2686 */           _output_.writeInt64(1, _v_.longValue());
/*      */         }
/* 2688 */         _output_.writeBool(2, this.activated);
/* 2689 */         _output_.writeInt64(3, this.lastlogintime);
/* 2690 */         _output_.writeInt64(4, this.last_login_roleid);
/* 2691 */         _output_.writeInt64(5, this.max_fighting_capacity);
/* 2692 */         _output_.writeInt64(6, this.max_fighting_capacity_roleid);
/* 2693 */         _output_.writeInt32(7, this.grc_friends_count);
/* 2694 */         _output_.writeInt32(8, this.grc_friends_count_award_serial_no);
/* 2695 */         _output_.writeInt32(9, this.sn);
/* 2696 */         _output_.writeBytes(10, ByteString.copyFrom(this.final_success_order_id, "UTF-16LE"));
/* 2697 */         _output_.writeInt64(11, this.final_transfer_success_time);
/* 2698 */         for (Long _v_ : this.compensates)
/*      */         {
/* 2700 */           _output_.writeInt64(12, _v_.longValue());
/*      */         }
/* 2702 */         for (Map.Entry<Integer, xbean.PrivilegeAwardInfo> _e_ : this.privilege_award_infos.entrySet())
/*      */         {
/* 2704 */           _output_.writeInt32(13, ((Integer)_e_.getKey()).intValue());
/* 2705 */           _output_.writeMessage(13, (Message)_e_.getValue());
/*      */         }
/* 2707 */         _output_.writeInt32(14, this.invitee_status);
/* 2708 */         _output_.writeBytes(15, ByteString.copyFrom(this.invitee_code, "UTF-16LE"));
/* 2709 */         _output_.writeInt64(16, this.invitee_total_present_rebate_bind_yuanbao);
/* 2710 */         _output_.writeBytes(17, ByteString.copyFrom(this.inviter_code, "UTF-16LE"));
/* 2711 */         _output_.writeInt64(18, this.inviter_total_rebate_bind_yuanbao);
/* 2712 */         _output_.writeInt64(19, this.inviter_total_gift_times);
/* 2713 */         _output_.writeInt64(20, this.invitee_save_amt);
/* 2714 */         _output_.writeInt64(21, this.register_time);
/* 2715 */         _output_.writeInt64(22, this.invitee_confirm_total_present_rebate_bind_yuanbao);
/* 2716 */         _output_.writeInt32(23, this.invitee_done_shimen_total_days);
/* 2717 */         _output_.writeInt64(24, this.invitee_done_shimen_timestamp);
/* 2718 */         _output_.writeMessage(25, this.recall_friend_back_game);
/* 2719 */         _output_.writeBytes(26, ByteString.copyFrom(this.figure_url, "UTF-16LE"));
/* 2720 */         _output_.writeBytes(27, ByteString.copyFrom(this.nick_name, "UTF-16LE"));
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2724 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2726 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 2734 */         boolean done = false;
/* 2735 */         while (!done)
/*      */         {
/* 2737 */           int tag = _input_.readTag();
/* 2738 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 2742 */             done = true;
/* 2743 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 2747 */             long _v_ = 0L;
/* 2748 */             _v_ = _input_.readInt64();
/* 2749 */             this.roleids.add(Long.valueOf(_v_));
/* 2750 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 2754 */             this.activated = _input_.readBool();
/* 2755 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 2759 */             this.lastlogintime = _input_.readInt64();
/* 2760 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 2764 */             this.last_login_roleid = _input_.readInt64();
/* 2765 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 2769 */             this.max_fighting_capacity = _input_.readInt64();
/* 2770 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 2774 */             this.max_fighting_capacity_roleid = _input_.readInt64();
/* 2775 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 2779 */             this.grc_friends_count = _input_.readInt32();
/* 2780 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 2784 */             this.grc_friends_count_award_serial_no = _input_.readInt32();
/* 2785 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 2789 */             this.sn = _input_.readInt32();
/* 2790 */             break;
/*      */           
/*      */ 
/*      */           case 82: 
/* 2794 */             this.final_success_order_id = _input_.readBytes().toString("UTF-16LE");
/* 2795 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 2799 */             this.final_transfer_success_time = _input_.readInt64();
/* 2800 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 2804 */             long _v_ = 0L;
/* 2805 */             _v_ = _input_.readInt64();
/* 2806 */             this.compensates.add(Long.valueOf(_v_));
/* 2807 */             break;
/*      */           
/*      */ 
/*      */           case 104: 
/* 2811 */             int _k_ = 0;
/* 2812 */             _k_ = _input_.readInt32();
/* 2813 */             int readTag = _input_.readTag();
/* 2814 */             if (106 != readTag)
/*      */             {
/* 2816 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 2818 */             xbean.PrivilegeAwardInfo _v_ = Pod.newPrivilegeAwardInfoData();
/* 2819 */             _input_.readMessage(_v_);
/* 2820 */             this.privilege_award_infos.put(Integer.valueOf(_k_), _v_);
/* 2821 */             break;
/*      */           
/*      */ 
/*      */           case 112: 
/* 2825 */             this.invitee_status = _input_.readInt32();
/* 2826 */             break;
/*      */           
/*      */ 
/*      */           case 122: 
/* 2830 */             this.invitee_code = _input_.readBytes().toString("UTF-16LE");
/* 2831 */             break;
/*      */           
/*      */ 
/*      */           case 128: 
/* 2835 */             this.invitee_total_present_rebate_bind_yuanbao = _input_.readInt64();
/* 2836 */             break;
/*      */           
/*      */ 
/*      */           case 138: 
/* 2840 */             this.inviter_code = _input_.readBytes().toString("UTF-16LE");
/* 2841 */             break;
/*      */           
/*      */ 
/*      */           case 144: 
/* 2845 */             this.inviter_total_rebate_bind_yuanbao = _input_.readInt64();
/* 2846 */             break;
/*      */           
/*      */ 
/*      */           case 152: 
/* 2850 */             this.inviter_total_gift_times = _input_.readInt64();
/* 2851 */             break;
/*      */           
/*      */ 
/*      */           case 160: 
/* 2855 */             this.invitee_save_amt = _input_.readInt64();
/* 2856 */             break;
/*      */           
/*      */ 
/*      */           case 168: 
/* 2860 */             this.register_time = _input_.readInt64();
/* 2861 */             break;
/*      */           
/*      */ 
/*      */           case 176: 
/* 2865 */             this.invitee_confirm_total_present_rebate_bind_yuanbao = _input_.readInt64();
/* 2866 */             break;
/*      */           
/*      */ 
/*      */           case 184: 
/* 2870 */             this.invitee_done_shimen_total_days = _input_.readInt32();
/* 2871 */             break;
/*      */           
/*      */ 
/*      */           case 192: 
/* 2875 */             this.invitee_done_shimen_timestamp = _input_.readInt64();
/* 2876 */             break;
/*      */           
/*      */ 
/*      */           case 202: 
/* 2880 */             _input_.readMessage(this.recall_friend_back_game);
/* 2881 */             break;
/*      */           
/*      */ 
/*      */           case 210: 
/* 2885 */             this.figure_url = _input_.readBytes().toString("UTF-16LE");
/* 2886 */             break;
/*      */           
/*      */ 
/*      */           case 218: 
/* 2890 */             this.nick_name = _input_.readBytes().toString("UTF-16LE");
/* 2891 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 2895 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 2897 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 2906 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 2910 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 2912 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.User copy()
/*      */     {
/* 2918 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.User toData()
/*      */     {
/* 2924 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.User toBean()
/*      */     {
/* 2929 */       return new User(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.User toDataIf()
/*      */     {
/* 2935 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.User toBeanIf()
/*      */     {
/* 2940 */       return new User(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 2946 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 2950 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 2954 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 2958 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 2962 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 2966 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 2970 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRoleids()
/*      */     {
/* 2977 */       return this.roleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRoleidsAsData()
/*      */     {
/* 2984 */       return this.roleids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getActivated()
/*      */     {
/* 2991 */       return this.activated;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastlogintime()
/*      */     {
/* 2998 */       return this.lastlogintime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_login_roleid()
/*      */     {
/* 3005 */       return this.last_login_roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMax_fighting_capacity()
/*      */     {
/* 3012 */       return this.max_fighting_capacity;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMax_fighting_capacity_roleid()
/*      */     {
/* 3019 */       return this.max_fighting_capacity_roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGrc_friends_count()
/*      */     {
/* 3026 */       return this.grc_friends_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGrc_friends_count_award_serial_no()
/*      */     {
/* 3033 */       return this.grc_friends_count_award_serial_no;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSn()
/*      */     {
/* 3040 */       return this.sn;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getFinal_success_order_id()
/*      */     {
/* 3047 */       return this.final_success_order_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getFinal_success_order_idOctets()
/*      */     {
/* 3054 */       return Octets.wrap(getFinal_success_order_id(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFinal_transfer_success_time()
/*      */     {
/* 3061 */       return this.final_transfer_success_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCompensates()
/*      */     {
/* 3068 */       return this.compensates;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getCompensatesAsData()
/*      */     {
/* 3075 */       return this.compensates;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.PrivilegeAwardInfo> getPrivilege_award_infos()
/*      */     {
/* 3082 */       return this.privilege_award_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.PrivilegeAwardInfo> getPrivilege_award_infosAsData()
/*      */     {
/* 3089 */       return this.privilege_award_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getInvitee_status()
/*      */     {
/* 3096 */       return this.invitee_status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getInvitee_code()
/*      */     {
/* 3103 */       return this.invitee_code;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getInvitee_codeOctets()
/*      */     {
/* 3110 */       return Octets.wrap(getInvitee_code(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInvitee_total_present_rebate_bind_yuanbao()
/*      */     {
/* 3117 */       return this.invitee_total_present_rebate_bind_yuanbao;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getInviter_code()
/*      */     {
/* 3124 */       return this.inviter_code;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getInviter_codeOctets()
/*      */     {
/* 3131 */       return Octets.wrap(getInviter_code(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInviter_total_rebate_bind_yuanbao()
/*      */     {
/* 3138 */       return this.inviter_total_rebate_bind_yuanbao;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInviter_total_gift_times()
/*      */     {
/* 3145 */       return this.inviter_total_gift_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInvitee_save_amt()
/*      */     {
/* 3152 */       return this.invitee_save_amt;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRegister_time()
/*      */     {
/* 3159 */       return this.register_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInvitee_confirm_total_present_rebate_bind_yuanbao()
/*      */     {
/* 3166 */       return this.invitee_confirm_total_present_rebate_bind_yuanbao;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getInvitee_done_shimen_total_days()
/*      */     {
/* 3173 */       return this.invitee_done_shimen_total_days;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInvitee_done_shimen_timestamp()
/*      */     {
/* 3180 */       return this.invitee_done_shimen_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.RecallFriendBackGame getRecall_friend_back_game()
/*      */     {
/* 3187 */       return this.recall_friend_back_game;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getFigure_url()
/*      */     {
/* 3194 */       return this.figure_url;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getFigure_urlOctets()
/*      */     {
/* 3201 */       return Octets.wrap(getFigure_url(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getNick_name()
/*      */     {
/* 3208 */       return this.nick_name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNick_nameOctets()
/*      */     {
/* 3215 */       return Octets.wrap(getNick_name(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivated(boolean _v_)
/*      */     {
/* 3222 */       this.activated = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastlogintime(long _v_)
/*      */     {
/* 3229 */       this.lastlogintime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_login_roleid(long _v_)
/*      */     {
/* 3236 */       this.last_login_roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMax_fighting_capacity(long _v_)
/*      */     {
/* 3243 */       this.max_fighting_capacity = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMax_fighting_capacity_roleid(long _v_)
/*      */     {
/* 3250 */       this.max_fighting_capacity_roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrc_friends_count(int _v_)
/*      */     {
/* 3257 */       this.grc_friends_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrc_friends_count_award_serial_no(int _v_)
/*      */     {
/* 3264 */       this.grc_friends_count_award_serial_no = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSn(int _v_)
/*      */     {
/* 3271 */       this.sn = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFinal_success_order_id(String _v_)
/*      */     {
/* 3278 */       if (null == _v_)
/* 3279 */         throw new NullPointerException();
/* 3280 */       this.final_success_order_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFinal_success_order_idOctets(Octets _v_)
/*      */     {
/* 3287 */       setFinal_success_order_id(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFinal_transfer_success_time(long _v_)
/*      */     {
/* 3294 */       this.final_transfer_success_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitee_status(int _v_)
/*      */     {
/* 3301 */       this.invitee_status = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitee_code(String _v_)
/*      */     {
/* 3308 */       if (null == _v_)
/* 3309 */         throw new NullPointerException();
/* 3310 */       this.invitee_code = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitee_codeOctets(Octets _v_)
/*      */     {
/* 3317 */       setInvitee_code(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitee_total_present_rebate_bind_yuanbao(long _v_)
/*      */     {
/* 3324 */       this.invitee_total_present_rebate_bind_yuanbao = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInviter_code(String _v_)
/*      */     {
/* 3331 */       if (null == _v_)
/* 3332 */         throw new NullPointerException();
/* 3333 */       this.inviter_code = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInviter_codeOctets(Octets _v_)
/*      */     {
/* 3340 */       setInviter_code(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInviter_total_rebate_bind_yuanbao(long _v_)
/*      */     {
/* 3347 */       this.inviter_total_rebate_bind_yuanbao = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInviter_total_gift_times(long _v_)
/*      */     {
/* 3354 */       this.inviter_total_gift_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitee_save_amt(long _v_)
/*      */     {
/* 3361 */       this.invitee_save_amt = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRegister_time(long _v_)
/*      */     {
/* 3368 */       this.register_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitee_confirm_total_present_rebate_bind_yuanbao(long _v_)
/*      */     {
/* 3375 */       this.invitee_confirm_total_present_rebate_bind_yuanbao = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitee_done_shimen_total_days(int _v_)
/*      */     {
/* 3382 */       this.invitee_done_shimen_total_days = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInvitee_done_shimen_timestamp(long _v_)
/*      */     {
/* 3389 */       this.invitee_done_shimen_timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFigure_url(String _v_)
/*      */     {
/* 3396 */       if (null == _v_)
/* 3397 */         throw new NullPointerException();
/* 3398 */       this.figure_url = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFigure_urlOctets(Octets _v_)
/*      */     {
/* 3405 */       setFigure_url(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNick_name(String _v_)
/*      */     {
/* 3412 */       if (null == _v_)
/* 3413 */         throw new NullPointerException();
/* 3414 */       this.nick_name = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNick_nameOctets(Octets _v_)
/*      */     {
/* 3421 */       setNick_name(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 3427 */       if (!(_o1_ instanceof Data)) return false;
/* 3428 */       Data _o_ = (Data)_o1_;
/* 3429 */       if (!this.roleids.equals(_o_.roleids)) return false;
/* 3430 */       if (this.activated != _o_.activated) return false;
/* 3431 */       if (this.lastlogintime != _o_.lastlogintime) return false;
/* 3432 */       if (this.last_login_roleid != _o_.last_login_roleid) return false;
/* 3433 */       if (this.max_fighting_capacity != _o_.max_fighting_capacity) return false;
/* 3434 */       if (this.max_fighting_capacity_roleid != _o_.max_fighting_capacity_roleid) return false;
/* 3435 */       if (this.grc_friends_count != _o_.grc_friends_count) return false;
/* 3436 */       if (this.grc_friends_count_award_serial_no != _o_.grc_friends_count_award_serial_no) return false;
/* 3437 */       if (this.sn != _o_.sn) return false;
/* 3438 */       if (!this.final_success_order_id.equals(_o_.final_success_order_id)) return false;
/* 3439 */       if (this.final_transfer_success_time != _o_.final_transfer_success_time) return false;
/* 3440 */       if (!this.compensates.equals(_o_.compensates)) return false;
/* 3441 */       if (!this.privilege_award_infos.equals(_o_.privilege_award_infos)) return false;
/* 3442 */       if (this.invitee_status != _o_.invitee_status) return false;
/* 3443 */       if (!this.invitee_code.equals(_o_.invitee_code)) return false;
/* 3444 */       if (this.invitee_total_present_rebate_bind_yuanbao != _o_.invitee_total_present_rebate_bind_yuanbao) return false;
/* 3445 */       if (!this.inviter_code.equals(_o_.inviter_code)) return false;
/* 3446 */       if (this.inviter_total_rebate_bind_yuanbao != _o_.inviter_total_rebate_bind_yuanbao) return false;
/* 3447 */       if (this.inviter_total_gift_times != _o_.inviter_total_gift_times) return false;
/* 3448 */       if (this.invitee_save_amt != _o_.invitee_save_amt) return false;
/* 3449 */       if (this.register_time != _o_.register_time) return false;
/* 3450 */       if (this.invitee_confirm_total_present_rebate_bind_yuanbao != _o_.invitee_confirm_total_present_rebate_bind_yuanbao) return false;
/* 3451 */       if (this.invitee_done_shimen_total_days != _o_.invitee_done_shimen_total_days) return false;
/* 3452 */       if (this.invitee_done_shimen_timestamp != _o_.invitee_done_shimen_timestamp) return false;
/* 3453 */       if (!this.recall_friend_back_game.equals(_o_.recall_friend_back_game)) return false;
/* 3454 */       if (!this.figure_url.equals(_o_.figure_url)) return false;
/* 3455 */       if (!this.nick_name.equals(_o_.nick_name)) return false;
/* 3456 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 3462 */       int _h_ = 0;
/* 3463 */       _h_ += this.roleids.hashCode();
/* 3464 */       _h_ += (this.activated ? 1231 : 1237);
/* 3465 */       _h_ = (int)(_h_ + this.lastlogintime);
/* 3466 */       _h_ = (int)(_h_ + this.last_login_roleid);
/* 3467 */       _h_ = (int)(_h_ + this.max_fighting_capacity);
/* 3468 */       _h_ = (int)(_h_ + this.max_fighting_capacity_roleid);
/* 3469 */       _h_ += this.grc_friends_count;
/* 3470 */       _h_ += this.grc_friends_count_award_serial_no;
/* 3471 */       _h_ += this.sn;
/* 3472 */       _h_ += this.final_success_order_id.hashCode();
/* 3473 */       _h_ = (int)(_h_ + this.final_transfer_success_time);
/* 3474 */       _h_ += this.compensates.hashCode();
/* 3475 */       _h_ += this.privilege_award_infos.hashCode();
/* 3476 */       _h_ += this.invitee_status;
/* 3477 */       _h_ += this.invitee_code.hashCode();
/* 3478 */       _h_ = (int)(_h_ + this.invitee_total_present_rebate_bind_yuanbao);
/* 3479 */       _h_ += this.inviter_code.hashCode();
/* 3480 */       _h_ = (int)(_h_ + this.inviter_total_rebate_bind_yuanbao);
/* 3481 */       _h_ = (int)(_h_ + this.inviter_total_gift_times);
/* 3482 */       _h_ = (int)(_h_ + this.invitee_save_amt);
/* 3483 */       _h_ = (int)(_h_ + this.register_time);
/* 3484 */       _h_ = (int)(_h_ + this.invitee_confirm_total_present_rebate_bind_yuanbao);
/* 3485 */       _h_ += this.invitee_done_shimen_total_days;
/* 3486 */       _h_ = (int)(_h_ + this.invitee_done_shimen_timestamp);
/* 3487 */       _h_ += this.recall_friend_back_game.hashCode();
/* 3488 */       _h_ += this.figure_url.hashCode();
/* 3489 */       _h_ += this.nick_name.hashCode();
/* 3490 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 3496 */       StringBuilder _sb_ = new StringBuilder();
/* 3497 */       _sb_.append("(");
/* 3498 */       _sb_.append(this.roleids);
/* 3499 */       _sb_.append(",");
/* 3500 */       _sb_.append(this.activated);
/* 3501 */       _sb_.append(",");
/* 3502 */       _sb_.append(this.lastlogintime);
/* 3503 */       _sb_.append(",");
/* 3504 */       _sb_.append(this.last_login_roleid);
/* 3505 */       _sb_.append(",");
/* 3506 */       _sb_.append(this.max_fighting_capacity);
/* 3507 */       _sb_.append(",");
/* 3508 */       _sb_.append(this.max_fighting_capacity_roleid);
/* 3509 */       _sb_.append(",");
/* 3510 */       _sb_.append(this.grc_friends_count);
/* 3511 */       _sb_.append(",");
/* 3512 */       _sb_.append(this.grc_friends_count_award_serial_no);
/* 3513 */       _sb_.append(",");
/* 3514 */       _sb_.append(this.sn);
/* 3515 */       _sb_.append(",");
/* 3516 */       _sb_.append("'").append(this.final_success_order_id).append("'");
/* 3517 */       _sb_.append(",");
/* 3518 */       _sb_.append(this.final_transfer_success_time);
/* 3519 */       _sb_.append(",");
/* 3520 */       _sb_.append(this.compensates);
/* 3521 */       _sb_.append(",");
/* 3522 */       _sb_.append(this.privilege_award_infos);
/* 3523 */       _sb_.append(",");
/* 3524 */       _sb_.append(this.invitee_status);
/* 3525 */       _sb_.append(",");
/* 3526 */       _sb_.append("'").append(this.invitee_code).append("'");
/* 3527 */       _sb_.append(",");
/* 3528 */       _sb_.append(this.invitee_total_present_rebate_bind_yuanbao);
/* 3529 */       _sb_.append(",");
/* 3530 */       _sb_.append("'").append(this.inviter_code).append("'");
/* 3531 */       _sb_.append(",");
/* 3532 */       _sb_.append(this.inviter_total_rebate_bind_yuanbao);
/* 3533 */       _sb_.append(",");
/* 3534 */       _sb_.append(this.inviter_total_gift_times);
/* 3535 */       _sb_.append(",");
/* 3536 */       _sb_.append(this.invitee_save_amt);
/* 3537 */       _sb_.append(",");
/* 3538 */       _sb_.append(this.register_time);
/* 3539 */       _sb_.append(",");
/* 3540 */       _sb_.append(this.invitee_confirm_total_present_rebate_bind_yuanbao);
/* 3541 */       _sb_.append(",");
/* 3542 */       _sb_.append(this.invitee_done_shimen_total_days);
/* 3543 */       _sb_.append(",");
/* 3544 */       _sb_.append(this.invitee_done_shimen_timestamp);
/* 3545 */       _sb_.append(",");
/* 3546 */       _sb_.append(this.recall_friend_back_game);
/* 3547 */       _sb_.append(",");
/* 3548 */       _sb_.append("'").append(this.figure_url).append("'");
/* 3549 */       _sb_.append(",");
/* 3550 */       _sb_.append("'").append(this.nick_name).append("'");
/* 3551 */       _sb_.append(")");
/* 3552 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\User.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */