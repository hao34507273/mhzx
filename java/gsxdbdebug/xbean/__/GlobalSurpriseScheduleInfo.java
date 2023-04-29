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
/*     */ public final class GlobalSurpriseScheduleInfo extends xdb.XBean implements xbean.GlobalSurpriseScheduleInfo
/*     */ {
/*     */   private HashMap<Integer, xbean.DaySessionInfo> sessioninfos;
/*     */   private SetX<Integer> openedgraphids;
/*     */   private int effectserverlevel;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.sessioninfos.clear();
/*  23 */     this.openedgraphids.clear();
/*  24 */     this.effectserverlevel = 0;
/*     */   }
/*     */   
/*     */   GlobalSurpriseScheduleInfo(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.sessioninfos = new HashMap();
/*  31 */     this.openedgraphids = new SetX();
/*     */   }
/*     */   
/*     */   public GlobalSurpriseScheduleInfo()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GlobalSurpriseScheduleInfo(GlobalSurpriseScheduleInfo _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GlobalSurpriseScheduleInfo(xbean.GlobalSurpriseScheduleInfo _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof GlobalSurpriseScheduleInfo)) { assign((GlobalSurpriseScheduleInfo)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GlobalSurpriseScheduleInfo _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.sessioninfos = new HashMap();
/*  57 */     for (Map.Entry<Integer, xbean.DaySessionInfo> _e_ : _o_.sessioninfos.entrySet())
/*  58 */       this.sessioninfos.put(_e_.getKey(), new DaySessionInfo((xbean.DaySessionInfo)_e_.getValue(), this, "sessioninfos"));
/*  59 */     this.openedgraphids = new SetX();
/*  60 */     this.openedgraphids.addAll(_o_.openedgraphids);
/*  61 */     this.effectserverlevel = _o_.effectserverlevel;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  66 */     this.sessioninfos = new HashMap();
/*  67 */     for (Map.Entry<Integer, xbean.DaySessionInfo> _e_ : _o_.sessioninfos.entrySet())
/*  68 */       this.sessioninfos.put(_e_.getKey(), new DaySessionInfo((xbean.DaySessionInfo)_e_.getValue(), this, "sessioninfos"));
/*  69 */     this.openedgraphids = new SetX();
/*  70 */     this.openedgraphids.addAll(_o_.openedgraphids);
/*  71 */     this.effectserverlevel = _o_.effectserverlevel;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  77 */     _xdb_verify_unsafe_();
/*  78 */     _os_.compact_uint32(this.sessioninfos.size());
/*  79 */     for (Map.Entry<Integer, xbean.DaySessionInfo> _e_ : this.sessioninfos.entrySet())
/*     */     {
/*  81 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  82 */       ((xbean.DaySessionInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  84 */     _os_.compact_uint32(this.openedgraphids.size());
/*  85 */     for (Integer _v_ : this.openedgraphids)
/*     */     {
/*  87 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  89 */     _os_.marshal(this.effectserverlevel);
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
/* 101 */       this.sessioninfos = new HashMap(size * 2);
/*     */     }
/* 103 */     for (; size > 0; size--)
/*     */     {
/* 105 */       int _k_ = 0;
/* 106 */       _k_ = _os_.unmarshal_int();
/* 107 */       xbean.DaySessionInfo _v_ = new DaySessionInfo(0, this, "sessioninfos");
/* 108 */       _v_.unmarshal(_os_);
/* 109 */       this.sessioninfos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 112 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 114 */       int _v_ = 0;
/* 115 */       _v_ = _os_.unmarshal_int();
/* 116 */       this.openedgraphids.add(Integer.valueOf(_v_));
/*     */     }
/* 118 */     this.effectserverlevel = _os_.unmarshal_int();
/* 119 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 125 */     _xdb_verify_unsafe_();
/* 126 */     int _size_ = 0;
/* 127 */     for (Map.Entry<Integer, xbean.DaySessionInfo> _e_ : this.sessioninfos.entrySet())
/*     */     {
/* 129 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 130 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 132 */     for (Integer _v_ : this.openedgraphids)
/*     */     {
/* 134 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */     }
/* 136 */     _size_ += CodedOutputStream.computeInt32Size(3, this.effectserverlevel);
/* 137 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 143 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 146 */       for (Map.Entry<Integer, xbean.DaySessionInfo> _e_ : this.sessioninfos.entrySet())
/*     */       {
/* 148 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 149 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 151 */       for (Integer _v_ : this.openedgraphids)
/*     */       {
/* 153 */         _output_.writeInt32(2, _v_.intValue());
/*     */       }
/* 155 */       _output_.writeInt32(3, this.effectserverlevel);
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
/* 183 */           int _k_ = 0;
/* 184 */           _k_ = _input_.readInt32();
/* 185 */           int readTag = _input_.readTag();
/* 186 */           if (10 != readTag)
/*     */           {
/* 188 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 190 */           xbean.DaySessionInfo _v_ = new DaySessionInfo(0, this, "sessioninfos");
/* 191 */           _input_.readMessage(_v_);
/* 192 */           this.sessioninfos.put(Integer.valueOf(_k_), _v_);
/* 193 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 197 */           int _v_ = 0;
/* 198 */           _v_ = _input_.readInt32();
/* 199 */           this.openedgraphids.add(Integer.valueOf(_v_));
/* 200 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 204 */           this.effectserverlevel = _input_.readInt32();
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
/*     */   public xbean.GlobalSurpriseScheduleInfo copy()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new GlobalSurpriseScheduleInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GlobalSurpriseScheduleInfo toData()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GlobalSurpriseScheduleInfo toBean()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return new GlobalSurpriseScheduleInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GlobalSurpriseScheduleInfo toDataIf()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GlobalSurpriseScheduleInfo toBeanIf()
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
/*     */   public Map<Integer, xbean.DaySessionInfo> getSessioninfos()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     return xdb.Logs.logMap(new xdb.LogKey(this, "sessioninfos"), this.sessioninfos);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.DaySessionInfo> getSessioninfosAsData()
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/*     */     
/* 283 */     GlobalSurpriseScheduleInfo _o_ = this;
/* 284 */     Map<Integer, xbean.DaySessionInfo> sessioninfos = new HashMap();
/* 285 */     for (Map.Entry<Integer, xbean.DaySessionInfo> _e_ : _o_.sessioninfos.entrySet())
/* 286 */       sessioninfos.put(_e_.getKey(), new DaySessionInfo.Data((xbean.DaySessionInfo)_e_.getValue()));
/* 287 */     return sessioninfos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getOpenedgraphids()
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/* 295 */     return xdb.Logs.logSet(new xdb.LogKey(this, "openedgraphids"), this.openedgraphids);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getOpenedgraphidsAsData()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/*     */     
/* 303 */     GlobalSurpriseScheduleInfo _o_ = this;
/* 304 */     Set<Integer> openedgraphids = new SetX();
/* 305 */     openedgraphids.addAll(_o_.openedgraphids);
/* 306 */     return openedgraphids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getEffectserverlevel()
/*     */   {
/* 313 */     _xdb_verify_unsafe_();
/* 314 */     return this.effectserverlevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEffectserverlevel(int _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new xdb.LogKey(this, "effectserverlevel")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 326 */         new xdb.logs.LogInt(this, GlobalSurpriseScheduleInfo.this.effectserverlevel)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             GlobalSurpriseScheduleInfo.this.effectserverlevel = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.effectserverlevel = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     GlobalSurpriseScheduleInfo _o_ = null;
/* 343 */     if ((_o1_ instanceof GlobalSurpriseScheduleInfo)) { _o_ = (GlobalSurpriseScheduleInfo)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (!this.sessioninfos.equals(_o_.sessioninfos)) return false;
/* 347 */     if (!this.openedgraphids.equals(_o_.openedgraphids)) return false;
/* 348 */     if (this.effectserverlevel != _o_.effectserverlevel) return false;
/* 349 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 355 */     _xdb_verify_unsafe_();
/* 356 */     int _h_ = 0;
/* 357 */     _h_ += this.sessioninfos.hashCode();
/* 358 */     _h_ += this.openedgraphids.hashCode();
/* 359 */     _h_ += this.effectserverlevel;
/* 360 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 366 */     _xdb_verify_unsafe_();
/* 367 */     StringBuilder _sb_ = new StringBuilder();
/* 368 */     _sb_.append("(");
/* 369 */     _sb_.append(this.sessioninfos);
/* 370 */     _sb_.append(",");
/* 371 */     _sb_.append(this.openedgraphids);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.effectserverlevel);
/* 374 */     _sb_.append(")");
/* 375 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 381 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 382 */     lb.add(new xdb.logs.ListenableMap().setVarName("sessioninfos"));
/* 383 */     lb.add(new xdb.logs.ListenableSet().setVarName("openedgraphids"));
/* 384 */     lb.add(new xdb.logs.ListenableChanged().setVarName("effectserverlevel"));
/* 385 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GlobalSurpriseScheduleInfo {
/*     */     private Const() {}
/*     */     
/*     */     GlobalSurpriseScheduleInfo nThis() {
/* 392 */       return GlobalSurpriseScheduleInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 398 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalSurpriseScheduleInfo copy()
/*     */     {
/* 404 */       return GlobalSurpriseScheduleInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalSurpriseScheduleInfo toData()
/*     */     {
/* 410 */       return GlobalSurpriseScheduleInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GlobalSurpriseScheduleInfo toBean()
/*     */     {
/* 415 */       return GlobalSurpriseScheduleInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalSurpriseScheduleInfo toDataIf()
/*     */     {
/* 421 */       return GlobalSurpriseScheduleInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GlobalSurpriseScheduleInfo toBeanIf()
/*     */     {
/* 426 */       return GlobalSurpriseScheduleInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.DaySessionInfo> getSessioninfos()
/*     */     {
/* 433 */       GlobalSurpriseScheduleInfo.this._xdb_verify_unsafe_();
/* 434 */       return xdb.Consts.constMap(GlobalSurpriseScheduleInfo.this.sessioninfos);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.DaySessionInfo> getSessioninfosAsData()
/*     */     {
/* 441 */       GlobalSurpriseScheduleInfo.this._xdb_verify_unsafe_();
/*     */       
/* 443 */       GlobalSurpriseScheduleInfo _o_ = GlobalSurpriseScheduleInfo.this;
/* 444 */       Map<Integer, xbean.DaySessionInfo> sessioninfos = new HashMap();
/* 445 */       for (Map.Entry<Integer, xbean.DaySessionInfo> _e_ : _o_.sessioninfos.entrySet())
/* 446 */         sessioninfos.put(_e_.getKey(), new DaySessionInfo.Data((xbean.DaySessionInfo)_e_.getValue()));
/* 447 */       return sessioninfos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getOpenedgraphids()
/*     */     {
/* 454 */       GlobalSurpriseScheduleInfo.this._xdb_verify_unsafe_();
/* 455 */       return xdb.Consts.constSet(GlobalSurpriseScheduleInfo.this.openedgraphids);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getOpenedgraphidsAsData()
/*     */     {
/* 461 */       GlobalSurpriseScheduleInfo.this._xdb_verify_unsafe_();
/*     */       
/* 463 */       GlobalSurpriseScheduleInfo _o_ = GlobalSurpriseScheduleInfo.this;
/* 464 */       Set<Integer> openedgraphids = new SetX();
/* 465 */       openedgraphids.addAll(_o_.openedgraphids);
/* 466 */       return openedgraphids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getEffectserverlevel()
/*     */     {
/* 473 */       GlobalSurpriseScheduleInfo.this._xdb_verify_unsafe_();
/* 474 */       return GlobalSurpriseScheduleInfo.this.effectserverlevel;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEffectserverlevel(int _v_)
/*     */     {
/* 481 */       GlobalSurpriseScheduleInfo.this._xdb_verify_unsafe_();
/* 482 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 488 */       GlobalSurpriseScheduleInfo.this._xdb_verify_unsafe_();
/* 489 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 495 */       GlobalSurpriseScheduleInfo.this._xdb_verify_unsafe_();
/* 496 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 502 */       return GlobalSurpriseScheduleInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 508 */       return GlobalSurpriseScheduleInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 514 */       GlobalSurpriseScheduleInfo.this._xdb_verify_unsafe_();
/* 515 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 521 */       return GlobalSurpriseScheduleInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 527 */       return GlobalSurpriseScheduleInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 533 */       GlobalSurpriseScheduleInfo.this._xdb_verify_unsafe_();
/* 534 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 540 */       return GlobalSurpriseScheduleInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 546 */       return GlobalSurpriseScheduleInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 552 */       return GlobalSurpriseScheduleInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 558 */       return GlobalSurpriseScheduleInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 564 */       return GlobalSurpriseScheduleInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 570 */       return GlobalSurpriseScheduleInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 576 */       return GlobalSurpriseScheduleInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GlobalSurpriseScheduleInfo
/*     */   {
/*     */     private HashMap<Integer, xbean.DaySessionInfo> sessioninfos;
/*     */     
/*     */     private HashSet<Integer> openedgraphids;
/*     */     
/*     */     private int effectserverlevel;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 592 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 597 */       this.sessioninfos = new HashMap();
/* 598 */       this.openedgraphids = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.GlobalSurpriseScheduleInfo _o1_)
/*     */     {
/* 603 */       if ((_o1_ instanceof GlobalSurpriseScheduleInfo)) { assign((GlobalSurpriseScheduleInfo)_o1_);
/* 604 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 605 */       } else if ((_o1_ instanceof GlobalSurpriseScheduleInfo.Const)) assign(((GlobalSurpriseScheduleInfo.Const)_o1_).nThis()); else {
/* 606 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GlobalSurpriseScheduleInfo _o_) {
/* 611 */       this.sessioninfos = new HashMap();
/* 612 */       for (Map.Entry<Integer, xbean.DaySessionInfo> _e_ : _o_.sessioninfos.entrySet())
/* 613 */         this.sessioninfos.put(_e_.getKey(), new DaySessionInfo.Data((xbean.DaySessionInfo)_e_.getValue()));
/* 614 */       this.openedgraphids = new HashSet();
/* 615 */       this.openedgraphids.addAll(_o_.openedgraphids);
/* 616 */       this.effectserverlevel = _o_.effectserverlevel;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 621 */       this.sessioninfos = new HashMap();
/* 622 */       for (Map.Entry<Integer, xbean.DaySessionInfo> _e_ : _o_.sessioninfos.entrySet())
/* 623 */         this.sessioninfos.put(_e_.getKey(), new DaySessionInfo.Data((xbean.DaySessionInfo)_e_.getValue()));
/* 624 */       this.openedgraphids = new HashSet();
/* 625 */       this.openedgraphids.addAll(_o_.openedgraphids);
/* 626 */       this.effectserverlevel = _o_.effectserverlevel;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 632 */       _os_.compact_uint32(this.sessioninfos.size());
/* 633 */       for (Map.Entry<Integer, xbean.DaySessionInfo> _e_ : this.sessioninfos.entrySet())
/*     */       {
/* 635 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 636 */         ((xbean.DaySessionInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 638 */       _os_.compact_uint32(this.openedgraphids.size());
/* 639 */       for (Integer _v_ : this.openedgraphids)
/*     */       {
/* 641 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 643 */       _os_.marshal(this.effectserverlevel);
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
/* 654 */         this.sessioninfos = new HashMap(size * 2);
/*     */       }
/* 656 */       for (; size > 0; size--)
/*     */       {
/* 658 */         int _k_ = 0;
/* 659 */         _k_ = _os_.unmarshal_int();
/* 660 */         xbean.DaySessionInfo _v_ = xbean.Pod.newDaySessionInfoData();
/* 661 */         _v_.unmarshal(_os_);
/* 662 */         this.sessioninfos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 665 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 667 */         int _v_ = 0;
/* 668 */         _v_ = _os_.unmarshal_int();
/* 669 */         this.openedgraphids.add(Integer.valueOf(_v_));
/*     */       }
/* 671 */       this.effectserverlevel = _os_.unmarshal_int();
/* 672 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 678 */       int _size_ = 0;
/* 679 */       for (Map.Entry<Integer, xbean.DaySessionInfo> _e_ : this.sessioninfos.entrySet())
/*     */       {
/* 681 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 682 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 684 */       for (Integer _v_ : this.openedgraphids)
/*     */       {
/* 686 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */       }
/* 688 */       _size_ += CodedOutputStream.computeInt32Size(3, this.effectserverlevel);
/* 689 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 697 */         for (Map.Entry<Integer, xbean.DaySessionInfo> _e_ : this.sessioninfos.entrySet())
/*     */         {
/* 699 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 700 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 702 */         for (Integer _v_ : this.openedgraphids)
/*     */         {
/* 704 */           _output_.writeInt32(2, _v_.intValue());
/*     */         }
/* 706 */         _output_.writeInt32(3, this.effectserverlevel);
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
/* 733 */             int _k_ = 0;
/* 734 */             _k_ = _input_.readInt32();
/* 735 */             int readTag = _input_.readTag();
/* 736 */             if (10 != readTag)
/*     */             {
/* 738 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 740 */             xbean.DaySessionInfo _v_ = xbean.Pod.newDaySessionInfoData();
/* 741 */             _input_.readMessage(_v_);
/* 742 */             this.sessioninfos.put(Integer.valueOf(_k_), _v_);
/* 743 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 747 */             int _v_ = 0;
/* 748 */             _v_ = _input_.readInt32();
/* 749 */             this.openedgraphids.add(Integer.valueOf(_v_));
/* 750 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 754 */             this.effectserverlevel = _input_.readInt32();
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
/*     */     public xbean.GlobalSurpriseScheduleInfo copy()
/*     */     {
/* 782 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalSurpriseScheduleInfo toData()
/*     */     {
/* 788 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GlobalSurpriseScheduleInfo toBean()
/*     */     {
/* 793 */       return new GlobalSurpriseScheduleInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobalSurpriseScheduleInfo toDataIf()
/*     */     {
/* 799 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GlobalSurpriseScheduleInfo toBeanIf()
/*     */     {
/* 804 */       return new GlobalSurpriseScheduleInfo(this, null, null);
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
/*     */     public Map<Integer, xbean.DaySessionInfo> getSessioninfos()
/*     */     {
/* 841 */       return this.sessioninfos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.DaySessionInfo> getSessioninfosAsData()
/*     */     {
/* 848 */       return this.sessioninfos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getOpenedgraphids()
/*     */     {
/* 855 */       return this.openedgraphids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getOpenedgraphidsAsData()
/*     */     {
/* 862 */       return this.openedgraphids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getEffectserverlevel()
/*     */     {
/* 869 */       return this.effectserverlevel;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEffectserverlevel(int _v_)
/*     */     {
/* 876 */       this.effectserverlevel = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 882 */       if (!(_o1_ instanceof Data)) return false;
/* 883 */       Data _o_ = (Data)_o1_;
/* 884 */       if (!this.sessioninfos.equals(_o_.sessioninfos)) return false;
/* 885 */       if (!this.openedgraphids.equals(_o_.openedgraphids)) return false;
/* 886 */       if (this.effectserverlevel != _o_.effectserverlevel) return false;
/* 887 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 893 */       int _h_ = 0;
/* 894 */       _h_ += this.sessioninfos.hashCode();
/* 895 */       _h_ += this.openedgraphids.hashCode();
/* 896 */       _h_ += this.effectserverlevel;
/* 897 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 903 */       StringBuilder _sb_ = new StringBuilder();
/* 904 */       _sb_.append("(");
/* 905 */       _sb_.append(this.sessioninfos);
/* 906 */       _sb_.append(",");
/* 907 */       _sb_.append(this.openedgraphids);
/* 908 */       _sb_.append(",");
/* 909 */       _sb_.append(this.effectserverlevel);
/* 910 */       _sb_.append(")");
/* 911 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GlobalSurpriseScheduleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */