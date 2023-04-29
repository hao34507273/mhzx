/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Consts;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.logs.LogObject;
/*      */ 
/*      */ public final class BackGameActivityInfo extends XBean implements xbean.BackGameActivityInfo
/*      */ {
/*      */   private int activity_id;
/*      */   private long join_time;
/*      */   private int join_level;
/*      */   private int join_recharge;
/*      */   private int sign_count;
/*      */   private long last_sign_time;
/*      */   private ArrayList<Integer> already_get_point_awards;
/*      */   private long last_get_point_award_time;
/*      */   private ArrayList<Integer> already_get_exp_awards;
/*      */   private int login_count;
/*      */   private long last_login_time;
/*      */   private boolean have_got_back_game_award;
/*      */   private HashMap<Integer, Integer> gift_buy_count_map;
/*      */   private long last_buy_gift_time;
/*      */   private long last_get_task_award_time;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   46 */     this.activity_id = 0;
/*   47 */     this.join_time = 0L;
/*   48 */     this.join_level = 0;
/*   49 */     this.join_recharge = 0;
/*   50 */     this.sign_count = 0;
/*   51 */     this.last_sign_time = 0L;
/*   52 */     this.already_get_point_awards.clear();
/*   53 */     this.last_get_point_award_time = 0L;
/*   54 */     this.already_get_exp_awards.clear();
/*   55 */     this.login_count = 0;
/*   56 */     this.last_login_time = 0L;
/*   57 */     this.have_got_back_game_award = false;
/*   58 */     this.gift_buy_count_map.clear();
/*   59 */     this.last_buy_gift_time = 0L;
/*   60 */     this.last_get_task_award_time = 0L;
/*      */   }
/*      */   
/*      */   BackGameActivityInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   65 */     super(_xp_, _vn_);
/*   66 */     this.already_get_point_awards = new ArrayList();
/*   67 */     this.already_get_exp_awards = new ArrayList();
/*   68 */     this.gift_buy_count_map = new HashMap();
/*      */   }
/*      */   
/*      */   public BackGameActivityInfo()
/*      */   {
/*   73 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public BackGameActivityInfo(BackGameActivityInfo _o_)
/*      */   {
/*   78 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   BackGameActivityInfo(xbean.BackGameActivityInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   83 */     super(_xp_, _vn_);
/*   84 */     if ((_o1_ instanceof BackGameActivityInfo)) { assign((BackGameActivityInfo)_o1_);
/*   85 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   86 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   87 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(BackGameActivityInfo _o_) {
/*   92 */     _o_._xdb_verify_unsafe_();
/*   93 */     this.activity_id = _o_.activity_id;
/*   94 */     this.join_time = _o_.join_time;
/*   95 */     this.join_level = _o_.join_level;
/*   96 */     this.join_recharge = _o_.join_recharge;
/*   97 */     this.sign_count = _o_.sign_count;
/*   98 */     this.last_sign_time = _o_.last_sign_time;
/*   99 */     this.already_get_point_awards = new ArrayList();
/*  100 */     this.already_get_point_awards.addAll(_o_.already_get_point_awards);
/*  101 */     this.last_get_point_award_time = _o_.last_get_point_award_time;
/*  102 */     this.already_get_exp_awards = new ArrayList();
/*  103 */     this.already_get_exp_awards.addAll(_o_.already_get_exp_awards);
/*  104 */     this.login_count = _o_.login_count;
/*  105 */     this.last_login_time = _o_.last_login_time;
/*  106 */     this.have_got_back_game_award = _o_.have_got_back_game_award;
/*  107 */     this.gift_buy_count_map = new HashMap();
/*  108 */     for (Map.Entry<Integer, Integer> _e_ : _o_.gift_buy_count_map.entrySet())
/*  109 */       this.gift_buy_count_map.put(_e_.getKey(), _e_.getValue());
/*  110 */     this.last_buy_gift_time = _o_.last_buy_gift_time;
/*  111 */     this.last_get_task_award_time = _o_.last_get_task_award_time;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  116 */     this.activity_id = _o_.activity_id;
/*  117 */     this.join_time = _o_.join_time;
/*  118 */     this.join_level = _o_.join_level;
/*  119 */     this.join_recharge = _o_.join_recharge;
/*  120 */     this.sign_count = _o_.sign_count;
/*  121 */     this.last_sign_time = _o_.last_sign_time;
/*  122 */     this.already_get_point_awards = new ArrayList();
/*  123 */     this.already_get_point_awards.addAll(_o_.already_get_point_awards);
/*  124 */     this.last_get_point_award_time = _o_.last_get_point_award_time;
/*  125 */     this.already_get_exp_awards = new ArrayList();
/*  126 */     this.already_get_exp_awards.addAll(_o_.already_get_exp_awards);
/*  127 */     this.login_count = _o_.login_count;
/*  128 */     this.last_login_time = _o_.last_login_time;
/*  129 */     this.have_got_back_game_award = _o_.have_got_back_game_award;
/*  130 */     this.gift_buy_count_map = new HashMap();
/*  131 */     for (Map.Entry<Integer, Integer> _e_ : _o_.gift_buy_count_map.entrySet())
/*  132 */       this.gift_buy_count_map.put(_e_.getKey(), _e_.getValue());
/*  133 */     this.last_buy_gift_time = _o_.last_buy_gift_time;
/*  134 */     this.last_get_task_award_time = _o_.last_get_task_award_time;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  140 */     _xdb_verify_unsafe_();
/*  141 */     _os_.marshal(this.activity_id);
/*  142 */     _os_.marshal(this.join_time);
/*  143 */     _os_.marshal(this.join_level);
/*  144 */     _os_.marshal(this.join_recharge);
/*  145 */     _os_.marshal(this.sign_count);
/*  146 */     _os_.marshal(this.last_sign_time);
/*  147 */     _os_.compact_uint32(this.already_get_point_awards.size());
/*  148 */     for (Integer _v_ : this.already_get_point_awards)
/*      */     {
/*  150 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  152 */     _os_.marshal(this.last_get_point_award_time);
/*  153 */     _os_.compact_uint32(this.already_get_exp_awards.size());
/*  154 */     for (Integer _v_ : this.already_get_exp_awards)
/*      */     {
/*  156 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  158 */     _os_.marshal(this.login_count);
/*  159 */     _os_.marshal(this.last_login_time);
/*  160 */     _os_.marshal(this.have_got_back_game_award);
/*  161 */     _os_.compact_uint32(this.gift_buy_count_map.size());
/*  162 */     for (Map.Entry<Integer, Integer> _e_ : this.gift_buy_count_map.entrySet())
/*      */     {
/*  164 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  165 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  167 */     _os_.marshal(this.last_buy_gift_time);
/*  168 */     _os_.marshal(this.last_get_task_award_time);
/*  169 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  175 */     _xdb_verify_unsafe_();
/*  176 */     this.activity_id = _os_.unmarshal_int();
/*  177 */     this.join_time = _os_.unmarshal_long();
/*  178 */     this.join_level = _os_.unmarshal_int();
/*  179 */     this.join_recharge = _os_.unmarshal_int();
/*  180 */     this.sign_count = _os_.unmarshal_int();
/*  181 */     this.last_sign_time = _os_.unmarshal_long();
/*  182 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  184 */       int _v_ = 0;
/*  185 */       _v_ = _os_.unmarshal_int();
/*  186 */       this.already_get_point_awards.add(Integer.valueOf(_v_));
/*      */     }
/*  188 */     this.last_get_point_award_time = _os_.unmarshal_long();
/*  189 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  191 */       int _v_ = 0;
/*  192 */       _v_ = _os_.unmarshal_int();
/*  193 */       this.already_get_exp_awards.add(Integer.valueOf(_v_));
/*      */     }
/*  195 */     this.login_count = _os_.unmarshal_int();
/*  196 */     this.last_login_time = _os_.unmarshal_long();
/*  197 */     this.have_got_back_game_award = _os_.unmarshal_boolean();
/*      */     
/*  199 */     int size = _os_.uncompact_uint32();
/*  200 */     if (size >= 12)
/*      */     {
/*  202 */       this.gift_buy_count_map = new HashMap(size * 2);
/*      */     }
/*  204 */     for (; size > 0; size--)
/*      */     {
/*  206 */       int _k_ = 0;
/*  207 */       _k_ = _os_.unmarshal_int();
/*  208 */       int _v_ = 0;
/*  209 */       _v_ = _os_.unmarshal_int();
/*  210 */       this.gift_buy_count_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  213 */     this.last_buy_gift_time = _os_.unmarshal_long();
/*  214 */     this.last_get_task_award_time = _os_.unmarshal_long();
/*  215 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  221 */     _xdb_verify_unsafe_();
/*  222 */     int _size_ = 0;
/*  223 */     _size_ += CodedOutputStream.computeInt32Size(1, this.activity_id);
/*  224 */     _size_ += CodedOutputStream.computeInt64Size(2, this.join_time);
/*  225 */     _size_ += CodedOutputStream.computeInt32Size(3, this.join_level);
/*  226 */     _size_ += CodedOutputStream.computeInt32Size(4, this.join_recharge);
/*  227 */     _size_ += CodedOutputStream.computeInt32Size(5, this.sign_count);
/*  228 */     _size_ += CodedOutputStream.computeInt64Size(6, this.last_sign_time);
/*  229 */     for (Integer _v_ : this.already_get_point_awards)
/*      */     {
/*  231 */       _size_ += CodedOutputStream.computeInt32Size(7, _v_.intValue());
/*      */     }
/*  233 */     _size_ += CodedOutputStream.computeInt64Size(8, this.last_get_point_award_time);
/*  234 */     for (Integer _v_ : this.already_get_exp_awards)
/*      */     {
/*  236 */       _size_ += CodedOutputStream.computeInt32Size(9, _v_.intValue());
/*      */     }
/*  238 */     _size_ += CodedOutputStream.computeInt32Size(10, this.login_count);
/*  239 */     _size_ += CodedOutputStream.computeInt64Size(11, this.last_login_time);
/*  240 */     _size_ += CodedOutputStream.computeBoolSize(12, this.have_got_back_game_award);
/*  241 */     for (Map.Entry<Integer, Integer> _e_ : this.gift_buy_count_map.entrySet())
/*      */     {
/*  243 */       _size_ += CodedOutputStream.computeInt32Size(13, ((Integer)_e_.getKey()).intValue());
/*  244 */       _size_ += CodedOutputStream.computeInt32Size(13, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  246 */     _size_ += CodedOutputStream.computeInt64Size(14, this.last_buy_gift_time);
/*  247 */     _size_ += CodedOutputStream.computeInt64Size(15, this.last_get_task_award_time);
/*  248 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  257 */       _output_.writeInt32(1, this.activity_id);
/*  258 */       _output_.writeInt64(2, this.join_time);
/*  259 */       _output_.writeInt32(3, this.join_level);
/*  260 */       _output_.writeInt32(4, this.join_recharge);
/*  261 */       _output_.writeInt32(5, this.sign_count);
/*  262 */       _output_.writeInt64(6, this.last_sign_time);
/*  263 */       for (Integer _v_ : this.already_get_point_awards)
/*      */       {
/*  265 */         _output_.writeInt32(7, _v_.intValue());
/*      */       }
/*  267 */       _output_.writeInt64(8, this.last_get_point_award_time);
/*  268 */       for (Integer _v_ : this.already_get_exp_awards)
/*      */       {
/*  270 */         _output_.writeInt32(9, _v_.intValue());
/*      */       }
/*  272 */       _output_.writeInt32(10, this.login_count);
/*  273 */       _output_.writeInt64(11, this.last_login_time);
/*  274 */       _output_.writeBool(12, this.have_got_back_game_award);
/*  275 */       for (Map.Entry<Integer, Integer> _e_ : this.gift_buy_count_map.entrySet())
/*      */       {
/*  277 */         _output_.writeInt32(13, ((Integer)_e_.getKey()).intValue());
/*  278 */         _output_.writeInt32(13, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  280 */       _output_.writeInt64(14, this.last_buy_gift_time);
/*  281 */       _output_.writeInt64(15, this.last_get_task_award_time);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  285 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  287 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  293 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  296 */       boolean done = false;
/*  297 */       while (!done)
/*      */       {
/*  299 */         int tag = _input_.readTag();
/*  300 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  304 */           done = true;
/*  305 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  309 */           this.activity_id = _input_.readInt32();
/*  310 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  314 */           this.join_time = _input_.readInt64();
/*  315 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  319 */           this.join_level = _input_.readInt32();
/*  320 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  324 */           this.join_recharge = _input_.readInt32();
/*  325 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  329 */           this.sign_count = _input_.readInt32();
/*  330 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  334 */           this.last_sign_time = _input_.readInt64();
/*  335 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  339 */           int _v_ = 0;
/*  340 */           _v_ = _input_.readInt32();
/*  341 */           this.already_get_point_awards.add(Integer.valueOf(_v_));
/*  342 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  346 */           this.last_get_point_award_time = _input_.readInt64();
/*  347 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  351 */           int _v_ = 0;
/*  352 */           _v_ = _input_.readInt32();
/*  353 */           this.already_get_exp_awards.add(Integer.valueOf(_v_));
/*  354 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  358 */           this.login_count = _input_.readInt32();
/*  359 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  363 */           this.last_login_time = _input_.readInt64();
/*  364 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  368 */           this.have_got_back_game_award = _input_.readBool();
/*  369 */           break;
/*      */         
/*      */ 
/*      */         case 104: 
/*  373 */           int _k_ = 0;
/*  374 */           _k_ = _input_.readInt32();
/*  375 */           int readTag = _input_.readTag();
/*  376 */           if (104 != readTag)
/*      */           {
/*  378 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  380 */           int _v_ = 0;
/*  381 */           _v_ = _input_.readInt32();
/*  382 */           this.gift_buy_count_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  383 */           break;
/*      */         
/*      */ 
/*      */         case 112: 
/*  387 */           this.last_buy_gift_time = _input_.readInt64();
/*  388 */           break;
/*      */         
/*      */ 
/*      */         case 120: 
/*  392 */           this.last_get_task_award_time = _input_.readInt64();
/*  393 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  397 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  399 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  408 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  412 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  414 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BackGameActivityInfo copy()
/*      */   {
/*  420 */     _xdb_verify_unsafe_();
/*  421 */     return new BackGameActivityInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BackGameActivityInfo toData()
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BackGameActivityInfo toBean()
/*      */   {
/*  433 */     _xdb_verify_unsafe_();
/*  434 */     return new BackGameActivityInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BackGameActivityInfo toDataIf()
/*      */   {
/*  440 */     _xdb_verify_unsafe_();
/*  441 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BackGameActivityInfo toBeanIf()
/*      */   {
/*  446 */     _xdb_verify_unsafe_();
/*  447 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  453 */     _xdb_verify_unsafe_();
/*  454 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getActivity_id()
/*      */   {
/*  461 */     _xdb_verify_unsafe_();
/*  462 */     return this.activity_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getJoin_time()
/*      */   {
/*  469 */     _xdb_verify_unsafe_();
/*  470 */     return this.join_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getJoin_level()
/*      */   {
/*  477 */     _xdb_verify_unsafe_();
/*  478 */     return this.join_level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getJoin_recharge()
/*      */   {
/*  485 */     _xdb_verify_unsafe_();
/*  486 */     return this.join_recharge;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getSign_count()
/*      */   {
/*  493 */     _xdb_verify_unsafe_();
/*  494 */     return this.sign_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLast_sign_time()
/*      */   {
/*  501 */     _xdb_verify_unsafe_();
/*  502 */     return this.last_sign_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getAlready_get_point_awards()
/*      */   {
/*  509 */     _xdb_verify_unsafe_();
/*  510 */     return Logs.logList(new LogKey(this, "already_get_point_awards"), this.already_get_point_awards);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getAlready_get_point_awardsAsData()
/*      */   {
/*  516 */     _xdb_verify_unsafe_();
/*      */     
/*  518 */     BackGameActivityInfo _o_ = this;
/*  519 */     List<Integer> already_get_point_awards = new ArrayList();
/*  520 */     already_get_point_awards.addAll(_o_.already_get_point_awards);
/*  521 */     return already_get_point_awards;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLast_get_point_award_time()
/*      */   {
/*  528 */     _xdb_verify_unsafe_();
/*  529 */     return this.last_get_point_award_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getAlready_get_exp_awards()
/*      */   {
/*  536 */     _xdb_verify_unsafe_();
/*  537 */     return Logs.logList(new LogKey(this, "already_get_exp_awards"), this.already_get_exp_awards);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getAlready_get_exp_awardsAsData()
/*      */   {
/*  543 */     _xdb_verify_unsafe_();
/*      */     
/*  545 */     BackGameActivityInfo _o_ = this;
/*  546 */     List<Integer> already_get_exp_awards = new ArrayList();
/*  547 */     already_get_exp_awards.addAll(_o_.already_get_exp_awards);
/*  548 */     return already_get_exp_awards;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLogin_count()
/*      */   {
/*  555 */     _xdb_verify_unsafe_();
/*  556 */     return this.login_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLast_login_time()
/*      */   {
/*  563 */     _xdb_verify_unsafe_();
/*  564 */     return this.last_login_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getHave_got_back_game_award()
/*      */   {
/*  571 */     _xdb_verify_unsafe_();
/*  572 */     return this.have_got_back_game_award;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getGift_buy_count_map()
/*      */   {
/*  579 */     _xdb_verify_unsafe_();
/*  580 */     return Logs.logMap(new LogKey(this, "gift_buy_count_map"), this.gift_buy_count_map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getGift_buy_count_mapAsData()
/*      */   {
/*  587 */     _xdb_verify_unsafe_();
/*      */     
/*  589 */     BackGameActivityInfo _o_ = this;
/*  590 */     Map<Integer, Integer> gift_buy_count_map = new HashMap();
/*  591 */     for (Map.Entry<Integer, Integer> _e_ : _o_.gift_buy_count_map.entrySet())
/*  592 */       gift_buy_count_map.put(_e_.getKey(), _e_.getValue());
/*  593 */     return gift_buy_count_map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLast_buy_gift_time()
/*      */   {
/*  600 */     _xdb_verify_unsafe_();
/*  601 */     return this.last_buy_gift_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLast_get_task_award_time()
/*      */   {
/*  608 */     _xdb_verify_unsafe_();
/*  609 */     return this.last_get_task_award_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActivity_id(int _v_)
/*      */   {
/*  616 */     _xdb_verify_unsafe_();
/*  617 */     Logs.logIf(new LogKey(this, "activity_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  621 */         new LogInt(this, BackGameActivityInfo.this.activity_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  625 */             BackGameActivityInfo.this.activity_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  629 */     });
/*  630 */     this.activity_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setJoin_time(long _v_)
/*      */   {
/*  637 */     _xdb_verify_unsafe_();
/*  638 */     Logs.logIf(new LogKey(this, "join_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  642 */         new LogLong(this, BackGameActivityInfo.this.join_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  646 */             BackGameActivityInfo.this.join_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  650 */     });
/*  651 */     this.join_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setJoin_level(int _v_)
/*      */   {
/*  658 */     _xdb_verify_unsafe_();
/*  659 */     Logs.logIf(new LogKey(this, "join_level")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  663 */         new LogInt(this, BackGameActivityInfo.this.join_level)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  667 */             BackGameActivityInfo.this.join_level = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  671 */     });
/*  672 */     this.join_level = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setJoin_recharge(int _v_)
/*      */   {
/*  679 */     _xdb_verify_unsafe_();
/*  680 */     Logs.logIf(new LogKey(this, "join_recharge")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  684 */         new LogInt(this, BackGameActivityInfo.this.join_recharge)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  688 */             BackGameActivityInfo.this.join_recharge = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  692 */     });
/*  693 */     this.join_recharge = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSign_count(int _v_)
/*      */   {
/*  700 */     _xdb_verify_unsafe_();
/*  701 */     Logs.logIf(new LogKey(this, "sign_count")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  705 */         new LogInt(this, BackGameActivityInfo.this.sign_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  709 */             BackGameActivityInfo.this.sign_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  713 */     });
/*  714 */     this.sign_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_sign_time(long _v_)
/*      */   {
/*  721 */     _xdb_verify_unsafe_();
/*  722 */     Logs.logIf(new LogKey(this, "last_sign_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  726 */         new LogLong(this, BackGameActivityInfo.this.last_sign_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  730 */             BackGameActivityInfo.this.last_sign_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  734 */     });
/*  735 */     this.last_sign_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_get_point_award_time(long _v_)
/*      */   {
/*  742 */     _xdb_verify_unsafe_();
/*  743 */     Logs.logIf(new LogKey(this, "last_get_point_award_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  747 */         new LogLong(this, BackGameActivityInfo.this.last_get_point_award_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  751 */             BackGameActivityInfo.this.last_get_point_award_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  755 */     });
/*  756 */     this.last_get_point_award_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLogin_count(int _v_)
/*      */   {
/*  763 */     _xdb_verify_unsafe_();
/*  764 */     Logs.logIf(new LogKey(this, "login_count")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  768 */         new LogInt(this, BackGameActivityInfo.this.login_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  772 */             BackGameActivityInfo.this.login_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  776 */     });
/*  777 */     this.login_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_login_time(long _v_)
/*      */   {
/*  784 */     _xdb_verify_unsafe_();
/*  785 */     Logs.logIf(new LogKey(this, "last_login_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  789 */         new LogLong(this, BackGameActivityInfo.this.last_login_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  793 */             BackGameActivityInfo.this.last_login_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  797 */     });
/*  798 */     this.last_login_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHave_got_back_game_award(boolean _v_)
/*      */   {
/*  805 */     _xdb_verify_unsafe_();
/*  806 */     Logs.logIf(new LogKey(this, "have_got_back_game_award")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  810 */         new LogObject(this, Boolean.valueOf(BackGameActivityInfo.this.have_got_back_game_award))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  814 */             BackGameActivityInfo.this.have_got_back_game_award = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  818 */     });
/*  819 */     this.have_got_back_game_award = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_buy_gift_time(long _v_)
/*      */   {
/*  826 */     _xdb_verify_unsafe_();
/*  827 */     Logs.logIf(new LogKey(this, "last_buy_gift_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  831 */         new LogLong(this, BackGameActivityInfo.this.last_buy_gift_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  835 */             BackGameActivityInfo.this.last_buy_gift_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  839 */     });
/*  840 */     this.last_buy_gift_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_get_task_award_time(long _v_)
/*      */   {
/*  847 */     _xdb_verify_unsafe_();
/*  848 */     Logs.logIf(new LogKey(this, "last_get_task_award_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  852 */         new LogLong(this, BackGameActivityInfo.this.last_get_task_award_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  856 */             BackGameActivityInfo.this.last_get_task_award_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  860 */     });
/*  861 */     this.last_get_task_award_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  867 */     _xdb_verify_unsafe_();
/*  868 */     BackGameActivityInfo _o_ = null;
/*  869 */     if ((_o1_ instanceof BackGameActivityInfo)) { _o_ = (BackGameActivityInfo)_o1_;
/*  870 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  871 */       return false;
/*  872 */     if (this.activity_id != _o_.activity_id) return false;
/*  873 */     if (this.join_time != _o_.join_time) return false;
/*  874 */     if (this.join_level != _o_.join_level) return false;
/*  875 */     if (this.join_recharge != _o_.join_recharge) return false;
/*  876 */     if (this.sign_count != _o_.sign_count) return false;
/*  877 */     if (this.last_sign_time != _o_.last_sign_time) return false;
/*  878 */     if (!this.already_get_point_awards.equals(_o_.already_get_point_awards)) return false;
/*  879 */     if (this.last_get_point_award_time != _o_.last_get_point_award_time) return false;
/*  880 */     if (!this.already_get_exp_awards.equals(_o_.already_get_exp_awards)) return false;
/*  881 */     if (this.login_count != _o_.login_count) return false;
/*  882 */     if (this.last_login_time != _o_.last_login_time) return false;
/*  883 */     if (this.have_got_back_game_award != _o_.have_got_back_game_award) return false;
/*  884 */     if (!this.gift_buy_count_map.equals(_o_.gift_buy_count_map)) return false;
/*  885 */     if (this.last_buy_gift_time != _o_.last_buy_gift_time) return false;
/*  886 */     if (this.last_get_task_award_time != _o_.last_get_task_award_time) return false;
/*  887 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  893 */     _xdb_verify_unsafe_();
/*  894 */     int _h_ = 0;
/*  895 */     _h_ += this.activity_id;
/*  896 */     _h_ = (int)(_h_ + this.join_time);
/*  897 */     _h_ += this.join_level;
/*  898 */     _h_ += this.join_recharge;
/*  899 */     _h_ += this.sign_count;
/*  900 */     _h_ = (int)(_h_ + this.last_sign_time);
/*  901 */     _h_ += this.already_get_point_awards.hashCode();
/*  902 */     _h_ = (int)(_h_ + this.last_get_point_award_time);
/*  903 */     _h_ += this.already_get_exp_awards.hashCode();
/*  904 */     _h_ += this.login_count;
/*  905 */     _h_ = (int)(_h_ + this.last_login_time);
/*  906 */     _h_ += (this.have_got_back_game_award ? 1231 : 1237);
/*  907 */     _h_ += this.gift_buy_count_map.hashCode();
/*  908 */     _h_ = (int)(_h_ + this.last_buy_gift_time);
/*  909 */     _h_ = (int)(_h_ + this.last_get_task_award_time);
/*  910 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  916 */     _xdb_verify_unsafe_();
/*  917 */     StringBuilder _sb_ = new StringBuilder();
/*  918 */     _sb_.append("(");
/*  919 */     _sb_.append(this.activity_id);
/*  920 */     _sb_.append(",");
/*  921 */     _sb_.append(this.join_time);
/*  922 */     _sb_.append(",");
/*  923 */     _sb_.append(this.join_level);
/*  924 */     _sb_.append(",");
/*  925 */     _sb_.append(this.join_recharge);
/*  926 */     _sb_.append(",");
/*  927 */     _sb_.append(this.sign_count);
/*  928 */     _sb_.append(",");
/*  929 */     _sb_.append(this.last_sign_time);
/*  930 */     _sb_.append(",");
/*  931 */     _sb_.append(this.already_get_point_awards);
/*  932 */     _sb_.append(",");
/*  933 */     _sb_.append(this.last_get_point_award_time);
/*  934 */     _sb_.append(",");
/*  935 */     _sb_.append(this.already_get_exp_awards);
/*  936 */     _sb_.append(",");
/*  937 */     _sb_.append(this.login_count);
/*  938 */     _sb_.append(",");
/*  939 */     _sb_.append(this.last_login_time);
/*  940 */     _sb_.append(",");
/*  941 */     _sb_.append(this.have_got_back_game_award);
/*  942 */     _sb_.append(",");
/*  943 */     _sb_.append(this.gift_buy_count_map);
/*  944 */     _sb_.append(",");
/*  945 */     _sb_.append(this.last_buy_gift_time);
/*  946 */     _sb_.append(",");
/*  947 */     _sb_.append(this.last_get_task_award_time);
/*  948 */     _sb_.append(")");
/*  949 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  955 */     ListenableBean lb = new ListenableBean();
/*  956 */     lb.add(new ListenableChanged().setVarName("activity_id"));
/*  957 */     lb.add(new ListenableChanged().setVarName("join_time"));
/*  958 */     lb.add(new ListenableChanged().setVarName("join_level"));
/*  959 */     lb.add(new ListenableChanged().setVarName("join_recharge"));
/*  960 */     lb.add(new ListenableChanged().setVarName("sign_count"));
/*  961 */     lb.add(new ListenableChanged().setVarName("last_sign_time"));
/*  962 */     lb.add(new ListenableChanged().setVarName("already_get_point_awards"));
/*  963 */     lb.add(new ListenableChanged().setVarName("last_get_point_award_time"));
/*  964 */     lb.add(new ListenableChanged().setVarName("already_get_exp_awards"));
/*  965 */     lb.add(new ListenableChanged().setVarName("login_count"));
/*  966 */     lb.add(new ListenableChanged().setVarName("last_login_time"));
/*  967 */     lb.add(new ListenableChanged().setVarName("have_got_back_game_award"));
/*  968 */     lb.add(new xdb.logs.ListenableMap().setVarName("gift_buy_count_map"));
/*  969 */     lb.add(new ListenableChanged().setVarName("last_buy_gift_time"));
/*  970 */     lb.add(new ListenableChanged().setVarName("last_get_task_award_time"));
/*  971 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.BackGameActivityInfo {
/*      */     private Const() {}
/*      */     
/*      */     BackGameActivityInfo nThis() {
/*  978 */       return BackGameActivityInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  984 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BackGameActivityInfo copy()
/*      */     {
/*  990 */       return BackGameActivityInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BackGameActivityInfo toData()
/*      */     {
/*  996 */       return BackGameActivityInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.BackGameActivityInfo toBean()
/*      */     {
/* 1001 */       return BackGameActivityInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BackGameActivityInfo toDataIf()
/*      */     {
/* 1007 */       return BackGameActivityInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.BackGameActivityInfo toBeanIf()
/*      */     {
/* 1012 */       return BackGameActivityInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActivity_id()
/*      */     {
/* 1019 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1020 */       return BackGameActivityInfo.this.activity_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getJoin_time()
/*      */     {
/* 1027 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1028 */       return BackGameActivityInfo.this.join_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getJoin_level()
/*      */     {
/* 1035 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1036 */       return BackGameActivityInfo.this.join_level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getJoin_recharge()
/*      */     {
/* 1043 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1044 */       return BackGameActivityInfo.this.join_recharge;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSign_count()
/*      */     {
/* 1051 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1052 */       return BackGameActivityInfo.this.sign_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_sign_time()
/*      */     {
/* 1059 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1060 */       return BackGameActivityInfo.this.last_sign_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getAlready_get_point_awards()
/*      */     {
/* 1067 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1068 */       return Consts.constList(BackGameActivityInfo.this.already_get_point_awards);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getAlready_get_point_awardsAsData()
/*      */     {
/* 1074 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1076 */       BackGameActivityInfo _o_ = BackGameActivityInfo.this;
/* 1077 */       List<Integer> already_get_point_awards = new ArrayList();
/* 1078 */       already_get_point_awards.addAll(_o_.already_get_point_awards);
/* 1079 */       return already_get_point_awards;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_get_point_award_time()
/*      */     {
/* 1086 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1087 */       return BackGameActivityInfo.this.last_get_point_award_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getAlready_get_exp_awards()
/*      */     {
/* 1094 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1095 */       return Consts.constList(BackGameActivityInfo.this.already_get_exp_awards);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getAlready_get_exp_awardsAsData()
/*      */     {
/* 1101 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1103 */       BackGameActivityInfo _o_ = BackGameActivityInfo.this;
/* 1104 */       List<Integer> already_get_exp_awards = new ArrayList();
/* 1105 */       already_get_exp_awards.addAll(_o_.already_get_exp_awards);
/* 1106 */       return already_get_exp_awards;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLogin_count()
/*      */     {
/* 1113 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1114 */       return BackGameActivityInfo.this.login_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_login_time()
/*      */     {
/* 1121 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1122 */       return BackGameActivityInfo.this.last_login_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getHave_got_back_game_award()
/*      */     {
/* 1129 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1130 */       return BackGameActivityInfo.this.have_got_back_game_award;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getGift_buy_count_map()
/*      */     {
/* 1137 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1138 */       return Consts.constMap(BackGameActivityInfo.this.gift_buy_count_map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getGift_buy_count_mapAsData()
/*      */     {
/* 1145 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/*      */       
/* 1147 */       BackGameActivityInfo _o_ = BackGameActivityInfo.this;
/* 1148 */       Map<Integer, Integer> gift_buy_count_map = new HashMap();
/* 1149 */       for (Map.Entry<Integer, Integer> _e_ : _o_.gift_buy_count_map.entrySet())
/* 1150 */         gift_buy_count_map.put(_e_.getKey(), _e_.getValue());
/* 1151 */       return gift_buy_count_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_buy_gift_time()
/*      */     {
/* 1158 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1159 */       return BackGameActivityInfo.this.last_buy_gift_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_get_task_award_time()
/*      */     {
/* 1166 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1167 */       return BackGameActivityInfo.this.last_get_task_award_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivity_id(int _v_)
/*      */     {
/* 1174 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1175 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setJoin_time(long _v_)
/*      */     {
/* 1182 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1183 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setJoin_level(int _v_)
/*      */     {
/* 1190 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1191 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setJoin_recharge(int _v_)
/*      */     {
/* 1198 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1199 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSign_count(int _v_)
/*      */     {
/* 1206 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1207 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_sign_time(long _v_)
/*      */     {
/* 1214 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1215 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_get_point_award_time(long _v_)
/*      */     {
/* 1222 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1223 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLogin_count(int _v_)
/*      */     {
/* 1230 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1231 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_login_time(long _v_)
/*      */     {
/* 1238 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1239 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHave_got_back_game_award(boolean _v_)
/*      */     {
/* 1246 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1247 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_buy_gift_time(long _v_)
/*      */     {
/* 1254 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1255 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_get_task_award_time(long _v_)
/*      */     {
/* 1262 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1263 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1269 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1270 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1276 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1277 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1283 */       return BackGameActivityInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1289 */       return BackGameActivityInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1295 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1296 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1302 */       return BackGameActivityInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1308 */       return BackGameActivityInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1314 */       BackGameActivityInfo.this._xdb_verify_unsafe_();
/* 1315 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1321 */       return BackGameActivityInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1327 */       return BackGameActivityInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1333 */       return BackGameActivityInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1339 */       return BackGameActivityInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1345 */       return BackGameActivityInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1351 */       return BackGameActivityInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1357 */       return BackGameActivityInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.BackGameActivityInfo
/*      */   {
/*      */     private int activity_id;
/*      */     
/*      */     private long join_time;
/*      */     
/*      */     private int join_level;
/*      */     
/*      */     private int join_recharge;
/*      */     
/*      */     private int sign_count;
/*      */     
/*      */     private long last_sign_time;
/*      */     
/*      */     private ArrayList<Integer> already_get_point_awards;
/*      */     
/*      */     private long last_get_point_award_time;
/*      */     
/*      */     private ArrayList<Integer> already_get_exp_awards;
/*      */     
/*      */     private int login_count;
/*      */     
/*      */     private long last_login_time;
/*      */     
/*      */     private boolean have_got_back_game_award;
/*      */     
/*      */     private HashMap<Integer, Integer> gift_buy_count_map;
/*      */     
/*      */     private long last_buy_gift_time;
/*      */     
/*      */     private long last_get_task_award_time;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1397 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1402 */       this.already_get_point_awards = new ArrayList();
/* 1403 */       this.already_get_exp_awards = new ArrayList();
/* 1404 */       this.gift_buy_count_map = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.BackGameActivityInfo _o1_)
/*      */     {
/* 1409 */       if ((_o1_ instanceof BackGameActivityInfo)) { assign((BackGameActivityInfo)_o1_);
/* 1410 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1411 */       } else if ((_o1_ instanceof BackGameActivityInfo.Const)) assign(((BackGameActivityInfo.Const)_o1_).nThis()); else {
/* 1412 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(BackGameActivityInfo _o_) {
/* 1417 */       this.activity_id = _o_.activity_id;
/* 1418 */       this.join_time = _o_.join_time;
/* 1419 */       this.join_level = _o_.join_level;
/* 1420 */       this.join_recharge = _o_.join_recharge;
/* 1421 */       this.sign_count = _o_.sign_count;
/* 1422 */       this.last_sign_time = _o_.last_sign_time;
/* 1423 */       this.already_get_point_awards = new ArrayList();
/* 1424 */       this.already_get_point_awards.addAll(_o_.already_get_point_awards);
/* 1425 */       this.last_get_point_award_time = _o_.last_get_point_award_time;
/* 1426 */       this.already_get_exp_awards = new ArrayList();
/* 1427 */       this.already_get_exp_awards.addAll(_o_.already_get_exp_awards);
/* 1428 */       this.login_count = _o_.login_count;
/* 1429 */       this.last_login_time = _o_.last_login_time;
/* 1430 */       this.have_got_back_game_award = _o_.have_got_back_game_award;
/* 1431 */       this.gift_buy_count_map = new HashMap();
/* 1432 */       for (Map.Entry<Integer, Integer> _e_ : _o_.gift_buy_count_map.entrySet())
/* 1433 */         this.gift_buy_count_map.put(_e_.getKey(), _e_.getValue());
/* 1434 */       this.last_buy_gift_time = _o_.last_buy_gift_time;
/* 1435 */       this.last_get_task_award_time = _o_.last_get_task_award_time;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1440 */       this.activity_id = _o_.activity_id;
/* 1441 */       this.join_time = _o_.join_time;
/* 1442 */       this.join_level = _o_.join_level;
/* 1443 */       this.join_recharge = _o_.join_recharge;
/* 1444 */       this.sign_count = _o_.sign_count;
/* 1445 */       this.last_sign_time = _o_.last_sign_time;
/* 1446 */       this.already_get_point_awards = new ArrayList();
/* 1447 */       this.already_get_point_awards.addAll(_o_.already_get_point_awards);
/* 1448 */       this.last_get_point_award_time = _o_.last_get_point_award_time;
/* 1449 */       this.already_get_exp_awards = new ArrayList();
/* 1450 */       this.already_get_exp_awards.addAll(_o_.already_get_exp_awards);
/* 1451 */       this.login_count = _o_.login_count;
/* 1452 */       this.last_login_time = _o_.last_login_time;
/* 1453 */       this.have_got_back_game_award = _o_.have_got_back_game_award;
/* 1454 */       this.gift_buy_count_map = new HashMap();
/* 1455 */       for (Map.Entry<Integer, Integer> _e_ : _o_.gift_buy_count_map.entrySet())
/* 1456 */         this.gift_buy_count_map.put(_e_.getKey(), _e_.getValue());
/* 1457 */       this.last_buy_gift_time = _o_.last_buy_gift_time;
/* 1458 */       this.last_get_task_award_time = _o_.last_get_task_award_time;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1464 */       _os_.marshal(this.activity_id);
/* 1465 */       _os_.marshal(this.join_time);
/* 1466 */       _os_.marshal(this.join_level);
/* 1467 */       _os_.marshal(this.join_recharge);
/* 1468 */       _os_.marshal(this.sign_count);
/* 1469 */       _os_.marshal(this.last_sign_time);
/* 1470 */       _os_.compact_uint32(this.already_get_point_awards.size());
/* 1471 */       for (Integer _v_ : this.already_get_point_awards)
/*      */       {
/* 1473 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1475 */       _os_.marshal(this.last_get_point_award_time);
/* 1476 */       _os_.compact_uint32(this.already_get_exp_awards.size());
/* 1477 */       for (Integer _v_ : this.already_get_exp_awards)
/*      */       {
/* 1479 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1481 */       _os_.marshal(this.login_count);
/* 1482 */       _os_.marshal(this.last_login_time);
/* 1483 */       _os_.marshal(this.have_got_back_game_award);
/* 1484 */       _os_.compact_uint32(this.gift_buy_count_map.size());
/* 1485 */       for (Map.Entry<Integer, Integer> _e_ : this.gift_buy_count_map.entrySet())
/*      */       {
/* 1487 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1488 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1490 */       _os_.marshal(this.last_buy_gift_time);
/* 1491 */       _os_.marshal(this.last_get_task_award_time);
/* 1492 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1498 */       this.activity_id = _os_.unmarshal_int();
/* 1499 */       this.join_time = _os_.unmarshal_long();
/* 1500 */       this.join_level = _os_.unmarshal_int();
/* 1501 */       this.join_recharge = _os_.unmarshal_int();
/* 1502 */       this.sign_count = _os_.unmarshal_int();
/* 1503 */       this.last_sign_time = _os_.unmarshal_long();
/* 1504 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1506 */         int _v_ = 0;
/* 1507 */         _v_ = _os_.unmarshal_int();
/* 1508 */         this.already_get_point_awards.add(Integer.valueOf(_v_));
/*      */       }
/* 1510 */       this.last_get_point_award_time = _os_.unmarshal_long();
/* 1511 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1513 */         int _v_ = 0;
/* 1514 */         _v_ = _os_.unmarshal_int();
/* 1515 */         this.already_get_exp_awards.add(Integer.valueOf(_v_));
/*      */       }
/* 1517 */       this.login_count = _os_.unmarshal_int();
/* 1518 */       this.last_login_time = _os_.unmarshal_long();
/* 1519 */       this.have_got_back_game_award = _os_.unmarshal_boolean();
/*      */       
/* 1521 */       int size = _os_.uncompact_uint32();
/* 1522 */       if (size >= 12)
/*      */       {
/* 1524 */         this.gift_buy_count_map = new HashMap(size * 2);
/*      */       }
/* 1526 */       for (; size > 0; size--)
/*      */       {
/* 1528 */         int _k_ = 0;
/* 1529 */         _k_ = _os_.unmarshal_int();
/* 1530 */         int _v_ = 0;
/* 1531 */         _v_ = _os_.unmarshal_int();
/* 1532 */         this.gift_buy_count_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1535 */       this.last_buy_gift_time = _os_.unmarshal_long();
/* 1536 */       this.last_get_task_award_time = _os_.unmarshal_long();
/* 1537 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1543 */       int _size_ = 0;
/* 1544 */       _size_ += CodedOutputStream.computeInt32Size(1, this.activity_id);
/* 1545 */       _size_ += CodedOutputStream.computeInt64Size(2, this.join_time);
/* 1546 */       _size_ += CodedOutputStream.computeInt32Size(3, this.join_level);
/* 1547 */       _size_ += CodedOutputStream.computeInt32Size(4, this.join_recharge);
/* 1548 */       _size_ += CodedOutputStream.computeInt32Size(5, this.sign_count);
/* 1549 */       _size_ += CodedOutputStream.computeInt64Size(6, this.last_sign_time);
/* 1550 */       for (Integer _v_ : this.already_get_point_awards)
/*      */       {
/* 1552 */         _size_ += CodedOutputStream.computeInt32Size(7, _v_.intValue());
/*      */       }
/* 1554 */       _size_ += CodedOutputStream.computeInt64Size(8, this.last_get_point_award_time);
/* 1555 */       for (Integer _v_ : this.already_get_exp_awards)
/*      */       {
/* 1557 */         _size_ += CodedOutputStream.computeInt32Size(9, _v_.intValue());
/*      */       }
/* 1559 */       _size_ += CodedOutputStream.computeInt32Size(10, this.login_count);
/* 1560 */       _size_ += CodedOutputStream.computeInt64Size(11, this.last_login_time);
/* 1561 */       _size_ += CodedOutputStream.computeBoolSize(12, this.have_got_back_game_award);
/* 1562 */       for (Map.Entry<Integer, Integer> _e_ : this.gift_buy_count_map.entrySet())
/*      */       {
/* 1564 */         _size_ += CodedOutputStream.computeInt32Size(13, ((Integer)_e_.getKey()).intValue());
/* 1565 */         _size_ += CodedOutputStream.computeInt32Size(13, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1567 */       _size_ += CodedOutputStream.computeInt64Size(14, this.last_buy_gift_time);
/* 1568 */       _size_ += CodedOutputStream.computeInt64Size(15, this.last_get_task_award_time);
/* 1569 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1577 */         _output_.writeInt32(1, this.activity_id);
/* 1578 */         _output_.writeInt64(2, this.join_time);
/* 1579 */         _output_.writeInt32(3, this.join_level);
/* 1580 */         _output_.writeInt32(4, this.join_recharge);
/* 1581 */         _output_.writeInt32(5, this.sign_count);
/* 1582 */         _output_.writeInt64(6, this.last_sign_time);
/* 1583 */         for (Integer _v_ : this.already_get_point_awards)
/*      */         {
/* 1585 */           _output_.writeInt32(7, _v_.intValue());
/*      */         }
/* 1587 */         _output_.writeInt64(8, this.last_get_point_award_time);
/* 1588 */         for (Integer _v_ : this.already_get_exp_awards)
/*      */         {
/* 1590 */           _output_.writeInt32(9, _v_.intValue());
/*      */         }
/* 1592 */         _output_.writeInt32(10, this.login_count);
/* 1593 */         _output_.writeInt64(11, this.last_login_time);
/* 1594 */         _output_.writeBool(12, this.have_got_back_game_award);
/* 1595 */         for (Map.Entry<Integer, Integer> _e_ : this.gift_buy_count_map.entrySet())
/*      */         {
/* 1597 */           _output_.writeInt32(13, ((Integer)_e_.getKey()).intValue());
/* 1598 */           _output_.writeInt32(13, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1600 */         _output_.writeInt64(14, this.last_buy_gift_time);
/* 1601 */         _output_.writeInt64(15, this.last_get_task_award_time);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1605 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1607 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1615 */         boolean done = false;
/* 1616 */         while (!done)
/*      */         {
/* 1618 */           int tag = _input_.readTag();
/* 1619 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1623 */             done = true;
/* 1624 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1628 */             this.activity_id = _input_.readInt32();
/* 1629 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1633 */             this.join_time = _input_.readInt64();
/* 1634 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1638 */             this.join_level = _input_.readInt32();
/* 1639 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1643 */             this.join_recharge = _input_.readInt32();
/* 1644 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1648 */             this.sign_count = _input_.readInt32();
/* 1649 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1653 */             this.last_sign_time = _input_.readInt64();
/* 1654 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1658 */             int _v_ = 0;
/* 1659 */             _v_ = _input_.readInt32();
/* 1660 */             this.already_get_point_awards.add(Integer.valueOf(_v_));
/* 1661 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1665 */             this.last_get_point_award_time = _input_.readInt64();
/* 1666 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1670 */             int _v_ = 0;
/* 1671 */             _v_ = _input_.readInt32();
/* 1672 */             this.already_get_exp_awards.add(Integer.valueOf(_v_));
/* 1673 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1677 */             this.login_count = _input_.readInt32();
/* 1678 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1682 */             this.last_login_time = _input_.readInt64();
/* 1683 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 1687 */             this.have_got_back_game_award = _input_.readBool();
/* 1688 */             break;
/*      */           
/*      */ 
/*      */           case 104: 
/* 1692 */             int _k_ = 0;
/* 1693 */             _k_ = _input_.readInt32();
/* 1694 */             int readTag = _input_.readTag();
/* 1695 */             if (104 != readTag)
/*      */             {
/* 1697 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1699 */             int _v_ = 0;
/* 1700 */             _v_ = _input_.readInt32();
/* 1701 */             this.gift_buy_count_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1702 */             break;
/*      */           
/*      */ 
/*      */           case 112: 
/* 1706 */             this.last_buy_gift_time = _input_.readInt64();
/* 1707 */             break;
/*      */           
/*      */ 
/*      */           case 120: 
/* 1711 */             this.last_get_task_award_time = _input_.readInt64();
/* 1712 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1716 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1718 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1727 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1731 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1733 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BackGameActivityInfo copy()
/*      */     {
/* 1739 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BackGameActivityInfo toData()
/*      */     {
/* 1745 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.BackGameActivityInfo toBean()
/*      */     {
/* 1750 */       return new BackGameActivityInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BackGameActivityInfo toDataIf()
/*      */     {
/* 1756 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.BackGameActivityInfo toBeanIf()
/*      */     {
/* 1761 */       return new BackGameActivityInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1767 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1771 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1775 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1779 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1783 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1787 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1791 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActivity_id()
/*      */     {
/* 1798 */       return this.activity_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getJoin_time()
/*      */     {
/* 1805 */       return this.join_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getJoin_level()
/*      */     {
/* 1812 */       return this.join_level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getJoin_recharge()
/*      */     {
/* 1819 */       return this.join_recharge;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSign_count()
/*      */     {
/* 1826 */       return this.sign_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_sign_time()
/*      */     {
/* 1833 */       return this.last_sign_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getAlready_get_point_awards()
/*      */     {
/* 1840 */       return this.already_get_point_awards;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getAlready_get_point_awardsAsData()
/*      */     {
/* 1847 */       return this.already_get_point_awards;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_get_point_award_time()
/*      */     {
/* 1854 */       return this.last_get_point_award_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getAlready_get_exp_awards()
/*      */     {
/* 1861 */       return this.already_get_exp_awards;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getAlready_get_exp_awardsAsData()
/*      */     {
/* 1868 */       return this.already_get_exp_awards;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLogin_count()
/*      */     {
/* 1875 */       return this.login_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_login_time()
/*      */     {
/* 1882 */       return this.last_login_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getHave_got_back_game_award()
/*      */     {
/* 1889 */       return this.have_got_back_game_award;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getGift_buy_count_map()
/*      */     {
/* 1896 */       return this.gift_buy_count_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getGift_buy_count_mapAsData()
/*      */     {
/* 1903 */       return this.gift_buy_count_map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_buy_gift_time()
/*      */     {
/* 1910 */       return this.last_buy_gift_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_get_task_award_time()
/*      */     {
/* 1917 */       return this.last_get_task_award_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivity_id(int _v_)
/*      */     {
/* 1924 */       this.activity_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setJoin_time(long _v_)
/*      */     {
/* 1931 */       this.join_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setJoin_level(int _v_)
/*      */     {
/* 1938 */       this.join_level = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setJoin_recharge(int _v_)
/*      */     {
/* 1945 */       this.join_recharge = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSign_count(int _v_)
/*      */     {
/* 1952 */       this.sign_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_sign_time(long _v_)
/*      */     {
/* 1959 */       this.last_sign_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_get_point_award_time(long _v_)
/*      */     {
/* 1966 */       this.last_get_point_award_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLogin_count(int _v_)
/*      */     {
/* 1973 */       this.login_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_login_time(long _v_)
/*      */     {
/* 1980 */       this.last_login_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHave_got_back_game_award(boolean _v_)
/*      */     {
/* 1987 */       this.have_got_back_game_award = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_buy_gift_time(long _v_)
/*      */     {
/* 1994 */       this.last_buy_gift_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_get_task_award_time(long _v_)
/*      */     {
/* 2001 */       this.last_get_task_award_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 2007 */       if (!(_o1_ instanceof Data)) return false;
/* 2008 */       Data _o_ = (Data)_o1_;
/* 2009 */       if (this.activity_id != _o_.activity_id) return false;
/* 2010 */       if (this.join_time != _o_.join_time) return false;
/* 2011 */       if (this.join_level != _o_.join_level) return false;
/* 2012 */       if (this.join_recharge != _o_.join_recharge) return false;
/* 2013 */       if (this.sign_count != _o_.sign_count) return false;
/* 2014 */       if (this.last_sign_time != _o_.last_sign_time) return false;
/* 2015 */       if (!this.already_get_point_awards.equals(_o_.already_get_point_awards)) return false;
/* 2016 */       if (this.last_get_point_award_time != _o_.last_get_point_award_time) return false;
/* 2017 */       if (!this.already_get_exp_awards.equals(_o_.already_get_exp_awards)) return false;
/* 2018 */       if (this.login_count != _o_.login_count) return false;
/* 2019 */       if (this.last_login_time != _o_.last_login_time) return false;
/* 2020 */       if (this.have_got_back_game_award != _o_.have_got_back_game_award) return false;
/* 2021 */       if (!this.gift_buy_count_map.equals(_o_.gift_buy_count_map)) return false;
/* 2022 */       if (this.last_buy_gift_time != _o_.last_buy_gift_time) return false;
/* 2023 */       if (this.last_get_task_award_time != _o_.last_get_task_award_time) return false;
/* 2024 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 2030 */       int _h_ = 0;
/* 2031 */       _h_ += this.activity_id;
/* 2032 */       _h_ = (int)(_h_ + this.join_time);
/* 2033 */       _h_ += this.join_level;
/* 2034 */       _h_ += this.join_recharge;
/* 2035 */       _h_ += this.sign_count;
/* 2036 */       _h_ = (int)(_h_ + this.last_sign_time);
/* 2037 */       _h_ += this.already_get_point_awards.hashCode();
/* 2038 */       _h_ = (int)(_h_ + this.last_get_point_award_time);
/* 2039 */       _h_ += this.already_get_exp_awards.hashCode();
/* 2040 */       _h_ += this.login_count;
/* 2041 */       _h_ = (int)(_h_ + this.last_login_time);
/* 2042 */       _h_ += (this.have_got_back_game_award ? 1231 : 1237);
/* 2043 */       _h_ += this.gift_buy_count_map.hashCode();
/* 2044 */       _h_ = (int)(_h_ + this.last_buy_gift_time);
/* 2045 */       _h_ = (int)(_h_ + this.last_get_task_award_time);
/* 2046 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 2052 */       StringBuilder _sb_ = new StringBuilder();
/* 2053 */       _sb_.append("(");
/* 2054 */       _sb_.append(this.activity_id);
/* 2055 */       _sb_.append(",");
/* 2056 */       _sb_.append(this.join_time);
/* 2057 */       _sb_.append(",");
/* 2058 */       _sb_.append(this.join_level);
/* 2059 */       _sb_.append(",");
/* 2060 */       _sb_.append(this.join_recharge);
/* 2061 */       _sb_.append(",");
/* 2062 */       _sb_.append(this.sign_count);
/* 2063 */       _sb_.append(",");
/* 2064 */       _sb_.append(this.last_sign_time);
/* 2065 */       _sb_.append(",");
/* 2066 */       _sb_.append(this.already_get_point_awards);
/* 2067 */       _sb_.append(",");
/* 2068 */       _sb_.append(this.last_get_point_award_time);
/* 2069 */       _sb_.append(",");
/* 2070 */       _sb_.append(this.already_get_exp_awards);
/* 2071 */       _sb_.append(",");
/* 2072 */       _sb_.append(this.login_count);
/* 2073 */       _sb_.append(",");
/* 2074 */       _sb_.append(this.last_login_time);
/* 2075 */       _sb_.append(",");
/* 2076 */       _sb_.append(this.have_got_back_game_award);
/* 2077 */       _sb_.append(",");
/* 2078 */       _sb_.append(this.gift_buy_count_map);
/* 2079 */       _sb_.append(",");
/* 2080 */       _sb_.append(this.last_buy_gift_time);
/* 2081 */       _sb_.append(",");
/* 2082 */       _sb_.append(this.last_get_task_award_time);
/* 2083 */       _sb_.append(")");
/* 2084 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\BackGameActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */