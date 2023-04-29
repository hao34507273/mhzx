/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import ppbio.Message;
/*      */ import xbean.MatchKey;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class MatchQueue extends xdb.XBean implements xbean.MatchQueue
/*      */ {
/*      */   private HashMap<MatchKey, xbean.TeamMatchQueue> teamqueue;
/*      */   private HashMap<MatchKey, xbean.TeamMatchQueue> rolequeue;
/*      */   private SetX<Long> repeatteamids;
/*      */   private SetX<Long> repeatleaderids;
/*      */   private HashMap<Long, xbean.MatchActivityCfg> roleinfo;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.teamqueue.clear();
/*   27 */     this.rolequeue.clear();
/*   28 */     this.repeatteamids.clear();
/*   29 */     this.repeatleaderids.clear();
/*   30 */     this.roleinfo.clear();
/*      */   }
/*      */   
/*      */   MatchQueue(int __, xdb.XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.teamqueue = new HashMap();
/*   37 */     this.rolequeue = new HashMap();
/*   38 */     this.repeatteamids = new SetX();
/*   39 */     this.repeatleaderids = new SetX();
/*   40 */     this.roleinfo = new HashMap();
/*      */   }
/*      */   
/*      */   public MatchQueue()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public MatchQueue(MatchQueue _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   MatchQueue(xbean.MatchQueue _o1_, xdb.XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof MatchQueue)) { assign((MatchQueue)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(MatchQueue _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.teamqueue = new HashMap();
/*   66 */     for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : _o_.teamqueue.entrySet())
/*   67 */       this.teamqueue.put(_e_.getKey(), new TeamMatchQueue((xbean.TeamMatchQueue)_e_.getValue(), this, "teamqueue"));
/*   68 */     this.rolequeue = new HashMap();
/*   69 */     for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : _o_.rolequeue.entrySet())
/*   70 */       this.rolequeue.put(_e_.getKey(), new TeamMatchQueue((xbean.TeamMatchQueue)_e_.getValue(), this, "rolequeue"));
/*   71 */     this.repeatteamids = new SetX();
/*   72 */     this.repeatteamids.addAll(_o_.repeatteamids);
/*   73 */     this.repeatleaderids = new SetX();
/*   74 */     this.repeatleaderids.addAll(_o_.repeatleaderids);
/*   75 */     this.roleinfo = new HashMap();
/*   76 */     for (Map.Entry<Long, xbean.MatchActivityCfg> _e_ : _o_.roleinfo.entrySet()) {
/*   77 */       this.roleinfo.put(_e_.getKey(), new MatchActivityCfg((xbean.MatchActivityCfg)_e_.getValue(), this, "roleinfo"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   82 */     this.teamqueue = new HashMap();
/*   83 */     for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : _o_.teamqueue.entrySet())
/*   84 */       this.teamqueue.put(_e_.getKey(), new TeamMatchQueue((xbean.TeamMatchQueue)_e_.getValue(), this, "teamqueue"));
/*   85 */     this.rolequeue = new HashMap();
/*   86 */     for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : _o_.rolequeue.entrySet())
/*   87 */       this.rolequeue.put(_e_.getKey(), new TeamMatchQueue((xbean.TeamMatchQueue)_e_.getValue(), this, "rolequeue"));
/*   88 */     this.repeatteamids = new SetX();
/*   89 */     this.repeatteamids.addAll(_o_.repeatteamids);
/*   90 */     this.repeatleaderids = new SetX();
/*   91 */     this.repeatleaderids.addAll(_o_.repeatleaderids);
/*   92 */     this.roleinfo = new HashMap();
/*   93 */     for (Map.Entry<Long, xbean.MatchActivityCfg> _e_ : _o_.roleinfo.entrySet()) {
/*   94 */       this.roleinfo.put(_e_.getKey(), new MatchActivityCfg((xbean.MatchActivityCfg)_e_.getValue(), this, "roleinfo"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  100 */     _xdb_verify_unsafe_();
/*  101 */     _os_.compact_uint32(this.teamqueue.size());
/*  102 */     for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : this.teamqueue.entrySet())
/*      */     {
/*  104 */       ((MatchKey)_e_.getKey()).marshal(_os_);
/*  105 */       ((xbean.TeamMatchQueue)_e_.getValue()).marshal(_os_);
/*      */     }
/*  107 */     _os_.compact_uint32(this.rolequeue.size());
/*  108 */     for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : this.rolequeue.entrySet())
/*      */     {
/*  110 */       ((MatchKey)_e_.getKey()).marshal(_os_);
/*  111 */       ((xbean.TeamMatchQueue)_e_.getValue()).marshal(_os_);
/*      */     }
/*  113 */     _os_.compact_uint32(this.repeatteamids.size());
/*  114 */     for (Long _v_ : this.repeatteamids)
/*      */     {
/*  116 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  118 */     _os_.compact_uint32(this.repeatleaderids.size());
/*  119 */     for (Long _v_ : this.repeatleaderids)
/*      */     {
/*  121 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  123 */     _os_.compact_uint32(this.roleinfo.size());
/*  124 */     for (Map.Entry<Long, xbean.MatchActivityCfg> _e_ : this.roleinfo.entrySet())
/*      */     {
/*  126 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  127 */       ((xbean.MatchActivityCfg)_e_.getValue()).marshal(_os_);
/*      */     }
/*  129 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  135 */     _xdb_verify_unsafe_();
/*      */     
/*  137 */     int size = _os_.uncompact_uint32();
/*  138 */     if (size >= 12)
/*      */     {
/*  140 */       this.teamqueue = new HashMap(size * 2);
/*      */     }
/*  142 */     for (; size > 0; size--)
/*      */     {
/*  144 */       MatchKey _k_ = new MatchKey();
/*  145 */       _k_.unmarshal(_os_);
/*  146 */       xbean.TeamMatchQueue _v_ = new TeamMatchQueue(0, this, "teamqueue");
/*  147 */       _v_.unmarshal(_os_);
/*  148 */       this.teamqueue.put(_k_, _v_);
/*      */     }
/*      */     
/*      */ 
/*  152 */     int size = _os_.uncompact_uint32();
/*  153 */     if (size >= 12)
/*      */     {
/*  155 */       this.rolequeue = new HashMap(size * 2);
/*      */     }
/*  157 */     for (; size > 0; size--)
/*      */     {
/*  159 */       MatchKey _k_ = new MatchKey();
/*  160 */       _k_.unmarshal(_os_);
/*  161 */       xbean.TeamMatchQueue _v_ = new TeamMatchQueue(0, this, "rolequeue");
/*  162 */       _v_.unmarshal(_os_);
/*  163 */       this.rolequeue.put(_k_, _v_);
/*      */     }
/*      */     
/*  166 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  168 */       long _v_ = 0L;
/*  169 */       _v_ = _os_.unmarshal_long();
/*  170 */       this.repeatteamids.add(Long.valueOf(_v_));
/*      */     }
/*  172 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  174 */       long _v_ = 0L;
/*  175 */       _v_ = _os_.unmarshal_long();
/*  176 */       this.repeatleaderids.add(Long.valueOf(_v_));
/*      */     }
/*      */     
/*  179 */     int size = _os_.uncompact_uint32();
/*  180 */     if (size >= 12)
/*      */     {
/*  182 */       this.roleinfo = new HashMap(size * 2);
/*      */     }
/*  184 */     for (; size > 0; size--)
/*      */     {
/*  186 */       long _k_ = 0L;
/*  187 */       _k_ = _os_.unmarshal_long();
/*  188 */       xbean.MatchActivityCfg _v_ = new MatchActivityCfg(0, this, "roleinfo");
/*  189 */       _v_.unmarshal(_os_);
/*  190 */       this.roleinfo.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  193 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  199 */     _xdb_verify_unsafe_();
/*  200 */     int _size_ = 0;
/*  201 */     for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : this.teamqueue.entrySet())
/*      */     {
/*  203 */       _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getKey());
/*  204 */       _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*      */     }
/*  206 */     for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : this.rolequeue.entrySet())
/*      */     {
/*  208 */       _size_ += CodedOutputStream.computeMessageSize(2, (Message)_e_.getKey());
/*  209 */       _size_ += CodedOutputStream.computeMessageSize(2, (Message)_e_.getValue());
/*      */     }
/*  211 */     for (Long _v_ : this.repeatteamids)
/*      */     {
/*  213 */       _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*      */     }
/*  215 */     for (Long _v_ : this.repeatleaderids)
/*      */     {
/*  217 */       _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */     }
/*  219 */     for (Map.Entry<Long, xbean.MatchActivityCfg> _e_ : this.roleinfo.entrySet())
/*      */     {
/*  221 */       _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getKey()).longValue());
/*  222 */       _size_ += CodedOutputStream.computeMessageSize(5, (Message)_e_.getValue());
/*      */     }
/*  224 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  230 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  233 */       for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : this.teamqueue.entrySet())
/*      */       {
/*  235 */         _output_.writeMessage(1, (Message)_e_.getKey());
/*  236 */         _output_.writeMessage(1, (Message)_e_.getValue());
/*      */       }
/*  238 */       for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : this.rolequeue.entrySet())
/*      */       {
/*  240 */         _output_.writeMessage(2, (Message)_e_.getKey());
/*  241 */         _output_.writeMessage(2, (Message)_e_.getValue());
/*      */       }
/*  243 */       for (Long _v_ : this.repeatteamids)
/*      */       {
/*  245 */         _output_.writeInt64(3, _v_.longValue());
/*      */       }
/*  247 */       for (Long _v_ : this.repeatleaderids)
/*      */       {
/*  249 */         _output_.writeInt64(4, _v_.longValue());
/*      */       }
/*  251 */       for (Map.Entry<Long, xbean.MatchActivityCfg> _e_ : this.roleinfo.entrySet())
/*      */       {
/*  253 */         _output_.writeInt64(5, ((Long)_e_.getKey()).longValue());
/*  254 */         _output_.writeMessage(5, (Message)_e_.getValue());
/*      */       }
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  259 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  261 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  270 */       boolean done = false;
/*  271 */       while (!done)
/*      */       {
/*  273 */         int tag = _input_.readTag();
/*  274 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  278 */           done = true;
/*  279 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  283 */           MatchKey _k_ = new MatchKey();
/*  284 */           _input_.readMessage(_k_);
/*  285 */           int readTag = _input_.readTag();
/*  286 */           if (10 != readTag)
/*      */           {
/*  288 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  290 */           xbean.TeamMatchQueue _v_ = new TeamMatchQueue(0, this, "teamqueue");
/*  291 */           _input_.readMessage(_v_);
/*  292 */           this.teamqueue.put(_k_, _v_);
/*  293 */           break;
/*      */         
/*      */ 
/*      */         case 18: 
/*  297 */           MatchKey _k_ = new MatchKey();
/*  298 */           _input_.readMessage(_k_);
/*  299 */           int readTag = _input_.readTag();
/*  300 */           if (18 != readTag)
/*      */           {
/*  302 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  304 */           xbean.TeamMatchQueue _v_ = new TeamMatchQueue(0, this, "rolequeue");
/*  305 */           _input_.readMessage(_v_);
/*  306 */           this.rolequeue.put(_k_, _v_);
/*  307 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  311 */           long _v_ = 0L;
/*  312 */           _v_ = _input_.readInt64();
/*  313 */           this.repeatteamids.add(Long.valueOf(_v_));
/*  314 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  318 */           long _v_ = 0L;
/*  319 */           _v_ = _input_.readInt64();
/*  320 */           this.repeatleaderids.add(Long.valueOf(_v_));
/*  321 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  325 */           long _k_ = 0L;
/*  326 */           _k_ = _input_.readInt64();
/*  327 */           int readTag = _input_.readTag();
/*  328 */           if (42 != readTag)
/*      */           {
/*  330 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  332 */           xbean.MatchActivityCfg _v_ = new MatchActivityCfg(0, this, "roleinfo");
/*  333 */           _input_.readMessage(_v_);
/*  334 */           this.roleinfo.put(Long.valueOf(_k_), _v_);
/*  335 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  339 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  341 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  350 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  354 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  356 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MatchQueue copy()
/*      */   {
/*  362 */     _xdb_verify_unsafe_();
/*  363 */     return new MatchQueue(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MatchQueue toData()
/*      */   {
/*  369 */     _xdb_verify_unsafe_();
/*  370 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MatchQueue toBean()
/*      */   {
/*  375 */     _xdb_verify_unsafe_();
/*  376 */     return new MatchQueue(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MatchQueue toDataIf()
/*      */   {
/*  382 */     _xdb_verify_unsafe_();
/*  383 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MatchQueue toBeanIf()
/*      */   {
/*  388 */     _xdb_verify_unsafe_();
/*  389 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  395 */     _xdb_verify_unsafe_();
/*  396 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<MatchKey, xbean.TeamMatchQueue> getTeamqueue()
/*      */   {
/*  403 */     _xdb_verify_unsafe_();
/*  404 */     return xdb.Logs.logMap(new xdb.LogKey(this, "teamqueue"), this.teamqueue);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<MatchKey, xbean.TeamMatchQueue> getTeamqueueAsData()
/*      */   {
/*  411 */     _xdb_verify_unsafe_();
/*      */     
/*  413 */     MatchQueue _o_ = this;
/*  414 */     Map<MatchKey, xbean.TeamMatchQueue> teamqueue = new HashMap();
/*  415 */     for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : _o_.teamqueue.entrySet())
/*  416 */       teamqueue.put(_e_.getKey(), new TeamMatchQueue.Data((xbean.TeamMatchQueue)_e_.getValue()));
/*  417 */     return teamqueue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<MatchKey, xbean.TeamMatchQueue> getRolequeue()
/*      */   {
/*  424 */     _xdb_verify_unsafe_();
/*  425 */     return xdb.Logs.logMap(new xdb.LogKey(this, "rolequeue"), this.rolequeue);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<MatchKey, xbean.TeamMatchQueue> getRolequeueAsData()
/*      */   {
/*  432 */     _xdb_verify_unsafe_();
/*      */     
/*  434 */     MatchQueue _o_ = this;
/*  435 */     Map<MatchKey, xbean.TeamMatchQueue> rolequeue = new HashMap();
/*  436 */     for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : _o_.rolequeue.entrySet())
/*  437 */       rolequeue.put(_e_.getKey(), new TeamMatchQueue.Data((xbean.TeamMatchQueue)_e_.getValue()));
/*  438 */     return rolequeue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getRepeatteamids()
/*      */   {
/*  445 */     _xdb_verify_unsafe_();
/*  446 */     return xdb.Logs.logSet(new xdb.LogKey(this, "repeatteamids"), this.repeatteamids);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getRepeatteamidsAsData()
/*      */   {
/*  452 */     _xdb_verify_unsafe_();
/*      */     
/*  454 */     MatchQueue _o_ = this;
/*  455 */     Set<Long> repeatteamids = new SetX();
/*  456 */     repeatteamids.addAll(_o_.repeatteamids);
/*  457 */     return repeatteamids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getRepeatleaderids()
/*      */   {
/*  464 */     _xdb_verify_unsafe_();
/*  465 */     return xdb.Logs.logSet(new xdb.LogKey(this, "repeatleaderids"), this.repeatleaderids);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getRepeatleaderidsAsData()
/*      */   {
/*  471 */     _xdb_verify_unsafe_();
/*      */     
/*  473 */     MatchQueue _o_ = this;
/*  474 */     Set<Long> repeatleaderids = new SetX();
/*  475 */     repeatleaderids.addAll(_o_.repeatleaderids);
/*  476 */     return repeatleaderids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.MatchActivityCfg> getRoleinfo()
/*      */   {
/*  483 */     _xdb_verify_unsafe_();
/*  484 */     return xdb.Logs.logMap(new xdb.LogKey(this, "roleinfo"), this.roleinfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.MatchActivityCfg> getRoleinfoAsData()
/*      */   {
/*  491 */     _xdb_verify_unsafe_();
/*      */     
/*  493 */     MatchQueue _o_ = this;
/*  494 */     Map<Long, xbean.MatchActivityCfg> roleinfo = new HashMap();
/*  495 */     for (Map.Entry<Long, xbean.MatchActivityCfg> _e_ : _o_.roleinfo.entrySet())
/*  496 */       roleinfo.put(_e_.getKey(), new MatchActivityCfg.Data((xbean.MatchActivityCfg)_e_.getValue()));
/*  497 */     return roleinfo;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  503 */     _xdb_verify_unsafe_();
/*  504 */     MatchQueue _o_ = null;
/*  505 */     if ((_o1_ instanceof MatchQueue)) { _o_ = (MatchQueue)_o1_;
/*  506 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  507 */       return false;
/*  508 */     if (!this.teamqueue.equals(_o_.teamqueue)) return false;
/*  509 */     if (!this.rolequeue.equals(_o_.rolequeue)) return false;
/*  510 */     if (!this.repeatteamids.equals(_o_.repeatteamids)) return false;
/*  511 */     if (!this.repeatleaderids.equals(_o_.repeatleaderids)) return false;
/*  512 */     if (!this.roleinfo.equals(_o_.roleinfo)) return false;
/*  513 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  519 */     _xdb_verify_unsafe_();
/*  520 */     int _h_ = 0;
/*  521 */     _h_ += this.teamqueue.hashCode();
/*  522 */     _h_ += this.rolequeue.hashCode();
/*  523 */     _h_ += this.repeatteamids.hashCode();
/*  524 */     _h_ += this.repeatleaderids.hashCode();
/*  525 */     _h_ += this.roleinfo.hashCode();
/*  526 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  532 */     _xdb_verify_unsafe_();
/*  533 */     StringBuilder _sb_ = new StringBuilder();
/*  534 */     _sb_.append("(");
/*  535 */     _sb_.append(this.teamqueue);
/*  536 */     _sb_.append(",");
/*  537 */     _sb_.append(this.rolequeue);
/*  538 */     _sb_.append(",");
/*  539 */     _sb_.append(this.repeatteamids);
/*  540 */     _sb_.append(",");
/*  541 */     _sb_.append(this.repeatleaderids);
/*  542 */     _sb_.append(",");
/*  543 */     _sb_.append(this.roleinfo);
/*  544 */     _sb_.append(")");
/*  545 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  551 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  552 */     lb.add(new xdb.logs.ListenableMap().setVarName("teamqueue"));
/*  553 */     lb.add(new xdb.logs.ListenableMap().setVarName("rolequeue"));
/*  554 */     lb.add(new xdb.logs.ListenableSet().setVarName("repeatteamids"));
/*  555 */     lb.add(new xdb.logs.ListenableSet().setVarName("repeatleaderids"));
/*  556 */     lb.add(new xdb.logs.ListenableMap().setVarName("roleinfo"));
/*  557 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.MatchQueue {
/*      */     private Const() {}
/*      */     
/*      */     MatchQueue nThis() {
/*  564 */       return MatchQueue.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  570 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MatchQueue copy()
/*      */     {
/*  576 */       return MatchQueue.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MatchQueue toData()
/*      */     {
/*  582 */       return MatchQueue.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.MatchQueue toBean()
/*      */     {
/*  587 */       return MatchQueue.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MatchQueue toDataIf()
/*      */     {
/*  593 */       return MatchQueue.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.MatchQueue toBeanIf()
/*      */     {
/*  598 */       return MatchQueue.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<MatchKey, xbean.TeamMatchQueue> getTeamqueue()
/*      */     {
/*  605 */       MatchQueue.this._xdb_verify_unsafe_();
/*  606 */       return xdb.Consts.constMap(MatchQueue.this.teamqueue);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<MatchKey, xbean.TeamMatchQueue> getTeamqueueAsData()
/*      */     {
/*  613 */       MatchQueue.this._xdb_verify_unsafe_();
/*      */       
/*  615 */       MatchQueue _o_ = MatchQueue.this;
/*  616 */       Map<MatchKey, xbean.TeamMatchQueue> teamqueue = new HashMap();
/*  617 */       for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : _o_.teamqueue.entrySet())
/*  618 */         teamqueue.put(_e_.getKey(), new TeamMatchQueue.Data((xbean.TeamMatchQueue)_e_.getValue()));
/*  619 */       return teamqueue;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<MatchKey, xbean.TeamMatchQueue> getRolequeue()
/*      */     {
/*  626 */       MatchQueue.this._xdb_verify_unsafe_();
/*  627 */       return xdb.Consts.constMap(MatchQueue.this.rolequeue);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<MatchKey, xbean.TeamMatchQueue> getRolequeueAsData()
/*      */     {
/*  634 */       MatchQueue.this._xdb_verify_unsafe_();
/*      */       
/*  636 */       MatchQueue _o_ = MatchQueue.this;
/*  637 */       Map<MatchKey, xbean.TeamMatchQueue> rolequeue = new HashMap();
/*  638 */       for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : _o_.rolequeue.entrySet())
/*  639 */         rolequeue.put(_e_.getKey(), new TeamMatchQueue.Data((xbean.TeamMatchQueue)_e_.getValue()));
/*  640 */       return rolequeue;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getRepeatteamids()
/*      */     {
/*  647 */       MatchQueue.this._xdb_verify_unsafe_();
/*  648 */       return xdb.Consts.constSet(MatchQueue.this.repeatteamids);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getRepeatteamidsAsData()
/*      */     {
/*  654 */       MatchQueue.this._xdb_verify_unsafe_();
/*      */       
/*  656 */       MatchQueue _o_ = MatchQueue.this;
/*  657 */       Set<Long> repeatteamids = new SetX();
/*  658 */       repeatteamids.addAll(_o_.repeatteamids);
/*  659 */       return repeatteamids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getRepeatleaderids()
/*      */     {
/*  666 */       MatchQueue.this._xdb_verify_unsafe_();
/*  667 */       return xdb.Consts.constSet(MatchQueue.this.repeatleaderids);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getRepeatleaderidsAsData()
/*      */     {
/*  673 */       MatchQueue.this._xdb_verify_unsafe_();
/*      */       
/*  675 */       MatchQueue _o_ = MatchQueue.this;
/*  676 */       Set<Long> repeatleaderids = new SetX();
/*  677 */       repeatleaderids.addAll(_o_.repeatleaderids);
/*  678 */       return repeatleaderids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MatchActivityCfg> getRoleinfo()
/*      */     {
/*  685 */       MatchQueue.this._xdb_verify_unsafe_();
/*  686 */       return xdb.Consts.constMap(MatchQueue.this.roleinfo);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MatchActivityCfg> getRoleinfoAsData()
/*      */     {
/*  693 */       MatchQueue.this._xdb_verify_unsafe_();
/*      */       
/*  695 */       MatchQueue _o_ = MatchQueue.this;
/*  696 */       Map<Long, xbean.MatchActivityCfg> roleinfo = new HashMap();
/*  697 */       for (Map.Entry<Long, xbean.MatchActivityCfg> _e_ : _o_.roleinfo.entrySet())
/*  698 */         roleinfo.put(_e_.getKey(), new MatchActivityCfg.Data((xbean.MatchActivityCfg)_e_.getValue()));
/*  699 */       return roleinfo;
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  705 */       MatchQueue.this._xdb_verify_unsafe_();
/*  706 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  712 */       MatchQueue.this._xdb_verify_unsafe_();
/*  713 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  719 */       return MatchQueue.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  725 */       return MatchQueue.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  731 */       MatchQueue.this._xdb_verify_unsafe_();
/*  732 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  738 */       return MatchQueue.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  744 */       return MatchQueue.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  750 */       MatchQueue.this._xdb_verify_unsafe_();
/*  751 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  757 */       return MatchQueue.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  763 */       return MatchQueue.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  769 */       return MatchQueue.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  775 */       return MatchQueue.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  781 */       return MatchQueue.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  787 */       return MatchQueue.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  793 */       return MatchQueue.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.MatchQueue
/*      */   {
/*      */     private HashMap<MatchKey, xbean.TeamMatchQueue> teamqueue;
/*      */     
/*      */     private HashMap<MatchKey, xbean.TeamMatchQueue> rolequeue;
/*      */     
/*      */     private HashSet<Long> repeatteamids;
/*      */     
/*      */     private HashSet<Long> repeatleaderids;
/*      */     
/*      */     private HashMap<Long, xbean.MatchActivityCfg> roleinfo;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  813 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  818 */       this.teamqueue = new HashMap();
/*  819 */       this.rolequeue = new HashMap();
/*  820 */       this.repeatteamids = new HashSet();
/*  821 */       this.repeatleaderids = new HashSet();
/*  822 */       this.roleinfo = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.MatchQueue _o1_)
/*      */     {
/*  827 */       if ((_o1_ instanceof MatchQueue)) { assign((MatchQueue)_o1_);
/*  828 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  829 */       } else if ((_o1_ instanceof MatchQueue.Const)) assign(((MatchQueue.Const)_o1_).nThis()); else {
/*  830 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(MatchQueue _o_) {
/*  835 */       this.teamqueue = new HashMap();
/*  836 */       for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : _o_.teamqueue.entrySet())
/*  837 */         this.teamqueue.put(_e_.getKey(), new TeamMatchQueue.Data((xbean.TeamMatchQueue)_e_.getValue()));
/*  838 */       this.rolequeue = new HashMap();
/*  839 */       for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : _o_.rolequeue.entrySet())
/*  840 */         this.rolequeue.put(_e_.getKey(), new TeamMatchQueue.Data((xbean.TeamMatchQueue)_e_.getValue()));
/*  841 */       this.repeatteamids = new HashSet();
/*  842 */       this.repeatteamids.addAll(_o_.repeatteamids);
/*  843 */       this.repeatleaderids = new HashSet();
/*  844 */       this.repeatleaderids.addAll(_o_.repeatleaderids);
/*  845 */       this.roleinfo = new HashMap();
/*  846 */       for (Map.Entry<Long, xbean.MatchActivityCfg> _e_ : _o_.roleinfo.entrySet()) {
/*  847 */         this.roleinfo.put(_e_.getKey(), new MatchActivityCfg.Data((xbean.MatchActivityCfg)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  852 */       this.teamqueue = new HashMap();
/*  853 */       for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : _o_.teamqueue.entrySet())
/*  854 */         this.teamqueue.put(_e_.getKey(), new TeamMatchQueue.Data((xbean.TeamMatchQueue)_e_.getValue()));
/*  855 */       this.rolequeue = new HashMap();
/*  856 */       for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : _o_.rolequeue.entrySet())
/*  857 */         this.rolequeue.put(_e_.getKey(), new TeamMatchQueue.Data((xbean.TeamMatchQueue)_e_.getValue()));
/*  858 */       this.repeatteamids = new HashSet();
/*  859 */       this.repeatteamids.addAll(_o_.repeatteamids);
/*  860 */       this.repeatleaderids = new HashSet();
/*  861 */       this.repeatleaderids.addAll(_o_.repeatleaderids);
/*  862 */       this.roleinfo = new HashMap();
/*  863 */       for (Map.Entry<Long, xbean.MatchActivityCfg> _e_ : _o_.roleinfo.entrySet()) {
/*  864 */         this.roleinfo.put(_e_.getKey(), new MatchActivityCfg.Data((xbean.MatchActivityCfg)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  870 */       _os_.compact_uint32(this.teamqueue.size());
/*  871 */       for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : this.teamqueue.entrySet())
/*      */       {
/*  873 */         ((MatchKey)_e_.getKey()).marshal(_os_);
/*  874 */         ((xbean.TeamMatchQueue)_e_.getValue()).marshal(_os_);
/*      */       }
/*  876 */       _os_.compact_uint32(this.rolequeue.size());
/*  877 */       for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : this.rolequeue.entrySet())
/*      */       {
/*  879 */         ((MatchKey)_e_.getKey()).marshal(_os_);
/*  880 */         ((xbean.TeamMatchQueue)_e_.getValue()).marshal(_os_);
/*      */       }
/*  882 */       _os_.compact_uint32(this.repeatteamids.size());
/*  883 */       for (Long _v_ : this.repeatteamids)
/*      */       {
/*  885 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  887 */       _os_.compact_uint32(this.repeatleaderids.size());
/*  888 */       for (Long _v_ : this.repeatleaderids)
/*      */       {
/*  890 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  892 */       _os_.compact_uint32(this.roleinfo.size());
/*  893 */       for (Map.Entry<Long, xbean.MatchActivityCfg> _e_ : this.roleinfo.entrySet())
/*      */       {
/*  895 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  896 */         ((xbean.MatchActivityCfg)_e_.getValue()).marshal(_os_);
/*      */       }
/*  898 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  905 */       int size = _os_.uncompact_uint32();
/*  906 */       if (size >= 12)
/*      */       {
/*  908 */         this.teamqueue = new HashMap(size * 2);
/*      */       }
/*  910 */       for (; size > 0; size--)
/*      */       {
/*  912 */         MatchKey _k_ = new MatchKey();
/*  913 */         _k_.unmarshal(_os_);
/*  914 */         xbean.TeamMatchQueue _v_ = xbean.Pod.newTeamMatchQueueData();
/*  915 */         _v_.unmarshal(_os_);
/*  916 */         this.teamqueue.put(_k_, _v_);
/*      */       }
/*      */       
/*      */ 
/*  920 */       int size = _os_.uncompact_uint32();
/*  921 */       if (size >= 12)
/*      */       {
/*  923 */         this.rolequeue = new HashMap(size * 2);
/*      */       }
/*  925 */       for (; size > 0; size--)
/*      */       {
/*  927 */         MatchKey _k_ = new MatchKey();
/*  928 */         _k_.unmarshal(_os_);
/*  929 */         xbean.TeamMatchQueue _v_ = xbean.Pod.newTeamMatchQueueData();
/*  930 */         _v_.unmarshal(_os_);
/*  931 */         this.rolequeue.put(_k_, _v_);
/*      */       }
/*      */       
/*  934 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  936 */         long _v_ = 0L;
/*  937 */         _v_ = _os_.unmarshal_long();
/*  938 */         this.repeatteamids.add(Long.valueOf(_v_));
/*      */       }
/*  940 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  942 */         long _v_ = 0L;
/*  943 */         _v_ = _os_.unmarshal_long();
/*  944 */         this.repeatleaderids.add(Long.valueOf(_v_));
/*      */       }
/*      */       
/*  947 */       int size = _os_.uncompact_uint32();
/*  948 */       if (size >= 12)
/*      */       {
/*  950 */         this.roleinfo = new HashMap(size * 2);
/*      */       }
/*  952 */       for (; size > 0; size--)
/*      */       {
/*  954 */         long _k_ = 0L;
/*  955 */         _k_ = _os_.unmarshal_long();
/*  956 */         xbean.MatchActivityCfg _v_ = xbean.Pod.newMatchActivityCfgData();
/*  957 */         _v_.unmarshal(_os_);
/*  958 */         this.roleinfo.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  961 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  967 */       int _size_ = 0;
/*  968 */       for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : this.teamqueue.entrySet())
/*      */       {
/*  970 */         _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getKey());
/*  971 */         _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*      */       }
/*  973 */       for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : this.rolequeue.entrySet())
/*      */       {
/*  975 */         _size_ += CodedOutputStream.computeMessageSize(2, (Message)_e_.getKey());
/*  976 */         _size_ += CodedOutputStream.computeMessageSize(2, (Message)_e_.getValue());
/*      */       }
/*  978 */       for (Long _v_ : this.repeatteamids)
/*      */       {
/*  980 */         _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*      */       }
/*  982 */       for (Long _v_ : this.repeatleaderids)
/*      */       {
/*  984 */         _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */       }
/*  986 */       for (Map.Entry<Long, xbean.MatchActivityCfg> _e_ : this.roleinfo.entrySet())
/*      */       {
/*  988 */         _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getKey()).longValue());
/*  989 */         _size_ += CodedOutputStream.computeMessageSize(5, (Message)_e_.getValue());
/*      */       }
/*  991 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  999 */         for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : this.teamqueue.entrySet())
/*      */         {
/* 1001 */           _output_.writeMessage(1, (Message)_e_.getKey());
/* 1002 */           _output_.writeMessage(1, (Message)_e_.getValue());
/*      */         }
/* 1004 */         for (Map.Entry<MatchKey, xbean.TeamMatchQueue> _e_ : this.rolequeue.entrySet())
/*      */         {
/* 1006 */           _output_.writeMessage(2, (Message)_e_.getKey());
/* 1007 */           _output_.writeMessage(2, (Message)_e_.getValue());
/*      */         }
/* 1009 */         for (Long _v_ : this.repeatteamids)
/*      */         {
/* 1011 */           _output_.writeInt64(3, _v_.longValue());
/*      */         }
/* 1013 */         for (Long _v_ : this.repeatleaderids)
/*      */         {
/* 1015 */           _output_.writeInt64(4, _v_.longValue());
/*      */         }
/* 1017 */         for (Map.Entry<Long, xbean.MatchActivityCfg> _e_ : this.roleinfo.entrySet())
/*      */         {
/* 1019 */           _output_.writeInt64(5, ((Long)_e_.getKey()).longValue());
/* 1020 */           _output_.writeMessage(5, (Message)_e_.getValue());
/*      */         }
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1025 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1027 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1035 */         boolean done = false;
/* 1036 */         while (!done)
/*      */         {
/* 1038 */           int tag = _input_.readTag();
/* 1039 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1043 */             done = true;
/* 1044 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/* 1048 */             MatchKey _k_ = new MatchKey();
/* 1049 */             _input_.readMessage(_k_);
/* 1050 */             int readTag = _input_.readTag();
/* 1051 */             if (10 != readTag)
/*      */             {
/* 1053 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1055 */             xbean.TeamMatchQueue _v_ = xbean.Pod.newTeamMatchQueueData();
/* 1056 */             _input_.readMessage(_v_);
/* 1057 */             this.teamqueue.put(_k_, _v_);
/* 1058 */             break;
/*      */           
/*      */ 
/*      */           case 18: 
/* 1062 */             MatchKey _k_ = new MatchKey();
/* 1063 */             _input_.readMessage(_k_);
/* 1064 */             int readTag = _input_.readTag();
/* 1065 */             if (18 != readTag)
/*      */             {
/* 1067 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1069 */             xbean.TeamMatchQueue _v_ = xbean.Pod.newTeamMatchQueueData();
/* 1070 */             _input_.readMessage(_v_);
/* 1071 */             this.rolequeue.put(_k_, _v_);
/* 1072 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1076 */             long _v_ = 0L;
/* 1077 */             _v_ = _input_.readInt64();
/* 1078 */             this.repeatteamids.add(Long.valueOf(_v_));
/* 1079 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1083 */             long _v_ = 0L;
/* 1084 */             _v_ = _input_.readInt64();
/* 1085 */             this.repeatleaderids.add(Long.valueOf(_v_));
/* 1086 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1090 */             long _k_ = 0L;
/* 1091 */             _k_ = _input_.readInt64();
/* 1092 */             int readTag = _input_.readTag();
/* 1093 */             if (42 != readTag)
/*      */             {
/* 1095 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1097 */             xbean.MatchActivityCfg _v_ = xbean.Pod.newMatchActivityCfgData();
/* 1098 */             _input_.readMessage(_v_);
/* 1099 */             this.roleinfo.put(Long.valueOf(_k_), _v_);
/* 1100 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1104 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1106 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1115 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1119 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1121 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MatchQueue copy()
/*      */     {
/* 1127 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MatchQueue toData()
/*      */     {
/* 1133 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.MatchQueue toBean()
/*      */     {
/* 1138 */       return new MatchQueue(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MatchQueue toDataIf()
/*      */     {
/* 1144 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.MatchQueue toBeanIf()
/*      */     {
/* 1149 */       return new MatchQueue(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1155 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1159 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1163 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1167 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1171 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1175 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1179 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<MatchKey, xbean.TeamMatchQueue> getTeamqueue()
/*      */     {
/* 1186 */       return this.teamqueue;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<MatchKey, xbean.TeamMatchQueue> getTeamqueueAsData()
/*      */     {
/* 1193 */       return this.teamqueue;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<MatchKey, xbean.TeamMatchQueue> getRolequeue()
/*      */     {
/* 1200 */       return this.rolequeue;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<MatchKey, xbean.TeamMatchQueue> getRolequeueAsData()
/*      */     {
/* 1207 */       return this.rolequeue;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getRepeatteamids()
/*      */     {
/* 1214 */       return this.repeatteamids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getRepeatteamidsAsData()
/*      */     {
/* 1221 */       return this.repeatteamids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getRepeatleaderids()
/*      */     {
/* 1228 */       return this.repeatleaderids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getRepeatleaderidsAsData()
/*      */     {
/* 1235 */       return this.repeatleaderids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MatchActivityCfg> getRoleinfo()
/*      */     {
/* 1242 */       return this.roleinfo;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.MatchActivityCfg> getRoleinfoAsData()
/*      */     {
/* 1249 */       return this.roleinfo;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1255 */       if (!(_o1_ instanceof Data)) return false;
/* 1256 */       Data _o_ = (Data)_o1_;
/* 1257 */       if (!this.teamqueue.equals(_o_.teamqueue)) return false;
/* 1258 */       if (!this.rolequeue.equals(_o_.rolequeue)) return false;
/* 1259 */       if (!this.repeatteamids.equals(_o_.repeatteamids)) return false;
/* 1260 */       if (!this.repeatleaderids.equals(_o_.repeatleaderids)) return false;
/* 1261 */       if (!this.roleinfo.equals(_o_.roleinfo)) return false;
/* 1262 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1268 */       int _h_ = 0;
/* 1269 */       _h_ += this.teamqueue.hashCode();
/* 1270 */       _h_ += this.rolequeue.hashCode();
/* 1271 */       _h_ += this.repeatteamids.hashCode();
/* 1272 */       _h_ += this.repeatleaderids.hashCode();
/* 1273 */       _h_ += this.roleinfo.hashCode();
/* 1274 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1280 */       StringBuilder _sb_ = new StringBuilder();
/* 1281 */       _sb_.append("(");
/* 1282 */       _sb_.append(this.teamqueue);
/* 1283 */       _sb_.append(",");
/* 1284 */       _sb_.append(this.rolequeue);
/* 1285 */       _sb_.append(",");
/* 1286 */       _sb_.append(this.repeatteamids);
/* 1287 */       _sb_.append(",");
/* 1288 */       _sb_.append(this.repeatleaderids);
/* 1289 */       _sb_.append(",");
/* 1290 */       _sb_.append(this.roleinfo);
/* 1291 */       _sb_.append(")");
/* 1292 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MatchQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */