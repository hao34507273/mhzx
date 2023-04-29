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
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class ApplyInfoMap extends XBean implements xbean.ApplyInfoMap
/*      */ {
/*      */   private HashMap<Long, xbean.ApplyInfo> applymap;
/*      */   private long cleardatatime;
/*      */   private int applyaddcount;
/*      */   private int applyaddrefusecount;
/*      */   private long refusebanchecktime;
/*      */   private HashMap<Long, Integer> refusecountmap;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.applymap.clear();
/*   29 */     this.cleardatatime = 0L;
/*   30 */     this.applyaddcount = 0;
/*   31 */     this.applyaddrefusecount = 0;
/*   32 */     this.refusebanchecktime = 0L;
/*   33 */     this.refusecountmap.clear();
/*      */   }
/*      */   
/*      */   ApplyInfoMap(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.applymap = new HashMap();
/*   40 */     this.refusebanchecktime = 0L;
/*   41 */     this.refusecountmap = new HashMap();
/*      */   }
/*      */   
/*      */   public ApplyInfoMap()
/*      */   {
/*   46 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public ApplyInfoMap(ApplyInfoMap _o_)
/*      */   {
/*   51 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   ApplyInfoMap(xbean.ApplyInfoMap _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   56 */     super(_xp_, _vn_);
/*   57 */     if ((_o1_ instanceof ApplyInfoMap)) { assign((ApplyInfoMap)_o1_);
/*   58 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   59 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   60 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(ApplyInfoMap _o_) {
/*   65 */     _o_._xdb_verify_unsafe_();
/*   66 */     this.applymap = new HashMap();
/*   67 */     for (Map.Entry<Long, xbean.ApplyInfo> _e_ : _o_.applymap.entrySet())
/*   68 */       this.applymap.put(_e_.getKey(), new ApplyInfo((xbean.ApplyInfo)_e_.getValue(), this, "applymap"));
/*   69 */     this.cleardatatime = _o_.cleardatatime;
/*   70 */     this.applyaddcount = _o_.applyaddcount;
/*   71 */     this.applyaddrefusecount = _o_.applyaddrefusecount;
/*   72 */     this.refusebanchecktime = _o_.refusebanchecktime;
/*   73 */     this.refusecountmap = new HashMap();
/*   74 */     for (Map.Entry<Long, Integer> _e_ : _o_.refusecountmap.entrySet()) {
/*   75 */       this.refusecountmap.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   80 */     this.applymap = new HashMap();
/*   81 */     for (Map.Entry<Long, xbean.ApplyInfo> _e_ : _o_.applymap.entrySet())
/*   82 */       this.applymap.put(_e_.getKey(), new ApplyInfo((xbean.ApplyInfo)_e_.getValue(), this, "applymap"));
/*   83 */     this.cleardatatime = _o_.cleardatatime;
/*   84 */     this.applyaddcount = _o_.applyaddcount;
/*   85 */     this.applyaddrefusecount = _o_.applyaddrefusecount;
/*   86 */     this.refusebanchecktime = _o_.refusebanchecktime;
/*   87 */     this.refusecountmap = new HashMap();
/*   88 */     for (Map.Entry<Long, Integer> _e_ : _o_.refusecountmap.entrySet()) {
/*   89 */       this.refusecountmap.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   95 */     _xdb_verify_unsafe_();
/*   96 */     _os_.compact_uint32(this.applymap.size());
/*   97 */     for (Map.Entry<Long, xbean.ApplyInfo> _e_ : this.applymap.entrySet())
/*      */     {
/*   99 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  100 */       ((xbean.ApplyInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  102 */     _os_.marshal(this.cleardatatime);
/*  103 */     _os_.marshal(this.applyaddcount);
/*  104 */     _os_.marshal(this.applyaddrefusecount);
/*  105 */     _os_.marshal(this.refusebanchecktime);
/*  106 */     _os_.compact_uint32(this.refusecountmap.size());
/*  107 */     for (Map.Entry<Long, Integer> _e_ : this.refusecountmap.entrySet())
/*      */     {
/*  109 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  110 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  112 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  118 */     _xdb_verify_unsafe_();
/*      */     
/*  120 */     int size = _os_.uncompact_uint32();
/*  121 */     if (size >= 12)
/*      */     {
/*  123 */       this.applymap = new HashMap(size * 2);
/*      */     }
/*  125 */     for (; size > 0; size--)
/*      */     {
/*  127 */       long _k_ = 0L;
/*  128 */       _k_ = _os_.unmarshal_long();
/*  129 */       xbean.ApplyInfo _v_ = new ApplyInfo(0, this, "applymap");
/*  130 */       _v_.unmarshal(_os_);
/*  131 */       this.applymap.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  134 */     this.cleardatatime = _os_.unmarshal_long();
/*  135 */     this.applyaddcount = _os_.unmarshal_int();
/*  136 */     this.applyaddrefusecount = _os_.unmarshal_int();
/*  137 */     this.refusebanchecktime = _os_.unmarshal_long();
/*      */     
/*  139 */     int size = _os_.uncompact_uint32();
/*  140 */     if (size >= 12)
/*      */     {
/*  142 */       this.refusecountmap = new HashMap(size * 2);
/*      */     }
/*  144 */     for (; size > 0; size--)
/*      */     {
/*  146 */       long _k_ = 0L;
/*  147 */       _k_ = _os_.unmarshal_long();
/*  148 */       int _v_ = 0;
/*  149 */       _v_ = _os_.unmarshal_int();
/*  150 */       this.refusecountmap.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  153 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  159 */     _xdb_verify_unsafe_();
/*  160 */     int _size_ = 0;
/*  161 */     for (Map.Entry<Long, xbean.ApplyInfo> _e_ : this.applymap.entrySet())
/*      */     {
/*  163 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/*  164 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*      */     }
/*  166 */     _size_ += CodedOutputStream.computeInt64Size(2, this.cleardatatime);
/*  167 */     _size_ += CodedOutputStream.computeInt32Size(3, this.applyaddcount);
/*  168 */     _size_ += CodedOutputStream.computeInt32Size(4, this.applyaddrefusecount);
/*  169 */     _size_ += CodedOutputStream.computeInt64Size(5, this.refusebanchecktime);
/*  170 */     for (Map.Entry<Long, Integer> _e_ : this.refusecountmap.entrySet())
/*      */     {
/*  172 */       _size_ += CodedOutputStream.computeInt64Size(6, ((Long)_e_.getKey()).longValue());
/*  173 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  175 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  181 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  184 */       for (Map.Entry<Long, xbean.ApplyInfo> _e_ : this.applymap.entrySet())
/*      */       {
/*  186 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/*  187 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*      */       }
/*  189 */       _output_.writeInt64(2, this.cleardatatime);
/*  190 */       _output_.writeInt32(3, this.applyaddcount);
/*  191 */       _output_.writeInt32(4, this.applyaddrefusecount);
/*  192 */       _output_.writeInt64(5, this.refusebanchecktime);
/*  193 */       for (Map.Entry<Long, Integer> _e_ : this.refusecountmap.entrySet())
/*      */       {
/*  195 */         _output_.writeInt64(6, ((Long)_e_.getKey()).longValue());
/*  196 */         _output_.writeInt32(6, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  201 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  203 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  209 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  212 */       boolean done = false;
/*  213 */       while (!done)
/*      */       {
/*  215 */         int tag = _input_.readTag();
/*  216 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  220 */           done = true;
/*  221 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  225 */           long _k_ = 0L;
/*  226 */           _k_ = _input_.readInt64();
/*  227 */           int readTag = _input_.readTag();
/*  228 */           if (10 != readTag)
/*      */           {
/*  230 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  232 */           xbean.ApplyInfo _v_ = new ApplyInfo(0, this, "applymap");
/*  233 */           _input_.readMessage(_v_);
/*  234 */           this.applymap.put(Long.valueOf(_k_), _v_);
/*  235 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  239 */           this.cleardatatime = _input_.readInt64();
/*  240 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  244 */           this.applyaddcount = _input_.readInt32();
/*  245 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  249 */           this.applyaddrefusecount = _input_.readInt32();
/*  250 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  254 */           this.refusebanchecktime = _input_.readInt64();
/*  255 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  259 */           long _k_ = 0L;
/*  260 */           _k_ = _input_.readInt64();
/*  261 */           int readTag = _input_.readTag();
/*  262 */           if (48 != readTag)
/*      */           {
/*  264 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  266 */           int _v_ = 0;
/*  267 */           _v_ = _input_.readInt32();
/*  268 */           this.refusecountmap.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  269 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  273 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  275 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  284 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  288 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  290 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ApplyInfoMap copy()
/*      */   {
/*  296 */     _xdb_verify_unsafe_();
/*  297 */     return new ApplyInfoMap(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ApplyInfoMap toData()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ApplyInfoMap toBean()
/*      */   {
/*  309 */     _xdb_verify_unsafe_();
/*  310 */     return new ApplyInfoMap(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ApplyInfoMap toDataIf()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ApplyInfoMap toBeanIf()
/*      */   {
/*  322 */     _xdb_verify_unsafe_();
/*  323 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.ApplyInfo> getApplymap()
/*      */   {
/*  337 */     _xdb_verify_unsafe_();
/*  338 */     return Logs.logMap(new LogKey(this, "applymap"), this.applymap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.ApplyInfo> getApplymapAsData()
/*      */   {
/*  345 */     _xdb_verify_unsafe_();
/*      */     
/*  347 */     ApplyInfoMap _o_ = this;
/*  348 */     Map<Long, xbean.ApplyInfo> applymap = new HashMap();
/*  349 */     for (Map.Entry<Long, xbean.ApplyInfo> _e_ : _o_.applymap.entrySet())
/*  350 */       applymap.put(_e_.getKey(), new ApplyInfo.Data((xbean.ApplyInfo)_e_.getValue()));
/*  351 */     return applymap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCleardatatime()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*  359 */     return this.cleardatatime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getApplyaddcount()
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*  367 */     return this.applyaddcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getApplyaddrefusecount()
/*      */   {
/*  374 */     _xdb_verify_unsafe_();
/*  375 */     return this.applyaddrefusecount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRefusebanchecktime()
/*      */   {
/*  382 */     _xdb_verify_unsafe_();
/*  383 */     return this.refusebanchecktime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getRefusecountmap()
/*      */   {
/*  390 */     _xdb_verify_unsafe_();
/*  391 */     return Logs.logMap(new LogKey(this, "refusecountmap"), this.refusecountmap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getRefusecountmapAsData()
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*      */     
/*  400 */     ApplyInfoMap _o_ = this;
/*  401 */     Map<Long, Integer> refusecountmap = new HashMap();
/*  402 */     for (Map.Entry<Long, Integer> _e_ : _o_.refusecountmap.entrySet())
/*  403 */       refusecountmap.put(_e_.getKey(), _e_.getValue());
/*  404 */     return refusecountmap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCleardatatime(long _v_)
/*      */   {
/*  411 */     _xdb_verify_unsafe_();
/*  412 */     Logs.logIf(new LogKey(this, "cleardatatime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  416 */         new xdb.logs.LogLong(this, ApplyInfoMap.this.cleardatatime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  420 */             ApplyInfoMap.this.cleardatatime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  424 */     });
/*  425 */     this.cleardatatime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setApplyaddcount(int _v_)
/*      */   {
/*  432 */     _xdb_verify_unsafe_();
/*  433 */     Logs.logIf(new LogKey(this, "applyaddcount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  437 */         new xdb.logs.LogInt(this, ApplyInfoMap.this.applyaddcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  441 */             ApplyInfoMap.this.applyaddcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  445 */     });
/*  446 */     this.applyaddcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setApplyaddrefusecount(int _v_)
/*      */   {
/*  453 */     _xdb_verify_unsafe_();
/*  454 */     Logs.logIf(new LogKey(this, "applyaddrefusecount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  458 */         new xdb.logs.LogInt(this, ApplyInfoMap.this.applyaddrefusecount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  462 */             ApplyInfoMap.this.applyaddrefusecount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  466 */     });
/*  467 */     this.applyaddrefusecount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRefusebanchecktime(long _v_)
/*      */   {
/*  474 */     _xdb_verify_unsafe_();
/*  475 */     Logs.logIf(new LogKey(this, "refusebanchecktime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  479 */         new xdb.logs.LogLong(this, ApplyInfoMap.this.refusebanchecktime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  483 */             ApplyInfoMap.this.refusebanchecktime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  487 */     });
/*  488 */     this.refusebanchecktime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  494 */     _xdb_verify_unsafe_();
/*  495 */     ApplyInfoMap _o_ = null;
/*  496 */     if ((_o1_ instanceof ApplyInfoMap)) { _o_ = (ApplyInfoMap)_o1_;
/*  497 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  498 */       return false;
/*  499 */     if (!this.applymap.equals(_o_.applymap)) return false;
/*  500 */     if (this.cleardatatime != _o_.cleardatatime) return false;
/*  501 */     if (this.applyaddcount != _o_.applyaddcount) return false;
/*  502 */     if (this.applyaddrefusecount != _o_.applyaddrefusecount) return false;
/*  503 */     if (this.refusebanchecktime != _o_.refusebanchecktime) return false;
/*  504 */     if (!this.refusecountmap.equals(_o_.refusecountmap)) return false;
/*  505 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  511 */     _xdb_verify_unsafe_();
/*  512 */     int _h_ = 0;
/*  513 */     _h_ += this.applymap.hashCode();
/*  514 */     _h_ = (int)(_h_ + this.cleardatatime);
/*  515 */     _h_ += this.applyaddcount;
/*  516 */     _h_ += this.applyaddrefusecount;
/*  517 */     _h_ = (int)(_h_ + this.refusebanchecktime);
/*  518 */     _h_ += this.refusecountmap.hashCode();
/*  519 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  525 */     _xdb_verify_unsafe_();
/*  526 */     StringBuilder _sb_ = new StringBuilder();
/*  527 */     _sb_.append("(");
/*  528 */     _sb_.append(this.applymap);
/*  529 */     _sb_.append(",");
/*  530 */     _sb_.append(this.cleardatatime);
/*  531 */     _sb_.append(",");
/*  532 */     _sb_.append(this.applyaddcount);
/*  533 */     _sb_.append(",");
/*  534 */     _sb_.append(this.applyaddrefusecount);
/*  535 */     _sb_.append(",");
/*  536 */     _sb_.append(this.refusebanchecktime);
/*  537 */     _sb_.append(",");
/*  538 */     _sb_.append(this.refusecountmap);
/*  539 */     _sb_.append(")");
/*  540 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  546 */     ListenableBean lb = new ListenableBean();
/*  547 */     lb.add(new xdb.logs.ListenableMap().setVarName("applymap"));
/*  548 */     lb.add(new ListenableChanged().setVarName("cleardatatime"));
/*  549 */     lb.add(new ListenableChanged().setVarName("applyaddcount"));
/*  550 */     lb.add(new ListenableChanged().setVarName("applyaddrefusecount"));
/*  551 */     lb.add(new ListenableChanged().setVarName("refusebanchecktime"));
/*  552 */     lb.add(new xdb.logs.ListenableMap().setVarName("refusecountmap"));
/*  553 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.ApplyInfoMap {
/*      */     private Const() {}
/*      */     
/*      */     ApplyInfoMap nThis() {
/*  560 */       return ApplyInfoMap.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  566 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ApplyInfoMap copy()
/*      */     {
/*  572 */       return ApplyInfoMap.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ApplyInfoMap toData()
/*      */     {
/*  578 */       return ApplyInfoMap.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.ApplyInfoMap toBean()
/*      */     {
/*  583 */       return ApplyInfoMap.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ApplyInfoMap toDataIf()
/*      */     {
/*  589 */       return ApplyInfoMap.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.ApplyInfoMap toBeanIf()
/*      */     {
/*  594 */       return ApplyInfoMap.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ApplyInfo> getApplymap()
/*      */     {
/*  601 */       ApplyInfoMap.this._xdb_verify_unsafe_();
/*  602 */       return xdb.Consts.constMap(ApplyInfoMap.this.applymap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ApplyInfo> getApplymapAsData()
/*      */     {
/*  609 */       ApplyInfoMap.this._xdb_verify_unsafe_();
/*      */       
/*  611 */       ApplyInfoMap _o_ = ApplyInfoMap.this;
/*  612 */       Map<Long, xbean.ApplyInfo> applymap = new HashMap();
/*  613 */       for (Map.Entry<Long, xbean.ApplyInfo> _e_ : _o_.applymap.entrySet())
/*  614 */         applymap.put(_e_.getKey(), new ApplyInfo.Data((xbean.ApplyInfo)_e_.getValue()));
/*  615 */       return applymap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCleardatatime()
/*      */     {
/*  622 */       ApplyInfoMap.this._xdb_verify_unsafe_();
/*  623 */       return ApplyInfoMap.this.cleardatatime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getApplyaddcount()
/*      */     {
/*  630 */       ApplyInfoMap.this._xdb_verify_unsafe_();
/*  631 */       return ApplyInfoMap.this.applyaddcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getApplyaddrefusecount()
/*      */     {
/*  638 */       ApplyInfoMap.this._xdb_verify_unsafe_();
/*  639 */       return ApplyInfoMap.this.applyaddrefusecount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRefusebanchecktime()
/*      */     {
/*  646 */       ApplyInfoMap.this._xdb_verify_unsafe_();
/*  647 */       return ApplyInfoMap.this.refusebanchecktime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRefusecountmap()
/*      */     {
/*  654 */       ApplyInfoMap.this._xdb_verify_unsafe_();
/*  655 */       return xdb.Consts.constMap(ApplyInfoMap.this.refusecountmap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRefusecountmapAsData()
/*      */     {
/*  662 */       ApplyInfoMap.this._xdb_verify_unsafe_();
/*      */       
/*  664 */       ApplyInfoMap _o_ = ApplyInfoMap.this;
/*  665 */       Map<Long, Integer> refusecountmap = new HashMap();
/*  666 */       for (Map.Entry<Long, Integer> _e_ : _o_.refusecountmap.entrySet())
/*  667 */         refusecountmap.put(_e_.getKey(), _e_.getValue());
/*  668 */       return refusecountmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCleardatatime(long _v_)
/*      */     {
/*  675 */       ApplyInfoMap.this._xdb_verify_unsafe_();
/*  676 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setApplyaddcount(int _v_)
/*      */     {
/*  683 */       ApplyInfoMap.this._xdb_verify_unsafe_();
/*  684 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setApplyaddrefusecount(int _v_)
/*      */     {
/*  691 */       ApplyInfoMap.this._xdb_verify_unsafe_();
/*  692 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRefusebanchecktime(long _v_)
/*      */     {
/*  699 */       ApplyInfoMap.this._xdb_verify_unsafe_();
/*  700 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  706 */       ApplyInfoMap.this._xdb_verify_unsafe_();
/*  707 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  713 */       ApplyInfoMap.this._xdb_verify_unsafe_();
/*  714 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  720 */       return ApplyInfoMap.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  726 */       return ApplyInfoMap.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  732 */       ApplyInfoMap.this._xdb_verify_unsafe_();
/*  733 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  739 */       return ApplyInfoMap.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  745 */       return ApplyInfoMap.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  751 */       ApplyInfoMap.this._xdb_verify_unsafe_();
/*  752 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  758 */       return ApplyInfoMap.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  764 */       return ApplyInfoMap.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  770 */       return ApplyInfoMap.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  776 */       return ApplyInfoMap.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  782 */       return ApplyInfoMap.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  788 */       return ApplyInfoMap.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  794 */       return ApplyInfoMap.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.ApplyInfoMap
/*      */   {
/*      */     private HashMap<Long, xbean.ApplyInfo> applymap;
/*      */     
/*      */     private long cleardatatime;
/*      */     
/*      */     private int applyaddcount;
/*      */     
/*      */     private int applyaddrefusecount;
/*      */     
/*      */     private long refusebanchecktime;
/*      */     
/*      */     private HashMap<Long, Integer> refusecountmap;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  816 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  821 */       this.applymap = new HashMap();
/*  822 */       this.refusebanchecktime = 0L;
/*  823 */       this.refusecountmap = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.ApplyInfoMap _o1_)
/*      */     {
/*  828 */       if ((_o1_ instanceof ApplyInfoMap)) { assign((ApplyInfoMap)_o1_);
/*  829 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  830 */       } else if ((_o1_ instanceof ApplyInfoMap.Const)) assign(((ApplyInfoMap.Const)_o1_).nThis()); else {
/*  831 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(ApplyInfoMap _o_) {
/*  836 */       this.applymap = new HashMap();
/*  837 */       for (Map.Entry<Long, xbean.ApplyInfo> _e_ : _o_.applymap.entrySet())
/*  838 */         this.applymap.put(_e_.getKey(), new ApplyInfo.Data((xbean.ApplyInfo)_e_.getValue()));
/*  839 */       this.cleardatatime = _o_.cleardatatime;
/*  840 */       this.applyaddcount = _o_.applyaddcount;
/*  841 */       this.applyaddrefusecount = _o_.applyaddrefusecount;
/*  842 */       this.refusebanchecktime = _o_.refusebanchecktime;
/*  843 */       this.refusecountmap = new HashMap();
/*  844 */       for (Map.Entry<Long, Integer> _e_ : _o_.refusecountmap.entrySet()) {
/*  845 */         this.refusecountmap.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  850 */       this.applymap = new HashMap();
/*  851 */       for (Map.Entry<Long, xbean.ApplyInfo> _e_ : _o_.applymap.entrySet())
/*  852 */         this.applymap.put(_e_.getKey(), new ApplyInfo.Data((xbean.ApplyInfo)_e_.getValue()));
/*  853 */       this.cleardatatime = _o_.cleardatatime;
/*  854 */       this.applyaddcount = _o_.applyaddcount;
/*  855 */       this.applyaddrefusecount = _o_.applyaddrefusecount;
/*  856 */       this.refusebanchecktime = _o_.refusebanchecktime;
/*  857 */       this.refusecountmap = new HashMap();
/*  858 */       for (Map.Entry<Long, Integer> _e_ : _o_.refusecountmap.entrySet()) {
/*  859 */         this.refusecountmap.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  865 */       _os_.compact_uint32(this.applymap.size());
/*  866 */       for (Map.Entry<Long, xbean.ApplyInfo> _e_ : this.applymap.entrySet())
/*      */       {
/*  868 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  869 */         ((xbean.ApplyInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  871 */       _os_.marshal(this.cleardatatime);
/*  872 */       _os_.marshal(this.applyaddcount);
/*  873 */       _os_.marshal(this.applyaddrefusecount);
/*  874 */       _os_.marshal(this.refusebanchecktime);
/*  875 */       _os_.compact_uint32(this.refusecountmap.size());
/*  876 */       for (Map.Entry<Long, Integer> _e_ : this.refusecountmap.entrySet())
/*      */       {
/*  878 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  879 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  881 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  888 */       int size = _os_.uncompact_uint32();
/*  889 */       if (size >= 12)
/*      */       {
/*  891 */         this.applymap = new HashMap(size * 2);
/*      */       }
/*  893 */       for (; size > 0; size--)
/*      */       {
/*  895 */         long _k_ = 0L;
/*  896 */         _k_ = _os_.unmarshal_long();
/*  897 */         xbean.ApplyInfo _v_ = xbean.Pod.newApplyInfoData();
/*  898 */         _v_.unmarshal(_os_);
/*  899 */         this.applymap.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  902 */       this.cleardatatime = _os_.unmarshal_long();
/*  903 */       this.applyaddcount = _os_.unmarshal_int();
/*  904 */       this.applyaddrefusecount = _os_.unmarshal_int();
/*  905 */       this.refusebanchecktime = _os_.unmarshal_long();
/*      */       
/*  907 */       int size = _os_.uncompact_uint32();
/*  908 */       if (size >= 12)
/*      */       {
/*  910 */         this.refusecountmap = new HashMap(size * 2);
/*      */       }
/*  912 */       for (; size > 0; size--)
/*      */       {
/*  914 */         long _k_ = 0L;
/*  915 */         _k_ = _os_.unmarshal_long();
/*  916 */         int _v_ = 0;
/*  917 */         _v_ = _os_.unmarshal_int();
/*  918 */         this.refusecountmap.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  921 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  927 */       int _size_ = 0;
/*  928 */       for (Map.Entry<Long, xbean.ApplyInfo> _e_ : this.applymap.entrySet())
/*      */       {
/*  930 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/*  931 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*      */       }
/*  933 */       _size_ += CodedOutputStream.computeInt64Size(2, this.cleardatatime);
/*  934 */       _size_ += CodedOutputStream.computeInt32Size(3, this.applyaddcount);
/*  935 */       _size_ += CodedOutputStream.computeInt32Size(4, this.applyaddrefusecount);
/*  936 */       _size_ += CodedOutputStream.computeInt64Size(5, this.refusebanchecktime);
/*  937 */       for (Map.Entry<Long, Integer> _e_ : this.refusecountmap.entrySet())
/*      */       {
/*  939 */         _size_ += CodedOutputStream.computeInt64Size(6, ((Long)_e_.getKey()).longValue());
/*  940 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  942 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  950 */         for (Map.Entry<Long, xbean.ApplyInfo> _e_ : this.applymap.entrySet())
/*      */         {
/*  952 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/*  953 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*      */         }
/*  955 */         _output_.writeInt64(2, this.cleardatatime);
/*  956 */         _output_.writeInt32(3, this.applyaddcount);
/*  957 */         _output_.writeInt32(4, this.applyaddrefusecount);
/*  958 */         _output_.writeInt64(5, this.refusebanchecktime);
/*  959 */         for (Map.Entry<Long, Integer> _e_ : this.refusecountmap.entrySet())
/*      */         {
/*  961 */           _output_.writeInt64(6, ((Long)_e_.getKey()).longValue());
/*  962 */           _output_.writeInt32(6, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  967 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  969 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  977 */         boolean done = false;
/*  978 */         while (!done)
/*      */         {
/*  980 */           int tag = _input_.readTag();
/*  981 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  985 */             done = true;
/*  986 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  990 */             long _k_ = 0L;
/*  991 */             _k_ = _input_.readInt64();
/*  992 */             int readTag = _input_.readTag();
/*  993 */             if (10 != readTag)
/*      */             {
/*  995 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  997 */             xbean.ApplyInfo _v_ = xbean.Pod.newApplyInfoData();
/*  998 */             _input_.readMessage(_v_);
/*  999 */             this.applymap.put(Long.valueOf(_k_), _v_);
/* 1000 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1004 */             this.cleardatatime = _input_.readInt64();
/* 1005 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1009 */             this.applyaddcount = _input_.readInt32();
/* 1010 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1014 */             this.applyaddrefusecount = _input_.readInt32();
/* 1015 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1019 */             this.refusebanchecktime = _input_.readInt64();
/* 1020 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1024 */             long _k_ = 0L;
/* 1025 */             _k_ = _input_.readInt64();
/* 1026 */             int readTag = _input_.readTag();
/* 1027 */             if (48 != readTag)
/*      */             {
/* 1029 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1031 */             int _v_ = 0;
/* 1032 */             _v_ = _input_.readInt32();
/* 1033 */             this.refusecountmap.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 1034 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1038 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1040 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1049 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1053 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1055 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ApplyInfoMap copy()
/*      */     {
/* 1061 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ApplyInfoMap toData()
/*      */     {
/* 1067 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.ApplyInfoMap toBean()
/*      */     {
/* 1072 */       return new ApplyInfoMap(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ApplyInfoMap toDataIf()
/*      */     {
/* 1078 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.ApplyInfoMap toBeanIf()
/*      */     {
/* 1083 */       return new ApplyInfoMap(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1089 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1093 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1097 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1101 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1105 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1109 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1113 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ApplyInfo> getApplymap()
/*      */     {
/* 1120 */       return this.applymap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ApplyInfo> getApplymapAsData()
/*      */     {
/* 1127 */       return this.applymap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCleardatatime()
/*      */     {
/* 1134 */       return this.cleardatatime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getApplyaddcount()
/*      */     {
/* 1141 */       return this.applyaddcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getApplyaddrefusecount()
/*      */     {
/* 1148 */       return this.applyaddrefusecount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRefusebanchecktime()
/*      */     {
/* 1155 */       return this.refusebanchecktime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRefusecountmap()
/*      */     {
/* 1162 */       return this.refusecountmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getRefusecountmapAsData()
/*      */     {
/* 1169 */       return this.refusecountmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCleardatatime(long _v_)
/*      */     {
/* 1176 */       this.cleardatatime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setApplyaddcount(int _v_)
/*      */     {
/* 1183 */       this.applyaddcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setApplyaddrefusecount(int _v_)
/*      */     {
/* 1190 */       this.applyaddrefusecount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRefusebanchecktime(long _v_)
/*      */     {
/* 1197 */       this.refusebanchecktime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1203 */       if (!(_o1_ instanceof Data)) return false;
/* 1204 */       Data _o_ = (Data)_o1_;
/* 1205 */       if (!this.applymap.equals(_o_.applymap)) return false;
/* 1206 */       if (this.cleardatatime != _o_.cleardatatime) return false;
/* 1207 */       if (this.applyaddcount != _o_.applyaddcount) return false;
/* 1208 */       if (this.applyaddrefusecount != _o_.applyaddrefusecount) return false;
/* 1209 */       if (this.refusebanchecktime != _o_.refusebanchecktime) return false;
/* 1210 */       if (!this.refusecountmap.equals(_o_.refusecountmap)) return false;
/* 1211 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1217 */       int _h_ = 0;
/* 1218 */       _h_ += this.applymap.hashCode();
/* 1219 */       _h_ = (int)(_h_ + this.cleardatatime);
/* 1220 */       _h_ += this.applyaddcount;
/* 1221 */       _h_ += this.applyaddrefusecount;
/* 1222 */       _h_ = (int)(_h_ + this.refusebanchecktime);
/* 1223 */       _h_ += this.refusecountmap.hashCode();
/* 1224 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1230 */       StringBuilder _sb_ = new StringBuilder();
/* 1231 */       _sb_.append("(");
/* 1232 */       _sb_.append(this.applymap);
/* 1233 */       _sb_.append(",");
/* 1234 */       _sb_.append(this.cleardatatime);
/* 1235 */       _sb_.append(",");
/* 1236 */       _sb_.append(this.applyaddcount);
/* 1237 */       _sb_.append(",");
/* 1238 */       _sb_.append(this.applyaddrefusecount);
/* 1239 */       _sb_.append(",");
/* 1240 */       _sb_.append(this.refusebanchecktime);
/* 1241 */       _sb_.append(",");
/* 1242 */       _sb_.append(this.refusecountmap);
/* 1243 */       _sb_.append(")");
/* 1244 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ApplyInfoMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */