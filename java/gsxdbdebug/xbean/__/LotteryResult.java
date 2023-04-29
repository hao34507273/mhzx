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
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class LotteryResult extends XBean implements xbean.LotteryResult
/*      */ {
/*      */   private int lotterytype;
/*      */   private int useditemid;
/*      */   private int logreason;
/*      */   private int subreason;
/*      */   private HashMap<Integer, Integer> map;
/*      */   private long sessionid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.lotterytype = 0;
/*   29 */     this.useditemid = 0;
/*   30 */     this.logreason = 0;
/*   31 */     this.subreason = 0;
/*   32 */     this.map.clear();
/*   33 */     this.sessionid = 0L;
/*      */   }
/*      */   
/*      */   LotteryResult(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.map = new HashMap();
/*      */   }
/*      */   
/*      */   public LotteryResult()
/*      */   {
/*   44 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public LotteryResult(LotteryResult _o_)
/*      */   {
/*   49 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   LotteryResult(xbean.LotteryResult _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   54 */     super(_xp_, _vn_);
/*   55 */     if ((_o1_ instanceof LotteryResult)) { assign((LotteryResult)_o1_);
/*   56 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   57 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   58 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(LotteryResult _o_) {
/*   63 */     _o_._xdb_verify_unsafe_();
/*   64 */     this.lotterytype = _o_.lotterytype;
/*   65 */     this.useditemid = _o_.useditemid;
/*   66 */     this.logreason = _o_.logreason;
/*   67 */     this.subreason = _o_.subreason;
/*   68 */     this.map = new HashMap();
/*   69 */     for (Map.Entry<Integer, Integer> _e_ : _o_.map.entrySet())
/*   70 */       this.map.put(_e_.getKey(), _e_.getValue());
/*   71 */     this.sessionid = _o_.sessionid;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   76 */     this.lotterytype = _o_.lotterytype;
/*   77 */     this.useditemid = _o_.useditemid;
/*   78 */     this.logreason = _o_.logreason;
/*   79 */     this.subreason = _o_.subreason;
/*   80 */     this.map = new HashMap();
/*   81 */     for (Map.Entry<Integer, Integer> _e_ : _o_.map.entrySet())
/*   82 */       this.map.put(_e_.getKey(), _e_.getValue());
/*   83 */     this.sessionid = _o_.sessionid;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   89 */     _xdb_verify_unsafe_();
/*   90 */     _os_.marshal(this.lotterytype);
/*   91 */     _os_.marshal(this.useditemid);
/*   92 */     _os_.marshal(this.logreason);
/*   93 */     _os_.marshal(this.subreason);
/*   94 */     _os_.compact_uint32(this.map.size());
/*   95 */     for (Map.Entry<Integer, Integer> _e_ : this.map.entrySet())
/*      */     {
/*   97 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   98 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  100 */     _os_.marshal(this.sessionid);
/*  101 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  107 */     _xdb_verify_unsafe_();
/*  108 */     this.lotterytype = _os_.unmarshal_int();
/*  109 */     this.useditemid = _os_.unmarshal_int();
/*  110 */     this.logreason = _os_.unmarshal_int();
/*  111 */     this.subreason = _os_.unmarshal_int();
/*      */     
/*  113 */     int size = _os_.uncompact_uint32();
/*  114 */     if (size >= 12)
/*      */     {
/*  116 */       this.map = new HashMap(size * 2);
/*      */     }
/*  118 */     for (; size > 0; size--)
/*      */     {
/*  120 */       int _k_ = 0;
/*  121 */       _k_ = _os_.unmarshal_int();
/*  122 */       int _v_ = 0;
/*  123 */       _v_ = _os_.unmarshal_int();
/*  124 */       this.map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  127 */     this.sessionid = _os_.unmarshal_long();
/*  128 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  134 */     _xdb_verify_unsafe_();
/*  135 */     int _size_ = 0;
/*  136 */     _size_ += CodedOutputStream.computeInt32Size(1, this.lotterytype);
/*  137 */     _size_ += CodedOutputStream.computeInt32Size(2, this.useditemid);
/*  138 */     _size_ += CodedOutputStream.computeInt32Size(3, this.logreason);
/*  139 */     _size_ += CodedOutputStream.computeInt32Size(4, this.subreason);
/*  140 */     for (Map.Entry<Integer, Integer> _e_ : this.map.entrySet())
/*      */     {
/*  142 */       _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/*  143 */       _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  145 */     _size_ += CodedOutputStream.computeInt64Size(6, this.sessionid);
/*  146 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  152 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  155 */       _output_.writeInt32(1, this.lotterytype);
/*  156 */       _output_.writeInt32(2, this.useditemid);
/*  157 */       _output_.writeInt32(3, this.logreason);
/*  158 */       _output_.writeInt32(4, this.subreason);
/*  159 */       for (Map.Entry<Integer, Integer> _e_ : this.map.entrySet())
/*      */       {
/*  161 */         _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/*  162 */         _output_.writeInt32(5, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  164 */       _output_.writeInt64(6, this.sessionid);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  168 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  170 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  176 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  179 */       boolean done = false;
/*  180 */       while (!done)
/*      */       {
/*  182 */         int tag = _input_.readTag();
/*  183 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  187 */           done = true;
/*  188 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  192 */           this.lotterytype = _input_.readInt32();
/*  193 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  197 */           this.useditemid = _input_.readInt32();
/*  198 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  202 */           this.logreason = _input_.readInt32();
/*  203 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  207 */           this.subreason = _input_.readInt32();
/*  208 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  212 */           int _k_ = 0;
/*  213 */           _k_ = _input_.readInt32();
/*  214 */           int readTag = _input_.readTag();
/*  215 */           if (40 != readTag)
/*      */           {
/*  217 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  219 */           int _v_ = 0;
/*  220 */           _v_ = _input_.readInt32();
/*  221 */           this.map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  222 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  226 */           this.sessionid = _input_.readInt64();
/*  227 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  231 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  233 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  242 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  246 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  248 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.LotteryResult copy()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return new LotteryResult(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.LotteryResult toData()
/*      */   {
/*  261 */     _xdb_verify_unsafe_();
/*  262 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.LotteryResult toBean()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return new LotteryResult(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.LotteryResult toDataIf()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.LotteryResult toBeanIf()
/*      */   {
/*  280 */     _xdb_verify_unsafe_();
/*  281 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLotterytype()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*  296 */     return this.lotterytype;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getUseditemid()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     return this.useditemid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLogreason()
/*      */   {
/*  311 */     _xdb_verify_unsafe_();
/*  312 */     return this.logreason;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getSubreason()
/*      */   {
/*  319 */     _xdb_verify_unsafe_();
/*  320 */     return this.subreason;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getMap()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*  328 */     return xdb.Logs.logMap(new LogKey(this, "map"), this.map);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getMapAsData()
/*      */   {
/*  335 */     _xdb_verify_unsafe_();
/*      */     
/*  337 */     LotteryResult _o_ = this;
/*  338 */     Map<Integer, Integer> map = new HashMap();
/*  339 */     for (Map.Entry<Integer, Integer> _e_ : _o_.map.entrySet())
/*  340 */       map.put(_e_.getKey(), _e_.getValue());
/*  341 */     return map;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSessionid()
/*      */   {
/*  348 */     _xdb_verify_unsafe_();
/*  349 */     return this.sessionid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLotterytype(int _v_)
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*  357 */     xdb.Logs.logIf(new LogKey(this, "lotterytype")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  361 */         new LogInt(this, LotteryResult.this.lotterytype)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  365 */             LotteryResult.this.lotterytype = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  369 */     });
/*  370 */     this.lotterytype = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUseditemid(int _v_)
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     xdb.Logs.logIf(new LogKey(this, "useditemid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  382 */         new LogInt(this, LotteryResult.this.useditemid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  386 */             LotteryResult.this.useditemid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  390 */     });
/*  391 */     this.useditemid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLogreason(int _v_)
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     xdb.Logs.logIf(new LogKey(this, "logreason")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  403 */         new LogInt(this, LotteryResult.this.logreason)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  407 */             LotteryResult.this.logreason = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  411 */     });
/*  412 */     this.logreason = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSubreason(int _v_)
/*      */   {
/*  419 */     _xdb_verify_unsafe_();
/*  420 */     xdb.Logs.logIf(new LogKey(this, "subreason")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  424 */         new LogInt(this, LotteryResult.this.subreason)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  428 */             LotteryResult.this.subreason = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  432 */     });
/*  433 */     this.subreason = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSessionid(long _v_)
/*      */   {
/*  440 */     _xdb_verify_unsafe_();
/*  441 */     xdb.Logs.logIf(new LogKey(this, "sessionid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  445 */         new xdb.logs.LogLong(this, LotteryResult.this.sessionid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  449 */             LotteryResult.this.sessionid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  453 */     });
/*  454 */     this.sessionid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  460 */     _xdb_verify_unsafe_();
/*  461 */     LotteryResult _o_ = null;
/*  462 */     if ((_o1_ instanceof LotteryResult)) { _o_ = (LotteryResult)_o1_;
/*  463 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  464 */       return false;
/*  465 */     if (this.lotterytype != _o_.lotterytype) return false;
/*  466 */     if (this.useditemid != _o_.useditemid) return false;
/*  467 */     if (this.logreason != _o_.logreason) return false;
/*  468 */     if (this.subreason != _o_.subreason) return false;
/*  469 */     if (!this.map.equals(_o_.map)) return false;
/*  470 */     if (this.sessionid != _o_.sessionid) return false;
/*  471 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  477 */     _xdb_verify_unsafe_();
/*  478 */     int _h_ = 0;
/*  479 */     _h_ += this.lotterytype;
/*  480 */     _h_ += this.useditemid;
/*  481 */     _h_ += this.logreason;
/*  482 */     _h_ += this.subreason;
/*  483 */     _h_ += this.map.hashCode();
/*  484 */     _h_ = (int)(_h_ + this.sessionid);
/*  485 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  491 */     _xdb_verify_unsafe_();
/*  492 */     StringBuilder _sb_ = new StringBuilder();
/*  493 */     _sb_.append("(");
/*  494 */     _sb_.append(this.lotterytype);
/*  495 */     _sb_.append(",");
/*  496 */     _sb_.append(this.useditemid);
/*  497 */     _sb_.append(",");
/*  498 */     _sb_.append(this.logreason);
/*  499 */     _sb_.append(",");
/*  500 */     _sb_.append(this.subreason);
/*  501 */     _sb_.append(",");
/*  502 */     _sb_.append(this.map);
/*  503 */     _sb_.append(",");
/*  504 */     _sb_.append(this.sessionid);
/*  505 */     _sb_.append(")");
/*  506 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  512 */     ListenableBean lb = new ListenableBean();
/*  513 */     lb.add(new ListenableChanged().setVarName("lotterytype"));
/*  514 */     lb.add(new ListenableChanged().setVarName("useditemid"));
/*  515 */     lb.add(new ListenableChanged().setVarName("logreason"));
/*  516 */     lb.add(new ListenableChanged().setVarName("subreason"));
/*  517 */     lb.add(new xdb.logs.ListenableMap().setVarName("map"));
/*  518 */     lb.add(new ListenableChanged().setVarName("sessionid"));
/*  519 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.LotteryResult {
/*      */     private Const() {}
/*      */     
/*      */     LotteryResult nThis() {
/*  526 */       return LotteryResult.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  532 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LotteryResult copy()
/*      */     {
/*  538 */       return LotteryResult.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LotteryResult toData()
/*      */     {
/*  544 */       return LotteryResult.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.LotteryResult toBean()
/*      */     {
/*  549 */       return LotteryResult.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LotteryResult toDataIf()
/*      */     {
/*  555 */       return LotteryResult.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.LotteryResult toBeanIf()
/*      */     {
/*  560 */       return LotteryResult.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLotterytype()
/*      */     {
/*  567 */       LotteryResult.this._xdb_verify_unsafe_();
/*  568 */       return LotteryResult.this.lotterytype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getUseditemid()
/*      */     {
/*  575 */       LotteryResult.this._xdb_verify_unsafe_();
/*  576 */       return LotteryResult.this.useditemid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLogreason()
/*      */     {
/*  583 */       LotteryResult.this._xdb_verify_unsafe_();
/*  584 */       return LotteryResult.this.logreason;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSubreason()
/*      */     {
/*  591 */       LotteryResult.this._xdb_verify_unsafe_();
/*  592 */       return LotteryResult.this.subreason;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getMap()
/*      */     {
/*  599 */       LotteryResult.this._xdb_verify_unsafe_();
/*  600 */       return xdb.Consts.constMap(LotteryResult.this.map);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getMapAsData()
/*      */     {
/*  607 */       LotteryResult.this._xdb_verify_unsafe_();
/*      */       
/*  609 */       LotteryResult _o_ = LotteryResult.this;
/*  610 */       Map<Integer, Integer> map = new HashMap();
/*  611 */       for (Map.Entry<Integer, Integer> _e_ : _o_.map.entrySet())
/*  612 */         map.put(_e_.getKey(), _e_.getValue());
/*  613 */       return map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSessionid()
/*      */     {
/*  620 */       LotteryResult.this._xdb_verify_unsafe_();
/*  621 */       return LotteryResult.this.sessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLotterytype(int _v_)
/*      */     {
/*  628 */       LotteryResult.this._xdb_verify_unsafe_();
/*  629 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUseditemid(int _v_)
/*      */     {
/*  636 */       LotteryResult.this._xdb_verify_unsafe_();
/*  637 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLogreason(int _v_)
/*      */     {
/*  644 */       LotteryResult.this._xdb_verify_unsafe_();
/*  645 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSubreason(int _v_)
/*      */     {
/*  652 */       LotteryResult.this._xdb_verify_unsafe_();
/*  653 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSessionid(long _v_)
/*      */     {
/*  660 */       LotteryResult.this._xdb_verify_unsafe_();
/*  661 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  667 */       LotteryResult.this._xdb_verify_unsafe_();
/*  668 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  674 */       LotteryResult.this._xdb_verify_unsafe_();
/*  675 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  681 */       return LotteryResult.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  687 */       return LotteryResult.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  693 */       LotteryResult.this._xdb_verify_unsafe_();
/*  694 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  700 */       return LotteryResult.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  706 */       return LotteryResult.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  712 */       LotteryResult.this._xdb_verify_unsafe_();
/*  713 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  719 */       return LotteryResult.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  725 */       return LotteryResult.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  731 */       return LotteryResult.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  737 */       return LotteryResult.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  743 */       return LotteryResult.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  749 */       return LotteryResult.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  755 */       return LotteryResult.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.LotteryResult
/*      */   {
/*      */     private int lotterytype;
/*      */     
/*      */     private int useditemid;
/*      */     
/*      */     private int logreason;
/*      */     
/*      */     private int subreason;
/*      */     
/*      */     private HashMap<Integer, Integer> map;
/*      */     
/*      */     private long sessionid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  777 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  782 */       this.map = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.LotteryResult _o1_)
/*      */     {
/*  787 */       if ((_o1_ instanceof LotteryResult)) { assign((LotteryResult)_o1_);
/*  788 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  789 */       } else if ((_o1_ instanceof LotteryResult.Const)) assign(((LotteryResult.Const)_o1_).nThis()); else {
/*  790 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(LotteryResult _o_) {
/*  795 */       this.lotterytype = _o_.lotterytype;
/*  796 */       this.useditemid = _o_.useditemid;
/*  797 */       this.logreason = _o_.logreason;
/*  798 */       this.subreason = _o_.subreason;
/*  799 */       this.map = new HashMap();
/*  800 */       for (Map.Entry<Integer, Integer> _e_ : _o_.map.entrySet())
/*  801 */         this.map.put(_e_.getKey(), _e_.getValue());
/*  802 */       this.sessionid = _o_.sessionid;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  807 */       this.lotterytype = _o_.lotterytype;
/*  808 */       this.useditemid = _o_.useditemid;
/*  809 */       this.logreason = _o_.logreason;
/*  810 */       this.subreason = _o_.subreason;
/*  811 */       this.map = new HashMap();
/*  812 */       for (Map.Entry<Integer, Integer> _e_ : _o_.map.entrySet())
/*  813 */         this.map.put(_e_.getKey(), _e_.getValue());
/*  814 */       this.sessionid = _o_.sessionid;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  820 */       _os_.marshal(this.lotterytype);
/*  821 */       _os_.marshal(this.useditemid);
/*  822 */       _os_.marshal(this.logreason);
/*  823 */       _os_.marshal(this.subreason);
/*  824 */       _os_.compact_uint32(this.map.size());
/*  825 */       for (Map.Entry<Integer, Integer> _e_ : this.map.entrySet())
/*      */       {
/*  827 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  828 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  830 */       _os_.marshal(this.sessionid);
/*  831 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  837 */       this.lotterytype = _os_.unmarshal_int();
/*  838 */       this.useditemid = _os_.unmarshal_int();
/*  839 */       this.logreason = _os_.unmarshal_int();
/*  840 */       this.subreason = _os_.unmarshal_int();
/*      */       
/*  842 */       int size = _os_.uncompact_uint32();
/*  843 */       if (size >= 12)
/*      */       {
/*  845 */         this.map = new HashMap(size * 2);
/*      */       }
/*  847 */       for (; size > 0; size--)
/*      */       {
/*  849 */         int _k_ = 0;
/*  850 */         _k_ = _os_.unmarshal_int();
/*  851 */         int _v_ = 0;
/*  852 */         _v_ = _os_.unmarshal_int();
/*  853 */         this.map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  856 */       this.sessionid = _os_.unmarshal_long();
/*  857 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  863 */       int _size_ = 0;
/*  864 */       _size_ += CodedOutputStream.computeInt32Size(1, this.lotterytype);
/*  865 */       _size_ += CodedOutputStream.computeInt32Size(2, this.useditemid);
/*  866 */       _size_ += CodedOutputStream.computeInt32Size(3, this.logreason);
/*  867 */       _size_ += CodedOutputStream.computeInt32Size(4, this.subreason);
/*  868 */       for (Map.Entry<Integer, Integer> _e_ : this.map.entrySet())
/*      */       {
/*  870 */         _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getKey()).intValue());
/*  871 */         _size_ += CodedOutputStream.computeInt32Size(5, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  873 */       _size_ += CodedOutputStream.computeInt64Size(6, this.sessionid);
/*  874 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  882 */         _output_.writeInt32(1, this.lotterytype);
/*  883 */         _output_.writeInt32(2, this.useditemid);
/*  884 */         _output_.writeInt32(3, this.logreason);
/*  885 */         _output_.writeInt32(4, this.subreason);
/*  886 */         for (Map.Entry<Integer, Integer> _e_ : this.map.entrySet())
/*      */         {
/*  888 */           _output_.writeInt32(5, ((Integer)_e_.getKey()).intValue());
/*  889 */           _output_.writeInt32(5, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  891 */         _output_.writeInt64(6, this.sessionid);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  895 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  897 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  905 */         boolean done = false;
/*  906 */         while (!done)
/*      */         {
/*  908 */           int tag = _input_.readTag();
/*  909 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  913 */             done = true;
/*  914 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  918 */             this.lotterytype = _input_.readInt32();
/*  919 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  923 */             this.useditemid = _input_.readInt32();
/*  924 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  928 */             this.logreason = _input_.readInt32();
/*  929 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  933 */             this.subreason = _input_.readInt32();
/*  934 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  938 */             int _k_ = 0;
/*  939 */             _k_ = _input_.readInt32();
/*  940 */             int readTag = _input_.readTag();
/*  941 */             if (40 != readTag)
/*      */             {
/*  943 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  945 */             int _v_ = 0;
/*  946 */             _v_ = _input_.readInt32();
/*  947 */             this.map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  948 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  952 */             this.sessionid = _input_.readInt64();
/*  953 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  957 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  959 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  968 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  972 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  974 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LotteryResult copy()
/*      */     {
/*  980 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LotteryResult toData()
/*      */     {
/*  986 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.LotteryResult toBean()
/*      */     {
/*  991 */       return new LotteryResult(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LotteryResult toDataIf()
/*      */     {
/*  997 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.LotteryResult toBeanIf()
/*      */     {
/* 1002 */       return new LotteryResult(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1008 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1012 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1016 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1020 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1024 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1028 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1032 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLotterytype()
/*      */     {
/* 1039 */       return this.lotterytype;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getUseditemid()
/*      */     {
/* 1046 */       return this.useditemid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLogreason()
/*      */     {
/* 1053 */       return this.logreason;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSubreason()
/*      */     {
/* 1060 */       return this.subreason;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getMap()
/*      */     {
/* 1067 */       return this.map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getMapAsData()
/*      */     {
/* 1074 */       return this.map;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSessionid()
/*      */     {
/* 1081 */       return this.sessionid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLotterytype(int _v_)
/*      */     {
/* 1088 */       this.lotterytype = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUseditemid(int _v_)
/*      */     {
/* 1095 */       this.useditemid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLogreason(int _v_)
/*      */     {
/* 1102 */       this.logreason = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSubreason(int _v_)
/*      */     {
/* 1109 */       this.subreason = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSessionid(long _v_)
/*      */     {
/* 1116 */       this.sessionid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1122 */       if (!(_o1_ instanceof Data)) return false;
/* 1123 */       Data _o_ = (Data)_o1_;
/* 1124 */       if (this.lotterytype != _o_.lotterytype) return false;
/* 1125 */       if (this.useditemid != _o_.useditemid) return false;
/* 1126 */       if (this.logreason != _o_.logreason) return false;
/* 1127 */       if (this.subreason != _o_.subreason) return false;
/* 1128 */       if (!this.map.equals(_o_.map)) return false;
/* 1129 */       if (this.sessionid != _o_.sessionid) return false;
/* 1130 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1136 */       int _h_ = 0;
/* 1137 */       _h_ += this.lotterytype;
/* 1138 */       _h_ += this.useditemid;
/* 1139 */       _h_ += this.logreason;
/* 1140 */       _h_ += this.subreason;
/* 1141 */       _h_ += this.map.hashCode();
/* 1142 */       _h_ = (int)(_h_ + this.sessionid);
/* 1143 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1149 */       StringBuilder _sb_ = new StringBuilder();
/* 1150 */       _sb_.append("(");
/* 1151 */       _sb_.append(this.lotterytype);
/* 1152 */       _sb_.append(",");
/* 1153 */       _sb_.append(this.useditemid);
/* 1154 */       _sb_.append(",");
/* 1155 */       _sb_.append(this.logreason);
/* 1156 */       _sb_.append(",");
/* 1157 */       _sb_.append(this.subreason);
/* 1158 */       _sb_.append(",");
/* 1159 */       _sb_.append(this.map);
/* 1160 */       _sb_.append(",");
/* 1161 */       _sb_.append(this.sessionid);
/* 1162 */       _sb_.append(")");
/* 1163 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\LotteryResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */