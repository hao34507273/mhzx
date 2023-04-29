/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class FactionPVETmp extends XBean implements xbean.FactionPVETmp
/*      */ {
/*      */   private long world;
/*      */   private int stage;
/*      */   private long sessionid;
/*      */   private HashMap<Integer, Integer> goal;
/*      */   private long end_sessionid;
/*      */   private SetX<Long> fights;
/*      */   private HashMap<Integer, Integer> killed_boss;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.world = 0L;
/*   31 */     this.stage = 0;
/*   32 */     this.sessionid = -1L;
/*   33 */     this.goal.clear();
/*   34 */     this.end_sessionid = -1L;
/*   35 */     this.fights.clear();
/*   36 */     this.killed_boss.clear();
/*      */   }
/*      */   
/*      */   FactionPVETmp(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.sessionid = -1L;
/*   43 */     this.goal = new HashMap();
/*   44 */     this.end_sessionid = -1L;
/*   45 */     this.fights = new SetX();
/*   46 */     this.killed_boss = new HashMap();
/*      */   }
/*      */   
/*      */   public FactionPVETmp()
/*      */   {
/*   51 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public FactionPVETmp(FactionPVETmp _o_)
/*      */   {
/*   56 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   FactionPVETmp(xbean.FactionPVETmp _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   61 */     super(_xp_, _vn_);
/*   62 */     if ((_o1_ instanceof FactionPVETmp)) { assign((FactionPVETmp)_o1_);
/*   63 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   64 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   65 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(FactionPVETmp _o_) {
/*   70 */     _o_._xdb_verify_unsafe_();
/*   71 */     this.world = _o_.world;
/*   72 */     this.stage = _o_.stage;
/*   73 */     this.sessionid = _o_.sessionid;
/*   74 */     this.goal = new HashMap();
/*   75 */     for (Map.Entry<Integer, Integer> _e_ : _o_.goal.entrySet())
/*   76 */       this.goal.put(_e_.getKey(), _e_.getValue());
/*   77 */     this.end_sessionid = _o_.end_sessionid;
/*   78 */     this.fights = new SetX();
/*   79 */     this.fights.addAll(_o_.fights);
/*   80 */     this.killed_boss = new HashMap();
/*   81 */     for (Map.Entry<Integer, Integer> _e_ : _o_.killed_boss.entrySet()) {
/*   82 */       this.killed_boss.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   87 */     this.world = _o_.world;
/*   88 */     this.stage = _o_.stage;
/*   89 */     this.sessionid = _o_.sessionid;
/*   90 */     this.goal = new HashMap();
/*   91 */     for (Map.Entry<Integer, Integer> _e_ : _o_.goal.entrySet())
/*   92 */       this.goal.put(_e_.getKey(), _e_.getValue());
/*   93 */     this.end_sessionid = _o_.end_sessionid;
/*   94 */     this.fights = new SetX();
/*   95 */     this.fights.addAll(_o_.fights);
/*   96 */     this.killed_boss = new HashMap();
/*   97 */     for (Map.Entry<Integer, Integer> _e_ : _o_.killed_boss.entrySet()) {
/*   98 */       this.killed_boss.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  104 */     _xdb_verify_unsafe_();
/*  105 */     _os_.marshal(this.world);
/*  106 */     _os_.marshal(this.stage);
/*  107 */     _os_.marshal(this.sessionid);
/*  108 */     _os_.compact_uint32(this.goal.size());
/*  109 */     for (Map.Entry<Integer, Integer> _e_ : this.goal.entrySet())
/*      */     {
/*  111 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  112 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  114 */     _os_.marshal(this.end_sessionid);
/*  115 */     _os_.compact_uint32(this.fights.size());
/*  116 */     for (Long _v_ : this.fights)
/*      */     {
/*  118 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  120 */     _os_.compact_uint32(this.killed_boss.size());
/*  121 */     for (Map.Entry<Integer, Integer> _e_ : this.killed_boss.entrySet())
/*      */     {
/*  123 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  124 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  126 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  132 */     _xdb_verify_unsafe_();
/*  133 */     this.world = _os_.unmarshal_long();
/*  134 */     this.stage = _os_.unmarshal_int();
/*  135 */     this.sessionid = _os_.unmarshal_long();
/*      */     
/*  137 */     int size = _os_.uncompact_uint32();
/*  138 */     if (size >= 12)
/*      */     {
/*  140 */       this.goal = new HashMap(size * 2);
/*      */     }
/*  142 */     for (; size > 0; size--)
/*      */     {
/*  144 */       int _k_ = 0;
/*  145 */       _k_ = _os_.unmarshal_int();
/*  146 */       int _v_ = 0;
/*  147 */       _v_ = _os_.unmarshal_int();
/*  148 */       this.goal.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  151 */     this.end_sessionid = _os_.unmarshal_long();
/*  152 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  154 */       long _v_ = 0L;
/*  155 */       _v_ = _os_.unmarshal_long();
/*  156 */       this.fights.add(Long.valueOf(_v_));
/*      */     }
/*      */     
/*  159 */     int size = _os_.uncompact_uint32();
/*  160 */     if (size >= 12)
/*      */     {
/*  162 */       this.killed_boss = new HashMap(size * 2);
/*      */     }
/*  164 */     for (; size > 0; size--)
/*      */     {
/*  166 */       int _k_ = 0;
/*  167 */       _k_ = _os_.unmarshal_int();
/*  168 */       int _v_ = 0;
/*  169 */       _v_ = _os_.unmarshal_int();
/*  170 */       this.killed_boss.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  173 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  179 */     _xdb_verify_unsafe_();
/*  180 */     int _size_ = 0;
/*  181 */     _size_ += CodedOutputStream.computeInt64Size(1, this.world);
/*  182 */     _size_ += CodedOutputStream.computeInt32Size(2, this.stage);
/*  183 */     _size_ += CodedOutputStream.computeInt64Size(3, this.sessionid);
/*  184 */     for (Map.Entry<Integer, Integer> _e_ : this.goal.entrySet())
/*      */     {
/*  186 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  187 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  189 */     _size_ += CodedOutputStream.computeInt64Size(5, this.end_sessionid);
/*  190 */     for (Long _v_ : this.fights)
/*      */     {
/*  192 */       _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */     }
/*  194 */     for (Map.Entry<Integer, Integer> _e_ : this.killed_boss.entrySet())
/*      */     {
/*  196 */       _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getKey()).intValue());
/*  197 */       _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  199 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  205 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  208 */       _output_.writeInt64(1, this.world);
/*  209 */       _output_.writeInt32(2, this.stage);
/*  210 */       _output_.writeInt64(3, this.sessionid);
/*  211 */       for (Map.Entry<Integer, Integer> _e_ : this.goal.entrySet())
/*      */       {
/*  213 */         _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  214 */         _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  216 */       _output_.writeInt64(5, this.end_sessionid);
/*  217 */       for (Long _v_ : this.fights)
/*      */       {
/*  219 */         _output_.writeInt64(6, _v_.longValue());
/*      */       }
/*  221 */       for (Map.Entry<Integer, Integer> _e_ : this.killed_boss.entrySet())
/*      */       {
/*  223 */         _output_.writeInt32(7, ((Integer)_e_.getKey()).intValue());
/*  224 */         _output_.writeInt32(7, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  229 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  231 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  237 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  240 */       boolean done = false;
/*  241 */       while (!done)
/*      */       {
/*  243 */         int tag = _input_.readTag();
/*  244 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  248 */           done = true;
/*  249 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  253 */           this.world = _input_.readInt64();
/*  254 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  258 */           this.stage = _input_.readInt32();
/*  259 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  263 */           this.sessionid = _input_.readInt64();
/*  264 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  268 */           int _k_ = 0;
/*  269 */           _k_ = _input_.readInt32();
/*  270 */           int readTag = _input_.readTag();
/*  271 */           if (32 != readTag)
/*      */           {
/*  273 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  275 */           int _v_ = 0;
/*  276 */           _v_ = _input_.readInt32();
/*  277 */           this.goal.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  278 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  282 */           this.end_sessionid = _input_.readInt64();
/*  283 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  287 */           long _v_ = 0L;
/*  288 */           _v_ = _input_.readInt64();
/*  289 */           this.fights.add(Long.valueOf(_v_));
/*  290 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  294 */           int _k_ = 0;
/*  295 */           _k_ = _input_.readInt32();
/*  296 */           int readTag = _input_.readTag();
/*  297 */           if (56 != readTag)
/*      */           {
/*  299 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  301 */           int _v_ = 0;
/*  302 */           _v_ = _input_.readInt32();
/*  303 */           this.killed_boss.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  304 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  308 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  310 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  319 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  323 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  325 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FactionPVETmp copy()
/*      */   {
/*  331 */     _xdb_verify_unsafe_();
/*  332 */     return new FactionPVETmp(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FactionPVETmp toData()
/*      */   {
/*  338 */     _xdb_verify_unsafe_();
/*  339 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FactionPVETmp toBean()
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*  345 */     return new FactionPVETmp(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FactionPVETmp toDataIf()
/*      */   {
/*  351 */     _xdb_verify_unsafe_();
/*  352 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FactionPVETmp toBeanIf()
/*      */   {
/*  357 */     _xdb_verify_unsafe_();
/*  358 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  364 */     _xdb_verify_unsafe_();
/*  365 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getWorld()
/*      */   {
/*  372 */     _xdb_verify_unsafe_();
/*  373 */     return this.world;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getStage()
/*      */   {
/*  380 */     _xdb_verify_unsafe_();
/*  381 */     return this.stage;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSessionid()
/*      */   {
/*  388 */     _xdb_verify_unsafe_();
/*  389 */     return this.sessionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getGoal()
/*      */   {
/*  396 */     _xdb_verify_unsafe_();
/*  397 */     return xdb.Logs.logMap(new LogKey(this, "goal"), this.goal);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getGoalAsData()
/*      */   {
/*  404 */     _xdb_verify_unsafe_();
/*      */     
/*  406 */     FactionPVETmp _o_ = this;
/*  407 */     Map<Integer, Integer> goal = new HashMap();
/*  408 */     for (Map.Entry<Integer, Integer> _e_ : _o_.goal.entrySet())
/*  409 */       goal.put(_e_.getKey(), _e_.getValue());
/*  410 */     return goal;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getEnd_sessionid()
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     return this.end_sessionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getFights()
/*      */   {
/*  425 */     _xdb_verify_unsafe_();
/*  426 */     return xdb.Logs.logSet(new LogKey(this, "fights"), this.fights);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getFightsAsData()
/*      */   {
/*  432 */     _xdb_verify_unsafe_();
/*      */     
/*  434 */     FactionPVETmp _o_ = this;
/*  435 */     Set<Long> fights = new SetX();
/*  436 */     fights.addAll(_o_.fights);
/*  437 */     return fights;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getKilled_boss()
/*      */   {
/*  444 */     _xdb_verify_unsafe_();
/*  445 */     return xdb.Logs.logMap(new LogKey(this, "killed_boss"), this.killed_boss);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getKilled_bossAsData()
/*      */   {
/*  452 */     _xdb_verify_unsafe_();
/*      */     
/*  454 */     FactionPVETmp _o_ = this;
/*  455 */     Map<Integer, Integer> killed_boss = new HashMap();
/*  456 */     for (Map.Entry<Integer, Integer> _e_ : _o_.killed_boss.entrySet())
/*  457 */       killed_boss.put(_e_.getKey(), _e_.getValue());
/*  458 */     return killed_boss;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWorld(long _v_)
/*      */   {
/*  465 */     _xdb_verify_unsafe_();
/*  466 */     xdb.Logs.logIf(new LogKey(this, "world")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  470 */         new xdb.logs.LogLong(this, FactionPVETmp.this.world)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  474 */             FactionPVETmp.this.world = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  478 */     });
/*  479 */     this.world = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStage(int _v_)
/*      */   {
/*  486 */     _xdb_verify_unsafe_();
/*  487 */     xdb.Logs.logIf(new LogKey(this, "stage")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  491 */         new xdb.logs.LogInt(this, FactionPVETmp.this.stage)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  495 */             FactionPVETmp.this.stage = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  499 */     });
/*  500 */     this.stage = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSessionid(long _v_)
/*      */   {
/*  507 */     _xdb_verify_unsafe_();
/*  508 */     xdb.Logs.logIf(new LogKey(this, "sessionid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  512 */         new xdb.logs.LogLong(this, FactionPVETmp.this.sessionid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  516 */             FactionPVETmp.this.sessionid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  520 */     });
/*  521 */     this.sessionid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEnd_sessionid(long _v_)
/*      */   {
/*  528 */     _xdb_verify_unsafe_();
/*  529 */     xdb.Logs.logIf(new LogKey(this, "end_sessionid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  533 */         new xdb.logs.LogLong(this, FactionPVETmp.this.end_sessionid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  537 */             FactionPVETmp.this.end_sessionid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  541 */     });
/*  542 */     this.end_sessionid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  548 */     _xdb_verify_unsafe_();
/*  549 */     FactionPVETmp _o_ = null;
/*  550 */     if ((_o1_ instanceof FactionPVETmp)) { _o_ = (FactionPVETmp)_o1_;
/*  551 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  552 */       return false;
/*  553 */     if (this.world != _o_.world) return false;
/*  554 */     if (this.stage != _o_.stage) return false;
/*  555 */     if (this.sessionid != _o_.sessionid) return false;
/*  556 */     if (!this.goal.equals(_o_.goal)) return false;
/*  557 */     if (this.end_sessionid != _o_.end_sessionid) return false;
/*  558 */     if (!this.fights.equals(_o_.fights)) return false;
/*  559 */     if (!this.killed_boss.equals(_o_.killed_boss)) return false;
/*  560 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  566 */     _xdb_verify_unsafe_();
/*  567 */     int _h_ = 0;
/*  568 */     _h_ = (int)(_h_ + this.world);
/*  569 */     _h_ += this.stage;
/*  570 */     _h_ = (int)(_h_ + this.sessionid);
/*  571 */     _h_ += this.goal.hashCode();
/*  572 */     _h_ = (int)(_h_ + this.end_sessionid);
/*  573 */     _h_ += this.fights.hashCode();
/*  574 */     _h_ += this.killed_boss.hashCode();
/*  575 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  581 */     _xdb_verify_unsafe_();
/*  582 */     StringBuilder _sb_ = new StringBuilder();
/*  583 */     _sb_.append("(");
/*  584 */     _sb_.append(this.world);
/*  585 */     _sb_.append(",");
/*  586 */     _sb_.append(this.stage);
/*  587 */     _sb_.append(",");
/*  588 */     _sb_.append(this.sessionid);
/*  589 */     _sb_.append(",");
/*  590 */     _sb_.append(this.goal);
/*  591 */     _sb_.append(",");
/*  592 */     _sb_.append(this.end_sessionid);
/*  593 */     _sb_.append(",");
/*  594 */     _sb_.append(this.fights);
/*  595 */     _sb_.append(",");
/*  596 */     _sb_.append(this.killed_boss);
/*  597 */     _sb_.append(")");
/*  598 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  604 */     ListenableBean lb = new ListenableBean();
/*  605 */     lb.add(new xdb.logs.ListenableChanged().setVarName("world"));
/*  606 */     lb.add(new xdb.logs.ListenableChanged().setVarName("stage"));
/*  607 */     lb.add(new xdb.logs.ListenableChanged().setVarName("sessionid"));
/*  608 */     lb.add(new xdb.logs.ListenableMap().setVarName("goal"));
/*  609 */     lb.add(new xdb.logs.ListenableChanged().setVarName("end_sessionid"));
/*  610 */     lb.add(new xdb.logs.ListenableSet().setVarName("fights"));
/*  611 */     lb.add(new xdb.logs.ListenableMap().setVarName("killed_boss"));
/*  612 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.FactionPVETmp {
/*      */     private Const() {}
/*      */     
/*      */     FactionPVETmp nThis() {
/*  619 */       return FactionPVETmp.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  625 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionPVETmp copy()
/*      */     {
/*  631 */       return FactionPVETmp.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionPVETmp toData()
/*      */     {
/*  637 */       return FactionPVETmp.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.FactionPVETmp toBean()
/*      */     {
/*  642 */       return FactionPVETmp.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionPVETmp toDataIf()
/*      */     {
/*  648 */       return FactionPVETmp.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.FactionPVETmp toBeanIf()
/*      */     {
/*  653 */       return FactionPVETmp.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWorld()
/*      */     {
/*  660 */       FactionPVETmp.this._xdb_verify_unsafe_();
/*  661 */       return FactionPVETmp.this.world;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStage()
/*      */     {
/*  668 */       FactionPVETmp.this._xdb_verify_unsafe_();
/*  669 */       return FactionPVETmp.this.stage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSessionid()
/*      */     {
/*  676 */       FactionPVETmp.this._xdb_verify_unsafe_();
/*  677 */       return FactionPVETmp.this.sessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getGoal()
/*      */     {
/*  684 */       FactionPVETmp.this._xdb_verify_unsafe_();
/*  685 */       return xdb.Consts.constMap(FactionPVETmp.this.goal);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getGoalAsData()
/*      */     {
/*  692 */       FactionPVETmp.this._xdb_verify_unsafe_();
/*      */       
/*  694 */       FactionPVETmp _o_ = FactionPVETmp.this;
/*  695 */       Map<Integer, Integer> goal = new HashMap();
/*  696 */       for (Map.Entry<Integer, Integer> _e_ : _o_.goal.entrySet())
/*  697 */         goal.put(_e_.getKey(), _e_.getValue());
/*  698 */       return goal;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEnd_sessionid()
/*      */     {
/*  705 */       FactionPVETmp.this._xdb_verify_unsafe_();
/*  706 */       return FactionPVETmp.this.end_sessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getFights()
/*      */     {
/*  713 */       FactionPVETmp.this._xdb_verify_unsafe_();
/*  714 */       return xdb.Consts.constSet(FactionPVETmp.this.fights);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getFightsAsData()
/*      */     {
/*  720 */       FactionPVETmp.this._xdb_verify_unsafe_();
/*      */       
/*  722 */       FactionPVETmp _o_ = FactionPVETmp.this;
/*  723 */       Set<Long> fights = new SetX();
/*  724 */       fights.addAll(_o_.fights);
/*  725 */       return fights;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getKilled_boss()
/*      */     {
/*  732 */       FactionPVETmp.this._xdb_verify_unsafe_();
/*  733 */       return xdb.Consts.constMap(FactionPVETmp.this.killed_boss);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getKilled_bossAsData()
/*      */     {
/*  740 */       FactionPVETmp.this._xdb_verify_unsafe_();
/*      */       
/*  742 */       FactionPVETmp _o_ = FactionPVETmp.this;
/*  743 */       Map<Integer, Integer> killed_boss = new HashMap();
/*  744 */       for (Map.Entry<Integer, Integer> _e_ : _o_.killed_boss.entrySet())
/*  745 */         killed_boss.put(_e_.getKey(), _e_.getValue());
/*  746 */       return killed_boss;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWorld(long _v_)
/*      */     {
/*  753 */       FactionPVETmp.this._xdb_verify_unsafe_();
/*  754 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStage(int _v_)
/*      */     {
/*  761 */       FactionPVETmp.this._xdb_verify_unsafe_();
/*  762 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSessionid(long _v_)
/*      */     {
/*  769 */       FactionPVETmp.this._xdb_verify_unsafe_();
/*  770 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEnd_sessionid(long _v_)
/*      */     {
/*  777 */       FactionPVETmp.this._xdb_verify_unsafe_();
/*  778 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  784 */       FactionPVETmp.this._xdb_verify_unsafe_();
/*  785 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  791 */       FactionPVETmp.this._xdb_verify_unsafe_();
/*  792 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  798 */       return FactionPVETmp.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  804 */       return FactionPVETmp.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  810 */       FactionPVETmp.this._xdb_verify_unsafe_();
/*  811 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  817 */       return FactionPVETmp.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  823 */       return FactionPVETmp.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  829 */       FactionPVETmp.this._xdb_verify_unsafe_();
/*  830 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  836 */       return FactionPVETmp.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  842 */       return FactionPVETmp.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  848 */       return FactionPVETmp.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  854 */       return FactionPVETmp.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  860 */       return FactionPVETmp.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  866 */       return FactionPVETmp.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  872 */       return FactionPVETmp.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.FactionPVETmp
/*      */   {
/*      */     private long world;
/*      */     
/*      */     private int stage;
/*      */     
/*      */     private long sessionid;
/*      */     
/*      */     private HashMap<Integer, Integer> goal;
/*      */     
/*      */     private long end_sessionid;
/*      */     
/*      */     private HashSet<Long> fights;
/*      */     
/*      */     private HashMap<Integer, Integer> killed_boss;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  896 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  901 */       this.sessionid = -1L;
/*  902 */       this.goal = new HashMap();
/*  903 */       this.end_sessionid = -1L;
/*  904 */       this.fights = new HashSet();
/*  905 */       this.killed_boss = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.FactionPVETmp _o1_)
/*      */     {
/*  910 */       if ((_o1_ instanceof FactionPVETmp)) { assign((FactionPVETmp)_o1_);
/*  911 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  912 */       } else if ((_o1_ instanceof FactionPVETmp.Const)) assign(((FactionPVETmp.Const)_o1_).nThis()); else {
/*  913 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(FactionPVETmp _o_) {
/*  918 */       this.world = _o_.world;
/*  919 */       this.stage = _o_.stage;
/*  920 */       this.sessionid = _o_.sessionid;
/*  921 */       this.goal = new HashMap();
/*  922 */       for (Map.Entry<Integer, Integer> _e_ : _o_.goal.entrySet())
/*  923 */         this.goal.put(_e_.getKey(), _e_.getValue());
/*  924 */       this.end_sessionid = _o_.end_sessionid;
/*  925 */       this.fights = new HashSet();
/*  926 */       this.fights.addAll(_o_.fights);
/*  927 */       this.killed_boss = new HashMap();
/*  928 */       for (Map.Entry<Integer, Integer> _e_ : _o_.killed_boss.entrySet()) {
/*  929 */         this.killed_boss.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  934 */       this.world = _o_.world;
/*  935 */       this.stage = _o_.stage;
/*  936 */       this.sessionid = _o_.sessionid;
/*  937 */       this.goal = new HashMap();
/*  938 */       for (Map.Entry<Integer, Integer> _e_ : _o_.goal.entrySet())
/*  939 */         this.goal.put(_e_.getKey(), _e_.getValue());
/*  940 */       this.end_sessionid = _o_.end_sessionid;
/*  941 */       this.fights = new HashSet();
/*  942 */       this.fights.addAll(_o_.fights);
/*  943 */       this.killed_boss = new HashMap();
/*  944 */       for (Map.Entry<Integer, Integer> _e_ : _o_.killed_boss.entrySet()) {
/*  945 */         this.killed_boss.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  951 */       _os_.marshal(this.world);
/*  952 */       _os_.marshal(this.stage);
/*  953 */       _os_.marshal(this.sessionid);
/*  954 */       _os_.compact_uint32(this.goal.size());
/*  955 */       for (Map.Entry<Integer, Integer> _e_ : this.goal.entrySet())
/*      */       {
/*  957 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  958 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  960 */       _os_.marshal(this.end_sessionid);
/*  961 */       _os_.compact_uint32(this.fights.size());
/*  962 */       for (Long _v_ : this.fights)
/*      */       {
/*  964 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  966 */       _os_.compact_uint32(this.killed_boss.size());
/*  967 */       for (Map.Entry<Integer, Integer> _e_ : this.killed_boss.entrySet())
/*      */       {
/*  969 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  970 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  972 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  978 */       this.world = _os_.unmarshal_long();
/*  979 */       this.stage = _os_.unmarshal_int();
/*  980 */       this.sessionid = _os_.unmarshal_long();
/*      */       
/*  982 */       int size = _os_.uncompact_uint32();
/*  983 */       if (size >= 12)
/*      */       {
/*  985 */         this.goal = new HashMap(size * 2);
/*      */       }
/*  987 */       for (; size > 0; size--)
/*      */       {
/*  989 */         int _k_ = 0;
/*  990 */         _k_ = _os_.unmarshal_int();
/*  991 */         int _v_ = 0;
/*  992 */         _v_ = _os_.unmarshal_int();
/*  993 */         this.goal.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  996 */       this.end_sessionid = _os_.unmarshal_long();
/*  997 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  999 */         long _v_ = 0L;
/* 1000 */         _v_ = _os_.unmarshal_long();
/* 1001 */         this.fights.add(Long.valueOf(_v_));
/*      */       }
/*      */       
/* 1004 */       int size = _os_.uncompact_uint32();
/* 1005 */       if (size >= 12)
/*      */       {
/* 1007 */         this.killed_boss = new HashMap(size * 2);
/*      */       }
/* 1009 */       for (; size > 0; size--)
/*      */       {
/* 1011 */         int _k_ = 0;
/* 1012 */         _k_ = _os_.unmarshal_int();
/* 1013 */         int _v_ = 0;
/* 1014 */         _v_ = _os_.unmarshal_int();
/* 1015 */         this.killed_boss.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1018 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1024 */       int _size_ = 0;
/* 1025 */       _size_ += CodedOutputStream.computeInt64Size(1, this.world);
/* 1026 */       _size_ += CodedOutputStream.computeInt32Size(2, this.stage);
/* 1027 */       _size_ += CodedOutputStream.computeInt64Size(3, this.sessionid);
/* 1028 */       for (Map.Entry<Integer, Integer> _e_ : this.goal.entrySet())
/*      */       {
/* 1030 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/* 1031 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1033 */       _size_ += CodedOutputStream.computeInt64Size(5, this.end_sessionid);
/* 1034 */       for (Long _v_ : this.fights)
/*      */       {
/* 1036 */         _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */       }
/* 1038 */       for (Map.Entry<Integer, Integer> _e_ : this.killed_boss.entrySet())
/*      */       {
/* 1040 */         _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getKey()).intValue());
/* 1041 */         _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1043 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1051 */         _output_.writeInt64(1, this.world);
/* 1052 */         _output_.writeInt32(2, this.stage);
/* 1053 */         _output_.writeInt64(3, this.sessionid);
/* 1054 */         for (Map.Entry<Integer, Integer> _e_ : this.goal.entrySet())
/*      */         {
/* 1056 */           _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/* 1057 */           _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1059 */         _output_.writeInt64(5, this.end_sessionid);
/* 1060 */         for (Long _v_ : this.fights)
/*      */         {
/* 1062 */           _output_.writeInt64(6, _v_.longValue());
/*      */         }
/* 1064 */         for (Map.Entry<Integer, Integer> _e_ : this.killed_boss.entrySet())
/*      */         {
/* 1066 */           _output_.writeInt32(7, ((Integer)_e_.getKey()).intValue());
/* 1067 */           _output_.writeInt32(7, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1072 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1074 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1082 */         boolean done = false;
/* 1083 */         while (!done)
/*      */         {
/* 1085 */           int tag = _input_.readTag();
/* 1086 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1090 */             done = true;
/* 1091 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1095 */             this.world = _input_.readInt64();
/* 1096 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1100 */             this.stage = _input_.readInt32();
/* 1101 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1105 */             this.sessionid = _input_.readInt64();
/* 1106 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1110 */             int _k_ = 0;
/* 1111 */             _k_ = _input_.readInt32();
/* 1112 */             int readTag = _input_.readTag();
/* 1113 */             if (32 != readTag)
/*      */             {
/* 1115 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1117 */             int _v_ = 0;
/* 1118 */             _v_ = _input_.readInt32();
/* 1119 */             this.goal.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1120 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1124 */             this.end_sessionid = _input_.readInt64();
/* 1125 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1129 */             long _v_ = 0L;
/* 1130 */             _v_ = _input_.readInt64();
/* 1131 */             this.fights.add(Long.valueOf(_v_));
/* 1132 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1136 */             int _k_ = 0;
/* 1137 */             _k_ = _input_.readInt32();
/* 1138 */             int readTag = _input_.readTag();
/* 1139 */             if (56 != readTag)
/*      */             {
/* 1141 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1143 */             int _v_ = 0;
/* 1144 */             _v_ = _input_.readInt32();
/* 1145 */             this.killed_boss.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1146 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1150 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1152 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1161 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1165 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1167 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionPVETmp copy()
/*      */     {
/* 1173 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionPVETmp toData()
/*      */     {
/* 1179 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.FactionPVETmp toBean()
/*      */     {
/* 1184 */       return new FactionPVETmp(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionPVETmp toDataIf()
/*      */     {
/* 1190 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.FactionPVETmp toBeanIf()
/*      */     {
/* 1195 */       return new FactionPVETmp(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1201 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1205 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1209 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1213 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1217 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1221 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1225 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWorld()
/*      */     {
/* 1232 */       return this.world;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStage()
/*      */     {
/* 1239 */       return this.stage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSessionid()
/*      */     {
/* 1246 */       return this.sessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getGoal()
/*      */     {
/* 1253 */       return this.goal;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getGoalAsData()
/*      */     {
/* 1260 */       return this.goal;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEnd_sessionid()
/*      */     {
/* 1267 */       return this.end_sessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getFights()
/*      */     {
/* 1274 */       return this.fights;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getFightsAsData()
/*      */     {
/* 1281 */       return this.fights;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getKilled_boss()
/*      */     {
/* 1288 */       return this.killed_boss;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getKilled_bossAsData()
/*      */     {
/* 1295 */       return this.killed_boss;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWorld(long _v_)
/*      */     {
/* 1302 */       this.world = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStage(int _v_)
/*      */     {
/* 1309 */       this.stage = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSessionid(long _v_)
/*      */     {
/* 1316 */       this.sessionid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEnd_sessionid(long _v_)
/*      */     {
/* 1323 */       this.end_sessionid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1329 */       if (!(_o1_ instanceof Data)) return false;
/* 1330 */       Data _o_ = (Data)_o1_;
/* 1331 */       if (this.world != _o_.world) return false;
/* 1332 */       if (this.stage != _o_.stage) return false;
/* 1333 */       if (this.sessionid != _o_.sessionid) return false;
/* 1334 */       if (!this.goal.equals(_o_.goal)) return false;
/* 1335 */       if (this.end_sessionid != _o_.end_sessionid) return false;
/* 1336 */       if (!this.fights.equals(_o_.fights)) return false;
/* 1337 */       if (!this.killed_boss.equals(_o_.killed_boss)) return false;
/* 1338 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1344 */       int _h_ = 0;
/* 1345 */       _h_ = (int)(_h_ + this.world);
/* 1346 */       _h_ += this.stage;
/* 1347 */       _h_ = (int)(_h_ + this.sessionid);
/* 1348 */       _h_ += this.goal.hashCode();
/* 1349 */       _h_ = (int)(_h_ + this.end_sessionid);
/* 1350 */       _h_ += this.fights.hashCode();
/* 1351 */       _h_ += this.killed_boss.hashCode();
/* 1352 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1358 */       StringBuilder _sb_ = new StringBuilder();
/* 1359 */       _sb_.append("(");
/* 1360 */       _sb_.append(this.world);
/* 1361 */       _sb_.append(",");
/* 1362 */       _sb_.append(this.stage);
/* 1363 */       _sb_.append(",");
/* 1364 */       _sb_.append(this.sessionid);
/* 1365 */       _sb_.append(",");
/* 1366 */       _sb_.append(this.goal);
/* 1367 */       _sb_.append(",");
/* 1368 */       _sb_.append(this.end_sessionid);
/* 1369 */       _sb_.append(",");
/* 1370 */       _sb_.append(this.fights);
/* 1371 */       _sb_.append(",");
/* 1372 */       _sb_.append(this.killed_boss);
/* 1373 */       _sb_.append(")");
/* 1374 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FactionPVETmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */