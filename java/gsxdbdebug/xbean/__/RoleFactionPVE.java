/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
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
/*      */ public final class RoleFactionPVE extends XBean implements xbean.RoleFactionPVE
/*      */ {
/*      */   private long participate_millis;
/*      */   private int participate_times;
/*      */   private HashMap<Integer, Integer> goal;
/*      */   private int goal_times;
/*      */   private long participate_faction;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.participate_millis = 0L;
/*   27 */     this.participate_times = 0;
/*   28 */     this.goal.clear();
/*   29 */     this.goal_times = 0;
/*   30 */     this.participate_faction = 0L;
/*      */   }
/*      */   
/*      */   RoleFactionPVE(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.participate_millis = 0L;
/*   37 */     this.participate_times = 0;
/*   38 */     this.goal = new HashMap();
/*   39 */     this.goal_times = 0;
/*   40 */     this.participate_faction = 0L;
/*      */   }
/*      */   
/*      */   public RoleFactionPVE()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RoleFactionPVE(RoleFactionPVE _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RoleFactionPVE(xbean.RoleFactionPVE _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof RoleFactionPVE)) { assign((RoleFactionPVE)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RoleFactionPVE _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.participate_millis = _o_.participate_millis;
/*   66 */     this.participate_times = _o_.participate_times;
/*   67 */     this.goal = new HashMap();
/*   68 */     for (Map.Entry<Integer, Integer> _e_ : _o_.goal.entrySet())
/*   69 */       this.goal.put(_e_.getKey(), _e_.getValue());
/*   70 */     this.goal_times = _o_.goal_times;
/*   71 */     this.participate_faction = _o_.participate_faction;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   76 */     this.participate_millis = _o_.participate_millis;
/*   77 */     this.participate_times = _o_.participate_times;
/*   78 */     this.goal = new HashMap();
/*   79 */     for (Map.Entry<Integer, Integer> _e_ : _o_.goal.entrySet())
/*   80 */       this.goal.put(_e_.getKey(), _e_.getValue());
/*   81 */     this.goal_times = _o_.goal_times;
/*   82 */     this.participate_faction = _o_.participate_faction;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   88 */     _xdb_verify_unsafe_();
/*   89 */     _os_.marshal(this.participate_millis);
/*   90 */     _os_.marshal(this.participate_times);
/*   91 */     _os_.compact_uint32(this.goal.size());
/*   92 */     for (Map.Entry<Integer, Integer> _e_ : this.goal.entrySet())
/*      */     {
/*   94 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   95 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*   97 */     _os_.marshal(this.goal_times);
/*   98 */     _os_.marshal(this.participate_faction);
/*   99 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  105 */     _xdb_verify_unsafe_();
/*  106 */     this.participate_millis = _os_.unmarshal_long();
/*  107 */     this.participate_times = _os_.unmarshal_int();
/*      */     
/*  109 */     int size = _os_.uncompact_uint32();
/*  110 */     if (size >= 12)
/*      */     {
/*  112 */       this.goal = new HashMap(size * 2);
/*      */     }
/*  114 */     for (; size > 0; size--)
/*      */     {
/*  116 */       int _k_ = 0;
/*  117 */       _k_ = _os_.unmarshal_int();
/*  118 */       int _v_ = 0;
/*  119 */       _v_ = _os_.unmarshal_int();
/*  120 */       this.goal.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  123 */     this.goal_times = _os_.unmarshal_int();
/*  124 */     this.participate_faction = _os_.unmarshal_long();
/*  125 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  131 */     _xdb_verify_unsafe_();
/*  132 */     int _size_ = 0;
/*  133 */     _size_ += CodedOutputStream.computeInt64Size(1, this.participate_millis);
/*  134 */     _size_ += CodedOutputStream.computeInt32Size(2, this.participate_times);
/*  135 */     for (Map.Entry<Integer, Integer> _e_ : this.goal.entrySet())
/*      */     {
/*  137 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  138 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  140 */     _size_ += CodedOutputStream.computeInt32Size(4, this.goal_times);
/*  141 */     _size_ += CodedOutputStream.computeInt64Size(5, this.participate_faction);
/*  142 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  148 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  151 */       _output_.writeInt64(1, this.participate_millis);
/*  152 */       _output_.writeInt32(2, this.participate_times);
/*  153 */       for (Map.Entry<Integer, Integer> _e_ : this.goal.entrySet())
/*      */       {
/*  155 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  156 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  158 */       _output_.writeInt32(4, this.goal_times);
/*  159 */       _output_.writeInt64(5, this.participate_faction);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  163 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  165 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  171 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  174 */       boolean done = false;
/*  175 */       while (!done)
/*      */       {
/*  177 */         int tag = _input_.readTag();
/*  178 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  182 */           done = true;
/*  183 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  187 */           this.participate_millis = _input_.readInt64();
/*  188 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  192 */           this.participate_times = _input_.readInt32();
/*  193 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  197 */           int _k_ = 0;
/*  198 */           _k_ = _input_.readInt32();
/*  199 */           int readTag = _input_.readTag();
/*  200 */           if (24 != readTag)
/*      */           {
/*  202 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  204 */           int _v_ = 0;
/*  205 */           _v_ = _input_.readInt32();
/*  206 */           this.goal.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  207 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  211 */           this.goal_times = _input_.readInt32();
/*  212 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  216 */           this.participate_faction = _input_.readInt64();
/*  217 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  221 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  223 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  232 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  236 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  238 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleFactionPVE copy()
/*      */   {
/*  244 */     _xdb_verify_unsafe_();
/*  245 */     return new RoleFactionPVE(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleFactionPVE toData()
/*      */   {
/*  251 */     _xdb_verify_unsafe_();
/*  252 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleFactionPVE toBean()
/*      */   {
/*  257 */     _xdb_verify_unsafe_();
/*  258 */     return new RoleFactionPVE(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleFactionPVE toDataIf()
/*      */   {
/*  264 */     _xdb_verify_unsafe_();
/*  265 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleFactionPVE toBeanIf()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  277 */     _xdb_verify_unsafe_();
/*  278 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getParticipate_millis()
/*      */   {
/*  285 */     _xdb_verify_unsafe_();
/*  286 */     return this.participate_millis;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getParticipate_times()
/*      */   {
/*  293 */     _xdb_verify_unsafe_();
/*  294 */     return this.participate_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getGoal()
/*      */   {
/*  301 */     _xdb_verify_unsafe_();
/*  302 */     return xdb.Logs.logMap(new LogKey(this, "goal"), this.goal);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getGoalAsData()
/*      */   {
/*  309 */     _xdb_verify_unsafe_();
/*      */     
/*  311 */     RoleFactionPVE _o_ = this;
/*  312 */     Map<Integer, Integer> goal = new HashMap();
/*  313 */     for (Map.Entry<Integer, Integer> _e_ : _o_.goal.entrySet())
/*  314 */       goal.put(_e_.getKey(), _e_.getValue());
/*  315 */     return goal;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGoal_times()
/*      */   {
/*  322 */     _xdb_verify_unsafe_();
/*  323 */     return this.goal_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getParticipate_faction()
/*      */   {
/*  330 */     _xdb_verify_unsafe_();
/*  331 */     return this.participate_faction;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setParticipate_millis(long _v_)
/*      */   {
/*  338 */     _xdb_verify_unsafe_();
/*  339 */     xdb.Logs.logIf(new LogKey(this, "participate_millis")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  343 */         new xdb.logs.LogLong(this, RoleFactionPVE.this.participate_millis)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  347 */             RoleFactionPVE.this.participate_millis = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  351 */     });
/*  352 */     this.participate_millis = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setParticipate_times(int _v_)
/*      */   {
/*  359 */     _xdb_verify_unsafe_();
/*  360 */     xdb.Logs.logIf(new LogKey(this, "participate_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  364 */         new xdb.logs.LogInt(this, RoleFactionPVE.this.participate_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  368 */             RoleFactionPVE.this.participate_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  372 */     });
/*  373 */     this.participate_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGoal_times(int _v_)
/*      */   {
/*  380 */     _xdb_verify_unsafe_();
/*  381 */     xdb.Logs.logIf(new LogKey(this, "goal_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  385 */         new xdb.logs.LogInt(this, RoleFactionPVE.this.goal_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  389 */             RoleFactionPVE.this.goal_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  393 */     });
/*  394 */     this.goal_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setParticipate_faction(long _v_)
/*      */   {
/*  401 */     _xdb_verify_unsafe_();
/*  402 */     xdb.Logs.logIf(new LogKey(this, "participate_faction")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  406 */         new xdb.logs.LogLong(this, RoleFactionPVE.this.participate_faction)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  410 */             RoleFactionPVE.this.participate_faction = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  414 */     });
/*  415 */     this.participate_faction = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  421 */     _xdb_verify_unsafe_();
/*  422 */     RoleFactionPVE _o_ = null;
/*  423 */     if ((_o1_ instanceof RoleFactionPVE)) { _o_ = (RoleFactionPVE)_o1_;
/*  424 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  425 */       return false;
/*  426 */     if (this.participate_millis != _o_.participate_millis) return false;
/*  427 */     if (this.participate_times != _o_.participate_times) return false;
/*  428 */     if (!this.goal.equals(_o_.goal)) return false;
/*  429 */     if (this.goal_times != _o_.goal_times) return false;
/*  430 */     if (this.participate_faction != _o_.participate_faction) return false;
/*  431 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  437 */     _xdb_verify_unsafe_();
/*  438 */     int _h_ = 0;
/*  439 */     _h_ = (int)(_h_ + this.participate_millis);
/*  440 */     _h_ += this.participate_times;
/*  441 */     _h_ += this.goal.hashCode();
/*  442 */     _h_ += this.goal_times;
/*  443 */     _h_ = (int)(_h_ + this.participate_faction);
/*  444 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  450 */     _xdb_verify_unsafe_();
/*  451 */     StringBuilder _sb_ = new StringBuilder();
/*  452 */     _sb_.append("(");
/*  453 */     _sb_.append(this.participate_millis);
/*  454 */     _sb_.append(",");
/*  455 */     _sb_.append(this.participate_times);
/*  456 */     _sb_.append(",");
/*  457 */     _sb_.append(this.goal);
/*  458 */     _sb_.append(",");
/*  459 */     _sb_.append(this.goal_times);
/*  460 */     _sb_.append(",");
/*  461 */     _sb_.append(this.participate_faction);
/*  462 */     _sb_.append(")");
/*  463 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  469 */     ListenableBean lb = new ListenableBean();
/*  470 */     lb.add(new ListenableChanged().setVarName("participate_millis"));
/*  471 */     lb.add(new ListenableChanged().setVarName("participate_times"));
/*  472 */     lb.add(new xdb.logs.ListenableMap().setVarName("goal"));
/*  473 */     lb.add(new ListenableChanged().setVarName("goal_times"));
/*  474 */     lb.add(new ListenableChanged().setVarName("participate_faction"));
/*  475 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RoleFactionPVE {
/*      */     private Const() {}
/*      */     
/*      */     RoleFactionPVE nThis() {
/*  482 */       return RoleFactionPVE.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  488 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleFactionPVE copy()
/*      */     {
/*  494 */       return RoleFactionPVE.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleFactionPVE toData()
/*      */     {
/*  500 */       return RoleFactionPVE.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RoleFactionPVE toBean()
/*      */     {
/*  505 */       return RoleFactionPVE.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleFactionPVE toDataIf()
/*      */     {
/*  511 */       return RoleFactionPVE.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RoleFactionPVE toBeanIf()
/*      */     {
/*  516 */       return RoleFactionPVE.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getParticipate_millis()
/*      */     {
/*  523 */       RoleFactionPVE.this._xdb_verify_unsafe_();
/*  524 */       return RoleFactionPVE.this.participate_millis;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getParticipate_times()
/*      */     {
/*  531 */       RoleFactionPVE.this._xdb_verify_unsafe_();
/*  532 */       return RoleFactionPVE.this.participate_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getGoal()
/*      */     {
/*  539 */       RoleFactionPVE.this._xdb_verify_unsafe_();
/*  540 */       return xdb.Consts.constMap(RoleFactionPVE.this.goal);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getGoalAsData()
/*      */     {
/*  547 */       RoleFactionPVE.this._xdb_verify_unsafe_();
/*      */       
/*  549 */       RoleFactionPVE _o_ = RoleFactionPVE.this;
/*  550 */       Map<Integer, Integer> goal = new HashMap();
/*  551 */       for (Map.Entry<Integer, Integer> _e_ : _o_.goal.entrySet())
/*  552 */         goal.put(_e_.getKey(), _e_.getValue());
/*  553 */       return goal;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGoal_times()
/*      */     {
/*  560 */       RoleFactionPVE.this._xdb_verify_unsafe_();
/*  561 */       return RoleFactionPVE.this.goal_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getParticipate_faction()
/*      */     {
/*  568 */       RoleFactionPVE.this._xdb_verify_unsafe_();
/*  569 */       return RoleFactionPVE.this.participate_faction;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setParticipate_millis(long _v_)
/*      */     {
/*  576 */       RoleFactionPVE.this._xdb_verify_unsafe_();
/*  577 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setParticipate_times(int _v_)
/*      */     {
/*  584 */       RoleFactionPVE.this._xdb_verify_unsafe_();
/*  585 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGoal_times(int _v_)
/*      */     {
/*  592 */       RoleFactionPVE.this._xdb_verify_unsafe_();
/*  593 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setParticipate_faction(long _v_)
/*      */     {
/*  600 */       RoleFactionPVE.this._xdb_verify_unsafe_();
/*  601 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  607 */       RoleFactionPVE.this._xdb_verify_unsafe_();
/*  608 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  614 */       RoleFactionPVE.this._xdb_verify_unsafe_();
/*  615 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  621 */       return RoleFactionPVE.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  627 */       return RoleFactionPVE.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  633 */       RoleFactionPVE.this._xdb_verify_unsafe_();
/*  634 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  640 */       return RoleFactionPVE.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  646 */       return RoleFactionPVE.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  652 */       RoleFactionPVE.this._xdb_verify_unsafe_();
/*  653 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  659 */       return RoleFactionPVE.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  665 */       return RoleFactionPVE.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  671 */       return RoleFactionPVE.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  677 */       return RoleFactionPVE.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  683 */       return RoleFactionPVE.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  689 */       return RoleFactionPVE.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  695 */       return RoleFactionPVE.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RoleFactionPVE
/*      */   {
/*      */     private long participate_millis;
/*      */     
/*      */     private int participate_times;
/*      */     
/*      */     private HashMap<Integer, Integer> goal;
/*      */     
/*      */     private int goal_times;
/*      */     
/*      */     private long participate_faction;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  715 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  720 */       this.participate_millis = 0L;
/*  721 */       this.participate_times = 0;
/*  722 */       this.goal = new HashMap();
/*  723 */       this.goal_times = 0;
/*  724 */       this.participate_faction = 0L;
/*      */     }
/*      */     
/*      */     Data(xbean.RoleFactionPVE _o1_)
/*      */     {
/*  729 */       if ((_o1_ instanceof RoleFactionPVE)) { assign((RoleFactionPVE)_o1_);
/*  730 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  731 */       } else if ((_o1_ instanceof RoleFactionPVE.Const)) assign(((RoleFactionPVE.Const)_o1_).nThis()); else {
/*  732 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RoleFactionPVE _o_) {
/*  737 */       this.participate_millis = _o_.participate_millis;
/*  738 */       this.participate_times = _o_.participate_times;
/*  739 */       this.goal = new HashMap();
/*  740 */       for (Map.Entry<Integer, Integer> _e_ : _o_.goal.entrySet())
/*  741 */         this.goal.put(_e_.getKey(), _e_.getValue());
/*  742 */       this.goal_times = _o_.goal_times;
/*  743 */       this.participate_faction = _o_.participate_faction;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  748 */       this.participate_millis = _o_.participate_millis;
/*  749 */       this.participate_times = _o_.participate_times;
/*  750 */       this.goal = new HashMap();
/*  751 */       for (Map.Entry<Integer, Integer> _e_ : _o_.goal.entrySet())
/*  752 */         this.goal.put(_e_.getKey(), _e_.getValue());
/*  753 */       this.goal_times = _o_.goal_times;
/*  754 */       this.participate_faction = _o_.participate_faction;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  760 */       _os_.marshal(this.participate_millis);
/*  761 */       _os_.marshal(this.participate_times);
/*  762 */       _os_.compact_uint32(this.goal.size());
/*  763 */       for (Map.Entry<Integer, Integer> _e_ : this.goal.entrySet())
/*      */       {
/*  765 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  766 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  768 */       _os_.marshal(this.goal_times);
/*  769 */       _os_.marshal(this.participate_faction);
/*  770 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  776 */       this.participate_millis = _os_.unmarshal_long();
/*  777 */       this.participate_times = _os_.unmarshal_int();
/*      */       
/*  779 */       int size = _os_.uncompact_uint32();
/*  780 */       if (size >= 12)
/*      */       {
/*  782 */         this.goal = new HashMap(size * 2);
/*      */       }
/*  784 */       for (; size > 0; size--)
/*      */       {
/*  786 */         int _k_ = 0;
/*  787 */         _k_ = _os_.unmarshal_int();
/*  788 */         int _v_ = 0;
/*  789 */         _v_ = _os_.unmarshal_int();
/*  790 */         this.goal.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  793 */       this.goal_times = _os_.unmarshal_int();
/*  794 */       this.participate_faction = _os_.unmarshal_long();
/*  795 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  801 */       int _size_ = 0;
/*  802 */       _size_ += CodedOutputStream.computeInt64Size(1, this.participate_millis);
/*  803 */       _size_ += CodedOutputStream.computeInt32Size(2, this.participate_times);
/*  804 */       for (Map.Entry<Integer, Integer> _e_ : this.goal.entrySet())
/*      */       {
/*  806 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  807 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  809 */       _size_ += CodedOutputStream.computeInt32Size(4, this.goal_times);
/*  810 */       _size_ += CodedOutputStream.computeInt64Size(5, this.participate_faction);
/*  811 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  819 */         _output_.writeInt64(1, this.participate_millis);
/*  820 */         _output_.writeInt32(2, this.participate_times);
/*  821 */         for (Map.Entry<Integer, Integer> _e_ : this.goal.entrySet())
/*      */         {
/*  823 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  824 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  826 */         _output_.writeInt32(4, this.goal_times);
/*  827 */         _output_.writeInt64(5, this.participate_faction);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  831 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  833 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  841 */         boolean done = false;
/*  842 */         while (!done)
/*      */         {
/*  844 */           int tag = _input_.readTag();
/*  845 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  849 */             done = true;
/*  850 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  854 */             this.participate_millis = _input_.readInt64();
/*  855 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  859 */             this.participate_times = _input_.readInt32();
/*  860 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  864 */             int _k_ = 0;
/*  865 */             _k_ = _input_.readInt32();
/*  866 */             int readTag = _input_.readTag();
/*  867 */             if (24 != readTag)
/*      */             {
/*  869 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  871 */             int _v_ = 0;
/*  872 */             _v_ = _input_.readInt32();
/*  873 */             this.goal.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  874 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  878 */             this.goal_times = _input_.readInt32();
/*  879 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  883 */             this.participate_faction = _input_.readInt64();
/*  884 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  888 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  890 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  899 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  903 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  905 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleFactionPVE copy()
/*      */     {
/*  911 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleFactionPVE toData()
/*      */     {
/*  917 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RoleFactionPVE toBean()
/*      */     {
/*  922 */       return new RoleFactionPVE(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleFactionPVE toDataIf()
/*      */     {
/*  928 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RoleFactionPVE toBeanIf()
/*      */     {
/*  933 */       return new RoleFactionPVE(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  939 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  943 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  947 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  951 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  955 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  959 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  963 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getParticipate_millis()
/*      */     {
/*  970 */       return this.participate_millis;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getParticipate_times()
/*      */     {
/*  977 */       return this.participate_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getGoal()
/*      */     {
/*  984 */       return this.goal;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getGoalAsData()
/*      */     {
/*  991 */       return this.goal;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGoal_times()
/*      */     {
/*  998 */       return this.goal_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getParticipate_faction()
/*      */     {
/* 1005 */       return this.participate_faction;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setParticipate_millis(long _v_)
/*      */     {
/* 1012 */       this.participate_millis = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setParticipate_times(int _v_)
/*      */     {
/* 1019 */       this.participate_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGoal_times(int _v_)
/*      */     {
/* 1026 */       this.goal_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setParticipate_faction(long _v_)
/*      */     {
/* 1033 */       this.participate_faction = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1039 */       if (!(_o1_ instanceof Data)) return false;
/* 1040 */       Data _o_ = (Data)_o1_;
/* 1041 */       if (this.participate_millis != _o_.participate_millis) return false;
/* 1042 */       if (this.participate_times != _o_.participate_times) return false;
/* 1043 */       if (!this.goal.equals(_o_.goal)) return false;
/* 1044 */       if (this.goal_times != _o_.goal_times) return false;
/* 1045 */       if (this.participate_faction != _o_.participate_faction) return false;
/* 1046 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1052 */       int _h_ = 0;
/* 1053 */       _h_ = (int)(_h_ + this.participate_millis);
/* 1054 */       _h_ += this.participate_times;
/* 1055 */       _h_ += this.goal.hashCode();
/* 1056 */       _h_ += this.goal_times;
/* 1057 */       _h_ = (int)(_h_ + this.participate_faction);
/* 1058 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1064 */       StringBuilder _sb_ = new StringBuilder();
/* 1065 */       _sb_.append("(");
/* 1066 */       _sb_.append(this.participate_millis);
/* 1067 */       _sb_.append(",");
/* 1068 */       _sb_.append(this.participate_times);
/* 1069 */       _sb_.append(",");
/* 1070 */       _sb_.append(this.goal);
/* 1071 */       _sb_.append(",");
/* 1072 */       _sb_.append(this.goal_times);
/* 1073 */       _sb_.append(",");
/* 1074 */       _sb_.append(this.participate_faction);
/* 1075 */       _sb_.append(")");
/* 1076 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleFactionPVE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */