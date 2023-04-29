/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class WAwardBean extends XBean implements xbean.WAwardBean
/*     */ {
/*     */   private long roleid;
/*     */   private HashMap<Integer, Integer> nbitems;
/*     */   private HashMap<Integer, Integer> nmitems;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.roleid = 0L;
/*  23 */     this.nbitems.clear();
/*  24 */     this.nmitems.clear();
/*     */   }
/*     */   
/*     */   WAwardBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.nbitems = new HashMap();
/*  31 */     this.nmitems = new HashMap();
/*     */   }
/*     */   
/*     */   public WAwardBean()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public WAwardBean(WAwardBean _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   WAwardBean(xbean.WAwardBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof WAwardBean)) { assign((WAwardBean)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(WAwardBean _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.roleid = _o_.roleid;
/*  57 */     this.nbitems = new HashMap();
/*  58 */     for (Map.Entry<Integer, Integer> _e_ : _o_.nbitems.entrySet())
/*  59 */       this.nbitems.put(_e_.getKey(), _e_.getValue());
/*  60 */     this.nmitems = new HashMap();
/*  61 */     for (Map.Entry<Integer, Integer> _e_ : _o_.nmitems.entrySet()) {
/*  62 */       this.nmitems.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  67 */     this.roleid = _o_.roleid;
/*  68 */     this.nbitems = new HashMap();
/*  69 */     for (Map.Entry<Integer, Integer> _e_ : _o_.nbitems.entrySet())
/*  70 */       this.nbitems.put(_e_.getKey(), _e_.getValue());
/*  71 */     this.nmitems = new HashMap();
/*  72 */     for (Map.Entry<Integer, Integer> _e_ : _o_.nmitems.entrySet()) {
/*  73 */       this.nmitems.put(_e_.getKey(), _e_.getValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.marshal(this.roleid);
/*  81 */     _os_.compact_uint32(this.nbitems.size());
/*  82 */     for (Map.Entry<Integer, Integer> _e_ : this.nbitems.entrySet())
/*     */     {
/*  84 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  85 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  87 */     _os_.compact_uint32(this.nmitems.size());
/*  88 */     for (Map.Entry<Integer, Integer> _e_ : this.nmitems.entrySet())
/*     */     {
/*  90 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  91 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/* 100 */     this.roleid = _os_.unmarshal_long();
/*     */     
/* 102 */     int size = _os_.uncompact_uint32();
/* 103 */     if (size >= 12)
/*     */     {
/* 105 */       this.nbitems = new HashMap(size * 2);
/*     */     }
/* 107 */     for (; size > 0; size--)
/*     */     {
/* 109 */       int _k_ = 0;
/* 110 */       _k_ = _os_.unmarshal_int();
/* 111 */       int _v_ = 0;
/* 112 */       _v_ = _os_.unmarshal_int();
/* 113 */       this.nbitems.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/*     */ 
/* 117 */     int size = _os_.uncompact_uint32();
/* 118 */     if (size >= 12)
/*     */     {
/* 120 */       this.nmitems = new HashMap(size * 2);
/*     */     }
/* 122 */     for (; size > 0; size--)
/*     */     {
/* 124 */       int _k_ = 0;
/* 125 */       _k_ = _os_.unmarshal_int();
/* 126 */       int _v_ = 0;
/* 127 */       _v_ = _os_.unmarshal_int();
/* 128 */       this.nmitems.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*     */     
/* 131 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/* 138 */     int _size_ = 0;
/* 139 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/* 140 */     for (Map.Entry<Integer, Integer> _e_ : this.nbitems.entrySet())
/*     */     {
/* 142 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 143 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 145 */     for (Map.Entry<Integer, Integer> _e_ : this.nmitems.entrySet())
/*     */     {
/* 147 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 148 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*     */     }
/* 150 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 156 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 159 */       _output_.writeInt64(1, this.roleid);
/* 160 */       for (Map.Entry<Integer, Integer> _e_ : this.nbitems.entrySet())
/*     */       {
/* 162 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 163 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 165 */       for (Map.Entry<Integer, Integer> _e_ : this.nmitems.entrySet())
/*     */       {
/* 167 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 168 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 173 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 175 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 184 */       boolean done = false;
/* 185 */       while (!done)
/*     */       {
/* 187 */         int tag = _input_.readTag();
/* 188 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 192 */           done = true;
/* 193 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 197 */           this.roleid = _input_.readInt64();
/* 198 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 202 */           int _k_ = 0;
/* 203 */           _k_ = _input_.readInt32();
/* 204 */           int readTag = _input_.readTag();
/* 205 */           if (16 != readTag)
/*     */           {
/* 207 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 209 */           int _v_ = 0;
/* 210 */           _v_ = _input_.readInt32();
/* 211 */           this.nbitems.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 212 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 216 */           int _k_ = 0;
/* 217 */           _k_ = _input_.readInt32();
/* 218 */           int readTag = _input_.readTag();
/* 219 */           if (24 != readTag)
/*     */           {
/* 221 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 223 */           int _v_ = 0;
/* 224 */           _v_ = _input_.readInt32();
/* 225 */           this.nmitems.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 226 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 230 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 232 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 241 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 245 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 247 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.WAwardBean copy()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return new WAwardBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.WAwardBean toData()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.WAwardBean toBean()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     return new WAwardBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.WAwardBean toDataIf()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.WAwardBean toBeanIf()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 286 */     _xdb_verify_unsafe_();
/* 287 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRoleid()
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/* 295 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getNbitems()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     return xdb.Logs.logMap(new LogKey(this, "nbitems"), this.nbitems);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getNbitemsAsData()
/*     */   {
/* 310 */     _xdb_verify_unsafe_();
/*     */     
/* 312 */     WAwardBean _o_ = this;
/* 313 */     Map<Integer, Integer> nbitems = new HashMap();
/* 314 */     for (Map.Entry<Integer, Integer> _e_ : _o_.nbitems.entrySet())
/* 315 */       nbitems.put(_e_.getKey(), _e_.getValue());
/* 316 */     return nbitems;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getNmitems()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     return xdb.Logs.logMap(new LogKey(this, "nmitems"), this.nmitems);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, Integer> getNmitemsAsData()
/*     */   {
/* 331 */     _xdb_verify_unsafe_();
/*     */     
/* 333 */     WAwardBean _o_ = this;
/* 334 */     Map<Integer, Integer> nmitems = new HashMap();
/* 335 */     for (Map.Entry<Integer, Integer> _e_ : _o_.nmitems.entrySet())
/* 336 */       nmitems.put(_e_.getKey(), _e_.getValue());
/* 337 */     return nmitems;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoleid(long _v_)
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     xdb.Logs.logIf(new LogKey(this, "roleid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 349 */         new xdb.logs.LogLong(this, WAwardBean.this.roleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 353 */             WAwardBean.this.roleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 357 */     });
/* 358 */     this.roleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 364 */     _xdb_verify_unsafe_();
/* 365 */     WAwardBean _o_ = null;
/* 366 */     if ((_o1_ instanceof WAwardBean)) { _o_ = (WAwardBean)_o1_;
/* 367 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 368 */       return false;
/* 369 */     if (this.roleid != _o_.roleid) return false;
/* 370 */     if (!this.nbitems.equals(_o_.nbitems)) return false;
/* 371 */     if (!this.nmitems.equals(_o_.nmitems)) return false;
/* 372 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 378 */     _xdb_verify_unsafe_();
/* 379 */     int _h_ = 0;
/* 380 */     _h_ = (int)(_h_ + this.roleid);
/* 381 */     _h_ += this.nbitems.hashCode();
/* 382 */     _h_ += this.nmitems.hashCode();
/* 383 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     StringBuilder _sb_ = new StringBuilder();
/* 391 */     _sb_.append("(");
/* 392 */     _sb_.append(this.roleid);
/* 393 */     _sb_.append(",");
/* 394 */     _sb_.append(this.nbitems);
/* 395 */     _sb_.append(",");
/* 396 */     _sb_.append(this.nmitems);
/* 397 */     _sb_.append(")");
/* 398 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 404 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 405 */     lb.add(new xdb.logs.ListenableChanged().setVarName("roleid"));
/* 406 */     lb.add(new xdb.logs.ListenableMap().setVarName("nbitems"));
/* 407 */     lb.add(new xdb.logs.ListenableMap().setVarName("nmitems"));
/* 408 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.WAwardBean {
/*     */     private Const() {}
/*     */     
/*     */     WAwardBean nThis() {
/* 415 */       return WAwardBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 421 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WAwardBean copy()
/*     */     {
/* 427 */       return WAwardBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WAwardBean toData()
/*     */     {
/* 433 */       return WAwardBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.WAwardBean toBean()
/*     */     {
/* 438 */       return WAwardBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WAwardBean toDataIf()
/*     */     {
/* 444 */       return WAwardBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.WAwardBean toBeanIf()
/*     */     {
/* 449 */       return WAwardBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 456 */       WAwardBean.this._xdb_verify_unsafe_();
/* 457 */       return WAwardBean.this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getNbitems()
/*     */     {
/* 464 */       WAwardBean.this._xdb_verify_unsafe_();
/* 465 */       return xdb.Consts.constMap(WAwardBean.this.nbitems);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getNbitemsAsData()
/*     */     {
/* 472 */       WAwardBean.this._xdb_verify_unsafe_();
/*     */       
/* 474 */       WAwardBean _o_ = WAwardBean.this;
/* 475 */       Map<Integer, Integer> nbitems = new HashMap();
/* 476 */       for (Map.Entry<Integer, Integer> _e_ : _o_.nbitems.entrySet())
/* 477 */         nbitems.put(_e_.getKey(), _e_.getValue());
/* 478 */       return nbitems;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getNmitems()
/*     */     {
/* 485 */       WAwardBean.this._xdb_verify_unsafe_();
/* 486 */       return xdb.Consts.constMap(WAwardBean.this.nmitems);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getNmitemsAsData()
/*     */     {
/* 493 */       WAwardBean.this._xdb_verify_unsafe_();
/*     */       
/* 495 */       WAwardBean _o_ = WAwardBean.this;
/* 496 */       Map<Integer, Integer> nmitems = new HashMap();
/* 497 */       for (Map.Entry<Integer, Integer> _e_ : _o_.nmitems.entrySet())
/* 498 */         nmitems.put(_e_.getKey(), _e_.getValue());
/* 499 */       return nmitems;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 506 */       WAwardBean.this._xdb_verify_unsafe_();
/* 507 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 513 */       WAwardBean.this._xdb_verify_unsafe_();
/* 514 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 520 */       WAwardBean.this._xdb_verify_unsafe_();
/* 521 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 527 */       return WAwardBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 533 */       return WAwardBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 539 */       WAwardBean.this._xdb_verify_unsafe_();
/* 540 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 546 */       return WAwardBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 552 */       return WAwardBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 558 */       WAwardBean.this._xdb_verify_unsafe_();
/* 559 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 565 */       return WAwardBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 571 */       return WAwardBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 577 */       return WAwardBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 583 */       return WAwardBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 589 */       return WAwardBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 595 */       return WAwardBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 601 */       return WAwardBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.WAwardBean
/*     */   {
/*     */     private long roleid;
/*     */     
/*     */     private HashMap<Integer, Integer> nbitems;
/*     */     
/*     */     private HashMap<Integer, Integer> nmitems;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 617 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 622 */       this.nbitems = new HashMap();
/* 623 */       this.nmitems = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.WAwardBean _o1_)
/*     */     {
/* 628 */       if ((_o1_ instanceof WAwardBean)) { assign((WAwardBean)_o1_);
/* 629 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 630 */       } else if ((_o1_ instanceof WAwardBean.Const)) assign(((WAwardBean.Const)_o1_).nThis()); else {
/* 631 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(WAwardBean _o_) {
/* 636 */       this.roleid = _o_.roleid;
/* 637 */       this.nbitems = new HashMap();
/* 638 */       for (Map.Entry<Integer, Integer> _e_ : _o_.nbitems.entrySet())
/* 639 */         this.nbitems.put(_e_.getKey(), _e_.getValue());
/* 640 */       this.nmitems = new HashMap();
/* 641 */       for (Map.Entry<Integer, Integer> _e_ : _o_.nmitems.entrySet()) {
/* 642 */         this.nmitems.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 647 */       this.roleid = _o_.roleid;
/* 648 */       this.nbitems = new HashMap();
/* 649 */       for (Map.Entry<Integer, Integer> _e_ : _o_.nbitems.entrySet())
/* 650 */         this.nbitems.put(_e_.getKey(), _e_.getValue());
/* 651 */       this.nmitems = new HashMap();
/* 652 */       for (Map.Entry<Integer, Integer> _e_ : _o_.nmitems.entrySet()) {
/* 653 */         this.nmitems.put(_e_.getKey(), _e_.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 659 */       _os_.marshal(this.roleid);
/* 660 */       _os_.compact_uint32(this.nbitems.size());
/* 661 */       for (Map.Entry<Integer, Integer> _e_ : this.nbitems.entrySet())
/*     */       {
/* 663 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 664 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 666 */       _os_.compact_uint32(this.nmitems.size());
/* 667 */       for (Map.Entry<Integer, Integer> _e_ : this.nmitems.entrySet())
/*     */       {
/* 669 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 670 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */       }
/* 672 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 678 */       this.roleid = _os_.unmarshal_long();
/*     */       
/* 680 */       int size = _os_.uncompact_uint32();
/* 681 */       if (size >= 12)
/*     */       {
/* 683 */         this.nbitems = new HashMap(size * 2);
/*     */       }
/* 685 */       for (; size > 0; size--)
/*     */       {
/* 687 */         int _k_ = 0;
/* 688 */         _k_ = _os_.unmarshal_int();
/* 689 */         int _v_ = 0;
/* 690 */         _v_ = _os_.unmarshal_int();
/* 691 */         this.nbitems.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/*     */ 
/* 695 */       int size = _os_.uncompact_uint32();
/* 696 */       if (size >= 12)
/*     */       {
/* 698 */         this.nmitems = new HashMap(size * 2);
/*     */       }
/* 700 */       for (; size > 0; size--)
/*     */       {
/* 702 */         int _k_ = 0;
/* 703 */         _k_ = _os_.unmarshal_int();
/* 704 */         int _v_ = 0;
/* 705 */         _v_ = _os_.unmarshal_int();
/* 706 */         this.nmitems.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */       }
/*     */       
/* 709 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 715 */       int _size_ = 0;
/* 716 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/* 717 */       for (Map.Entry<Integer, Integer> _e_ : this.nbitems.entrySet())
/*     */       {
/* 719 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 720 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 722 */       for (Map.Entry<Integer, Integer> _e_ : this.nmitems.entrySet())
/*     */       {
/* 724 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 725 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*     */       }
/* 727 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 735 */         _output_.writeInt64(1, this.roleid);
/* 736 */         for (Map.Entry<Integer, Integer> _e_ : this.nbitems.entrySet())
/*     */         {
/* 738 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 739 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*     */         }
/* 741 */         for (Map.Entry<Integer, Integer> _e_ : this.nmitems.entrySet())
/*     */         {
/* 743 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 744 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 749 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 751 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 759 */         boolean done = false;
/* 760 */         while (!done)
/*     */         {
/* 762 */           int tag = _input_.readTag();
/* 763 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 767 */             done = true;
/* 768 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 772 */             this.roleid = _input_.readInt64();
/* 773 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 777 */             int _k_ = 0;
/* 778 */             _k_ = _input_.readInt32();
/* 779 */             int readTag = _input_.readTag();
/* 780 */             if (16 != readTag)
/*     */             {
/* 782 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 784 */             int _v_ = 0;
/* 785 */             _v_ = _input_.readInt32();
/* 786 */             this.nbitems.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 791 */             int _k_ = 0;
/* 792 */             _k_ = _input_.readInt32();
/* 793 */             int readTag = _input_.readTag();
/* 794 */             if (24 != readTag)
/*     */             {
/* 796 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 798 */             int _v_ = 0;
/* 799 */             _v_ = _input_.readInt32();
/* 800 */             this.nmitems.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 801 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 805 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 807 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 816 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 820 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 822 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WAwardBean copy()
/*     */     {
/* 828 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WAwardBean toData()
/*     */     {
/* 834 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.WAwardBean toBean()
/*     */     {
/* 839 */       return new WAwardBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WAwardBean toDataIf()
/*     */     {
/* 845 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.WAwardBean toBeanIf()
/*     */     {
/* 850 */       return new WAwardBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 856 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 860 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 864 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 868 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 872 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 876 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 880 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 887 */       return this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getNbitems()
/*     */     {
/* 894 */       return this.nbitems;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getNbitemsAsData()
/*     */     {
/* 901 */       return this.nbitems;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getNmitems()
/*     */     {
/* 908 */       return this.nmitems;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, Integer> getNmitemsAsData()
/*     */     {
/* 915 */       return this.nmitems;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 922 */       this.roleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 928 */       if (!(_o1_ instanceof Data)) return false;
/* 929 */       Data _o_ = (Data)_o1_;
/* 930 */       if (this.roleid != _o_.roleid) return false;
/* 931 */       if (!this.nbitems.equals(_o_.nbitems)) return false;
/* 932 */       if (!this.nmitems.equals(_o_.nmitems)) return false;
/* 933 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 939 */       int _h_ = 0;
/* 940 */       _h_ = (int)(_h_ + this.roleid);
/* 941 */       _h_ += this.nbitems.hashCode();
/* 942 */       _h_ += this.nmitems.hashCode();
/* 943 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 949 */       StringBuilder _sb_ = new StringBuilder();
/* 950 */       _sb_.append("(");
/* 951 */       _sb_.append(this.roleid);
/* 952 */       _sb_.append(",");
/* 953 */       _sb_.append(this.nbitems);
/* 954 */       _sb_.append(",");
/* 955 */       _sb_.append(this.nmitems);
/* 956 */       _sb_.append(")");
/* 957 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\WAwardBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */