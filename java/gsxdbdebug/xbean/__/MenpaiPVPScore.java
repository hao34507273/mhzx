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
/*      */ public final class MenpaiPVPScore extends XBean implements xbean.MenpaiPVPScore
/*      */ {
/*      */   private int score;
/*      */   private int win_times;
/*      */   private int lose_times;
/*      */   private HashMap<Long, Integer> matchroles;
/*      */   private boolean participated;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.score = 0;
/*   27 */     this.win_times = 0;
/*   28 */     this.lose_times = 0;
/*   29 */     this.matchroles.clear();
/*   30 */     this.participated = false;
/*      */   }
/*      */   
/*      */   MenpaiPVPScore(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.score = 0;
/*   37 */     this.win_times = 0;
/*   38 */     this.lose_times = 0;
/*   39 */     this.matchroles = new HashMap();
/*   40 */     this.participated = false;
/*      */   }
/*      */   
/*      */   public MenpaiPVPScore()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public MenpaiPVPScore(MenpaiPVPScore _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   MenpaiPVPScore(xbean.MenpaiPVPScore _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof MenpaiPVPScore)) { assign((MenpaiPVPScore)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(MenpaiPVPScore _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.score = _o_.score;
/*   66 */     this.win_times = _o_.win_times;
/*   67 */     this.lose_times = _o_.lose_times;
/*   68 */     this.matchroles = new HashMap();
/*   69 */     for (Map.Entry<Long, Integer> _e_ : _o_.matchroles.entrySet())
/*   70 */       this.matchroles.put(_e_.getKey(), _e_.getValue());
/*   71 */     this.participated = _o_.participated;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   76 */     this.score = _o_.score;
/*   77 */     this.win_times = _o_.win_times;
/*   78 */     this.lose_times = _o_.lose_times;
/*   79 */     this.matchroles = new HashMap();
/*   80 */     for (Map.Entry<Long, Integer> _e_ : _o_.matchroles.entrySet())
/*   81 */       this.matchroles.put(_e_.getKey(), _e_.getValue());
/*   82 */     this.participated = _o_.participated;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   88 */     _xdb_verify_unsafe_();
/*   89 */     _os_.marshal(this.score);
/*   90 */     _os_.marshal(this.win_times);
/*   91 */     _os_.marshal(this.lose_times);
/*   92 */     _os_.compact_uint32(this.matchroles.size());
/*   93 */     for (Map.Entry<Long, Integer> _e_ : this.matchroles.entrySet())
/*      */     {
/*   95 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*   96 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*   98 */     _os_.marshal(this.participated);
/*   99 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  105 */     _xdb_verify_unsafe_();
/*  106 */     this.score = _os_.unmarshal_int();
/*  107 */     this.win_times = _os_.unmarshal_int();
/*  108 */     this.lose_times = _os_.unmarshal_int();
/*      */     
/*  110 */     int size = _os_.uncompact_uint32();
/*  111 */     if (size >= 12)
/*      */     {
/*  113 */       this.matchroles = new HashMap(size * 2);
/*      */     }
/*  115 */     for (; size > 0; size--)
/*      */     {
/*  117 */       long _k_ = 0L;
/*  118 */       _k_ = _os_.unmarshal_long();
/*  119 */       int _v_ = 0;
/*  120 */       _v_ = _os_.unmarshal_int();
/*  121 */       this.matchroles.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  124 */     this.participated = _os_.unmarshal_boolean();
/*  125 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  131 */     _xdb_verify_unsafe_();
/*  132 */     int _size_ = 0;
/*  133 */     _size_ += CodedOutputStream.computeInt32Size(1, this.score);
/*  134 */     _size_ += CodedOutputStream.computeInt32Size(2, this.win_times);
/*  135 */     _size_ += CodedOutputStream.computeInt32Size(3, this.lose_times);
/*  136 */     for (Map.Entry<Long, Integer> _e_ : this.matchroles.entrySet())
/*      */     {
/*  138 */       _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/*  139 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  141 */     _size_ += CodedOutputStream.computeBoolSize(5, this.participated);
/*  142 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  148 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  151 */       _output_.writeInt32(1, this.score);
/*  152 */       _output_.writeInt32(2, this.win_times);
/*  153 */       _output_.writeInt32(3, this.lose_times);
/*  154 */       for (Map.Entry<Long, Integer> _e_ : this.matchroles.entrySet())
/*      */       {
/*  156 */         _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/*  157 */         _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  159 */       _output_.writeBool(5, this.participated);
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
/*  187 */           this.score = _input_.readInt32();
/*  188 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  192 */           this.win_times = _input_.readInt32();
/*  193 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  197 */           this.lose_times = _input_.readInt32();
/*  198 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  202 */           long _k_ = 0L;
/*  203 */           _k_ = _input_.readInt64();
/*  204 */           int readTag = _input_.readTag();
/*  205 */           if (32 != readTag)
/*      */           {
/*  207 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  209 */           int _v_ = 0;
/*  210 */           _v_ = _input_.readInt32();
/*  211 */           this.matchroles.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  212 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  216 */           this.participated = _input_.readBool();
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
/*      */   public xbean.MenpaiPVPScore copy()
/*      */   {
/*  244 */     _xdb_verify_unsafe_();
/*  245 */     return new MenpaiPVPScore(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MenpaiPVPScore toData()
/*      */   {
/*  251 */     _xdb_verify_unsafe_();
/*  252 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MenpaiPVPScore toBean()
/*      */   {
/*  257 */     _xdb_verify_unsafe_();
/*  258 */     return new MenpaiPVPScore(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MenpaiPVPScore toDataIf()
/*      */   {
/*  264 */     _xdb_verify_unsafe_();
/*  265 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MenpaiPVPScore toBeanIf()
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
/*      */   public int getScore()
/*      */   {
/*  285 */     _xdb_verify_unsafe_();
/*  286 */     return this.score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getWin_times()
/*      */   {
/*  293 */     _xdb_verify_unsafe_();
/*  294 */     return this.win_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLose_times()
/*      */   {
/*  301 */     _xdb_verify_unsafe_();
/*  302 */     return this.lose_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getMatchroles()
/*      */   {
/*  309 */     _xdb_verify_unsafe_();
/*  310 */     return xdb.Logs.logMap(new LogKey(this, "matchroles"), this.matchroles);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getMatchrolesAsData()
/*      */   {
/*  317 */     _xdb_verify_unsafe_();
/*      */     
/*  319 */     MenpaiPVPScore _o_ = this;
/*  320 */     Map<Long, Integer> matchroles = new HashMap();
/*  321 */     for (Map.Entry<Long, Integer> _e_ : _o_.matchroles.entrySet())
/*  322 */       matchroles.put(_e_.getKey(), _e_.getValue());
/*  323 */     return matchroles;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getParticipated()
/*      */   {
/*  330 */     _xdb_verify_unsafe_();
/*  331 */     return this.participated;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setScore(int _v_)
/*      */   {
/*  338 */     _xdb_verify_unsafe_();
/*  339 */     xdb.Logs.logIf(new LogKey(this, "score")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  343 */         new xdb.logs.LogInt(this, MenpaiPVPScore.this.score)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  347 */             MenpaiPVPScore.this.score = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  351 */     });
/*  352 */     this.score = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWin_times(int _v_)
/*      */   {
/*  359 */     _xdb_verify_unsafe_();
/*  360 */     xdb.Logs.logIf(new LogKey(this, "win_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  364 */         new xdb.logs.LogInt(this, MenpaiPVPScore.this.win_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  368 */             MenpaiPVPScore.this.win_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  372 */     });
/*  373 */     this.win_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLose_times(int _v_)
/*      */   {
/*  380 */     _xdb_verify_unsafe_();
/*  381 */     xdb.Logs.logIf(new LogKey(this, "lose_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  385 */         new xdb.logs.LogInt(this, MenpaiPVPScore.this.lose_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  389 */             MenpaiPVPScore.this.lose_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  393 */     });
/*  394 */     this.lose_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setParticipated(boolean _v_)
/*      */   {
/*  401 */     _xdb_verify_unsafe_();
/*  402 */     xdb.Logs.logIf(new LogKey(this, "participated")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  406 */         new xdb.logs.LogObject(this, Boolean.valueOf(MenpaiPVPScore.this.participated))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  410 */             MenpaiPVPScore.this.participated = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  414 */     });
/*  415 */     this.participated = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  421 */     _xdb_verify_unsafe_();
/*  422 */     MenpaiPVPScore _o_ = null;
/*  423 */     if ((_o1_ instanceof MenpaiPVPScore)) { _o_ = (MenpaiPVPScore)_o1_;
/*  424 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  425 */       return false;
/*  426 */     if (this.score != _o_.score) return false;
/*  427 */     if (this.win_times != _o_.win_times) return false;
/*  428 */     if (this.lose_times != _o_.lose_times) return false;
/*  429 */     if (!this.matchroles.equals(_o_.matchroles)) return false;
/*  430 */     if (this.participated != _o_.participated) return false;
/*  431 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  437 */     _xdb_verify_unsafe_();
/*  438 */     int _h_ = 0;
/*  439 */     _h_ += this.score;
/*  440 */     _h_ += this.win_times;
/*  441 */     _h_ += this.lose_times;
/*  442 */     _h_ += this.matchroles.hashCode();
/*  443 */     _h_ += (this.participated ? 1231 : 1237);
/*  444 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  450 */     _xdb_verify_unsafe_();
/*  451 */     StringBuilder _sb_ = new StringBuilder();
/*  452 */     _sb_.append("(");
/*  453 */     _sb_.append(this.score);
/*  454 */     _sb_.append(",");
/*  455 */     _sb_.append(this.win_times);
/*  456 */     _sb_.append(",");
/*  457 */     _sb_.append(this.lose_times);
/*  458 */     _sb_.append(",");
/*  459 */     _sb_.append(this.matchroles);
/*  460 */     _sb_.append(",");
/*  461 */     _sb_.append(this.participated);
/*  462 */     _sb_.append(")");
/*  463 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  469 */     ListenableBean lb = new ListenableBean();
/*  470 */     lb.add(new ListenableChanged().setVarName("score"));
/*  471 */     lb.add(new ListenableChanged().setVarName("win_times"));
/*  472 */     lb.add(new ListenableChanged().setVarName("lose_times"));
/*  473 */     lb.add(new xdb.logs.ListenableMap().setVarName("matchroles"));
/*  474 */     lb.add(new ListenableChanged().setVarName("participated"));
/*  475 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.MenpaiPVPScore {
/*      */     private Const() {}
/*      */     
/*      */     MenpaiPVPScore nThis() {
/*  482 */       return MenpaiPVPScore.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  488 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MenpaiPVPScore copy()
/*      */     {
/*  494 */       return MenpaiPVPScore.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MenpaiPVPScore toData()
/*      */     {
/*  500 */       return MenpaiPVPScore.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.MenpaiPVPScore toBean()
/*      */     {
/*  505 */       return MenpaiPVPScore.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MenpaiPVPScore toDataIf()
/*      */     {
/*  511 */       return MenpaiPVPScore.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.MenpaiPVPScore toBeanIf()
/*      */     {
/*  516 */       return MenpaiPVPScore.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getScore()
/*      */     {
/*  523 */       MenpaiPVPScore.this._xdb_verify_unsafe_();
/*  524 */       return MenpaiPVPScore.this.score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_times()
/*      */     {
/*  531 */       MenpaiPVPScore.this._xdb_verify_unsafe_();
/*  532 */       return MenpaiPVPScore.this.win_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLose_times()
/*      */     {
/*  539 */       MenpaiPVPScore.this._xdb_verify_unsafe_();
/*  540 */       return MenpaiPVPScore.this.lose_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getMatchroles()
/*      */     {
/*  547 */       MenpaiPVPScore.this._xdb_verify_unsafe_();
/*  548 */       return xdb.Consts.constMap(MenpaiPVPScore.this.matchroles);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getMatchrolesAsData()
/*      */     {
/*  555 */       MenpaiPVPScore.this._xdb_verify_unsafe_();
/*      */       
/*  557 */       MenpaiPVPScore _o_ = MenpaiPVPScore.this;
/*  558 */       Map<Long, Integer> matchroles = new HashMap();
/*  559 */       for (Map.Entry<Long, Integer> _e_ : _o_.matchroles.entrySet())
/*  560 */         matchroles.put(_e_.getKey(), _e_.getValue());
/*  561 */       return matchroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getParticipated()
/*      */     {
/*  568 */       MenpaiPVPScore.this._xdb_verify_unsafe_();
/*  569 */       return MenpaiPVPScore.this.participated;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setScore(int _v_)
/*      */     {
/*  576 */       MenpaiPVPScore.this._xdb_verify_unsafe_();
/*  577 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_times(int _v_)
/*      */     {
/*  584 */       MenpaiPVPScore.this._xdb_verify_unsafe_();
/*  585 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLose_times(int _v_)
/*      */     {
/*  592 */       MenpaiPVPScore.this._xdb_verify_unsafe_();
/*  593 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setParticipated(boolean _v_)
/*      */     {
/*  600 */       MenpaiPVPScore.this._xdb_verify_unsafe_();
/*  601 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  607 */       MenpaiPVPScore.this._xdb_verify_unsafe_();
/*  608 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  614 */       MenpaiPVPScore.this._xdb_verify_unsafe_();
/*  615 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  621 */       return MenpaiPVPScore.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  627 */       return MenpaiPVPScore.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  633 */       MenpaiPVPScore.this._xdb_verify_unsafe_();
/*  634 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  640 */       return MenpaiPVPScore.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  646 */       return MenpaiPVPScore.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  652 */       MenpaiPVPScore.this._xdb_verify_unsafe_();
/*  653 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  659 */       return MenpaiPVPScore.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  665 */       return MenpaiPVPScore.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  671 */       return MenpaiPVPScore.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  677 */       return MenpaiPVPScore.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  683 */       return MenpaiPVPScore.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  689 */       return MenpaiPVPScore.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  695 */       return MenpaiPVPScore.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.MenpaiPVPScore
/*      */   {
/*      */     private int score;
/*      */     
/*      */     private int win_times;
/*      */     
/*      */     private int lose_times;
/*      */     
/*      */     private HashMap<Long, Integer> matchroles;
/*      */     
/*      */     private boolean participated;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  715 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  720 */       this.score = 0;
/*  721 */       this.win_times = 0;
/*  722 */       this.lose_times = 0;
/*  723 */       this.matchroles = new HashMap();
/*  724 */       this.participated = false;
/*      */     }
/*      */     
/*      */     Data(xbean.MenpaiPVPScore _o1_)
/*      */     {
/*  729 */       if ((_o1_ instanceof MenpaiPVPScore)) { assign((MenpaiPVPScore)_o1_);
/*  730 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  731 */       } else if ((_o1_ instanceof MenpaiPVPScore.Const)) assign(((MenpaiPVPScore.Const)_o1_).nThis()); else {
/*  732 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(MenpaiPVPScore _o_) {
/*  737 */       this.score = _o_.score;
/*  738 */       this.win_times = _o_.win_times;
/*  739 */       this.lose_times = _o_.lose_times;
/*  740 */       this.matchroles = new HashMap();
/*  741 */       for (Map.Entry<Long, Integer> _e_ : _o_.matchroles.entrySet())
/*  742 */         this.matchroles.put(_e_.getKey(), _e_.getValue());
/*  743 */       this.participated = _o_.participated;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  748 */       this.score = _o_.score;
/*  749 */       this.win_times = _o_.win_times;
/*  750 */       this.lose_times = _o_.lose_times;
/*  751 */       this.matchroles = new HashMap();
/*  752 */       for (Map.Entry<Long, Integer> _e_ : _o_.matchroles.entrySet())
/*  753 */         this.matchroles.put(_e_.getKey(), _e_.getValue());
/*  754 */       this.participated = _o_.participated;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  760 */       _os_.marshal(this.score);
/*  761 */       _os_.marshal(this.win_times);
/*  762 */       _os_.marshal(this.lose_times);
/*  763 */       _os_.compact_uint32(this.matchroles.size());
/*  764 */       for (Map.Entry<Long, Integer> _e_ : this.matchroles.entrySet())
/*      */       {
/*  766 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  767 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  769 */       _os_.marshal(this.participated);
/*  770 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  776 */       this.score = _os_.unmarshal_int();
/*  777 */       this.win_times = _os_.unmarshal_int();
/*  778 */       this.lose_times = _os_.unmarshal_int();
/*      */       
/*  780 */       int size = _os_.uncompact_uint32();
/*  781 */       if (size >= 12)
/*      */       {
/*  783 */         this.matchroles = new HashMap(size * 2);
/*      */       }
/*  785 */       for (; size > 0; size--)
/*      */       {
/*  787 */         long _k_ = 0L;
/*  788 */         _k_ = _os_.unmarshal_long();
/*  789 */         int _v_ = 0;
/*  790 */         _v_ = _os_.unmarshal_int();
/*  791 */         this.matchroles.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  794 */       this.participated = _os_.unmarshal_boolean();
/*  795 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  801 */       int _size_ = 0;
/*  802 */       _size_ += CodedOutputStream.computeInt32Size(1, this.score);
/*  803 */       _size_ += CodedOutputStream.computeInt32Size(2, this.win_times);
/*  804 */       _size_ += CodedOutputStream.computeInt32Size(3, this.lose_times);
/*  805 */       for (Map.Entry<Long, Integer> _e_ : this.matchroles.entrySet())
/*      */       {
/*  807 */         _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/*  808 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  810 */       _size_ += CodedOutputStream.computeBoolSize(5, this.participated);
/*  811 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  819 */         _output_.writeInt32(1, this.score);
/*  820 */         _output_.writeInt32(2, this.win_times);
/*  821 */         _output_.writeInt32(3, this.lose_times);
/*  822 */         for (Map.Entry<Long, Integer> _e_ : this.matchroles.entrySet())
/*      */         {
/*  824 */           _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/*  825 */           _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  827 */         _output_.writeBool(5, this.participated);
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
/*  854 */             this.score = _input_.readInt32();
/*  855 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  859 */             this.win_times = _input_.readInt32();
/*  860 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  864 */             this.lose_times = _input_.readInt32();
/*  865 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  869 */             long _k_ = 0L;
/*  870 */             _k_ = _input_.readInt64();
/*  871 */             int readTag = _input_.readTag();
/*  872 */             if (32 != readTag)
/*      */             {
/*  874 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  876 */             int _v_ = 0;
/*  877 */             _v_ = _input_.readInt32();
/*  878 */             this.matchroles.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  879 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  883 */             this.participated = _input_.readBool();
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
/*      */     public xbean.MenpaiPVPScore copy()
/*      */     {
/*  911 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MenpaiPVPScore toData()
/*      */     {
/*  917 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.MenpaiPVPScore toBean()
/*      */     {
/*  922 */       return new MenpaiPVPScore(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MenpaiPVPScore toDataIf()
/*      */     {
/*  928 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.MenpaiPVPScore toBeanIf()
/*      */     {
/*  933 */       return new MenpaiPVPScore(this, null, null);
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
/*      */     public int getScore()
/*      */     {
/*  970 */       return this.score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_times()
/*      */     {
/*  977 */       return this.win_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLose_times()
/*      */     {
/*  984 */       return this.lose_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getMatchroles()
/*      */     {
/*  991 */       return this.matchroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getMatchrolesAsData()
/*      */     {
/*  998 */       return this.matchroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getParticipated()
/*      */     {
/* 1005 */       return this.participated;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setScore(int _v_)
/*      */     {
/* 1012 */       this.score = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_times(int _v_)
/*      */     {
/* 1019 */       this.win_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLose_times(int _v_)
/*      */     {
/* 1026 */       this.lose_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setParticipated(boolean _v_)
/*      */     {
/* 1033 */       this.participated = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1039 */       if (!(_o1_ instanceof Data)) return false;
/* 1040 */       Data _o_ = (Data)_o1_;
/* 1041 */       if (this.score != _o_.score) return false;
/* 1042 */       if (this.win_times != _o_.win_times) return false;
/* 1043 */       if (this.lose_times != _o_.lose_times) return false;
/* 1044 */       if (!this.matchroles.equals(_o_.matchroles)) return false;
/* 1045 */       if (this.participated != _o_.participated) return false;
/* 1046 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1052 */       int _h_ = 0;
/* 1053 */       _h_ += this.score;
/* 1054 */       _h_ += this.win_times;
/* 1055 */       _h_ += this.lose_times;
/* 1056 */       _h_ += this.matchroles.hashCode();
/* 1057 */       _h_ += (this.participated ? 1231 : 1237);
/* 1058 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1064 */       StringBuilder _sb_ = new StringBuilder();
/* 1065 */       _sb_.append("(");
/* 1066 */       _sb_.append(this.score);
/* 1067 */       _sb_.append(",");
/* 1068 */       _sb_.append(this.win_times);
/* 1069 */       _sb_.append(",");
/* 1070 */       _sb_.append(this.lose_times);
/* 1071 */       _sb_.append(",");
/* 1072 */       _sb_.append(this.matchroles);
/* 1073 */       _sb_.append(",");
/* 1074 */       _sb_.append(this.participated);
/* 1075 */       _sb_.append(")");
/* 1076 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MenpaiPVPScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */