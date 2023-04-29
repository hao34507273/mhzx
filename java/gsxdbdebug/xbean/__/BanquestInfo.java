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
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class BanquestInfo extends XBean implements xbean.BanquestInfo
/*      */ {
/*      */   private HashMap<Integer, Integer> owndishes;
/*      */   private int holdcount;
/*      */   private boolean holdbanqueststate;
/*      */   private long lastbanqueststarttime;
/*      */   private int dishescount;
/*      */   private HashMap<Long, xbean.SingleBanquestInfo> joinbanquestinfo;
/*      */   private long fristjoinbanquesttime;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.owndishes.clear();
/*   31 */     this.holdcount = 0;
/*   32 */     this.holdbanqueststate = false;
/*   33 */     this.lastbanqueststarttime = 0L;
/*   34 */     this.dishescount = 0;
/*   35 */     this.joinbanquestinfo.clear();
/*   36 */     this.fristjoinbanquesttime = 0L;
/*      */   }
/*      */   
/*      */   BanquestInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.owndishes = new HashMap();
/*   43 */     this.joinbanquestinfo = new HashMap();
/*      */   }
/*      */   
/*      */   public BanquestInfo()
/*      */   {
/*   48 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public BanquestInfo(BanquestInfo _o_)
/*      */   {
/*   53 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   BanquestInfo(xbean.BanquestInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   58 */     super(_xp_, _vn_);
/*   59 */     if ((_o1_ instanceof BanquestInfo)) { assign((BanquestInfo)_o1_);
/*   60 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   61 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   62 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(BanquestInfo _o_) {
/*   67 */     _o_._xdb_verify_unsafe_();
/*   68 */     this.owndishes = new HashMap();
/*   69 */     for (Map.Entry<Integer, Integer> _e_ : _o_.owndishes.entrySet())
/*   70 */       this.owndishes.put(_e_.getKey(), _e_.getValue());
/*   71 */     this.holdcount = _o_.holdcount;
/*   72 */     this.holdbanqueststate = _o_.holdbanqueststate;
/*   73 */     this.lastbanqueststarttime = _o_.lastbanqueststarttime;
/*   74 */     this.dishescount = _o_.dishescount;
/*   75 */     this.joinbanquestinfo = new HashMap();
/*   76 */     for (Map.Entry<Long, xbean.SingleBanquestInfo> _e_ : _o_.joinbanquestinfo.entrySet())
/*   77 */       this.joinbanquestinfo.put(_e_.getKey(), new SingleBanquestInfo((xbean.SingleBanquestInfo)_e_.getValue(), this, "joinbanquestinfo"));
/*   78 */     this.fristjoinbanquesttime = _o_.fristjoinbanquesttime;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   83 */     this.owndishes = new HashMap();
/*   84 */     for (Map.Entry<Integer, Integer> _e_ : _o_.owndishes.entrySet())
/*   85 */       this.owndishes.put(_e_.getKey(), _e_.getValue());
/*   86 */     this.holdcount = _o_.holdcount;
/*   87 */     this.holdbanqueststate = _o_.holdbanqueststate;
/*   88 */     this.lastbanqueststarttime = _o_.lastbanqueststarttime;
/*   89 */     this.dishescount = _o_.dishescount;
/*   90 */     this.joinbanquestinfo = new HashMap();
/*   91 */     for (Map.Entry<Long, xbean.SingleBanquestInfo> _e_ : _o_.joinbanquestinfo.entrySet())
/*   92 */       this.joinbanquestinfo.put(_e_.getKey(), new SingleBanquestInfo((xbean.SingleBanquestInfo)_e_.getValue(), this, "joinbanquestinfo"));
/*   93 */     this.fristjoinbanquesttime = _o_.fristjoinbanquesttime;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   99 */     _xdb_verify_unsafe_();
/*  100 */     _os_.compact_uint32(this.owndishes.size());
/*  101 */     for (Map.Entry<Integer, Integer> _e_ : this.owndishes.entrySet())
/*      */     {
/*  103 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  104 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  106 */     _os_.marshal(this.holdcount);
/*  107 */     _os_.marshal(this.holdbanqueststate);
/*  108 */     _os_.marshal(this.lastbanqueststarttime);
/*  109 */     _os_.marshal(this.dishescount);
/*  110 */     _os_.compact_uint32(this.joinbanquestinfo.size());
/*  111 */     for (Map.Entry<Long, xbean.SingleBanquestInfo> _e_ : this.joinbanquestinfo.entrySet())
/*      */     {
/*  113 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  114 */       ((xbean.SingleBanquestInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  116 */     _os_.marshal(this.fristjoinbanquesttime);
/*  117 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  123 */     _xdb_verify_unsafe_();
/*      */     
/*  125 */     int size = _os_.uncompact_uint32();
/*  126 */     if (size >= 12)
/*      */     {
/*  128 */       this.owndishes = new HashMap(size * 2);
/*      */     }
/*  130 */     for (; size > 0; size--)
/*      */     {
/*  132 */       int _k_ = 0;
/*  133 */       _k_ = _os_.unmarshal_int();
/*  134 */       int _v_ = 0;
/*  135 */       _v_ = _os_.unmarshal_int();
/*  136 */       this.owndishes.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  139 */     this.holdcount = _os_.unmarshal_int();
/*  140 */     this.holdbanqueststate = _os_.unmarshal_boolean();
/*  141 */     this.lastbanqueststarttime = _os_.unmarshal_long();
/*  142 */     this.dishescount = _os_.unmarshal_int();
/*      */     
/*  144 */     int size = _os_.uncompact_uint32();
/*  145 */     if (size >= 12)
/*      */     {
/*  147 */       this.joinbanquestinfo = new HashMap(size * 2);
/*      */     }
/*  149 */     for (; size > 0; size--)
/*      */     {
/*  151 */       long _k_ = 0L;
/*  152 */       _k_ = _os_.unmarshal_long();
/*  153 */       xbean.SingleBanquestInfo _v_ = new SingleBanquestInfo(0, this, "joinbanquestinfo");
/*  154 */       _v_.unmarshal(_os_);
/*  155 */       this.joinbanquestinfo.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  158 */     this.fristjoinbanquesttime = _os_.unmarshal_long();
/*  159 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  165 */     _xdb_verify_unsafe_();
/*  166 */     int _size_ = 0;
/*  167 */     for (Map.Entry<Integer, Integer> _e_ : this.owndishes.entrySet())
/*      */     {
/*  169 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  170 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  172 */     _size_ += CodedOutputStream.computeInt32Size(2, this.holdcount);
/*  173 */     _size_ += CodedOutputStream.computeBoolSize(4, this.holdbanqueststate);
/*  174 */     _size_ += CodedOutputStream.computeInt64Size(5, this.lastbanqueststarttime);
/*  175 */     _size_ += CodedOutputStream.computeInt32Size(6, this.dishescount);
/*  176 */     for (Map.Entry<Long, xbean.SingleBanquestInfo> _e_ : this.joinbanquestinfo.entrySet())
/*      */     {
/*  178 */       _size_ += CodedOutputStream.computeInt64Size(7, ((Long)_e_.getKey()).longValue());
/*  179 */       _size_ += CodedOutputStream.computeMessageSize(7, (ppbio.Message)_e_.getValue());
/*      */     }
/*  181 */     _size_ += CodedOutputStream.computeInt64Size(8, this.fristjoinbanquesttime);
/*  182 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  188 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  191 */       for (Map.Entry<Integer, Integer> _e_ : this.owndishes.entrySet())
/*      */       {
/*  193 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/*  194 */         _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  196 */       _output_.writeInt32(2, this.holdcount);
/*  197 */       _output_.writeBool(4, this.holdbanqueststate);
/*  198 */       _output_.writeInt64(5, this.lastbanqueststarttime);
/*  199 */       _output_.writeInt32(6, this.dishescount);
/*  200 */       for (Map.Entry<Long, xbean.SingleBanquestInfo> _e_ : this.joinbanquestinfo.entrySet())
/*      */       {
/*  202 */         _output_.writeInt64(7, ((Long)_e_.getKey()).longValue());
/*  203 */         _output_.writeMessage(7, (ppbio.Message)_e_.getValue());
/*      */       }
/*  205 */       _output_.writeInt64(8, this.fristjoinbanquesttime);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  209 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  211 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  217 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  220 */       boolean done = false;
/*  221 */       while (!done)
/*      */       {
/*  223 */         int tag = _input_.readTag();
/*  224 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  228 */           done = true;
/*  229 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  233 */           int _k_ = 0;
/*  234 */           _k_ = _input_.readInt32();
/*  235 */           int readTag = _input_.readTag();
/*  236 */           if (8 != readTag)
/*      */           {
/*  238 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  240 */           int _v_ = 0;
/*  241 */           _v_ = _input_.readInt32();
/*  242 */           this.owndishes.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  243 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  247 */           this.holdcount = _input_.readInt32();
/*  248 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  252 */           this.holdbanqueststate = _input_.readBool();
/*  253 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  257 */           this.lastbanqueststarttime = _input_.readInt64();
/*  258 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  262 */           this.dishescount = _input_.readInt32();
/*  263 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  267 */           long _k_ = 0L;
/*  268 */           _k_ = _input_.readInt64();
/*  269 */           int readTag = _input_.readTag();
/*  270 */           if (58 != readTag)
/*      */           {
/*  272 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  274 */           xbean.SingleBanquestInfo _v_ = new SingleBanquestInfo(0, this, "joinbanquestinfo");
/*  275 */           _input_.readMessage(_v_);
/*  276 */           this.joinbanquestinfo.put(Long.valueOf(_k_), _v_);
/*  277 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  281 */           this.fristjoinbanquesttime = _input_.readInt64();
/*  282 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  286 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  288 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  297 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  301 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  303 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BanquestInfo copy()
/*      */   {
/*  309 */     _xdb_verify_unsafe_();
/*  310 */     return new BanquestInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BanquestInfo toData()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BanquestInfo toBean()
/*      */   {
/*  322 */     _xdb_verify_unsafe_();
/*  323 */     return new BanquestInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BanquestInfo toDataIf()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BanquestInfo toBeanIf()
/*      */   {
/*  335 */     _xdb_verify_unsafe_();
/*  336 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  342 */     _xdb_verify_unsafe_();
/*  343 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getOwndishes()
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*  351 */     return Logs.logMap(new LogKey(this, "owndishes"), this.owndishes);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getOwndishesAsData()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*      */     
/*  360 */     BanquestInfo _o_ = this;
/*  361 */     Map<Integer, Integer> owndishes = new HashMap();
/*  362 */     for (Map.Entry<Integer, Integer> _e_ : _o_.owndishes.entrySet())
/*  363 */       owndishes.put(_e_.getKey(), _e_.getValue());
/*  364 */     return owndishes;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getHoldcount()
/*      */   {
/*  371 */     _xdb_verify_unsafe_();
/*  372 */     return this.holdcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getHoldbanqueststate()
/*      */   {
/*  379 */     _xdb_verify_unsafe_();
/*  380 */     return this.holdbanqueststate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLastbanqueststarttime()
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*  388 */     return this.lastbanqueststarttime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDishescount()
/*      */   {
/*  395 */     _xdb_verify_unsafe_();
/*  396 */     return this.dishescount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.SingleBanquestInfo> getJoinbanquestinfo()
/*      */   {
/*  403 */     _xdb_verify_unsafe_();
/*  404 */     return Logs.logMap(new LogKey(this, "joinbanquestinfo"), this.joinbanquestinfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.SingleBanquestInfo> getJoinbanquestinfoAsData()
/*      */   {
/*  411 */     _xdb_verify_unsafe_();
/*      */     
/*  413 */     BanquestInfo _o_ = this;
/*  414 */     Map<Long, xbean.SingleBanquestInfo> joinbanquestinfo = new HashMap();
/*  415 */     for (Map.Entry<Long, xbean.SingleBanquestInfo> _e_ : _o_.joinbanquestinfo.entrySet())
/*  416 */       joinbanquestinfo.put(_e_.getKey(), new SingleBanquestInfo.Data((xbean.SingleBanquestInfo)_e_.getValue()));
/*  417 */     return joinbanquestinfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getFristjoinbanquesttime()
/*      */   {
/*  424 */     _xdb_verify_unsafe_();
/*  425 */     return this.fristjoinbanquesttime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHoldcount(int _v_)
/*      */   {
/*  432 */     _xdb_verify_unsafe_();
/*  433 */     Logs.logIf(new LogKey(this, "holdcount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  437 */         new xdb.logs.LogInt(this, BanquestInfo.this.holdcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  441 */             BanquestInfo.this.holdcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  445 */     });
/*  446 */     this.holdcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHoldbanqueststate(boolean _v_)
/*      */   {
/*  453 */     _xdb_verify_unsafe_();
/*  454 */     Logs.logIf(new LogKey(this, "holdbanqueststate")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  458 */         new xdb.logs.LogObject(this, Boolean.valueOf(BanquestInfo.this.holdbanqueststate))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  462 */             BanquestInfo.this.holdbanqueststate = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  466 */     });
/*  467 */     this.holdbanqueststate = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLastbanqueststarttime(long _v_)
/*      */   {
/*  474 */     _xdb_verify_unsafe_();
/*  475 */     Logs.logIf(new LogKey(this, "lastbanqueststarttime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  479 */         new xdb.logs.LogLong(this, BanquestInfo.this.lastbanqueststarttime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  483 */             BanquestInfo.this.lastbanqueststarttime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  487 */     });
/*  488 */     this.lastbanqueststarttime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDishescount(int _v_)
/*      */   {
/*  495 */     _xdb_verify_unsafe_();
/*  496 */     Logs.logIf(new LogKey(this, "dishescount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  500 */         new xdb.logs.LogInt(this, BanquestInfo.this.dishescount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  504 */             BanquestInfo.this.dishescount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  508 */     });
/*  509 */     this.dishescount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFristjoinbanquesttime(long _v_)
/*      */   {
/*  516 */     _xdb_verify_unsafe_();
/*  517 */     Logs.logIf(new LogKey(this, "fristjoinbanquesttime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  521 */         new xdb.logs.LogLong(this, BanquestInfo.this.fristjoinbanquesttime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  525 */             BanquestInfo.this.fristjoinbanquesttime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  529 */     });
/*  530 */     this.fristjoinbanquesttime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  536 */     _xdb_verify_unsafe_();
/*  537 */     BanquestInfo _o_ = null;
/*  538 */     if ((_o1_ instanceof BanquestInfo)) { _o_ = (BanquestInfo)_o1_;
/*  539 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  540 */       return false;
/*  541 */     if (!this.owndishes.equals(_o_.owndishes)) return false;
/*  542 */     if (this.holdcount != _o_.holdcount) return false;
/*  543 */     if (this.holdbanqueststate != _o_.holdbanqueststate) return false;
/*  544 */     if (this.lastbanqueststarttime != _o_.lastbanqueststarttime) return false;
/*  545 */     if (this.dishescount != _o_.dishescount) return false;
/*  546 */     if (!this.joinbanquestinfo.equals(_o_.joinbanquestinfo)) return false;
/*  547 */     if (this.fristjoinbanquesttime != _o_.fristjoinbanquesttime) return false;
/*  548 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  554 */     _xdb_verify_unsafe_();
/*  555 */     int _h_ = 0;
/*  556 */     _h_ += this.owndishes.hashCode();
/*  557 */     _h_ += this.holdcount;
/*  558 */     _h_ += (this.holdbanqueststate ? 1231 : 1237);
/*  559 */     _h_ = (int)(_h_ + this.lastbanqueststarttime);
/*  560 */     _h_ += this.dishescount;
/*  561 */     _h_ += this.joinbanquestinfo.hashCode();
/*  562 */     _h_ = (int)(_h_ + this.fristjoinbanquesttime);
/*  563 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  569 */     _xdb_verify_unsafe_();
/*  570 */     StringBuilder _sb_ = new StringBuilder();
/*  571 */     _sb_.append("(");
/*  572 */     _sb_.append(this.owndishes);
/*  573 */     _sb_.append(",");
/*  574 */     _sb_.append(this.holdcount);
/*  575 */     _sb_.append(",");
/*  576 */     _sb_.append(this.holdbanqueststate);
/*  577 */     _sb_.append(",");
/*  578 */     _sb_.append(this.lastbanqueststarttime);
/*  579 */     _sb_.append(",");
/*  580 */     _sb_.append(this.dishescount);
/*  581 */     _sb_.append(",");
/*  582 */     _sb_.append(this.joinbanquestinfo);
/*  583 */     _sb_.append(",");
/*  584 */     _sb_.append(this.fristjoinbanquesttime);
/*  585 */     _sb_.append(")");
/*  586 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  592 */     ListenableBean lb = new ListenableBean();
/*  593 */     lb.add(new xdb.logs.ListenableMap().setVarName("owndishes"));
/*  594 */     lb.add(new ListenableChanged().setVarName("holdcount"));
/*  595 */     lb.add(new ListenableChanged().setVarName("holdbanqueststate"));
/*  596 */     lb.add(new ListenableChanged().setVarName("lastbanqueststarttime"));
/*  597 */     lb.add(new ListenableChanged().setVarName("dishescount"));
/*  598 */     lb.add(new xdb.logs.ListenableMap().setVarName("joinbanquestinfo"));
/*  599 */     lb.add(new ListenableChanged().setVarName("fristjoinbanquesttime"));
/*  600 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.BanquestInfo {
/*      */     private Const() {}
/*      */     
/*      */     BanquestInfo nThis() {
/*  607 */       return BanquestInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  613 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BanquestInfo copy()
/*      */     {
/*  619 */       return BanquestInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BanquestInfo toData()
/*      */     {
/*  625 */       return BanquestInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.BanquestInfo toBean()
/*      */     {
/*  630 */       return BanquestInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BanquestInfo toDataIf()
/*      */     {
/*  636 */       return BanquestInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.BanquestInfo toBeanIf()
/*      */     {
/*  641 */       return BanquestInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOwndishes()
/*      */     {
/*  648 */       BanquestInfo.this._xdb_verify_unsafe_();
/*  649 */       return xdb.Consts.constMap(BanquestInfo.this.owndishes);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOwndishesAsData()
/*      */     {
/*  656 */       BanquestInfo.this._xdb_verify_unsafe_();
/*      */       
/*  658 */       BanquestInfo _o_ = BanquestInfo.this;
/*  659 */       Map<Integer, Integer> owndishes = new HashMap();
/*  660 */       for (Map.Entry<Integer, Integer> _e_ : _o_.owndishes.entrySet())
/*  661 */         owndishes.put(_e_.getKey(), _e_.getValue());
/*  662 */       return owndishes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHoldcount()
/*      */     {
/*  669 */       BanquestInfo.this._xdb_verify_unsafe_();
/*  670 */       return BanquestInfo.this.holdcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getHoldbanqueststate()
/*      */     {
/*  677 */       BanquestInfo.this._xdb_verify_unsafe_();
/*  678 */       return BanquestInfo.this.holdbanqueststate;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastbanqueststarttime()
/*      */     {
/*  685 */       BanquestInfo.this._xdb_verify_unsafe_();
/*  686 */       return BanquestInfo.this.lastbanqueststarttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDishescount()
/*      */     {
/*  693 */       BanquestInfo.this._xdb_verify_unsafe_();
/*  694 */       return BanquestInfo.this.dishescount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.SingleBanquestInfo> getJoinbanquestinfo()
/*      */     {
/*  701 */       BanquestInfo.this._xdb_verify_unsafe_();
/*  702 */       return xdb.Consts.constMap(BanquestInfo.this.joinbanquestinfo);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.SingleBanquestInfo> getJoinbanquestinfoAsData()
/*      */     {
/*  709 */       BanquestInfo.this._xdb_verify_unsafe_();
/*      */       
/*  711 */       BanquestInfo _o_ = BanquestInfo.this;
/*  712 */       Map<Long, xbean.SingleBanquestInfo> joinbanquestinfo = new HashMap();
/*  713 */       for (Map.Entry<Long, xbean.SingleBanquestInfo> _e_ : _o_.joinbanquestinfo.entrySet())
/*  714 */         joinbanquestinfo.put(_e_.getKey(), new SingleBanquestInfo.Data((xbean.SingleBanquestInfo)_e_.getValue()));
/*  715 */       return joinbanquestinfo;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFristjoinbanquesttime()
/*      */     {
/*  722 */       BanquestInfo.this._xdb_verify_unsafe_();
/*  723 */       return BanquestInfo.this.fristjoinbanquesttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHoldcount(int _v_)
/*      */     {
/*  730 */       BanquestInfo.this._xdb_verify_unsafe_();
/*  731 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHoldbanqueststate(boolean _v_)
/*      */     {
/*  738 */       BanquestInfo.this._xdb_verify_unsafe_();
/*  739 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastbanqueststarttime(long _v_)
/*      */     {
/*  746 */       BanquestInfo.this._xdb_verify_unsafe_();
/*  747 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDishescount(int _v_)
/*      */     {
/*  754 */       BanquestInfo.this._xdb_verify_unsafe_();
/*  755 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFristjoinbanquesttime(long _v_)
/*      */     {
/*  762 */       BanquestInfo.this._xdb_verify_unsafe_();
/*  763 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  769 */       BanquestInfo.this._xdb_verify_unsafe_();
/*  770 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  776 */       BanquestInfo.this._xdb_verify_unsafe_();
/*  777 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  783 */       return BanquestInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  789 */       return BanquestInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  795 */       BanquestInfo.this._xdb_verify_unsafe_();
/*  796 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  802 */       return BanquestInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  808 */       return BanquestInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  814 */       BanquestInfo.this._xdb_verify_unsafe_();
/*  815 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  821 */       return BanquestInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  827 */       return BanquestInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  833 */       return BanquestInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  839 */       return BanquestInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  845 */       return BanquestInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  851 */       return BanquestInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  857 */       return BanquestInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.BanquestInfo
/*      */   {
/*      */     private HashMap<Integer, Integer> owndishes;
/*      */     
/*      */     private int holdcount;
/*      */     
/*      */     private boolean holdbanqueststate;
/*      */     
/*      */     private long lastbanqueststarttime;
/*      */     
/*      */     private int dishescount;
/*      */     
/*      */     private HashMap<Long, xbean.SingleBanquestInfo> joinbanquestinfo;
/*      */     
/*      */     private long fristjoinbanquesttime;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  881 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  886 */       this.owndishes = new HashMap();
/*  887 */       this.joinbanquestinfo = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.BanquestInfo _o1_)
/*      */     {
/*  892 */       if ((_o1_ instanceof BanquestInfo)) { assign((BanquestInfo)_o1_);
/*  893 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  894 */       } else if ((_o1_ instanceof BanquestInfo.Const)) assign(((BanquestInfo.Const)_o1_).nThis()); else {
/*  895 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(BanquestInfo _o_) {
/*  900 */       this.owndishes = new HashMap();
/*  901 */       for (Map.Entry<Integer, Integer> _e_ : _o_.owndishes.entrySet())
/*  902 */         this.owndishes.put(_e_.getKey(), _e_.getValue());
/*  903 */       this.holdcount = _o_.holdcount;
/*  904 */       this.holdbanqueststate = _o_.holdbanqueststate;
/*  905 */       this.lastbanqueststarttime = _o_.lastbanqueststarttime;
/*  906 */       this.dishescount = _o_.dishescount;
/*  907 */       this.joinbanquestinfo = new HashMap();
/*  908 */       for (Map.Entry<Long, xbean.SingleBanquestInfo> _e_ : _o_.joinbanquestinfo.entrySet())
/*  909 */         this.joinbanquestinfo.put(_e_.getKey(), new SingleBanquestInfo.Data((xbean.SingleBanquestInfo)_e_.getValue()));
/*  910 */       this.fristjoinbanquesttime = _o_.fristjoinbanquesttime;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  915 */       this.owndishes = new HashMap();
/*  916 */       for (Map.Entry<Integer, Integer> _e_ : _o_.owndishes.entrySet())
/*  917 */         this.owndishes.put(_e_.getKey(), _e_.getValue());
/*  918 */       this.holdcount = _o_.holdcount;
/*  919 */       this.holdbanqueststate = _o_.holdbanqueststate;
/*  920 */       this.lastbanqueststarttime = _o_.lastbanqueststarttime;
/*  921 */       this.dishescount = _o_.dishescount;
/*  922 */       this.joinbanquestinfo = new HashMap();
/*  923 */       for (Map.Entry<Long, xbean.SingleBanquestInfo> _e_ : _o_.joinbanquestinfo.entrySet())
/*  924 */         this.joinbanquestinfo.put(_e_.getKey(), new SingleBanquestInfo.Data((xbean.SingleBanquestInfo)_e_.getValue()));
/*  925 */       this.fristjoinbanquesttime = _o_.fristjoinbanquesttime;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  931 */       _os_.compact_uint32(this.owndishes.size());
/*  932 */       for (Map.Entry<Integer, Integer> _e_ : this.owndishes.entrySet())
/*      */       {
/*  934 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  935 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  937 */       _os_.marshal(this.holdcount);
/*  938 */       _os_.marshal(this.holdbanqueststate);
/*  939 */       _os_.marshal(this.lastbanqueststarttime);
/*  940 */       _os_.marshal(this.dishescount);
/*  941 */       _os_.compact_uint32(this.joinbanquestinfo.size());
/*  942 */       for (Map.Entry<Long, xbean.SingleBanquestInfo> _e_ : this.joinbanquestinfo.entrySet())
/*      */       {
/*  944 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  945 */         ((xbean.SingleBanquestInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  947 */       _os_.marshal(this.fristjoinbanquesttime);
/*  948 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  955 */       int size = _os_.uncompact_uint32();
/*  956 */       if (size >= 12)
/*      */       {
/*  958 */         this.owndishes = new HashMap(size * 2);
/*      */       }
/*  960 */       for (; size > 0; size--)
/*      */       {
/*  962 */         int _k_ = 0;
/*  963 */         _k_ = _os_.unmarshal_int();
/*  964 */         int _v_ = 0;
/*  965 */         _v_ = _os_.unmarshal_int();
/*  966 */         this.owndishes.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  969 */       this.holdcount = _os_.unmarshal_int();
/*  970 */       this.holdbanqueststate = _os_.unmarshal_boolean();
/*  971 */       this.lastbanqueststarttime = _os_.unmarshal_long();
/*  972 */       this.dishescount = _os_.unmarshal_int();
/*      */       
/*  974 */       int size = _os_.uncompact_uint32();
/*  975 */       if (size >= 12)
/*      */       {
/*  977 */         this.joinbanquestinfo = new HashMap(size * 2);
/*      */       }
/*  979 */       for (; size > 0; size--)
/*      */       {
/*  981 */         long _k_ = 0L;
/*  982 */         _k_ = _os_.unmarshal_long();
/*  983 */         xbean.SingleBanquestInfo _v_ = xbean.Pod.newSingleBanquestInfoData();
/*  984 */         _v_.unmarshal(_os_);
/*  985 */         this.joinbanquestinfo.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  988 */       this.fristjoinbanquesttime = _os_.unmarshal_long();
/*  989 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  995 */       int _size_ = 0;
/*  996 */       for (Map.Entry<Integer, Integer> _e_ : this.owndishes.entrySet())
/*      */       {
/*  998 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  999 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1001 */       _size_ += CodedOutputStream.computeInt32Size(2, this.holdcount);
/* 1002 */       _size_ += CodedOutputStream.computeBoolSize(4, this.holdbanqueststate);
/* 1003 */       _size_ += CodedOutputStream.computeInt64Size(5, this.lastbanqueststarttime);
/* 1004 */       _size_ += CodedOutputStream.computeInt32Size(6, this.dishescount);
/* 1005 */       for (Map.Entry<Long, xbean.SingleBanquestInfo> _e_ : this.joinbanquestinfo.entrySet())
/*      */       {
/* 1007 */         _size_ += CodedOutputStream.computeInt64Size(7, ((Long)_e_.getKey()).longValue());
/* 1008 */         _size_ += CodedOutputStream.computeMessageSize(7, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1010 */       _size_ += CodedOutputStream.computeInt64Size(8, this.fristjoinbanquesttime);
/* 1011 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1019 */         for (Map.Entry<Integer, Integer> _e_ : this.owndishes.entrySet())
/*      */         {
/* 1021 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 1022 */           _output_.writeInt32(1, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1024 */         _output_.writeInt32(2, this.holdcount);
/* 1025 */         _output_.writeBool(4, this.holdbanqueststate);
/* 1026 */         _output_.writeInt64(5, this.lastbanqueststarttime);
/* 1027 */         _output_.writeInt32(6, this.dishescount);
/* 1028 */         for (Map.Entry<Long, xbean.SingleBanquestInfo> _e_ : this.joinbanquestinfo.entrySet())
/*      */         {
/* 1030 */           _output_.writeInt64(7, ((Long)_e_.getKey()).longValue());
/* 1031 */           _output_.writeMessage(7, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1033 */         _output_.writeInt64(8, this.fristjoinbanquesttime);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1037 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1039 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1047 */         boolean done = false;
/* 1048 */         while (!done)
/*      */         {
/* 1050 */           int tag = _input_.readTag();
/* 1051 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1055 */             done = true;
/* 1056 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1060 */             int _k_ = 0;
/* 1061 */             _k_ = _input_.readInt32();
/* 1062 */             int readTag = _input_.readTag();
/* 1063 */             if (8 != readTag)
/*      */             {
/* 1065 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1067 */             int _v_ = 0;
/* 1068 */             _v_ = _input_.readInt32();
/* 1069 */             this.owndishes.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1070 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1074 */             this.holdcount = _input_.readInt32();
/* 1075 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1079 */             this.holdbanqueststate = _input_.readBool();
/* 1080 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1084 */             this.lastbanqueststarttime = _input_.readInt64();
/* 1085 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1089 */             this.dishescount = _input_.readInt32();
/* 1090 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1094 */             long _k_ = 0L;
/* 1095 */             _k_ = _input_.readInt64();
/* 1096 */             int readTag = _input_.readTag();
/* 1097 */             if (58 != readTag)
/*      */             {
/* 1099 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1101 */             xbean.SingleBanquestInfo _v_ = xbean.Pod.newSingleBanquestInfoData();
/* 1102 */             _input_.readMessage(_v_);
/* 1103 */             this.joinbanquestinfo.put(Long.valueOf(_k_), _v_);
/* 1104 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1108 */             this.fristjoinbanquesttime = _input_.readInt64();
/* 1109 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1113 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1115 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1124 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1128 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1130 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BanquestInfo copy()
/*      */     {
/* 1136 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BanquestInfo toData()
/*      */     {
/* 1142 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.BanquestInfo toBean()
/*      */     {
/* 1147 */       return new BanquestInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BanquestInfo toDataIf()
/*      */     {
/* 1153 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.BanquestInfo toBeanIf()
/*      */     {
/* 1158 */       return new BanquestInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1164 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1168 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1172 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1176 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1180 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1184 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1188 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOwndishes()
/*      */     {
/* 1195 */       return this.owndishes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOwndishesAsData()
/*      */     {
/* 1202 */       return this.owndishes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHoldcount()
/*      */     {
/* 1209 */       return this.holdcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getHoldbanqueststate()
/*      */     {
/* 1216 */       return this.holdbanqueststate;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLastbanqueststarttime()
/*      */     {
/* 1223 */       return this.lastbanqueststarttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDishescount()
/*      */     {
/* 1230 */       return this.dishescount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.SingleBanquestInfo> getJoinbanquestinfo()
/*      */     {
/* 1237 */       return this.joinbanquestinfo;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.SingleBanquestInfo> getJoinbanquestinfoAsData()
/*      */     {
/* 1244 */       return this.joinbanquestinfo;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFristjoinbanquesttime()
/*      */     {
/* 1251 */       return this.fristjoinbanquesttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHoldcount(int _v_)
/*      */     {
/* 1258 */       this.holdcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHoldbanqueststate(boolean _v_)
/*      */     {
/* 1265 */       this.holdbanqueststate = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLastbanqueststarttime(long _v_)
/*      */     {
/* 1272 */       this.lastbanqueststarttime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDishescount(int _v_)
/*      */     {
/* 1279 */       this.dishescount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFristjoinbanquesttime(long _v_)
/*      */     {
/* 1286 */       this.fristjoinbanquesttime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1292 */       if (!(_o1_ instanceof Data)) return false;
/* 1293 */       Data _o_ = (Data)_o1_;
/* 1294 */       if (!this.owndishes.equals(_o_.owndishes)) return false;
/* 1295 */       if (this.holdcount != _o_.holdcount) return false;
/* 1296 */       if (this.holdbanqueststate != _o_.holdbanqueststate) return false;
/* 1297 */       if (this.lastbanqueststarttime != _o_.lastbanqueststarttime) return false;
/* 1298 */       if (this.dishescount != _o_.dishescount) return false;
/* 1299 */       if (!this.joinbanquestinfo.equals(_o_.joinbanquestinfo)) return false;
/* 1300 */       if (this.fristjoinbanquesttime != _o_.fristjoinbanquesttime) return false;
/* 1301 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1307 */       int _h_ = 0;
/* 1308 */       _h_ += this.owndishes.hashCode();
/* 1309 */       _h_ += this.holdcount;
/* 1310 */       _h_ += (this.holdbanqueststate ? 1231 : 1237);
/* 1311 */       _h_ = (int)(_h_ + this.lastbanqueststarttime);
/* 1312 */       _h_ += this.dishescount;
/* 1313 */       _h_ += this.joinbanquestinfo.hashCode();
/* 1314 */       _h_ = (int)(_h_ + this.fristjoinbanquesttime);
/* 1315 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1321 */       StringBuilder _sb_ = new StringBuilder();
/* 1322 */       _sb_.append("(");
/* 1323 */       _sb_.append(this.owndishes);
/* 1324 */       _sb_.append(",");
/* 1325 */       _sb_.append(this.holdcount);
/* 1326 */       _sb_.append(",");
/* 1327 */       _sb_.append(this.holdbanqueststate);
/* 1328 */       _sb_.append(",");
/* 1329 */       _sb_.append(this.lastbanqueststarttime);
/* 1330 */       _sb_.append(",");
/* 1331 */       _sb_.append(this.dishescount);
/* 1332 */       _sb_.append(",");
/* 1333 */       _sb_.append(this.joinbanquestinfo);
/* 1334 */       _sb_.append(",");
/* 1335 */       _sb_.append(this.fristjoinbanquesttime);
/* 1336 */       _sb_.append(")");
/* 1337 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\BanquestInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */