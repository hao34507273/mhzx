/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class RoamItemRecord extends XBean implements xbean.RoamItemRecord
/*     */ {
/*     */   private ArrayList<Integer> logreason;
/*     */   private int removemodel;
/*     */   private HashMap<Integer, Integer> itemmap;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.logreason.clear();
/*  23 */     this.removemodel = 0;
/*  24 */     this.itemmap.clear();
/*     */   }
/*     */   
/*     */   RoamItemRecord(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.logreason = new ArrayList();
/*  31 */     this.itemmap = new HashMap();
/*     */   }
/*     */   
/*     */   public RoamItemRecord()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoamItemRecord(RoamItemRecord _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoamItemRecord(xbean.RoamItemRecord _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof RoamItemRecord)) { assign((RoamItemRecord)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoamItemRecord _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.logreason = new ArrayList();
/*  57 */     this.logreason.addAll(_o_.logreason);
/*  58 */     this.removemodel = _o_.removemodel;
/*  59 */     this.itemmap = new HashMap();
/*  60 */     for (Map.Entry<Integer, Integer> _e_ : _o_.itemmap.entrySet()) {
/*  61 */       this.itemmap.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  66 */     this.logreason = new ArrayList();
/*  67 */     this.logreason.addAll(_o_.logreason);
/*  68 */     this.removemodel = _o_.removemodel;
/*  69 */     this.itemmap = new HashMap();
/*  70 */     for (Map.Entry<Integer, Integer> _e_ : _o_.itemmap.entrySet()) {
/*  71 */       this.itemmap.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  77 */     _xdb_verify_unsafe_();
/*  78 */     _os_.compact_uint32(this.logreason.size());
/*  79 */     for (Integer _v_ : this.logreason)
/*     */     {
/*  81 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  83 */     _os_.marshal(this.removemodel);
/*  84 */     _os_.compact_uint32(this.itemmap.size());
/*  85 */     for (Map.Entry<Integer, Integer> _e_ : this.itemmap.entrySet())
/*     */     {
/*  87 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  88 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  99 */       int _v_ = 0;
/* 100 */       _v_ = _os_.unmarshal_int();
/* 101 */       this.logreason.add(Integer.valueOf(_v_));
/*     */     }
/* 103 */     this.removemodel = _os_.unmarshal_int();
/*     */     
/* 105 */     int size = _os_.uncompact_uint32();
/* 106 */     if (size >= 12)
/*     */     {
/* 108 */       this.itemmap = new HashMap(size * 2);
/*     */     }
/* 110 */     for (; size > 0; size--)
/*     */     {
/* 112 */       int _k_ = 0;
/* 113 */       _k_ = _os_.unmarshal_int();
/* 114 */       int _v_ = 0;
/* 115 */       _v_ = _os_.unmarshal_int();
/* 116 */       this.itemmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 119 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 125 */     _xdb_verify_unsafe_();
/* 126 */     int _size_ = 0;
/* 127 */     for (Integer _v_ : this.logreason)
/*     */     {
/* 129 */       _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */     }
/* 131 */     _size_ += CodedOutputStream.computeInt32Size(2, this.removemodel);
/* 132 */     for (Map.Entry<Integer, Integer> _e_ : this.itemmap.entrySet())
/*     */     {
/* 134 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 135 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
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
/* 146 */       for (Integer _v_ : this.logreason)
/*     */       {
/* 148 */         _output_.writeInt32(1, _v_.intValue());
/*     */       }
/* 150 */       _output_.writeInt32(2, this.removemodel);
/* 151 */       for (Map.Entry<Integer, Integer> _e_ : this.itemmap.entrySet())
/*     */       {
/* 153 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 154 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
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
/* 183 */           int _v_ = 0;
/* 184 */           _v_ = _input_.readInt32();
/* 185 */           this.logreason.add(Integer.valueOf(_v_));
/* 186 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 190 */           this.removemodel = _input_.readInt32();
/* 191 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 195 */           int _k_ = 0;
/* 196 */           _k_ = _input_.readInt32();
/* 197 */           int readTag = _input_.readTag();
/* 198 */           if (24 != readTag)
/*     */           {
/* 200 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 202 */           int _v_ = 0;
/* 203 */           _v_ = _input_.readInt32();
/* 204 */           this.itemmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
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
/*     */   public xbean.RoamItemRecord copy()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new RoamItemRecord(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoamItemRecord toData()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoamItemRecord toBean()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return new RoamItemRecord(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoamItemRecord toDataIf()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoamItemRecord toBeanIf()
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
/*     */   public List<Integer> getLogreason()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     return xdb.Logs.logList(new xdb.LogKey(this, "logreason"), this.logreason);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getLogreasonAsData()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/*     */     
/* 282 */     RoamItemRecord _o_ = this;
/* 283 */     List<Integer> logreason = new ArrayList();
/* 284 */     logreason.addAll(_o_.logreason);
/* 285 */     return logreason;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRemovemodel()
/*     */   {
/* 292 */     _xdb_verify_unsafe_();
/* 293 */     return this.removemodel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getItemmap()
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     return xdb.Logs.logMap(new xdb.LogKey(this, "itemmap"), this.itemmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getItemmapAsData()
/*     */   {
/* 308 */     _xdb_verify_unsafe_();
/*     */     
/* 310 */     RoamItemRecord _o_ = this;
/* 311 */     Map<Integer, Integer> itemmap = new HashMap();
/* 312 */     for (Map.Entry<Integer, Integer> _e_ : _o_.itemmap.entrySet())
/* 313 */       itemmap.put(_e_.getKey(), _e_.getValue());
/* 314 */     return itemmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRemovemodel(int _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new xdb.LogKey(this, "removemodel")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 326 */         new xdb.logs.LogInt(this, RoamItemRecord.this.removemodel)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             RoamItemRecord.this.removemodel = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.removemodel = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     RoamItemRecord _o_ = null;
/* 343 */     if ((_o1_ instanceof RoamItemRecord)) { _o_ = (RoamItemRecord)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (!this.logreason.equals(_o_.logreason)) return false;
/* 347 */     if (this.removemodel != _o_.removemodel) return false;
/* 348 */     if (!this.itemmap.equals(_o_.itemmap)) return false;
/* 349 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 355 */     _xdb_verify_unsafe_();
/* 356 */     int _h_ = 0;
/* 357 */     _h_ += this.logreason.hashCode();
/* 358 */     _h_ += this.removemodel;
/* 359 */     _h_ += this.itemmap.hashCode();
/* 360 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 366 */     _xdb_verify_unsafe_();
/* 367 */     StringBuilder _sb_ = new StringBuilder();
/* 368 */     _sb_.append("(");
/* 369 */     _sb_.append(this.logreason);
/* 370 */     _sb_.append(",");
/* 371 */     _sb_.append(this.removemodel);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.itemmap);
/* 374 */     _sb_.append(")");
/* 375 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 381 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 382 */     lb.add(new xdb.logs.ListenableChanged().setVarName("logreason"));
/* 383 */     lb.add(new xdb.logs.ListenableChanged().setVarName("removemodel"));
/* 384 */     lb.add(new xdb.logs.ListenableMap().setVarName("itemmap"));
/* 385 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoamItemRecord {
/*     */     private Const() {}
/*     */     
/*     */     RoamItemRecord nThis() {
/* 392 */       return RoamItemRecord.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 398 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoamItemRecord copy()
/*     */     {
/* 404 */       return RoamItemRecord.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoamItemRecord toData()
/*     */     {
/* 410 */       return RoamItemRecord.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoamItemRecord toBean()
/*     */     {
/* 415 */       return RoamItemRecord.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoamItemRecord toDataIf()
/*     */     {
/* 421 */       return RoamItemRecord.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoamItemRecord toBeanIf()
/*     */     {
/* 426 */       return RoamItemRecord.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getLogreason()
/*     */     {
/* 433 */       RoamItemRecord.this._xdb_verify_unsafe_();
/* 434 */       return xdb.Consts.constList(RoamItemRecord.this.logreason);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Integer> getLogreasonAsData()
/*     */     {
/* 440 */       RoamItemRecord.this._xdb_verify_unsafe_();
/*     */       
/* 442 */       RoamItemRecord _o_ = RoamItemRecord.this;
/* 443 */       List<Integer> logreason = new ArrayList();
/* 444 */       logreason.addAll(_o_.logreason);
/* 445 */       return logreason;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRemovemodel()
/*     */     {
/* 452 */       RoamItemRecord.this._xdb_verify_unsafe_();
/* 453 */       return RoamItemRecord.this.removemodel;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getItemmap()
/*     */     {
/* 460 */       RoamItemRecord.this._xdb_verify_unsafe_();
/* 461 */       return xdb.Consts.constMap(RoamItemRecord.this.itemmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getItemmapAsData()
/*     */     {
/* 468 */       RoamItemRecord.this._xdb_verify_unsafe_();
/*     */       
/* 470 */       RoamItemRecord _o_ = RoamItemRecord.this;
/* 471 */       Map<Integer, Integer> itemmap = new HashMap();
/* 472 */       for (Map.Entry<Integer, Integer> _e_ : _o_.itemmap.entrySet())
/* 473 */         itemmap.put(_e_.getKey(), _e_.getValue());
/* 474 */       return itemmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRemovemodel(int _v_)
/*     */     {
/* 481 */       RoamItemRecord.this._xdb_verify_unsafe_();
/* 482 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 488 */       RoamItemRecord.this._xdb_verify_unsafe_();
/* 489 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 495 */       RoamItemRecord.this._xdb_verify_unsafe_();
/* 496 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 502 */       return RoamItemRecord.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 508 */       return RoamItemRecord.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 514 */       RoamItemRecord.this._xdb_verify_unsafe_();
/* 515 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 521 */       return RoamItemRecord.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 527 */       return RoamItemRecord.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 533 */       RoamItemRecord.this._xdb_verify_unsafe_();
/* 534 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 540 */       return RoamItemRecord.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 546 */       return RoamItemRecord.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 552 */       return RoamItemRecord.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 558 */       return RoamItemRecord.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 564 */       return RoamItemRecord.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 570 */       return RoamItemRecord.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 576 */       return RoamItemRecord.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoamItemRecord
/*     */   {
/*     */     private ArrayList<Integer> logreason;
/*     */     
/*     */     private int removemodel;
/*     */     
/*     */     private HashMap<Integer, Integer> itemmap;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 592 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 597 */       this.logreason = new ArrayList();
/* 598 */       this.itemmap = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.RoamItemRecord _o1_)
/*     */     {
/* 603 */       if ((_o1_ instanceof RoamItemRecord)) { assign((RoamItemRecord)_o1_);
/* 604 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 605 */       } else if ((_o1_ instanceof RoamItemRecord.Const)) assign(((RoamItemRecord.Const)_o1_).nThis()); else {
/* 606 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoamItemRecord _o_) {
/* 611 */       this.logreason = new ArrayList();
/* 612 */       this.logreason.addAll(_o_.logreason);
/* 613 */       this.removemodel = _o_.removemodel;
/* 614 */       this.itemmap = new HashMap();
/* 615 */       for (Map.Entry<Integer, Integer> _e_ : _o_.itemmap.entrySet()) {
/* 616 */         this.itemmap.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 621 */       this.logreason = new ArrayList();
/* 622 */       this.logreason.addAll(_o_.logreason);
/* 623 */       this.removemodel = _o_.removemodel;
/* 624 */       this.itemmap = new HashMap();
/* 625 */       for (Map.Entry<Integer, Integer> _e_ : _o_.itemmap.entrySet()) {
/* 626 */         this.itemmap.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 632 */       _os_.compact_uint32(this.logreason.size());
/* 633 */       for (Integer _v_ : this.logreason)
/*     */       {
/* 635 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 637 */       _os_.marshal(this.removemodel);
/* 638 */       _os_.compact_uint32(this.itemmap.size());
/* 639 */       for (Map.Entry<Integer, Integer> _e_ : this.itemmap.entrySet())
/*     */       {
/* 641 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 642 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 644 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 650 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 652 */         int _v_ = 0;
/* 653 */         _v_ = _os_.unmarshal_int();
/* 654 */         this.logreason.add(Integer.valueOf(_v_));
/*     */       }
/* 656 */       this.removemodel = _os_.unmarshal_int();
/*     */       
/* 658 */       int size = _os_.uncompact_uint32();
/* 659 */       if (size >= 12)
/*     */       {
/* 661 */         this.itemmap = new HashMap(size * 2);
/*     */       }
/* 663 */       for (; size > 0; size--)
/*     */       {
/* 665 */         int _k_ = 0;
/* 666 */         _k_ = _os_.unmarshal_int();
/* 667 */         int _v_ = 0;
/* 668 */         _v_ = _os_.unmarshal_int();
/* 669 */         this.itemmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 672 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 678 */       int _size_ = 0;
/* 679 */       for (Integer _v_ : this.logreason)
/*     */       {
/* 681 */         _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */       }
/* 683 */       _size_ += CodedOutputStream.computeInt32Size(2, this.removemodel);
/* 684 */       for (Map.Entry<Integer, Integer> _e_ : this.itemmap.entrySet())
/*     */       {
/* 686 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 687 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 689 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 697 */         for (Integer _v_ : this.logreason)
/*     */         {
/* 699 */           _output_.writeInt32(1, _v_.intValue());
/*     */         }
/* 701 */         _output_.writeInt32(2, this.removemodel);
/* 702 */         for (Map.Entry<Integer, Integer> _e_ : this.itemmap.entrySet())
/*     */         {
/* 704 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 705 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
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
/* 733 */             int _v_ = 0;
/* 734 */             _v_ = _input_.readInt32();
/* 735 */             this.logreason.add(Integer.valueOf(_v_));
/* 736 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 740 */             this.removemodel = _input_.readInt32();
/* 741 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 745 */             int _k_ = 0;
/* 746 */             _k_ = _input_.readInt32();
/* 747 */             int readTag = _input_.readTag();
/* 748 */             if (24 != readTag)
/*     */             {
/* 750 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 752 */             int _v_ = 0;
/* 753 */             _v_ = _input_.readInt32();
/* 754 */             this.itemmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
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
/*     */     public xbean.RoamItemRecord copy()
/*     */     {
/* 782 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoamItemRecord toData()
/*     */     {
/* 788 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoamItemRecord toBean()
/*     */     {
/* 793 */       return new RoamItemRecord(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoamItemRecord toDataIf()
/*     */     {
/* 799 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoamItemRecord toBeanIf()
/*     */     {
/* 804 */       return new RoamItemRecord(this, null, null);
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
/*     */     public List<Integer> getLogreason()
/*     */     {
/* 841 */       return this.logreason;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getLogreasonAsData()
/*     */     {
/* 848 */       return this.logreason;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRemovemodel()
/*     */     {
/* 855 */       return this.removemodel;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getItemmap()
/*     */     {
/* 862 */       return this.itemmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getItemmapAsData()
/*     */     {
/* 869 */       return this.itemmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRemovemodel(int _v_)
/*     */     {
/* 876 */       this.removemodel = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 882 */       if (!(_o1_ instanceof Data)) return false;
/* 883 */       Data _o_ = (Data)_o1_;
/* 884 */       if (!this.logreason.equals(_o_.logreason)) return false;
/* 885 */       if (this.removemodel != _o_.removemodel) return false;
/* 886 */       if (!this.itemmap.equals(_o_.itemmap)) return false;
/* 887 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 893 */       int _h_ = 0;
/* 894 */       _h_ += this.logreason.hashCode();
/* 895 */       _h_ += this.removemodel;
/* 896 */       _h_ += this.itemmap.hashCode();
/* 897 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 903 */       StringBuilder _sb_ = new StringBuilder();
/* 904 */       _sb_.append("(");
/* 905 */       _sb_.append(this.logreason);
/* 906 */       _sb_.append(",");
/* 907 */       _sb_.append(this.removemodel);
/* 908 */       _sb_.append(",");
/* 909 */       _sb_.append(this.itemmap);
/* 910 */       _sb_.append(")");
/* 911 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoamItemRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */