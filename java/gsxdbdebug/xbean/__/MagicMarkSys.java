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
/*     */ public final class MagicMarkSys extends XBean implements xbean.MagicMarkSys
/*     */ {
/*     */   private int euqipedmagicmarktype;
/*     */   private int propmagicmarktype;
/*     */   private HashMap<Integer, xbean.MagicMarkInfo> magicmarkinfos;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.euqipedmagicmarktype = 0;
/*  23 */     this.propmagicmarktype = 0;
/*  24 */     this.magicmarkinfos.clear();
/*     */   }
/*     */   
/*     */   MagicMarkSys(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.euqipedmagicmarktype = 0;
/*  31 */     this.propmagicmarktype = 0;
/*  32 */     this.magicmarkinfos = new HashMap();
/*     */   }
/*     */   
/*     */   public MagicMarkSys()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MagicMarkSys(MagicMarkSys _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MagicMarkSys(xbean.MagicMarkSys _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof MagicMarkSys)) { assign((MagicMarkSys)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MagicMarkSys _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.euqipedmagicmarktype = _o_.euqipedmagicmarktype;
/*  58 */     this.propmagicmarktype = _o_.propmagicmarktype;
/*  59 */     this.magicmarkinfos = new HashMap();
/*  60 */     for (Map.Entry<Integer, xbean.MagicMarkInfo> _e_ : _o_.magicmarkinfos.entrySet()) {
/*  61 */       this.magicmarkinfos.put(_e_.getKey(), new MagicMarkInfo((xbean.MagicMarkInfo)_e_.getValue(), this, "magicmarkinfos"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  66 */     this.euqipedmagicmarktype = _o_.euqipedmagicmarktype;
/*  67 */     this.propmagicmarktype = _o_.propmagicmarktype;
/*  68 */     this.magicmarkinfos = new HashMap();
/*  69 */     for (Map.Entry<Integer, xbean.MagicMarkInfo> _e_ : _o_.magicmarkinfos.entrySet()) {
/*  70 */       this.magicmarkinfos.put(_e_.getKey(), new MagicMarkInfo((xbean.MagicMarkInfo)_e_.getValue(), this, "magicmarkinfos"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     _os_.marshal(this.euqipedmagicmarktype);
/*  78 */     _os_.marshal(this.propmagicmarktype);
/*  79 */     _os_.compact_uint32(this.magicmarkinfos.size());
/*  80 */     for (Map.Entry<Integer, xbean.MagicMarkInfo> _e_ : this.magicmarkinfos.entrySet())
/*     */     {
/*  82 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  83 */       ((xbean.MagicMarkInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     this.euqipedmagicmarktype = _os_.unmarshal_int();
/*  93 */     this.propmagicmarktype = _os_.unmarshal_int();
/*     */     
/*  95 */     int size = _os_.uncompact_uint32();
/*  96 */     if (size >= 12)
/*     */     {
/*  98 */       this.magicmarkinfos = new HashMap(size * 2);
/*     */     }
/* 100 */     for (; size > 0; size--)
/*     */     {
/* 102 */       int _k_ = 0;
/* 103 */       _k_ = _os_.unmarshal_int();
/* 104 */       xbean.MagicMarkInfo _v_ = new MagicMarkInfo(0, this, "magicmarkinfos");
/* 105 */       _v_.unmarshal(_os_);
/* 106 */       this.magicmarkinfos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 109 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 115 */     _xdb_verify_unsafe_();
/* 116 */     int _size_ = 0;
/* 117 */     _size_ += CodedOutputStream.computeInt32Size(1, this.euqipedmagicmarktype);
/* 118 */     _size_ += CodedOutputStream.computeInt32Size(2, this.propmagicmarktype);
/* 119 */     for (Map.Entry<Integer, xbean.MagicMarkInfo> _e_ : this.magicmarkinfos.entrySet())
/*     */     {
/* 121 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 122 */       _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */     }
/* 124 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 130 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 133 */       _output_.writeInt32(1, this.euqipedmagicmarktype);
/* 134 */       _output_.writeInt32(2, this.propmagicmarktype);
/* 135 */       for (Map.Entry<Integer, xbean.MagicMarkInfo> _e_ : this.magicmarkinfos.entrySet())
/*     */       {
/* 137 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 138 */         _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 143 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 145 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 151 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 154 */       boolean done = false;
/* 155 */       while (!done)
/*     */       {
/* 157 */         int tag = _input_.readTag();
/* 158 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 162 */           done = true;
/* 163 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 167 */           this.euqipedmagicmarktype = _input_.readInt32();
/* 168 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 172 */           this.propmagicmarktype = _input_.readInt32();
/* 173 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 177 */           int _k_ = 0;
/* 178 */           _k_ = _input_.readInt32();
/* 179 */           int readTag = _input_.readTag();
/* 180 */           if (26 != readTag)
/*     */           {
/* 182 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 184 */           xbean.MagicMarkInfo _v_ = new MagicMarkInfo(0, this, "magicmarkinfos");
/* 185 */           _input_.readMessage(_v_);
/* 186 */           this.magicmarkinfos.put(Integer.valueOf(_k_), _v_);
/* 187 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 191 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 193 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 202 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 206 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 208 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MagicMarkSys copy()
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     return new MagicMarkSys(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MagicMarkSys toData()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MagicMarkSys toBean()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return new MagicMarkSys(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MagicMarkSys toDataIf()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MagicMarkSys toBeanIf()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/* 248 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getEuqipedmagicmarktype()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     return this.euqipedmagicmarktype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPropmagicmarktype()
/*     */   {
/* 263 */     _xdb_verify_unsafe_();
/* 264 */     return this.propmagicmarktype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.MagicMarkInfo> getMagicmarkinfos()
/*     */   {
/* 271 */     _xdb_verify_unsafe_();
/* 272 */     return xdb.Logs.logMap(new LogKey(this, "magicmarkinfos"), this.magicmarkinfos);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.MagicMarkInfo> getMagicmarkinfosAsData()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/*     */     
/* 281 */     MagicMarkSys _o_ = this;
/* 282 */     Map<Integer, xbean.MagicMarkInfo> magicmarkinfos = new HashMap();
/* 283 */     for (Map.Entry<Integer, xbean.MagicMarkInfo> _e_ : _o_.magicmarkinfos.entrySet())
/* 284 */       magicmarkinfos.put(_e_.getKey(), new MagicMarkInfo.Data((xbean.MagicMarkInfo)_e_.getValue()));
/* 285 */     return magicmarkinfos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEuqipedmagicmarktype(int _v_)
/*     */   {
/* 292 */     _xdb_verify_unsafe_();
/* 293 */     xdb.Logs.logIf(new LogKey(this, "euqipedmagicmarktype")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 297 */         new xdb.logs.LogInt(this, MagicMarkSys.this.euqipedmagicmarktype)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 301 */             MagicMarkSys.this.euqipedmagicmarktype = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 305 */     });
/* 306 */     this.euqipedmagicmarktype = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPropmagicmarktype(int _v_)
/*     */   {
/* 313 */     _xdb_verify_unsafe_();
/* 314 */     xdb.Logs.logIf(new LogKey(this, "propmagicmarktype")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 318 */         new xdb.logs.LogInt(this, MagicMarkSys.this.propmagicmarktype)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 322 */             MagicMarkSys.this.propmagicmarktype = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 326 */     });
/* 327 */     this.propmagicmarktype = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     MagicMarkSys _o_ = null;
/* 335 */     if ((_o1_ instanceof MagicMarkSys)) { _o_ = (MagicMarkSys)_o1_;
/* 336 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 337 */       return false;
/* 338 */     if (this.euqipedmagicmarktype != _o_.euqipedmagicmarktype) return false;
/* 339 */     if (this.propmagicmarktype != _o_.propmagicmarktype) return false;
/* 340 */     if (!this.magicmarkinfos.equals(_o_.magicmarkinfos)) return false;
/* 341 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 347 */     _xdb_verify_unsafe_();
/* 348 */     int _h_ = 0;
/* 349 */     _h_ += this.euqipedmagicmarktype;
/* 350 */     _h_ += this.propmagicmarktype;
/* 351 */     _h_ += this.magicmarkinfos.hashCode();
/* 352 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 358 */     _xdb_verify_unsafe_();
/* 359 */     StringBuilder _sb_ = new StringBuilder();
/* 360 */     _sb_.append("(");
/* 361 */     _sb_.append(this.euqipedmagicmarktype);
/* 362 */     _sb_.append(",");
/* 363 */     _sb_.append(this.propmagicmarktype);
/* 364 */     _sb_.append(",");
/* 365 */     _sb_.append(this.magicmarkinfos);
/* 366 */     _sb_.append(")");
/* 367 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 373 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 374 */     lb.add(new xdb.logs.ListenableChanged().setVarName("euqipedmagicmarktype"));
/* 375 */     lb.add(new xdb.logs.ListenableChanged().setVarName("propmagicmarktype"));
/* 376 */     lb.add(new xdb.logs.ListenableMap().setVarName("magicmarkinfos"));
/* 377 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MagicMarkSys {
/*     */     private Const() {}
/*     */     
/*     */     MagicMarkSys nThis() {
/* 384 */       return MagicMarkSys.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 390 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MagicMarkSys copy()
/*     */     {
/* 396 */       return MagicMarkSys.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MagicMarkSys toData()
/*     */     {
/* 402 */       return MagicMarkSys.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MagicMarkSys toBean()
/*     */     {
/* 407 */       return MagicMarkSys.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MagicMarkSys toDataIf()
/*     */     {
/* 413 */       return MagicMarkSys.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MagicMarkSys toBeanIf()
/*     */     {
/* 418 */       return MagicMarkSys.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getEuqipedmagicmarktype()
/*     */     {
/* 425 */       MagicMarkSys.this._xdb_verify_unsafe_();
/* 426 */       return MagicMarkSys.this.euqipedmagicmarktype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPropmagicmarktype()
/*     */     {
/* 433 */       MagicMarkSys.this._xdb_verify_unsafe_();
/* 434 */       return MagicMarkSys.this.propmagicmarktype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.MagicMarkInfo> getMagicmarkinfos()
/*     */     {
/* 441 */       MagicMarkSys.this._xdb_verify_unsafe_();
/* 442 */       return xdb.Consts.constMap(MagicMarkSys.this.magicmarkinfos);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.MagicMarkInfo> getMagicmarkinfosAsData()
/*     */     {
/* 449 */       MagicMarkSys.this._xdb_verify_unsafe_();
/*     */       
/* 451 */       MagicMarkSys _o_ = MagicMarkSys.this;
/* 452 */       Map<Integer, xbean.MagicMarkInfo> magicmarkinfos = new HashMap();
/* 453 */       for (Map.Entry<Integer, xbean.MagicMarkInfo> _e_ : _o_.magicmarkinfos.entrySet())
/* 454 */         magicmarkinfos.put(_e_.getKey(), new MagicMarkInfo.Data((xbean.MagicMarkInfo)_e_.getValue()));
/* 455 */       return magicmarkinfos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEuqipedmagicmarktype(int _v_)
/*     */     {
/* 462 */       MagicMarkSys.this._xdb_verify_unsafe_();
/* 463 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPropmagicmarktype(int _v_)
/*     */     {
/* 470 */       MagicMarkSys.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 477 */       MagicMarkSys.this._xdb_verify_unsafe_();
/* 478 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 484 */       MagicMarkSys.this._xdb_verify_unsafe_();
/* 485 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 491 */       return MagicMarkSys.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 497 */       return MagicMarkSys.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 503 */       MagicMarkSys.this._xdb_verify_unsafe_();
/* 504 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 510 */       return MagicMarkSys.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 516 */       return MagicMarkSys.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 522 */       MagicMarkSys.this._xdb_verify_unsafe_();
/* 523 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 529 */       return MagicMarkSys.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 535 */       return MagicMarkSys.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 541 */       return MagicMarkSys.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 547 */       return MagicMarkSys.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 553 */       return MagicMarkSys.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 559 */       return MagicMarkSys.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 565 */       return MagicMarkSys.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MagicMarkSys
/*     */   {
/*     */     private int euqipedmagicmarktype;
/*     */     
/*     */     private int propmagicmarktype;
/*     */     
/*     */     private HashMap<Integer, xbean.MagicMarkInfo> magicmarkinfos;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 581 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 586 */       this.euqipedmagicmarktype = 0;
/* 587 */       this.propmagicmarktype = 0;
/* 588 */       this.magicmarkinfos = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.MagicMarkSys _o1_)
/*     */     {
/* 593 */       if ((_o1_ instanceof MagicMarkSys)) { assign((MagicMarkSys)_o1_);
/* 594 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 595 */       } else if ((_o1_ instanceof MagicMarkSys.Const)) assign(((MagicMarkSys.Const)_o1_).nThis()); else {
/* 596 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MagicMarkSys _o_) {
/* 601 */       this.euqipedmagicmarktype = _o_.euqipedmagicmarktype;
/* 602 */       this.propmagicmarktype = _o_.propmagicmarktype;
/* 603 */       this.magicmarkinfos = new HashMap();
/* 604 */       for (Map.Entry<Integer, xbean.MagicMarkInfo> _e_ : _o_.magicmarkinfos.entrySet()) {
/* 605 */         this.magicmarkinfos.put(_e_.getKey(), new MagicMarkInfo.Data((xbean.MagicMarkInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 610 */       this.euqipedmagicmarktype = _o_.euqipedmagicmarktype;
/* 611 */       this.propmagicmarktype = _o_.propmagicmarktype;
/* 612 */       this.magicmarkinfos = new HashMap();
/* 613 */       for (Map.Entry<Integer, xbean.MagicMarkInfo> _e_ : _o_.magicmarkinfos.entrySet()) {
/* 614 */         this.magicmarkinfos.put(_e_.getKey(), new MagicMarkInfo.Data((xbean.MagicMarkInfo)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 620 */       _os_.marshal(this.euqipedmagicmarktype);
/* 621 */       _os_.marshal(this.propmagicmarktype);
/* 622 */       _os_.compact_uint32(this.magicmarkinfos.size());
/* 623 */       for (Map.Entry<Integer, xbean.MagicMarkInfo> _e_ : this.magicmarkinfos.entrySet())
/*     */       {
/* 625 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 626 */         ((xbean.MagicMarkInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 628 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 634 */       this.euqipedmagicmarktype = _os_.unmarshal_int();
/* 635 */       this.propmagicmarktype = _os_.unmarshal_int();
/*     */       
/* 637 */       int size = _os_.uncompact_uint32();
/* 638 */       if (size >= 12)
/*     */       {
/* 640 */         this.magicmarkinfos = new HashMap(size * 2);
/*     */       }
/* 642 */       for (; size > 0; size--)
/*     */       {
/* 644 */         int _k_ = 0;
/* 645 */         _k_ = _os_.unmarshal_int();
/* 646 */         xbean.MagicMarkInfo _v_ = xbean.Pod.newMagicMarkInfoData();
/* 647 */         _v_.unmarshal(_os_);
/* 648 */         this.magicmarkinfos.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 651 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 657 */       int _size_ = 0;
/* 658 */       _size_ += CodedOutputStream.computeInt32Size(1, this.euqipedmagicmarktype);
/* 659 */       _size_ += CodedOutputStream.computeInt32Size(2, this.propmagicmarktype);
/* 660 */       for (Map.Entry<Integer, xbean.MagicMarkInfo> _e_ : this.magicmarkinfos.entrySet())
/*     */       {
/* 662 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 663 */         _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */       }
/* 665 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 673 */         _output_.writeInt32(1, this.euqipedmagicmarktype);
/* 674 */         _output_.writeInt32(2, this.propmagicmarktype);
/* 675 */         for (Map.Entry<Integer, xbean.MagicMarkInfo> _e_ : this.magicmarkinfos.entrySet())
/*     */         {
/* 677 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 678 */           _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 683 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 685 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 693 */         boolean done = false;
/* 694 */         while (!done)
/*     */         {
/* 696 */           int tag = _input_.readTag();
/* 697 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 701 */             done = true;
/* 702 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 706 */             this.euqipedmagicmarktype = _input_.readInt32();
/* 707 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 711 */             this.propmagicmarktype = _input_.readInt32();
/* 712 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 716 */             int _k_ = 0;
/* 717 */             _k_ = _input_.readInt32();
/* 718 */             int readTag = _input_.readTag();
/* 719 */             if (26 != readTag)
/*     */             {
/* 721 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 723 */             xbean.MagicMarkInfo _v_ = xbean.Pod.newMagicMarkInfoData();
/* 724 */             _input_.readMessage(_v_);
/* 725 */             this.magicmarkinfos.put(Integer.valueOf(_k_), _v_);
/* 726 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 730 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 732 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 741 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 745 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 747 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MagicMarkSys copy()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MagicMarkSys toData()
/*     */     {
/* 759 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MagicMarkSys toBean()
/*     */     {
/* 764 */       return new MagicMarkSys(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MagicMarkSys toDataIf()
/*     */     {
/* 770 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MagicMarkSys toBeanIf()
/*     */     {
/* 775 */       return new MagicMarkSys(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 781 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 785 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 789 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 793 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 797 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 801 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 805 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getEuqipedmagicmarktype()
/*     */     {
/* 812 */       return this.euqipedmagicmarktype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPropmagicmarktype()
/*     */     {
/* 819 */       return this.propmagicmarktype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.MagicMarkInfo> getMagicmarkinfos()
/*     */     {
/* 826 */       return this.magicmarkinfos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.MagicMarkInfo> getMagicmarkinfosAsData()
/*     */     {
/* 833 */       return this.magicmarkinfos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setEuqipedmagicmarktype(int _v_)
/*     */     {
/* 840 */       this.euqipedmagicmarktype = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPropmagicmarktype(int _v_)
/*     */     {
/* 847 */       this.propmagicmarktype = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 853 */       if (!(_o1_ instanceof Data)) return false;
/* 854 */       Data _o_ = (Data)_o1_;
/* 855 */       if (this.euqipedmagicmarktype != _o_.euqipedmagicmarktype) return false;
/* 856 */       if (this.propmagicmarktype != _o_.propmagicmarktype) return false;
/* 857 */       if (!this.magicmarkinfos.equals(_o_.magicmarkinfos)) return false;
/* 858 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 864 */       int _h_ = 0;
/* 865 */       _h_ += this.euqipedmagicmarktype;
/* 866 */       _h_ += this.propmagicmarktype;
/* 867 */       _h_ += this.magicmarkinfos.hashCode();
/* 868 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 874 */       StringBuilder _sb_ = new StringBuilder();
/* 875 */       _sb_.append("(");
/* 876 */       _sb_.append(this.euqipedmagicmarktype);
/* 877 */       _sb_.append(",");
/* 878 */       _sb_.append(this.propmagicmarktype);
/* 879 */       _sb_.append(",");
/* 880 */       _sb_.append(this.magicmarkinfos);
/* 881 */       _sb_.append(")");
/* 882 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MagicMarkSys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */