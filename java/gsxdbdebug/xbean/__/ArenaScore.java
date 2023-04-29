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
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class ArenaScore extends XBean implements xbean.ArenaScore
/*      */ {
/*      */   private int camp;
/*      */   private int score;
/*      */   private int action_point;
/*      */   private int win_times;
/*      */   private SetX<Integer> get_awards;
/*      */   private boolean participated;
/*      */   private HashMap<Long, Integer> matchroles;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.camp = -1;
/*   31 */     this.score = 0;
/*   32 */     this.action_point = 0;
/*   33 */     this.win_times = 0;
/*   34 */     this.get_awards.clear();
/*   35 */     this.participated = false;
/*   36 */     this.matchroles.clear();
/*      */   }
/*      */   
/*      */   ArenaScore(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.camp = -1;
/*   43 */     this.score = 0;
/*   44 */     this.action_point = 0;
/*   45 */     this.win_times = 0;
/*   46 */     this.get_awards = new SetX();
/*   47 */     this.participated = false;
/*   48 */     this.matchroles = new HashMap();
/*      */   }
/*      */   
/*      */   public ArenaScore()
/*      */   {
/*   53 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public ArenaScore(ArenaScore _o_)
/*      */   {
/*   58 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   ArenaScore(xbean.ArenaScore _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   63 */     super(_xp_, _vn_);
/*   64 */     if ((_o1_ instanceof ArenaScore)) { assign((ArenaScore)_o1_);
/*   65 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   66 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   67 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(ArenaScore _o_) {
/*   72 */     _o_._xdb_verify_unsafe_();
/*   73 */     this.camp = _o_.camp;
/*   74 */     this.score = _o_.score;
/*   75 */     this.action_point = _o_.action_point;
/*   76 */     this.win_times = _o_.win_times;
/*   77 */     this.get_awards = new SetX();
/*   78 */     this.get_awards.addAll(_o_.get_awards);
/*   79 */     this.participated = _o_.participated;
/*   80 */     this.matchroles = new HashMap();
/*   81 */     for (Map.Entry<Long, Integer> _e_ : _o_.matchroles.entrySet()) {
/*   82 */       this.matchroles.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   87 */     this.camp = _o_.camp;
/*   88 */     this.score = _o_.score;
/*   89 */     this.action_point = _o_.action_point;
/*   90 */     this.win_times = _o_.win_times;
/*   91 */     this.get_awards = new SetX();
/*   92 */     this.get_awards.addAll(_o_.get_awards);
/*   93 */     this.participated = _o_.participated;
/*   94 */     this.matchroles = new HashMap();
/*   95 */     for (Map.Entry<Long, Integer> _e_ : _o_.matchroles.entrySet()) {
/*   96 */       this.matchroles.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  102 */     _xdb_verify_unsafe_();
/*  103 */     _os_.marshal(this.camp);
/*  104 */     _os_.marshal(this.score);
/*  105 */     _os_.marshal(this.action_point);
/*  106 */     _os_.marshal(this.win_times);
/*  107 */     _os_.compact_uint32(this.get_awards.size());
/*  108 */     for (Integer _v_ : this.get_awards)
/*      */     {
/*  110 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  112 */     _os_.marshal(this.participated);
/*  113 */     _os_.compact_uint32(this.matchroles.size());
/*  114 */     for (Map.Entry<Long, Integer> _e_ : this.matchroles.entrySet())
/*      */     {
/*  116 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  117 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  119 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  125 */     _xdb_verify_unsafe_();
/*  126 */     this.camp = _os_.unmarshal_int();
/*  127 */     this.score = _os_.unmarshal_int();
/*  128 */     this.action_point = _os_.unmarshal_int();
/*  129 */     this.win_times = _os_.unmarshal_int();
/*  130 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  132 */       int _v_ = 0;
/*  133 */       _v_ = _os_.unmarshal_int();
/*  134 */       this.get_awards.add(Integer.valueOf(_v_));
/*      */     }
/*  136 */     this.participated = _os_.unmarshal_boolean();
/*      */     
/*  138 */     int size = _os_.uncompact_uint32();
/*  139 */     if (size >= 12)
/*      */     {
/*  141 */       this.matchroles = new HashMap(size * 2);
/*      */     }
/*  143 */     for (; size > 0; size--)
/*      */     {
/*  145 */       long _k_ = 0L;
/*  146 */       _k_ = _os_.unmarshal_long();
/*  147 */       int _v_ = 0;
/*  148 */       _v_ = _os_.unmarshal_int();
/*  149 */       this.matchroles.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  152 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  158 */     _xdb_verify_unsafe_();
/*  159 */     int _size_ = 0;
/*  160 */     _size_ += CodedOutputStream.computeInt32Size(1, this.camp);
/*  161 */     _size_ += CodedOutputStream.computeInt32Size(2, this.score);
/*  162 */     _size_ += CodedOutputStream.computeInt32Size(3, this.action_point);
/*  163 */     _size_ += CodedOutputStream.computeInt32Size(4, this.win_times);
/*  164 */     for (Integer _v_ : this.get_awards)
/*      */     {
/*  166 */       _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */     }
/*  168 */     _size_ += CodedOutputStream.computeBoolSize(6, this.participated);
/*  169 */     for (Map.Entry<Long, Integer> _e_ : this.matchroles.entrySet())
/*      */     {
/*  171 */       _size_ += CodedOutputStream.computeInt64Size(7, ((Long)_e_.getKey()).longValue());
/*  172 */       _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  174 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  180 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  183 */       _output_.writeInt32(1, this.camp);
/*  184 */       _output_.writeInt32(2, this.score);
/*  185 */       _output_.writeInt32(3, this.action_point);
/*  186 */       _output_.writeInt32(4, this.win_times);
/*  187 */       for (Integer _v_ : this.get_awards)
/*      */       {
/*  189 */         _output_.writeInt32(5, _v_.intValue());
/*      */       }
/*  191 */       _output_.writeBool(6, this.participated);
/*  192 */       for (Map.Entry<Long, Integer> _e_ : this.matchroles.entrySet())
/*      */       {
/*  194 */         _output_.writeInt64(7, ((Long)_e_.getKey()).longValue());
/*  195 */         _output_.writeInt32(7, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  200 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  202 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  208 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  211 */       boolean done = false;
/*  212 */       while (!done)
/*      */       {
/*  214 */         int tag = _input_.readTag();
/*  215 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  219 */           done = true;
/*  220 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  224 */           this.camp = _input_.readInt32();
/*  225 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  229 */           this.score = _input_.readInt32();
/*  230 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  234 */           this.action_point = _input_.readInt32();
/*  235 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  239 */           this.win_times = _input_.readInt32();
/*  240 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  244 */           int _v_ = 0;
/*  245 */           _v_ = _input_.readInt32();
/*  246 */           this.get_awards.add(Integer.valueOf(_v_));
/*  247 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  251 */           this.participated = _input_.readBool();
/*  252 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  256 */           long _k_ = 0L;
/*  257 */           _k_ = _input_.readInt64();
/*  258 */           int readTag = _input_.readTag();
/*  259 */           if (56 != readTag)
/*      */           {
/*  261 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  263 */           int _v_ = 0;
/*  264 */           _v_ = _input_.readInt32();
/*  265 */           this.matchroles.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  266 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  270 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  272 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  281 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  285 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  287 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ArenaScore copy()
/*      */   {
/*  293 */     _xdb_verify_unsafe_();
/*  294 */     return new ArenaScore(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ArenaScore toData()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ArenaScore toBean()
/*      */   {
/*  306 */     _xdb_verify_unsafe_();
/*  307 */     return new ArenaScore(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ArenaScore toDataIf()
/*      */   {
/*  313 */     _xdb_verify_unsafe_();
/*  314 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ArenaScore toBeanIf()
/*      */   {
/*  319 */     _xdb_verify_unsafe_();
/*  320 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*  327 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCamp()
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     return this.camp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getScore()
/*      */   {
/*  342 */     _xdb_verify_unsafe_();
/*  343 */     return this.score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAction_point()
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*  351 */     return this.action_point;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getWin_times()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*  359 */     return this.win_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getGet_awards()
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*  367 */     return xdb.Logs.logSet(new LogKey(this, "get_awards"), this.get_awards);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getGet_awardsAsData()
/*      */   {
/*  373 */     _xdb_verify_unsafe_();
/*      */     
/*  375 */     ArenaScore _o_ = this;
/*  376 */     Set<Integer> get_awards = new SetX();
/*  377 */     get_awards.addAll(_o_.get_awards);
/*  378 */     return get_awards;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getParticipated()
/*      */   {
/*  385 */     _xdb_verify_unsafe_();
/*  386 */     return this.participated;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getMatchroles()
/*      */   {
/*  393 */     _xdb_verify_unsafe_();
/*  394 */     return xdb.Logs.logMap(new LogKey(this, "matchroles"), this.matchroles);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getMatchrolesAsData()
/*      */   {
/*  401 */     _xdb_verify_unsafe_();
/*      */     
/*  403 */     ArenaScore _o_ = this;
/*  404 */     Map<Long, Integer> matchroles = new HashMap();
/*  405 */     for (Map.Entry<Long, Integer> _e_ : _o_.matchroles.entrySet())
/*  406 */       matchroles.put(_e_.getKey(), _e_.getValue());
/*  407 */     return matchroles;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCamp(int _v_)
/*      */   {
/*  414 */     _xdb_verify_unsafe_();
/*  415 */     xdb.Logs.logIf(new LogKey(this, "camp")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  419 */         new xdb.logs.LogInt(this, ArenaScore.this.camp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  423 */             ArenaScore.this.camp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  427 */     });
/*  428 */     this.camp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setScore(int _v_)
/*      */   {
/*  435 */     _xdb_verify_unsafe_();
/*  436 */     xdb.Logs.logIf(new LogKey(this, "score")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  440 */         new xdb.logs.LogInt(this, ArenaScore.this.score)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  444 */             ArenaScore.this.score = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  448 */     });
/*  449 */     this.score = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAction_point(int _v_)
/*      */   {
/*  456 */     _xdb_verify_unsafe_();
/*  457 */     xdb.Logs.logIf(new LogKey(this, "action_point")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  461 */         new xdb.logs.LogInt(this, ArenaScore.this.action_point)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  465 */             ArenaScore.this.action_point = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  469 */     });
/*  470 */     this.action_point = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWin_times(int _v_)
/*      */   {
/*  477 */     _xdb_verify_unsafe_();
/*  478 */     xdb.Logs.logIf(new LogKey(this, "win_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  482 */         new xdb.logs.LogInt(this, ArenaScore.this.win_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  486 */             ArenaScore.this.win_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  490 */     });
/*  491 */     this.win_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setParticipated(boolean _v_)
/*      */   {
/*  498 */     _xdb_verify_unsafe_();
/*  499 */     xdb.Logs.logIf(new LogKey(this, "participated")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  503 */         new xdb.logs.LogObject(this, Boolean.valueOf(ArenaScore.this.participated))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  507 */             ArenaScore.this.participated = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  511 */     });
/*  512 */     this.participated = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  518 */     _xdb_verify_unsafe_();
/*  519 */     ArenaScore _o_ = null;
/*  520 */     if ((_o1_ instanceof ArenaScore)) { _o_ = (ArenaScore)_o1_;
/*  521 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  522 */       return false;
/*  523 */     if (this.camp != _o_.camp) return false;
/*  524 */     if (this.score != _o_.score) return false;
/*  525 */     if (this.action_point != _o_.action_point) return false;
/*  526 */     if (this.win_times != _o_.win_times) return false;
/*  527 */     if (!this.get_awards.equals(_o_.get_awards)) return false;
/*  528 */     if (this.participated != _o_.participated) return false;
/*  529 */     if (!this.matchroles.equals(_o_.matchroles)) return false;
/*  530 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  536 */     _xdb_verify_unsafe_();
/*  537 */     int _h_ = 0;
/*  538 */     _h_ += this.camp;
/*  539 */     _h_ += this.score;
/*  540 */     _h_ += this.action_point;
/*  541 */     _h_ += this.win_times;
/*  542 */     _h_ += this.get_awards.hashCode();
/*  543 */     _h_ += (this.participated ? 1231 : 1237);
/*  544 */     _h_ += this.matchroles.hashCode();
/*  545 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  551 */     _xdb_verify_unsafe_();
/*  552 */     StringBuilder _sb_ = new StringBuilder();
/*  553 */     _sb_.append("(");
/*  554 */     _sb_.append(this.camp);
/*  555 */     _sb_.append(",");
/*  556 */     _sb_.append(this.score);
/*  557 */     _sb_.append(",");
/*  558 */     _sb_.append(this.action_point);
/*  559 */     _sb_.append(",");
/*  560 */     _sb_.append(this.win_times);
/*  561 */     _sb_.append(",");
/*  562 */     _sb_.append(this.get_awards);
/*  563 */     _sb_.append(",");
/*  564 */     _sb_.append(this.participated);
/*  565 */     _sb_.append(",");
/*  566 */     _sb_.append(this.matchroles);
/*  567 */     _sb_.append(")");
/*  568 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  574 */     ListenableBean lb = new ListenableBean();
/*  575 */     lb.add(new ListenableChanged().setVarName("camp"));
/*  576 */     lb.add(new ListenableChanged().setVarName("score"));
/*  577 */     lb.add(new ListenableChanged().setVarName("action_point"));
/*  578 */     lb.add(new ListenableChanged().setVarName("win_times"));
/*  579 */     lb.add(new xdb.logs.ListenableSet().setVarName("get_awards"));
/*  580 */     lb.add(new ListenableChanged().setVarName("participated"));
/*  581 */     lb.add(new xdb.logs.ListenableMap().setVarName("matchroles"));
/*  582 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.ArenaScore {
/*      */     private Const() {}
/*      */     
/*      */     ArenaScore nThis() {
/*  589 */       return ArenaScore.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  595 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ArenaScore copy()
/*      */     {
/*  601 */       return ArenaScore.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ArenaScore toData()
/*      */     {
/*  607 */       return ArenaScore.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.ArenaScore toBean()
/*      */     {
/*  612 */       return ArenaScore.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ArenaScore toDataIf()
/*      */     {
/*  618 */       return ArenaScore.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.ArenaScore toBeanIf()
/*      */     {
/*  623 */       return ArenaScore.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCamp()
/*      */     {
/*  630 */       ArenaScore.this._xdb_verify_unsafe_();
/*  631 */       return ArenaScore.this.camp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getScore()
/*      */     {
/*  638 */       ArenaScore.this._xdb_verify_unsafe_();
/*  639 */       return ArenaScore.this.score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAction_point()
/*      */     {
/*  646 */       ArenaScore.this._xdb_verify_unsafe_();
/*  647 */       return ArenaScore.this.action_point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_times()
/*      */     {
/*  654 */       ArenaScore.this._xdb_verify_unsafe_();
/*  655 */       return ArenaScore.this.win_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getGet_awards()
/*      */     {
/*  662 */       ArenaScore.this._xdb_verify_unsafe_();
/*  663 */       return xdb.Consts.constSet(ArenaScore.this.get_awards);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getGet_awardsAsData()
/*      */     {
/*  669 */       ArenaScore.this._xdb_verify_unsafe_();
/*      */       
/*  671 */       ArenaScore _o_ = ArenaScore.this;
/*  672 */       Set<Integer> get_awards = new SetX();
/*  673 */       get_awards.addAll(_o_.get_awards);
/*  674 */       return get_awards;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getParticipated()
/*      */     {
/*  681 */       ArenaScore.this._xdb_verify_unsafe_();
/*  682 */       return ArenaScore.this.participated;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getMatchroles()
/*      */     {
/*  689 */       ArenaScore.this._xdb_verify_unsafe_();
/*  690 */       return xdb.Consts.constMap(ArenaScore.this.matchroles);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getMatchrolesAsData()
/*      */     {
/*  697 */       ArenaScore.this._xdb_verify_unsafe_();
/*      */       
/*  699 */       ArenaScore _o_ = ArenaScore.this;
/*  700 */       Map<Long, Integer> matchroles = new HashMap();
/*  701 */       for (Map.Entry<Long, Integer> _e_ : _o_.matchroles.entrySet())
/*  702 */         matchroles.put(_e_.getKey(), _e_.getValue());
/*  703 */       return matchroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCamp(int _v_)
/*      */     {
/*  710 */       ArenaScore.this._xdb_verify_unsafe_();
/*  711 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setScore(int _v_)
/*      */     {
/*  718 */       ArenaScore.this._xdb_verify_unsafe_();
/*  719 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAction_point(int _v_)
/*      */     {
/*  726 */       ArenaScore.this._xdb_verify_unsafe_();
/*  727 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_times(int _v_)
/*      */     {
/*  734 */       ArenaScore.this._xdb_verify_unsafe_();
/*  735 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setParticipated(boolean _v_)
/*      */     {
/*  742 */       ArenaScore.this._xdb_verify_unsafe_();
/*  743 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  749 */       ArenaScore.this._xdb_verify_unsafe_();
/*  750 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  756 */       ArenaScore.this._xdb_verify_unsafe_();
/*  757 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  763 */       return ArenaScore.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  769 */       return ArenaScore.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  775 */       ArenaScore.this._xdb_verify_unsafe_();
/*  776 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  782 */       return ArenaScore.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  788 */       return ArenaScore.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  794 */       ArenaScore.this._xdb_verify_unsafe_();
/*  795 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  801 */       return ArenaScore.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  807 */       return ArenaScore.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  813 */       return ArenaScore.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  819 */       return ArenaScore.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  825 */       return ArenaScore.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  831 */       return ArenaScore.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  837 */       return ArenaScore.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.ArenaScore
/*      */   {
/*      */     private int camp;
/*      */     
/*      */     private int score;
/*      */     
/*      */     private int action_point;
/*      */     
/*      */     private int win_times;
/*      */     
/*      */     private HashSet<Integer> get_awards;
/*      */     
/*      */     private boolean participated;
/*      */     
/*      */     private HashMap<Long, Integer> matchroles;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  861 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  866 */       this.camp = -1;
/*  867 */       this.score = 0;
/*  868 */       this.action_point = 0;
/*  869 */       this.win_times = 0;
/*  870 */       this.get_awards = new HashSet();
/*  871 */       this.participated = false;
/*  872 */       this.matchroles = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.ArenaScore _o1_)
/*      */     {
/*  877 */       if ((_o1_ instanceof ArenaScore)) { assign((ArenaScore)_o1_);
/*  878 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  879 */       } else if ((_o1_ instanceof ArenaScore.Const)) assign(((ArenaScore.Const)_o1_).nThis()); else {
/*  880 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(ArenaScore _o_) {
/*  885 */       this.camp = _o_.camp;
/*  886 */       this.score = _o_.score;
/*  887 */       this.action_point = _o_.action_point;
/*  888 */       this.win_times = _o_.win_times;
/*  889 */       this.get_awards = new HashSet();
/*  890 */       this.get_awards.addAll(_o_.get_awards);
/*  891 */       this.participated = _o_.participated;
/*  892 */       this.matchroles = new HashMap();
/*  893 */       for (Map.Entry<Long, Integer> _e_ : _o_.matchroles.entrySet()) {
/*  894 */         this.matchroles.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  899 */       this.camp = _o_.camp;
/*  900 */       this.score = _o_.score;
/*  901 */       this.action_point = _o_.action_point;
/*  902 */       this.win_times = _o_.win_times;
/*  903 */       this.get_awards = new HashSet();
/*  904 */       this.get_awards.addAll(_o_.get_awards);
/*  905 */       this.participated = _o_.participated;
/*  906 */       this.matchroles = new HashMap();
/*  907 */       for (Map.Entry<Long, Integer> _e_ : _o_.matchroles.entrySet()) {
/*  908 */         this.matchroles.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  914 */       _os_.marshal(this.camp);
/*  915 */       _os_.marshal(this.score);
/*  916 */       _os_.marshal(this.action_point);
/*  917 */       _os_.marshal(this.win_times);
/*  918 */       _os_.compact_uint32(this.get_awards.size());
/*  919 */       for (Integer _v_ : this.get_awards)
/*      */       {
/*  921 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  923 */       _os_.marshal(this.participated);
/*  924 */       _os_.compact_uint32(this.matchroles.size());
/*  925 */       for (Map.Entry<Long, Integer> _e_ : this.matchroles.entrySet())
/*      */       {
/*  927 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  928 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  930 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  936 */       this.camp = _os_.unmarshal_int();
/*  937 */       this.score = _os_.unmarshal_int();
/*  938 */       this.action_point = _os_.unmarshal_int();
/*  939 */       this.win_times = _os_.unmarshal_int();
/*  940 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  942 */         int _v_ = 0;
/*  943 */         _v_ = _os_.unmarshal_int();
/*  944 */         this.get_awards.add(Integer.valueOf(_v_));
/*      */       }
/*  946 */       this.participated = _os_.unmarshal_boolean();
/*      */       
/*  948 */       int size = _os_.uncompact_uint32();
/*  949 */       if (size >= 12)
/*      */       {
/*  951 */         this.matchroles = new HashMap(size * 2);
/*      */       }
/*  953 */       for (; size > 0; size--)
/*      */       {
/*  955 */         long _k_ = 0L;
/*  956 */         _k_ = _os_.unmarshal_long();
/*  957 */         int _v_ = 0;
/*  958 */         _v_ = _os_.unmarshal_int();
/*  959 */         this.matchroles.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  962 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  968 */       int _size_ = 0;
/*  969 */       _size_ += CodedOutputStream.computeInt32Size(1, this.camp);
/*  970 */       _size_ += CodedOutputStream.computeInt32Size(2, this.score);
/*  971 */       _size_ += CodedOutputStream.computeInt32Size(3, this.action_point);
/*  972 */       _size_ += CodedOutputStream.computeInt32Size(4, this.win_times);
/*  973 */       for (Integer _v_ : this.get_awards)
/*      */       {
/*  975 */         _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */       }
/*  977 */       _size_ += CodedOutputStream.computeBoolSize(6, this.participated);
/*  978 */       for (Map.Entry<Long, Integer> _e_ : this.matchroles.entrySet())
/*      */       {
/*  980 */         _size_ += CodedOutputStream.computeInt64Size(7, ((Long)_e_.getKey()).longValue());
/*  981 */         _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  983 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  991 */         _output_.writeInt32(1, this.camp);
/*  992 */         _output_.writeInt32(2, this.score);
/*  993 */         _output_.writeInt32(3, this.action_point);
/*  994 */         _output_.writeInt32(4, this.win_times);
/*  995 */         for (Integer _v_ : this.get_awards)
/*      */         {
/*  997 */           _output_.writeInt32(5, _v_.intValue());
/*      */         }
/*  999 */         _output_.writeBool(6, this.participated);
/* 1000 */         for (Map.Entry<Long, Integer> _e_ : this.matchroles.entrySet())
/*      */         {
/* 1002 */           _output_.writeInt64(7, ((Long)_e_.getKey()).longValue());
/* 1003 */           _output_.writeInt32(7, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1008 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1010 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1018 */         boolean done = false;
/* 1019 */         while (!done)
/*      */         {
/* 1021 */           int tag = _input_.readTag();
/* 1022 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1026 */             done = true;
/* 1027 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1031 */             this.camp = _input_.readInt32();
/* 1032 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1036 */             this.score = _input_.readInt32();
/* 1037 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1041 */             this.action_point = _input_.readInt32();
/* 1042 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1046 */             this.win_times = _input_.readInt32();
/* 1047 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1051 */             int _v_ = 0;
/* 1052 */             _v_ = _input_.readInt32();
/* 1053 */             this.get_awards.add(Integer.valueOf(_v_));
/* 1054 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1058 */             this.participated = _input_.readBool();
/* 1059 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1063 */             long _k_ = 0L;
/* 1064 */             _k_ = _input_.readInt64();
/* 1065 */             int readTag = _input_.readTag();
/* 1066 */             if (56 != readTag)
/*      */             {
/* 1068 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1070 */             int _v_ = 0;
/* 1071 */             _v_ = _input_.readInt32();
/* 1072 */             this.matchroles.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 1073 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1077 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1079 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1088 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1092 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1094 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ArenaScore copy()
/*      */     {
/* 1100 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ArenaScore toData()
/*      */     {
/* 1106 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.ArenaScore toBean()
/*      */     {
/* 1111 */       return new ArenaScore(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ArenaScore toDataIf()
/*      */     {
/* 1117 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.ArenaScore toBeanIf()
/*      */     {
/* 1122 */       return new ArenaScore(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1128 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1132 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1136 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1140 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1144 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1148 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1152 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCamp()
/*      */     {
/* 1159 */       return this.camp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getScore()
/*      */     {
/* 1166 */       return this.score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAction_point()
/*      */     {
/* 1173 */       return this.action_point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_times()
/*      */     {
/* 1180 */       return this.win_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getGet_awards()
/*      */     {
/* 1187 */       return this.get_awards;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getGet_awardsAsData()
/*      */     {
/* 1194 */       return this.get_awards;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getParticipated()
/*      */     {
/* 1201 */       return this.participated;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getMatchroles()
/*      */     {
/* 1208 */       return this.matchroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getMatchrolesAsData()
/*      */     {
/* 1215 */       return this.matchroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCamp(int _v_)
/*      */     {
/* 1222 */       this.camp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setScore(int _v_)
/*      */     {
/* 1229 */       this.score = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAction_point(int _v_)
/*      */     {
/* 1236 */       this.action_point = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_times(int _v_)
/*      */     {
/* 1243 */       this.win_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setParticipated(boolean _v_)
/*      */     {
/* 1250 */       this.participated = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1256 */       if (!(_o1_ instanceof Data)) return false;
/* 1257 */       Data _o_ = (Data)_o1_;
/* 1258 */       if (this.camp != _o_.camp) return false;
/* 1259 */       if (this.score != _o_.score) return false;
/* 1260 */       if (this.action_point != _o_.action_point) return false;
/* 1261 */       if (this.win_times != _o_.win_times) return false;
/* 1262 */       if (!this.get_awards.equals(_o_.get_awards)) return false;
/* 1263 */       if (this.participated != _o_.participated) return false;
/* 1264 */       if (!this.matchroles.equals(_o_.matchroles)) return false;
/* 1265 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1271 */       int _h_ = 0;
/* 1272 */       _h_ += this.camp;
/* 1273 */       _h_ += this.score;
/* 1274 */       _h_ += this.action_point;
/* 1275 */       _h_ += this.win_times;
/* 1276 */       _h_ += this.get_awards.hashCode();
/* 1277 */       _h_ += (this.participated ? 1231 : 1237);
/* 1278 */       _h_ += this.matchroles.hashCode();
/* 1279 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1285 */       StringBuilder _sb_ = new StringBuilder();
/* 1286 */       _sb_.append("(");
/* 1287 */       _sb_.append(this.camp);
/* 1288 */       _sb_.append(",");
/* 1289 */       _sb_.append(this.score);
/* 1290 */       _sb_.append(",");
/* 1291 */       _sb_.append(this.action_point);
/* 1292 */       _sb_.append(",");
/* 1293 */       _sb_.append(this.win_times);
/* 1294 */       _sb_.append(",");
/* 1295 */       _sb_.append(this.get_awards);
/* 1296 */       _sb_.append(",");
/* 1297 */       _sb_.append(this.participated);
/* 1298 */       _sb_.append(",");
/* 1299 */       _sb_.append(this.matchroles);
/* 1300 */       _sb_.append(")");
/* 1301 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ArenaScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */