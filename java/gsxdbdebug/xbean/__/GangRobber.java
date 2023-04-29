/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class GangRobber extends xdb.XBean implements xbean.GangRobber
/*     */ {
/*     */   private HashMap<Long, xbean.GangMonsterRobber> gangrobberdatas;
/*     */   private int stage;
/*     */   private SetX<Integer> roundopenset;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.gangrobberdatas.clear();
/*  23 */     this.stage = 0;
/*  24 */     this.roundopenset.clear();
/*     */   }
/*     */   
/*     */   GangRobber(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.gangrobberdatas = new HashMap();
/*  31 */     this.roundopenset = new SetX();
/*     */   }
/*     */   
/*     */   public GangRobber()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GangRobber(GangRobber _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GangRobber(xbean.GangRobber _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof GangRobber)) { assign((GangRobber)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GangRobber _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.gangrobberdatas = new HashMap();
/*  57 */     for (Map.Entry<Long, xbean.GangMonsterRobber> _e_ : _o_.gangrobberdatas.entrySet())
/*  58 */       this.gangrobberdatas.put(_e_.getKey(), new GangMonsterRobber((xbean.GangMonsterRobber)_e_.getValue(), this, "gangrobberdatas"));
/*  59 */     this.stage = _o_.stage;
/*  60 */     this.roundopenset = new SetX();
/*  61 */     this.roundopenset.addAll(_o_.roundopenset);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  66 */     this.gangrobberdatas = new HashMap();
/*  67 */     for (Map.Entry<Long, xbean.GangMonsterRobber> _e_ : _o_.gangrobberdatas.entrySet())
/*  68 */       this.gangrobberdatas.put(_e_.getKey(), new GangMonsterRobber((xbean.GangMonsterRobber)_e_.getValue(), this, "gangrobberdatas"));
/*  69 */     this.stage = _o_.stage;
/*  70 */     this.roundopenset = new SetX();
/*  71 */     this.roundopenset.addAll(_o_.roundopenset);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  77 */     _xdb_verify_unsafe_();
/*  78 */     _os_.compact_uint32(this.gangrobberdatas.size());
/*  79 */     for (Map.Entry<Long, xbean.GangMonsterRobber> _e_ : this.gangrobberdatas.entrySet())
/*     */     {
/*  81 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  82 */       ((xbean.GangMonsterRobber)_e_.getValue()).marshal(_os_);
/*     */     }
/*  84 */     _os_.marshal(this.stage);
/*  85 */     _os_.compact_uint32(this.roundopenset.size());
/*  86 */     for (Integer _v_ : this.roundopenset)
/*     */     {
/*  88 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*     */     
/*  98 */     int size = _os_.uncompact_uint32();
/*  99 */     if (size >= 12)
/*     */     {
/* 101 */       this.gangrobberdatas = new HashMap(size * 2);
/*     */     }
/* 103 */     for (; size > 0; size--)
/*     */     {
/* 105 */       long _k_ = 0L;
/* 106 */       _k_ = _os_.unmarshal_long();
/* 107 */       xbean.GangMonsterRobber _v_ = new GangMonsterRobber(0, this, "gangrobberdatas");
/* 108 */       _v_.unmarshal(_os_);
/* 109 */       this.gangrobberdatas.put(Long.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 112 */     this.stage = _os_.unmarshal_int();
/* 113 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 115 */       int _v_ = 0;
/* 116 */       _v_ = _os_.unmarshal_int();
/* 117 */       this.roundopenset.add(Integer.valueOf(_v_));
/*     */     }
/* 119 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 125 */     _xdb_verify_unsafe_();
/* 126 */     int _size_ = 0;
/* 127 */     for (Map.Entry<Long, xbean.GangMonsterRobber> _e_ : this.gangrobberdatas.entrySet())
/*     */     {
/* 129 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 130 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 132 */     _size_ += CodedOutputStream.computeInt32Size(2, this.stage);
/* 133 */     for (Integer _v_ : this.roundopenset)
/*     */     {
/* 135 */       _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*     */     }
/* 137 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 143 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 146 */       for (Map.Entry<Long, xbean.GangMonsterRobber> _e_ : this.gangrobberdatas.entrySet())
/*     */       {
/* 148 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 149 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 151 */       _output_.writeInt32(2, this.stage);
/* 152 */       for (Integer _v_ : this.roundopenset)
/*     */       {
/* 154 */         _output_.writeInt32(3, _v_.intValue());
/*     */       }
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 159 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 161 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 167 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 170 */       boolean done = false;
/* 171 */       while (!done)
/*     */       {
/* 173 */         int tag = _input_.readTag();
/* 174 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 178 */           done = true;
/* 179 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 183 */           long _k_ = 0L;
/* 184 */           _k_ = _input_.readInt64();
/* 185 */           int readTag = _input_.readTag();
/* 186 */           if (10 != readTag)
/*     */           {
/* 188 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 190 */           xbean.GangMonsterRobber _v_ = new GangMonsterRobber(0, this, "gangrobberdatas");
/* 191 */           _input_.readMessage(_v_);
/* 192 */           this.gangrobberdatas.put(Long.valueOf(_k_), _v_);
/* 193 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 197 */           this.stage = _input_.readInt32();
/* 198 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 202 */           int _v_ = 0;
/* 203 */           _v_ = _input_.readInt32();
/* 204 */           this.roundopenset.add(Integer.valueOf(_v_));
/* 205 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 209 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 211 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 220 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (java.io.IOException e)
/*     */     {
/* 224 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 226 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangRobber copy()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new GangRobber(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangRobber toData()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GangRobber toBean()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return new GangRobber(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangRobber toDataIf()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GangRobber toBeanIf()
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.GangMonsterRobber> getGangrobberdatas()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     return xdb.Logs.logMap(new xdb.LogKey(this, "gangrobberdatas"), this.gangrobberdatas);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Long, xbean.GangMonsterRobber> getGangrobberdatasAsData()
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/*     */     
/* 283 */     GangRobber _o_ = this;
/* 284 */     Map<Long, xbean.GangMonsterRobber> gangrobberdatas = new HashMap();
/* 285 */     for (Map.Entry<Long, xbean.GangMonsterRobber> _e_ : _o_.gangrobberdatas.entrySet())
/* 286 */       gangrobberdatas.put(_e_.getKey(), new GangMonsterRobber.Data((xbean.GangMonsterRobber)_e_.getValue()));
/* 287 */     return gangrobberdatas;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getStage()
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/* 295 */     return this.stage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getRoundopenset()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     return xdb.Logs.logSet(new xdb.LogKey(this, "roundopenset"), this.roundopenset);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getRoundopensetAsData()
/*     */   {
/* 309 */     _xdb_verify_unsafe_();
/*     */     
/* 311 */     GangRobber _o_ = this;
/* 312 */     Set<Integer> roundopenset = new SetX();
/* 313 */     roundopenset.addAll(_o_.roundopenset);
/* 314 */     return roundopenset;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStage(int _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new xdb.LogKey(this, "stage")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 326 */         new xdb.logs.LogInt(this, GangRobber.this.stage)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             GangRobber.this.stage = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.stage = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     GangRobber _o_ = null;
/* 343 */     if ((_o1_ instanceof GangRobber)) { _o_ = (GangRobber)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (!this.gangrobberdatas.equals(_o_.gangrobberdatas)) return false;
/* 347 */     if (this.stage != _o_.stage) return false;
/* 348 */     if (!this.roundopenset.equals(_o_.roundopenset)) return false;
/* 349 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 355 */     _xdb_verify_unsafe_();
/* 356 */     int _h_ = 0;
/* 357 */     _h_ += this.gangrobberdatas.hashCode();
/* 358 */     _h_ += this.stage;
/* 359 */     _h_ += this.roundopenset.hashCode();
/* 360 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 366 */     _xdb_verify_unsafe_();
/* 367 */     StringBuilder _sb_ = new StringBuilder();
/* 368 */     _sb_.append("(");
/* 369 */     _sb_.append(this.gangrobberdatas);
/* 370 */     _sb_.append(",");
/* 371 */     _sb_.append(this.stage);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.roundopenset);
/* 374 */     _sb_.append(")");
/* 375 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 381 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 382 */     lb.add(new xdb.logs.ListenableMap().setVarName("gangrobberdatas"));
/* 383 */     lb.add(new xdb.logs.ListenableChanged().setVarName("stage"));
/* 384 */     lb.add(new xdb.logs.ListenableSet().setVarName("roundopenset"));
/* 385 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GangRobber {
/*     */     private Const() {}
/*     */     
/*     */     GangRobber nThis() {
/* 392 */       return GangRobber.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 398 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangRobber copy()
/*     */     {
/* 404 */       return GangRobber.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangRobber toData()
/*     */     {
/* 410 */       return GangRobber.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GangRobber toBean()
/*     */     {
/* 415 */       return GangRobber.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangRobber toDataIf()
/*     */     {
/* 421 */       return GangRobber.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GangRobber toBeanIf()
/*     */     {
/* 426 */       return GangRobber.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.GangMonsterRobber> getGangrobberdatas()
/*     */     {
/* 433 */       GangRobber.this._xdb_verify_unsafe_();
/* 434 */       return xdb.Consts.constMap(GangRobber.this.gangrobberdatas);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.GangMonsterRobber> getGangrobberdatasAsData()
/*     */     {
/* 441 */       GangRobber.this._xdb_verify_unsafe_();
/*     */       
/* 443 */       GangRobber _o_ = GangRobber.this;
/* 444 */       Map<Long, xbean.GangMonsterRobber> gangrobberdatas = new HashMap();
/* 445 */       for (Map.Entry<Long, xbean.GangMonsterRobber> _e_ : _o_.gangrobberdatas.entrySet())
/* 446 */         gangrobberdatas.put(_e_.getKey(), new GangMonsterRobber.Data((xbean.GangMonsterRobber)_e_.getValue()));
/* 447 */       return gangrobberdatas;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getStage()
/*     */     {
/* 454 */       GangRobber.this._xdb_verify_unsafe_();
/* 455 */       return GangRobber.this.stage;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getRoundopenset()
/*     */     {
/* 462 */       GangRobber.this._xdb_verify_unsafe_();
/* 463 */       return xdb.Consts.constSet(GangRobber.this.roundopenset);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getRoundopensetAsData()
/*     */     {
/* 469 */       GangRobber.this._xdb_verify_unsafe_();
/*     */       
/* 471 */       GangRobber _o_ = GangRobber.this;
/* 472 */       Set<Integer> roundopenset = new SetX();
/* 473 */       roundopenset.addAll(_o_.roundopenset);
/* 474 */       return roundopenset;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStage(int _v_)
/*     */     {
/* 481 */       GangRobber.this._xdb_verify_unsafe_();
/* 482 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 488 */       GangRobber.this._xdb_verify_unsafe_();
/* 489 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 495 */       GangRobber.this._xdb_verify_unsafe_();
/* 496 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 502 */       return GangRobber.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 508 */       return GangRobber.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 514 */       GangRobber.this._xdb_verify_unsafe_();
/* 515 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 521 */       return GangRobber.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 527 */       return GangRobber.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 533 */       GangRobber.this._xdb_verify_unsafe_();
/* 534 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 540 */       return GangRobber.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 546 */       return GangRobber.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 552 */       return GangRobber.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 558 */       return GangRobber.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 564 */       return GangRobber.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 570 */       return GangRobber.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 576 */       return GangRobber.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GangRobber
/*     */   {
/*     */     private HashMap<Long, xbean.GangMonsterRobber> gangrobberdatas;
/*     */     
/*     */     private int stage;
/*     */     
/*     */     private HashSet<Integer> roundopenset;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 592 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 597 */       this.gangrobberdatas = new HashMap();
/* 598 */       this.roundopenset = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.GangRobber _o1_)
/*     */     {
/* 603 */       if ((_o1_ instanceof GangRobber)) { assign((GangRobber)_o1_);
/* 604 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 605 */       } else if ((_o1_ instanceof GangRobber.Const)) assign(((GangRobber.Const)_o1_).nThis()); else {
/* 606 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GangRobber _o_) {
/* 611 */       this.gangrobberdatas = new HashMap();
/* 612 */       for (Map.Entry<Long, xbean.GangMonsterRobber> _e_ : _o_.gangrobberdatas.entrySet())
/* 613 */         this.gangrobberdatas.put(_e_.getKey(), new GangMonsterRobber.Data((xbean.GangMonsterRobber)_e_.getValue()));
/* 614 */       this.stage = _o_.stage;
/* 615 */       this.roundopenset = new HashSet();
/* 616 */       this.roundopenset.addAll(_o_.roundopenset);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 621 */       this.gangrobberdatas = new HashMap();
/* 622 */       for (Map.Entry<Long, xbean.GangMonsterRobber> _e_ : _o_.gangrobberdatas.entrySet())
/* 623 */         this.gangrobberdatas.put(_e_.getKey(), new GangMonsterRobber.Data((xbean.GangMonsterRobber)_e_.getValue()));
/* 624 */       this.stage = _o_.stage;
/* 625 */       this.roundopenset = new HashSet();
/* 626 */       this.roundopenset.addAll(_o_.roundopenset);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 632 */       _os_.compact_uint32(this.gangrobberdatas.size());
/* 633 */       for (Map.Entry<Long, xbean.GangMonsterRobber> _e_ : this.gangrobberdatas.entrySet())
/*     */       {
/* 635 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 636 */         ((xbean.GangMonsterRobber)_e_.getValue()).marshal(_os_);
/*     */       }
/* 638 */       _os_.marshal(this.stage);
/* 639 */       _os_.compact_uint32(this.roundopenset.size());
/* 640 */       for (Integer _v_ : this.roundopenset)
/*     */       {
/* 642 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 644 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 651 */       int size = _os_.uncompact_uint32();
/* 652 */       if (size >= 12)
/*     */       {
/* 654 */         this.gangrobberdatas = new HashMap(size * 2);
/*     */       }
/* 656 */       for (; size > 0; size--)
/*     */       {
/* 658 */         long _k_ = 0L;
/* 659 */         _k_ = _os_.unmarshal_long();
/* 660 */         xbean.GangMonsterRobber _v_ = xbean.Pod.newGangMonsterRobberData();
/* 661 */         _v_.unmarshal(_os_);
/* 662 */         this.gangrobberdatas.put(Long.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 665 */       this.stage = _os_.unmarshal_int();
/* 666 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 668 */         int _v_ = 0;
/* 669 */         _v_ = _os_.unmarshal_int();
/* 670 */         this.roundopenset.add(Integer.valueOf(_v_));
/*     */       }
/* 672 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 678 */       int _size_ = 0;
/* 679 */       for (Map.Entry<Long, xbean.GangMonsterRobber> _e_ : this.gangrobberdatas.entrySet())
/*     */       {
/* 681 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/* 682 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 684 */       _size_ += CodedOutputStream.computeInt32Size(2, this.stage);
/* 685 */       for (Integer _v_ : this.roundopenset)
/*     */       {
/* 687 */         _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*     */       }
/* 689 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 697 */         for (Map.Entry<Long, xbean.GangMonsterRobber> _e_ : this.gangrobberdatas.entrySet())
/*     */         {
/* 699 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/* 700 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 702 */         _output_.writeInt32(2, this.stage);
/* 703 */         for (Integer _v_ : this.roundopenset)
/*     */         {
/* 705 */           _output_.writeInt32(3, _v_.intValue());
/*     */         }
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 710 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 712 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 720 */         boolean done = false;
/* 721 */         while (!done)
/*     */         {
/* 723 */           int tag = _input_.readTag();
/* 724 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 728 */             done = true;
/* 729 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 733 */             long _k_ = 0L;
/* 734 */             _k_ = _input_.readInt64();
/* 735 */             int readTag = _input_.readTag();
/* 736 */             if (10 != readTag)
/*     */             {
/* 738 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 740 */             xbean.GangMonsterRobber _v_ = xbean.Pod.newGangMonsterRobberData();
/* 741 */             _input_.readMessage(_v_);
/* 742 */             this.gangrobberdatas.put(Long.valueOf(_k_), _v_);
/* 743 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 747 */             this.stage = _input_.readInt32();
/* 748 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 752 */             int _v_ = 0;
/* 753 */             _v_ = _input_.readInt32();
/* 754 */             this.roundopenset.add(Integer.valueOf(_v_));
/* 755 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 759 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 761 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 770 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 774 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 776 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangRobber copy()
/*     */     {
/* 782 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangRobber toData()
/*     */     {
/* 788 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GangRobber toBean()
/*     */     {
/* 793 */       return new GangRobber(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangRobber toDataIf()
/*     */     {
/* 799 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GangRobber toBeanIf()
/*     */     {
/* 804 */       return new GangRobber(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 810 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 814 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 818 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 822 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 826 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 830 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 834 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.GangMonsterRobber> getGangrobberdatas()
/*     */     {
/* 841 */       return this.gangrobberdatas;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Long, xbean.GangMonsterRobber> getGangrobberdatasAsData()
/*     */     {
/* 848 */       return this.gangrobberdatas;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getStage()
/*     */     {
/* 855 */       return this.stage;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getRoundopenset()
/*     */     {
/* 862 */       return this.roundopenset;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getRoundopensetAsData()
/*     */     {
/* 869 */       return this.roundopenset;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStage(int _v_)
/*     */     {
/* 876 */       this.stage = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 882 */       if (!(_o1_ instanceof Data)) return false;
/* 883 */       Data _o_ = (Data)_o1_;
/* 884 */       if (!this.gangrobberdatas.equals(_o_.gangrobberdatas)) return false;
/* 885 */       if (this.stage != _o_.stage) return false;
/* 886 */       if (!this.roundopenset.equals(_o_.roundopenset)) return false;
/* 887 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 893 */       int _h_ = 0;
/* 894 */       _h_ += this.gangrobberdatas.hashCode();
/* 895 */       _h_ += this.stage;
/* 896 */       _h_ += this.roundopenset.hashCode();
/* 897 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 903 */       StringBuilder _sb_ = new StringBuilder();
/* 904 */       _sb_.append("(");
/* 905 */       _sb_.append(this.gangrobberdatas);
/* 906 */       _sb_.append(",");
/* 907 */       _sb_.append(this.stage);
/* 908 */       _sb_.append(",");
/* 909 */       _sb_.append(this.roundopenset);
/* 910 */       _sb_.append(")");
/* 911 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GangRobber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */