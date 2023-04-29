/*      */ package xbean.__;
/*      */ 
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
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class BreakEggGameInfo extends XBean implements xbean.BreakEggGameInfo
/*      */ {
/*      */   private long session_id;
/*      */   private int activity_id;
/*      */   private long inviter_id;
/*      */   private ArrayList<Long> roleid_list;
/*      */   private ArrayList<Integer> reward_info_id;
/*      */   private HashMap<Integer, xbean.BreakEggInfo> index2break_egg_info;
/*      */   private HashMap<Long, Integer> role_id2break_num;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.session_id = -1L;
/*   31 */     this.activity_id = 0;
/*   32 */     this.inviter_id = 0L;
/*   33 */     this.roleid_list.clear();
/*   34 */     this.reward_info_id.clear();
/*   35 */     this.index2break_egg_info.clear();
/*   36 */     this.role_id2break_num.clear();
/*      */   }
/*      */   
/*      */   BreakEggGameInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.session_id = -1L;
/*   43 */     this.activity_id = 0;
/*   44 */     this.inviter_id = 0L;
/*   45 */     this.roleid_list = new ArrayList();
/*   46 */     this.reward_info_id = new ArrayList();
/*   47 */     this.index2break_egg_info = new HashMap();
/*   48 */     this.role_id2break_num = new HashMap();
/*      */   }
/*      */   
/*      */   public BreakEggGameInfo()
/*      */   {
/*   53 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public BreakEggGameInfo(BreakEggGameInfo _o_)
/*      */   {
/*   58 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   BreakEggGameInfo(xbean.BreakEggGameInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   63 */     super(_xp_, _vn_);
/*   64 */     if ((_o1_ instanceof BreakEggGameInfo)) { assign((BreakEggGameInfo)_o1_);
/*   65 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   66 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   67 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(BreakEggGameInfo _o_) {
/*   72 */     _o_._xdb_verify_unsafe_();
/*   73 */     this.session_id = _o_.session_id;
/*   74 */     this.activity_id = _o_.activity_id;
/*   75 */     this.inviter_id = _o_.inviter_id;
/*   76 */     this.roleid_list = new ArrayList();
/*   77 */     this.roleid_list.addAll(_o_.roleid_list);
/*   78 */     this.reward_info_id = new ArrayList();
/*   79 */     this.reward_info_id.addAll(_o_.reward_info_id);
/*   80 */     this.index2break_egg_info = new HashMap();
/*   81 */     for (Map.Entry<Integer, xbean.BreakEggInfo> _e_ : _o_.index2break_egg_info.entrySet())
/*   82 */       this.index2break_egg_info.put(_e_.getKey(), new BreakEggInfo((xbean.BreakEggInfo)_e_.getValue(), this, "index2break_egg_info"));
/*   83 */     this.role_id2break_num = new HashMap();
/*   84 */     for (Map.Entry<Long, Integer> _e_ : _o_.role_id2break_num.entrySet()) {
/*   85 */       this.role_id2break_num.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   90 */     this.session_id = _o_.session_id;
/*   91 */     this.activity_id = _o_.activity_id;
/*   92 */     this.inviter_id = _o_.inviter_id;
/*   93 */     this.roleid_list = new ArrayList();
/*   94 */     this.roleid_list.addAll(_o_.roleid_list);
/*   95 */     this.reward_info_id = new ArrayList();
/*   96 */     this.reward_info_id.addAll(_o_.reward_info_id);
/*   97 */     this.index2break_egg_info = new HashMap();
/*   98 */     for (Map.Entry<Integer, xbean.BreakEggInfo> _e_ : _o_.index2break_egg_info.entrySet())
/*   99 */       this.index2break_egg_info.put(_e_.getKey(), new BreakEggInfo((xbean.BreakEggInfo)_e_.getValue(), this, "index2break_egg_info"));
/*  100 */     this.role_id2break_num = new HashMap();
/*  101 */     for (Map.Entry<Long, Integer> _e_ : _o_.role_id2break_num.entrySet()) {
/*  102 */       this.role_id2break_num.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  108 */     _xdb_verify_unsafe_();
/*  109 */     _os_.marshal(this.session_id);
/*  110 */     _os_.marshal(this.activity_id);
/*  111 */     _os_.marshal(this.inviter_id);
/*  112 */     _os_.compact_uint32(this.roleid_list.size());
/*  113 */     for (Long _v_ : this.roleid_list)
/*      */     {
/*  115 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  117 */     _os_.compact_uint32(this.reward_info_id.size());
/*  118 */     for (Integer _v_ : this.reward_info_id)
/*      */     {
/*  120 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  122 */     _os_.compact_uint32(this.index2break_egg_info.size());
/*  123 */     for (Map.Entry<Integer, xbean.BreakEggInfo> _e_ : this.index2break_egg_info.entrySet())
/*      */     {
/*  125 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  126 */       ((xbean.BreakEggInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  128 */     _os_.compact_uint32(this.role_id2break_num.size());
/*  129 */     for (Map.Entry<Long, Integer> _e_ : this.role_id2break_num.entrySet())
/*      */     {
/*  131 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  132 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  134 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  140 */     _xdb_verify_unsafe_();
/*  141 */     this.session_id = _os_.unmarshal_long();
/*  142 */     this.activity_id = _os_.unmarshal_int();
/*  143 */     this.inviter_id = _os_.unmarshal_long();
/*  144 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  146 */       long _v_ = 0L;
/*  147 */       _v_ = _os_.unmarshal_long();
/*  148 */       this.roleid_list.add(Long.valueOf(_v_));
/*      */     }
/*  150 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  152 */       int _v_ = 0;
/*  153 */       _v_ = _os_.unmarshal_int();
/*  154 */       this.reward_info_id.add(Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  157 */     int size = _os_.uncompact_uint32();
/*  158 */     if (size >= 12)
/*      */     {
/*  160 */       this.index2break_egg_info = new HashMap(size * 2);
/*      */     }
/*  162 */     for (; size > 0; size--)
/*      */     {
/*  164 */       int _k_ = 0;
/*  165 */       _k_ = _os_.unmarshal_int();
/*  166 */       xbean.BreakEggInfo _v_ = new BreakEggInfo(0, this, "index2break_egg_info");
/*  167 */       _v_.unmarshal(_os_);
/*  168 */       this.index2break_egg_info.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  172 */     int size = _os_.uncompact_uint32();
/*  173 */     if (size >= 12)
/*      */     {
/*  175 */       this.role_id2break_num = new HashMap(size * 2);
/*      */     }
/*  177 */     for (; size > 0; size--)
/*      */     {
/*  179 */       long _k_ = 0L;
/*  180 */       _k_ = _os_.unmarshal_long();
/*  181 */       int _v_ = 0;
/*  182 */       _v_ = _os_.unmarshal_int();
/*  183 */       this.role_id2break_num.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  186 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  192 */     _xdb_verify_unsafe_();
/*  193 */     int _size_ = 0;
/*  194 */     _size_ += CodedOutputStream.computeInt64Size(1, this.session_id);
/*  195 */     _size_ += CodedOutputStream.computeInt32Size(2, this.activity_id);
/*  196 */     _size_ += CodedOutputStream.computeInt64Size(3, this.inviter_id);
/*  197 */     for (Long _v_ : this.roleid_list)
/*      */     {
/*  199 */       _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */     }
/*  201 */     for (Integer _v_ : this.reward_info_id)
/*      */     {
/*  203 */       _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */     }
/*  205 */     for (Map.Entry<Integer, xbean.BreakEggInfo> _e_ : this.index2break_egg_info.entrySet())
/*      */     {
/*  207 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/*  208 */       _size_ += CodedOutputStream.computeMessageSize(6, (ppbio.Message)_e_.getValue());
/*      */     }
/*  210 */     for (Map.Entry<Long, Integer> _e_ : this.role_id2break_num.entrySet())
/*      */     {
/*  212 */       _size_ += CodedOutputStream.computeInt64Size(7, ((Long)_e_.getKey()).longValue());
/*  213 */       _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  215 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  221 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  224 */       _output_.writeInt64(1, this.session_id);
/*  225 */       _output_.writeInt32(2, this.activity_id);
/*  226 */       _output_.writeInt64(3, this.inviter_id);
/*  227 */       for (Long _v_ : this.roleid_list)
/*      */       {
/*  229 */         _output_.writeInt64(4, _v_.longValue());
/*      */       }
/*  231 */       for (Integer _v_ : this.reward_info_id)
/*      */       {
/*  233 */         _output_.writeInt32(5, _v_.intValue());
/*      */       }
/*  235 */       for (Map.Entry<Integer, xbean.BreakEggInfo> _e_ : this.index2break_egg_info.entrySet())
/*      */       {
/*  237 */         _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/*  238 */         _output_.writeMessage(6, (ppbio.Message)_e_.getValue());
/*      */       }
/*  240 */       for (Map.Entry<Long, Integer> _e_ : this.role_id2break_num.entrySet())
/*      */       {
/*  242 */         _output_.writeInt64(7, ((Long)_e_.getKey()).longValue());
/*  243 */         _output_.writeInt32(7, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  248 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  250 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  256 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  259 */       boolean done = false;
/*  260 */       while (!done)
/*      */       {
/*  262 */         int tag = _input_.readTag();
/*  263 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  267 */           done = true;
/*  268 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  272 */           this.session_id = _input_.readInt64();
/*  273 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  277 */           this.activity_id = _input_.readInt32();
/*  278 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  282 */           this.inviter_id = _input_.readInt64();
/*  283 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  287 */           long _v_ = 0L;
/*  288 */           _v_ = _input_.readInt64();
/*  289 */           this.roleid_list.add(Long.valueOf(_v_));
/*  290 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  294 */           int _v_ = 0;
/*  295 */           _v_ = _input_.readInt32();
/*  296 */           this.reward_info_id.add(Integer.valueOf(_v_));
/*  297 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  301 */           int _k_ = 0;
/*  302 */           _k_ = _input_.readInt32();
/*  303 */           int readTag = _input_.readTag();
/*  304 */           if (50 != readTag)
/*      */           {
/*  306 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  308 */           xbean.BreakEggInfo _v_ = new BreakEggInfo(0, this, "index2break_egg_info");
/*  309 */           _input_.readMessage(_v_);
/*  310 */           this.index2break_egg_info.put(Integer.valueOf(_k_), _v_);
/*  311 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  315 */           long _k_ = 0L;
/*  316 */           _k_ = _input_.readInt64();
/*  317 */           int readTag = _input_.readTag();
/*  318 */           if (56 != readTag)
/*      */           {
/*  320 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  322 */           int _v_ = 0;
/*  323 */           _v_ = _input_.readInt32();
/*  324 */           this.role_id2break_num.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  325 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  329 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  331 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  340 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  344 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  346 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BreakEggGameInfo copy()
/*      */   {
/*  352 */     _xdb_verify_unsafe_();
/*  353 */     return new BreakEggGameInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BreakEggGameInfo toData()
/*      */   {
/*  359 */     _xdb_verify_unsafe_();
/*  360 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BreakEggGameInfo toBean()
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*  366 */     return new BreakEggGameInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BreakEggGameInfo toDataIf()
/*      */   {
/*  372 */     _xdb_verify_unsafe_();
/*  373 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BreakEggGameInfo toBeanIf()
/*      */   {
/*  378 */     _xdb_verify_unsafe_();
/*  379 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  385 */     _xdb_verify_unsafe_();
/*  386 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSession_id()
/*      */   {
/*  393 */     _xdb_verify_unsafe_();
/*  394 */     return this.session_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getActivity_id()
/*      */   {
/*  401 */     _xdb_verify_unsafe_();
/*  402 */     return this.activity_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getInviter_id()
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     return this.inviter_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getRoleid_list()
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     return xdb.Logs.logList(new LogKey(this, "roleid_list"), this.roleid_list);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getRoleid_listAsData()
/*      */   {
/*  424 */     _xdb_verify_unsafe_();
/*      */     
/*  426 */     BreakEggGameInfo _o_ = this;
/*  427 */     List<Long> roleid_list = new ArrayList();
/*  428 */     roleid_list.addAll(_o_.roleid_list);
/*  429 */     return roleid_list;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getReward_info_id()
/*      */   {
/*  436 */     _xdb_verify_unsafe_();
/*  437 */     return xdb.Logs.logList(new LogKey(this, "reward_info_id"), this.reward_info_id);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getReward_info_idAsData()
/*      */   {
/*  443 */     _xdb_verify_unsafe_();
/*      */     
/*  445 */     BreakEggGameInfo _o_ = this;
/*  446 */     List<Integer> reward_info_id = new ArrayList();
/*  447 */     reward_info_id.addAll(_o_.reward_info_id);
/*  448 */     return reward_info_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.BreakEggInfo> getIndex2break_egg_info()
/*      */   {
/*  455 */     _xdb_verify_unsafe_();
/*  456 */     return xdb.Logs.logMap(new LogKey(this, "index2break_egg_info"), this.index2break_egg_info);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.BreakEggInfo> getIndex2break_egg_infoAsData()
/*      */   {
/*  463 */     _xdb_verify_unsafe_();
/*      */     
/*  465 */     BreakEggGameInfo _o_ = this;
/*  466 */     Map<Integer, xbean.BreakEggInfo> index2break_egg_info = new HashMap();
/*  467 */     for (Map.Entry<Integer, xbean.BreakEggInfo> _e_ : _o_.index2break_egg_info.entrySet())
/*  468 */       index2break_egg_info.put(_e_.getKey(), new BreakEggInfo.Data((xbean.BreakEggInfo)_e_.getValue()));
/*  469 */     return index2break_egg_info;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getRole_id2break_num()
/*      */   {
/*  476 */     _xdb_verify_unsafe_();
/*  477 */     return xdb.Logs.logMap(new LogKey(this, "role_id2break_num"), this.role_id2break_num);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getRole_id2break_numAsData()
/*      */   {
/*  484 */     _xdb_verify_unsafe_();
/*      */     
/*  486 */     BreakEggGameInfo _o_ = this;
/*  487 */     Map<Long, Integer> role_id2break_num = new HashMap();
/*  488 */     for (Map.Entry<Long, Integer> _e_ : _o_.role_id2break_num.entrySet())
/*  489 */       role_id2break_num.put(_e_.getKey(), _e_.getValue());
/*  490 */     return role_id2break_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSession_id(long _v_)
/*      */   {
/*  497 */     _xdb_verify_unsafe_();
/*  498 */     xdb.Logs.logIf(new LogKey(this, "session_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  502 */         new xdb.logs.LogLong(this, BreakEggGameInfo.this.session_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  506 */             BreakEggGameInfo.this.session_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  510 */     });
/*  511 */     this.session_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActivity_id(int _v_)
/*      */   {
/*  518 */     _xdb_verify_unsafe_();
/*  519 */     xdb.Logs.logIf(new LogKey(this, "activity_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  523 */         new xdb.logs.LogInt(this, BreakEggGameInfo.this.activity_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  527 */             BreakEggGameInfo.this.activity_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  531 */     });
/*  532 */     this.activity_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInviter_id(long _v_)
/*      */   {
/*  539 */     _xdb_verify_unsafe_();
/*  540 */     xdb.Logs.logIf(new LogKey(this, "inviter_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  544 */         new xdb.logs.LogLong(this, BreakEggGameInfo.this.inviter_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  548 */             BreakEggGameInfo.this.inviter_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  552 */     });
/*  553 */     this.inviter_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  559 */     _xdb_verify_unsafe_();
/*  560 */     BreakEggGameInfo _o_ = null;
/*  561 */     if ((_o1_ instanceof BreakEggGameInfo)) { _o_ = (BreakEggGameInfo)_o1_;
/*  562 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  563 */       return false;
/*  564 */     if (this.session_id != _o_.session_id) return false;
/*  565 */     if (this.activity_id != _o_.activity_id) return false;
/*  566 */     if (this.inviter_id != _o_.inviter_id) return false;
/*  567 */     if (!this.roleid_list.equals(_o_.roleid_list)) return false;
/*  568 */     if (!this.reward_info_id.equals(_o_.reward_info_id)) return false;
/*  569 */     if (!this.index2break_egg_info.equals(_o_.index2break_egg_info)) return false;
/*  570 */     if (!this.role_id2break_num.equals(_o_.role_id2break_num)) return false;
/*  571 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  577 */     _xdb_verify_unsafe_();
/*  578 */     int _h_ = 0;
/*  579 */     _h_ = (int)(_h_ + this.session_id);
/*  580 */     _h_ += this.activity_id;
/*  581 */     _h_ = (int)(_h_ + this.inviter_id);
/*  582 */     _h_ += this.roleid_list.hashCode();
/*  583 */     _h_ += this.reward_info_id.hashCode();
/*  584 */     _h_ += this.index2break_egg_info.hashCode();
/*  585 */     _h_ += this.role_id2break_num.hashCode();
/*  586 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  592 */     _xdb_verify_unsafe_();
/*  593 */     StringBuilder _sb_ = new StringBuilder();
/*  594 */     _sb_.append("(");
/*  595 */     _sb_.append(this.session_id);
/*  596 */     _sb_.append(",");
/*  597 */     _sb_.append(this.activity_id);
/*  598 */     _sb_.append(",");
/*  599 */     _sb_.append(this.inviter_id);
/*  600 */     _sb_.append(",");
/*  601 */     _sb_.append(this.roleid_list);
/*  602 */     _sb_.append(",");
/*  603 */     _sb_.append(this.reward_info_id);
/*  604 */     _sb_.append(",");
/*  605 */     _sb_.append(this.index2break_egg_info);
/*  606 */     _sb_.append(",");
/*  607 */     _sb_.append(this.role_id2break_num);
/*  608 */     _sb_.append(")");
/*  609 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  615 */     ListenableBean lb = new ListenableBean();
/*  616 */     lb.add(new ListenableChanged().setVarName("session_id"));
/*  617 */     lb.add(new ListenableChanged().setVarName("activity_id"));
/*  618 */     lb.add(new ListenableChanged().setVarName("inviter_id"));
/*  619 */     lb.add(new ListenableChanged().setVarName("roleid_list"));
/*  620 */     lb.add(new ListenableChanged().setVarName("reward_info_id"));
/*  621 */     lb.add(new xdb.logs.ListenableMap().setVarName("index2break_egg_info"));
/*  622 */     lb.add(new xdb.logs.ListenableMap().setVarName("role_id2break_num"));
/*  623 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.BreakEggGameInfo {
/*      */     private Const() {}
/*      */     
/*      */     BreakEggGameInfo nThis() {
/*  630 */       return BreakEggGameInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  636 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BreakEggGameInfo copy()
/*      */     {
/*  642 */       return BreakEggGameInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BreakEggGameInfo toData()
/*      */     {
/*  648 */       return BreakEggGameInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.BreakEggGameInfo toBean()
/*      */     {
/*  653 */       return BreakEggGameInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BreakEggGameInfo toDataIf()
/*      */     {
/*  659 */       return BreakEggGameInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.BreakEggGameInfo toBeanIf()
/*      */     {
/*  664 */       return BreakEggGameInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSession_id()
/*      */     {
/*  671 */       BreakEggGameInfo.this._xdb_verify_unsafe_();
/*  672 */       return BreakEggGameInfo.this.session_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActivity_id()
/*      */     {
/*  679 */       BreakEggGameInfo.this._xdb_verify_unsafe_();
/*  680 */       return BreakEggGameInfo.this.activity_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInviter_id()
/*      */     {
/*  687 */       BreakEggGameInfo.this._xdb_verify_unsafe_();
/*  688 */       return BreakEggGameInfo.this.inviter_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRoleid_list()
/*      */     {
/*  695 */       BreakEggGameInfo.this._xdb_verify_unsafe_();
/*  696 */       return xdb.Consts.constList(BreakEggGameInfo.this.roleid_list);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getRoleid_listAsData()
/*      */     {
/*  702 */       BreakEggGameInfo.this._xdb_verify_unsafe_();
/*      */       
/*  704 */       BreakEggGameInfo _o_ = BreakEggGameInfo.this;
/*  705 */       List<Long> roleid_list = new ArrayList();
/*  706 */       roleid_list.addAll(_o_.roleid_list);
/*  707 */       return roleid_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getReward_info_id()
/*      */     {
/*  714 */       BreakEggGameInfo.this._xdb_verify_unsafe_();
/*  715 */       return xdb.Consts.constList(BreakEggGameInfo.this.reward_info_id);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getReward_info_idAsData()
/*      */     {
/*  721 */       BreakEggGameInfo.this._xdb_verify_unsafe_();
/*      */       
/*  723 */       BreakEggGameInfo _o_ = BreakEggGameInfo.this;
/*  724 */       List<Integer> reward_info_id = new ArrayList();
/*  725 */       reward_info_id.addAll(_o_.reward_info_id);
/*  726 */       return reward_info_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BreakEggInfo> getIndex2break_egg_info()
/*      */     {
/*  733 */       BreakEggGameInfo.this._xdb_verify_unsafe_();
/*  734 */       return xdb.Consts.constMap(BreakEggGameInfo.this.index2break_egg_info);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BreakEggInfo> getIndex2break_egg_infoAsData()
/*      */     {
/*  741 */       BreakEggGameInfo.this._xdb_verify_unsafe_();
/*      */       
/*  743 */       BreakEggGameInfo _o_ = BreakEggGameInfo.this;
/*  744 */       Map<Integer, xbean.BreakEggInfo> index2break_egg_info = new HashMap();
/*  745 */       for (Map.Entry<Integer, xbean.BreakEggInfo> _e_ : _o_.index2break_egg_info.entrySet())
/*  746 */         index2break_egg_info.put(_e_.getKey(), new BreakEggInfo.Data((xbean.BreakEggInfo)_e_.getValue()));
/*  747 */       return index2break_egg_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRole_id2break_num()
/*      */     {
/*  754 */       BreakEggGameInfo.this._xdb_verify_unsafe_();
/*  755 */       return xdb.Consts.constMap(BreakEggGameInfo.this.role_id2break_num);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRole_id2break_numAsData()
/*      */     {
/*  762 */       BreakEggGameInfo.this._xdb_verify_unsafe_();
/*      */       
/*  764 */       BreakEggGameInfo _o_ = BreakEggGameInfo.this;
/*  765 */       Map<Long, Integer> role_id2break_num = new HashMap();
/*  766 */       for (Map.Entry<Long, Integer> _e_ : _o_.role_id2break_num.entrySet())
/*  767 */         role_id2break_num.put(_e_.getKey(), _e_.getValue());
/*  768 */       return role_id2break_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSession_id(long _v_)
/*      */     {
/*  775 */       BreakEggGameInfo.this._xdb_verify_unsafe_();
/*  776 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivity_id(int _v_)
/*      */     {
/*  783 */       BreakEggGameInfo.this._xdb_verify_unsafe_();
/*  784 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInviter_id(long _v_)
/*      */     {
/*  791 */       BreakEggGameInfo.this._xdb_verify_unsafe_();
/*  792 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  798 */       BreakEggGameInfo.this._xdb_verify_unsafe_();
/*  799 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  805 */       BreakEggGameInfo.this._xdb_verify_unsafe_();
/*  806 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  812 */       return BreakEggGameInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  818 */       return BreakEggGameInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  824 */       BreakEggGameInfo.this._xdb_verify_unsafe_();
/*  825 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  831 */       return BreakEggGameInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  837 */       return BreakEggGameInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  843 */       BreakEggGameInfo.this._xdb_verify_unsafe_();
/*  844 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  850 */       return BreakEggGameInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  856 */       return BreakEggGameInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  862 */       return BreakEggGameInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  868 */       return BreakEggGameInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  874 */       return BreakEggGameInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  880 */       return BreakEggGameInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  886 */       return BreakEggGameInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.BreakEggGameInfo
/*      */   {
/*      */     private long session_id;
/*      */     
/*      */     private int activity_id;
/*      */     
/*      */     private long inviter_id;
/*      */     
/*      */     private ArrayList<Long> roleid_list;
/*      */     
/*      */     private ArrayList<Integer> reward_info_id;
/*      */     
/*      */     private HashMap<Integer, xbean.BreakEggInfo> index2break_egg_info;
/*      */     
/*      */     private HashMap<Long, Integer> role_id2break_num;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  910 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  915 */       this.session_id = -1L;
/*  916 */       this.activity_id = 0;
/*  917 */       this.inviter_id = 0L;
/*  918 */       this.roleid_list = new ArrayList();
/*  919 */       this.reward_info_id = new ArrayList();
/*  920 */       this.index2break_egg_info = new HashMap();
/*  921 */       this.role_id2break_num = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.BreakEggGameInfo _o1_)
/*      */     {
/*  926 */       if ((_o1_ instanceof BreakEggGameInfo)) { assign((BreakEggGameInfo)_o1_);
/*  927 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  928 */       } else if ((_o1_ instanceof BreakEggGameInfo.Const)) assign(((BreakEggGameInfo.Const)_o1_).nThis()); else {
/*  929 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(BreakEggGameInfo _o_) {
/*  934 */       this.session_id = _o_.session_id;
/*  935 */       this.activity_id = _o_.activity_id;
/*  936 */       this.inviter_id = _o_.inviter_id;
/*  937 */       this.roleid_list = new ArrayList();
/*  938 */       this.roleid_list.addAll(_o_.roleid_list);
/*  939 */       this.reward_info_id = new ArrayList();
/*  940 */       this.reward_info_id.addAll(_o_.reward_info_id);
/*  941 */       this.index2break_egg_info = new HashMap();
/*  942 */       for (Map.Entry<Integer, xbean.BreakEggInfo> _e_ : _o_.index2break_egg_info.entrySet())
/*  943 */         this.index2break_egg_info.put(_e_.getKey(), new BreakEggInfo.Data((xbean.BreakEggInfo)_e_.getValue()));
/*  944 */       this.role_id2break_num = new HashMap();
/*  945 */       for (Map.Entry<Long, Integer> _e_ : _o_.role_id2break_num.entrySet()) {
/*  946 */         this.role_id2break_num.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  951 */       this.session_id = _o_.session_id;
/*  952 */       this.activity_id = _o_.activity_id;
/*  953 */       this.inviter_id = _o_.inviter_id;
/*  954 */       this.roleid_list = new ArrayList();
/*  955 */       this.roleid_list.addAll(_o_.roleid_list);
/*  956 */       this.reward_info_id = new ArrayList();
/*  957 */       this.reward_info_id.addAll(_o_.reward_info_id);
/*  958 */       this.index2break_egg_info = new HashMap();
/*  959 */       for (Map.Entry<Integer, xbean.BreakEggInfo> _e_ : _o_.index2break_egg_info.entrySet())
/*  960 */         this.index2break_egg_info.put(_e_.getKey(), new BreakEggInfo.Data((xbean.BreakEggInfo)_e_.getValue()));
/*  961 */       this.role_id2break_num = new HashMap();
/*  962 */       for (Map.Entry<Long, Integer> _e_ : _o_.role_id2break_num.entrySet()) {
/*  963 */         this.role_id2break_num.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  969 */       _os_.marshal(this.session_id);
/*  970 */       _os_.marshal(this.activity_id);
/*  971 */       _os_.marshal(this.inviter_id);
/*  972 */       _os_.compact_uint32(this.roleid_list.size());
/*  973 */       for (Long _v_ : this.roleid_list)
/*      */       {
/*  975 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  977 */       _os_.compact_uint32(this.reward_info_id.size());
/*  978 */       for (Integer _v_ : this.reward_info_id)
/*      */       {
/*  980 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  982 */       _os_.compact_uint32(this.index2break_egg_info.size());
/*  983 */       for (Map.Entry<Integer, xbean.BreakEggInfo> _e_ : this.index2break_egg_info.entrySet())
/*      */       {
/*  985 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  986 */         ((xbean.BreakEggInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  988 */       _os_.compact_uint32(this.role_id2break_num.size());
/*  989 */       for (Map.Entry<Long, Integer> _e_ : this.role_id2break_num.entrySet())
/*      */       {
/*  991 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  992 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  994 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1000 */       this.session_id = _os_.unmarshal_long();
/* 1001 */       this.activity_id = _os_.unmarshal_int();
/* 1002 */       this.inviter_id = _os_.unmarshal_long();
/* 1003 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1005 */         long _v_ = 0L;
/* 1006 */         _v_ = _os_.unmarshal_long();
/* 1007 */         this.roleid_list.add(Long.valueOf(_v_));
/*      */       }
/* 1009 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1011 */         int _v_ = 0;
/* 1012 */         _v_ = _os_.unmarshal_int();
/* 1013 */         this.reward_info_id.add(Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1016 */       int size = _os_.uncompact_uint32();
/* 1017 */       if (size >= 12)
/*      */       {
/* 1019 */         this.index2break_egg_info = new HashMap(size * 2);
/*      */       }
/* 1021 */       for (; size > 0; size--)
/*      */       {
/* 1023 */         int _k_ = 0;
/* 1024 */         _k_ = _os_.unmarshal_int();
/* 1025 */         xbean.BreakEggInfo _v_ = xbean.Pod.newBreakEggInfoData();
/* 1026 */         _v_.unmarshal(_os_);
/* 1027 */         this.index2break_egg_info.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/* 1031 */       int size = _os_.uncompact_uint32();
/* 1032 */       if (size >= 12)
/*      */       {
/* 1034 */         this.role_id2break_num = new HashMap(size * 2);
/*      */       }
/* 1036 */       for (; size > 0; size--)
/*      */       {
/* 1038 */         long _k_ = 0L;
/* 1039 */         _k_ = _os_.unmarshal_long();
/* 1040 */         int _v_ = 0;
/* 1041 */         _v_ = _os_.unmarshal_int();
/* 1042 */         this.role_id2break_num.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1045 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1051 */       int _size_ = 0;
/* 1052 */       _size_ += CodedOutputStream.computeInt64Size(1, this.session_id);
/* 1053 */       _size_ += CodedOutputStream.computeInt32Size(2, this.activity_id);
/* 1054 */       _size_ += CodedOutputStream.computeInt64Size(3, this.inviter_id);
/* 1055 */       for (Long _v_ : this.roleid_list)
/*      */       {
/* 1057 */         _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */       }
/* 1059 */       for (Integer _v_ : this.reward_info_id)
/*      */       {
/* 1061 */         _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */       }
/* 1063 */       for (Map.Entry<Integer, xbean.BreakEggInfo> _e_ : this.index2break_egg_info.entrySet())
/*      */       {
/* 1065 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/* 1066 */         _size_ += CodedOutputStream.computeMessageSize(6, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1068 */       for (Map.Entry<Long, Integer> _e_ : this.role_id2break_num.entrySet())
/*      */       {
/* 1070 */         _size_ += CodedOutputStream.computeInt64Size(7, ((Long)_e_.getKey()).longValue());
/* 1071 */         _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1073 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1081 */         _output_.writeInt64(1, this.session_id);
/* 1082 */         _output_.writeInt32(2, this.activity_id);
/* 1083 */         _output_.writeInt64(3, this.inviter_id);
/* 1084 */         for (Long _v_ : this.roleid_list)
/*      */         {
/* 1086 */           _output_.writeInt64(4, _v_.longValue());
/*      */         }
/* 1088 */         for (Integer _v_ : this.reward_info_id)
/*      */         {
/* 1090 */           _output_.writeInt32(5, _v_.intValue());
/*      */         }
/* 1092 */         for (Map.Entry<Integer, xbean.BreakEggInfo> _e_ : this.index2break_egg_info.entrySet())
/*      */         {
/* 1094 */           _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/* 1095 */           _output_.writeMessage(6, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1097 */         for (Map.Entry<Long, Integer> _e_ : this.role_id2break_num.entrySet())
/*      */         {
/* 1099 */           _output_.writeInt64(7, ((Long)_e_.getKey()).longValue());
/* 1100 */           _output_.writeInt32(7, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1105 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1107 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1115 */         boolean done = false;
/* 1116 */         while (!done)
/*      */         {
/* 1118 */           int tag = _input_.readTag();
/* 1119 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1123 */             done = true;
/* 1124 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1128 */             this.session_id = _input_.readInt64();
/* 1129 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1133 */             this.activity_id = _input_.readInt32();
/* 1134 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1138 */             this.inviter_id = _input_.readInt64();
/* 1139 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1143 */             long _v_ = 0L;
/* 1144 */             _v_ = _input_.readInt64();
/* 1145 */             this.roleid_list.add(Long.valueOf(_v_));
/* 1146 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1150 */             int _v_ = 0;
/* 1151 */             _v_ = _input_.readInt32();
/* 1152 */             this.reward_info_id.add(Integer.valueOf(_v_));
/* 1153 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1157 */             int _k_ = 0;
/* 1158 */             _k_ = _input_.readInt32();
/* 1159 */             int readTag = _input_.readTag();
/* 1160 */             if (50 != readTag)
/*      */             {
/* 1162 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1164 */             xbean.BreakEggInfo _v_ = xbean.Pod.newBreakEggInfoData();
/* 1165 */             _input_.readMessage(_v_);
/* 1166 */             this.index2break_egg_info.put(Integer.valueOf(_k_), _v_);
/* 1167 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1171 */             long _k_ = 0L;
/* 1172 */             _k_ = _input_.readInt64();
/* 1173 */             int readTag = _input_.readTag();
/* 1174 */             if (56 != readTag)
/*      */             {
/* 1176 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1178 */             int _v_ = 0;
/* 1179 */             _v_ = _input_.readInt32();
/* 1180 */             this.role_id2break_num.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 1181 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1185 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1187 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1196 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1200 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1202 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BreakEggGameInfo copy()
/*      */     {
/* 1208 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BreakEggGameInfo toData()
/*      */     {
/* 1214 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.BreakEggGameInfo toBean()
/*      */     {
/* 1219 */       return new BreakEggGameInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BreakEggGameInfo toDataIf()
/*      */     {
/* 1225 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.BreakEggGameInfo toBeanIf()
/*      */     {
/* 1230 */       return new BreakEggGameInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1236 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1240 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1244 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1248 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1252 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1256 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1260 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSession_id()
/*      */     {
/* 1267 */       return this.session_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActivity_id()
/*      */     {
/* 1274 */       return this.activity_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInviter_id()
/*      */     {
/* 1281 */       return this.inviter_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRoleid_list()
/*      */     {
/* 1288 */       return this.roleid_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getRoleid_listAsData()
/*      */     {
/* 1295 */       return this.roleid_list;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getReward_info_id()
/*      */     {
/* 1302 */       return this.reward_info_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getReward_info_idAsData()
/*      */     {
/* 1309 */       return this.reward_info_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BreakEggInfo> getIndex2break_egg_info()
/*      */     {
/* 1316 */       return this.index2break_egg_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BreakEggInfo> getIndex2break_egg_infoAsData()
/*      */     {
/* 1323 */       return this.index2break_egg_info;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRole_id2break_num()
/*      */     {
/* 1330 */       return this.role_id2break_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRole_id2break_numAsData()
/*      */     {
/* 1337 */       return this.role_id2break_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSession_id(long _v_)
/*      */     {
/* 1344 */       this.session_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivity_id(int _v_)
/*      */     {
/* 1351 */       this.activity_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInviter_id(long _v_)
/*      */     {
/* 1358 */       this.inviter_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1364 */       if (!(_o1_ instanceof Data)) return false;
/* 1365 */       Data _o_ = (Data)_o1_;
/* 1366 */       if (this.session_id != _o_.session_id) return false;
/* 1367 */       if (this.activity_id != _o_.activity_id) return false;
/* 1368 */       if (this.inviter_id != _o_.inviter_id) return false;
/* 1369 */       if (!this.roleid_list.equals(_o_.roleid_list)) return false;
/* 1370 */       if (!this.reward_info_id.equals(_o_.reward_info_id)) return false;
/* 1371 */       if (!this.index2break_egg_info.equals(_o_.index2break_egg_info)) return false;
/* 1372 */       if (!this.role_id2break_num.equals(_o_.role_id2break_num)) return false;
/* 1373 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1379 */       int _h_ = 0;
/* 1380 */       _h_ = (int)(_h_ + this.session_id);
/* 1381 */       _h_ += this.activity_id;
/* 1382 */       _h_ = (int)(_h_ + this.inviter_id);
/* 1383 */       _h_ += this.roleid_list.hashCode();
/* 1384 */       _h_ += this.reward_info_id.hashCode();
/* 1385 */       _h_ += this.index2break_egg_info.hashCode();
/* 1386 */       _h_ += this.role_id2break_num.hashCode();
/* 1387 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1393 */       StringBuilder _sb_ = new StringBuilder();
/* 1394 */       _sb_.append("(");
/* 1395 */       _sb_.append(this.session_id);
/* 1396 */       _sb_.append(",");
/* 1397 */       _sb_.append(this.activity_id);
/* 1398 */       _sb_.append(",");
/* 1399 */       _sb_.append(this.inviter_id);
/* 1400 */       _sb_.append(",");
/* 1401 */       _sb_.append(this.roleid_list);
/* 1402 */       _sb_.append(",");
/* 1403 */       _sb_.append(this.reward_info_id);
/* 1404 */       _sb_.append(",");
/* 1405 */       _sb_.append(this.index2break_egg_info);
/* 1406 */       _sb_.append(",");
/* 1407 */       _sb_.append(this.role_id2break_num);
/* 1408 */       _sb_.append(")");
/* 1409 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\BreakEggGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */