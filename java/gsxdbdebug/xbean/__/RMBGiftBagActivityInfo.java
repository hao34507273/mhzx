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
/*     */ public final class RMBGiftBagActivityInfo extends XBean implements xbean.RMBGiftBagActivityInfo
/*     */ {
/*     */   private HashMap<Integer, xbean.RMBGiftBagTierInfo> tiers;
/*     */   private int open_server_days;
/*     */   private int send_award_mail_cfgid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.tiers.clear();
/*  23 */     this.open_server_days = 0;
/*  24 */     this.send_award_mail_cfgid = 0;
/*     */   }
/*     */   
/*     */   RMBGiftBagActivityInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.tiers = new HashMap();
/*  31 */     this.open_server_days = 0;
/*  32 */     this.send_award_mail_cfgid = 0;
/*     */   }
/*     */   
/*     */   public RMBGiftBagActivityInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RMBGiftBagActivityInfo(RMBGiftBagActivityInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RMBGiftBagActivityInfo(xbean.RMBGiftBagActivityInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof RMBGiftBagActivityInfo)) { assign((RMBGiftBagActivityInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RMBGiftBagActivityInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.tiers = new HashMap();
/*  58 */     for (Map.Entry<Integer, xbean.RMBGiftBagTierInfo> _e_ : _o_.tiers.entrySet())
/*  59 */       this.tiers.put(_e_.getKey(), new RMBGiftBagTierInfo((xbean.RMBGiftBagTierInfo)_e_.getValue(), this, "tiers"));
/*  60 */     this.open_server_days = _o_.open_server_days;
/*  61 */     this.send_award_mail_cfgid = _o_.send_award_mail_cfgid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  66 */     this.tiers = new HashMap();
/*  67 */     for (Map.Entry<Integer, xbean.RMBGiftBagTierInfo> _e_ : _o_.tiers.entrySet())
/*  68 */       this.tiers.put(_e_.getKey(), new RMBGiftBagTierInfo((xbean.RMBGiftBagTierInfo)_e_.getValue(), this, "tiers"));
/*  69 */     this.open_server_days = _o_.open_server_days;
/*  70 */     this.send_award_mail_cfgid = _o_.send_award_mail_cfgid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     _os_.compact_uint32(this.tiers.size());
/*  78 */     for (Map.Entry<Integer, xbean.RMBGiftBagTierInfo> _e_ : this.tiers.entrySet())
/*     */     {
/*  80 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  81 */       ((xbean.RMBGiftBagTierInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  83 */     _os_.marshal(this.open_server_days);
/*  84 */     _os_.marshal(this.send_award_mail_cfgid);
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*     */     
/*  93 */     int size = _os_.uncompact_uint32();
/*  94 */     if (size >= 12)
/*     */     {
/*  96 */       this.tiers = new HashMap(size * 2);
/*     */     }
/*  98 */     for (; size > 0; size--)
/*     */     {
/* 100 */       int _k_ = 0;
/* 101 */       _k_ = _os_.unmarshal_int();
/* 102 */       xbean.RMBGiftBagTierInfo _v_ = new RMBGiftBagTierInfo(0, this, "tiers");
/* 103 */       _v_.unmarshal(_os_);
/* 104 */       this.tiers.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 107 */     this.open_server_days = _os_.unmarshal_int();
/* 108 */     this.send_award_mail_cfgid = _os_.unmarshal_int();
/* 109 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 115 */     _xdb_verify_unsafe_();
/* 116 */     int _size_ = 0;
/* 117 */     for (Map.Entry<Integer, xbean.RMBGiftBagTierInfo> _e_ : this.tiers.entrySet())
/*     */     {
/* 119 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 120 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 122 */     _size_ += CodedOutputStream.computeInt32Size(2, this.open_server_days);
/* 123 */     _size_ += CodedOutputStream.computeInt32Size(3, this.send_award_mail_cfgid);
/* 124 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 130 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 133 */       for (Map.Entry<Integer, xbean.RMBGiftBagTierInfo> _e_ : this.tiers.entrySet())
/*     */       {
/* 135 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 136 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 138 */       _output_.writeInt32(2, this.open_server_days);
/* 139 */       _output_.writeInt32(3, this.send_award_mail_cfgid);
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
/* 167 */           int _k_ = 0;
/* 168 */           _k_ = _input_.readInt32();
/* 169 */           int readTag = _input_.readTag();
/* 170 */           if (10 != readTag)
/*     */           {
/* 172 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 174 */           xbean.RMBGiftBagTierInfo _v_ = new RMBGiftBagTierInfo(0, this, "tiers");
/* 175 */           _input_.readMessage(_v_);
/* 176 */           this.tiers.put(Integer.valueOf(_k_), _v_);
/* 177 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 181 */           this.open_server_days = _input_.readInt32();
/* 182 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 186 */           this.send_award_mail_cfgid = _input_.readInt32();
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
/*     */   public xbean.RMBGiftBagActivityInfo copy()
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     return new RMBGiftBagActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RMBGiftBagActivityInfo toData()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RMBGiftBagActivityInfo toBean()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return new RMBGiftBagActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RMBGiftBagActivityInfo toDataIf()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RMBGiftBagActivityInfo toBeanIf()
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
/*     */   public Map<Integer, xbean.RMBGiftBagTierInfo> getTiers()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     return xdb.Logs.logMap(new LogKey(this, "tiers"), this.tiers);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.RMBGiftBagTierInfo> getTiersAsData()
/*     */   {
/* 263 */     _xdb_verify_unsafe_();
/*     */     
/* 265 */     RMBGiftBagActivityInfo _o_ = this;
/* 266 */     Map<Integer, xbean.RMBGiftBagTierInfo> tiers = new HashMap();
/* 267 */     for (Map.Entry<Integer, xbean.RMBGiftBagTierInfo> _e_ : _o_.tiers.entrySet())
/* 268 */       tiers.put(_e_.getKey(), new RMBGiftBagTierInfo.Data((xbean.RMBGiftBagTierInfo)_e_.getValue()));
/* 269 */     return tiers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getOpen_server_days()
/*     */   {
/* 276 */     _xdb_verify_unsafe_();
/* 277 */     return this.open_server_days;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSend_award_mail_cfgid()
/*     */   {
/* 284 */     _xdb_verify_unsafe_();
/* 285 */     return this.send_award_mail_cfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOpen_server_days(int _v_)
/*     */   {
/* 292 */     _xdb_verify_unsafe_();
/* 293 */     xdb.Logs.logIf(new LogKey(this, "open_server_days")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 297 */         new xdb.logs.LogInt(this, RMBGiftBagActivityInfo.this.open_server_days)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 301 */             RMBGiftBagActivityInfo.this.open_server_days = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 305 */     });
/* 306 */     this.open_server_days = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSend_award_mail_cfgid(int _v_)
/*     */   {
/* 313 */     _xdb_verify_unsafe_();
/* 314 */     xdb.Logs.logIf(new LogKey(this, "send_award_mail_cfgid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 318 */         new xdb.logs.LogInt(this, RMBGiftBagActivityInfo.this.send_award_mail_cfgid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 322 */             RMBGiftBagActivityInfo.this.send_award_mail_cfgid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 326 */     });
/* 327 */     this.send_award_mail_cfgid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     RMBGiftBagActivityInfo _o_ = null;
/* 335 */     if ((_o1_ instanceof RMBGiftBagActivityInfo)) { _o_ = (RMBGiftBagActivityInfo)_o1_;
/* 336 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 337 */       return false;
/* 338 */     if (!this.tiers.equals(_o_.tiers)) return false;
/* 339 */     if (this.open_server_days != _o_.open_server_days) return false;
/* 340 */     if (this.send_award_mail_cfgid != _o_.send_award_mail_cfgid) return false;
/* 341 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 347 */     _xdb_verify_unsafe_();
/* 348 */     int _h_ = 0;
/* 349 */     _h_ += this.tiers.hashCode();
/* 350 */     _h_ += this.open_server_days;
/* 351 */     _h_ += this.send_award_mail_cfgid;
/* 352 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 358 */     _xdb_verify_unsafe_();
/* 359 */     StringBuilder _sb_ = new StringBuilder();
/* 360 */     _sb_.append("(");
/* 361 */     _sb_.append(this.tiers);
/* 362 */     _sb_.append(",");
/* 363 */     _sb_.append(this.open_server_days);
/* 364 */     _sb_.append(",");
/* 365 */     _sb_.append(this.send_award_mail_cfgid);
/* 366 */     _sb_.append(")");
/* 367 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 373 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 374 */     lb.add(new xdb.logs.ListenableMap().setVarName("tiers"));
/* 375 */     lb.add(new xdb.logs.ListenableChanged().setVarName("open_server_days"));
/* 376 */     lb.add(new xdb.logs.ListenableChanged().setVarName("send_award_mail_cfgid"));
/* 377 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RMBGiftBagActivityInfo {
/*     */     private Const() {}
/*     */     
/*     */     RMBGiftBagActivityInfo nThis() {
/* 384 */       return RMBGiftBagActivityInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 390 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RMBGiftBagActivityInfo copy()
/*     */     {
/* 396 */       return RMBGiftBagActivityInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RMBGiftBagActivityInfo toData()
/*     */     {
/* 402 */       return RMBGiftBagActivityInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RMBGiftBagActivityInfo toBean()
/*     */     {
/* 407 */       return RMBGiftBagActivityInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RMBGiftBagActivityInfo toDataIf()
/*     */     {
/* 413 */       return RMBGiftBagActivityInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RMBGiftBagActivityInfo toBeanIf()
/*     */     {
/* 418 */       return RMBGiftBagActivityInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RMBGiftBagTierInfo> getTiers()
/*     */     {
/* 425 */       RMBGiftBagActivityInfo.this._xdb_verify_unsafe_();
/* 426 */       return xdb.Consts.constMap(RMBGiftBagActivityInfo.this.tiers);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RMBGiftBagTierInfo> getTiersAsData()
/*     */     {
/* 433 */       RMBGiftBagActivityInfo.this._xdb_verify_unsafe_();
/*     */       
/* 435 */       RMBGiftBagActivityInfo _o_ = RMBGiftBagActivityInfo.this;
/* 436 */       Map<Integer, xbean.RMBGiftBagTierInfo> tiers = new HashMap();
/* 437 */       for (Map.Entry<Integer, xbean.RMBGiftBagTierInfo> _e_ : _o_.tiers.entrySet())
/* 438 */         tiers.put(_e_.getKey(), new RMBGiftBagTierInfo.Data((xbean.RMBGiftBagTierInfo)_e_.getValue()));
/* 439 */       return tiers;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getOpen_server_days()
/*     */     {
/* 446 */       RMBGiftBagActivityInfo.this._xdb_verify_unsafe_();
/* 447 */       return RMBGiftBagActivityInfo.this.open_server_days;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSend_award_mail_cfgid()
/*     */     {
/* 454 */       RMBGiftBagActivityInfo.this._xdb_verify_unsafe_();
/* 455 */       return RMBGiftBagActivityInfo.this.send_award_mail_cfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOpen_server_days(int _v_)
/*     */     {
/* 462 */       RMBGiftBagActivityInfo.this._xdb_verify_unsafe_();
/* 463 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSend_award_mail_cfgid(int _v_)
/*     */     {
/* 470 */       RMBGiftBagActivityInfo.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 477 */       RMBGiftBagActivityInfo.this._xdb_verify_unsafe_();
/* 478 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 484 */       RMBGiftBagActivityInfo.this._xdb_verify_unsafe_();
/* 485 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 491 */       return RMBGiftBagActivityInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 497 */       return RMBGiftBagActivityInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 503 */       RMBGiftBagActivityInfo.this._xdb_verify_unsafe_();
/* 504 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 510 */       return RMBGiftBagActivityInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 516 */       return RMBGiftBagActivityInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 522 */       RMBGiftBagActivityInfo.this._xdb_verify_unsafe_();
/* 523 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 529 */       return RMBGiftBagActivityInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 535 */       return RMBGiftBagActivityInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 541 */       return RMBGiftBagActivityInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 547 */       return RMBGiftBagActivityInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 553 */       return RMBGiftBagActivityInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 559 */       return RMBGiftBagActivityInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 565 */       return RMBGiftBagActivityInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RMBGiftBagActivityInfo
/*     */   {
/*     */     private HashMap<Integer, xbean.RMBGiftBagTierInfo> tiers;
/*     */     
/*     */     private int open_server_days;
/*     */     
/*     */     private int send_award_mail_cfgid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 581 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 586 */       this.tiers = new HashMap();
/* 587 */       this.open_server_days = 0;
/* 588 */       this.send_award_mail_cfgid = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.RMBGiftBagActivityInfo _o1_)
/*     */     {
/* 593 */       if ((_o1_ instanceof RMBGiftBagActivityInfo)) { assign((RMBGiftBagActivityInfo)_o1_);
/* 594 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 595 */       } else if ((_o1_ instanceof RMBGiftBagActivityInfo.Const)) assign(((RMBGiftBagActivityInfo.Const)_o1_).nThis()); else {
/* 596 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RMBGiftBagActivityInfo _o_) {
/* 601 */       this.tiers = new HashMap();
/* 602 */       for (Map.Entry<Integer, xbean.RMBGiftBagTierInfo> _e_ : _o_.tiers.entrySet())
/* 603 */         this.tiers.put(_e_.getKey(), new RMBGiftBagTierInfo.Data((xbean.RMBGiftBagTierInfo)_e_.getValue()));
/* 604 */       this.open_server_days = _o_.open_server_days;
/* 605 */       this.send_award_mail_cfgid = _o_.send_award_mail_cfgid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 610 */       this.tiers = new HashMap();
/* 611 */       for (Map.Entry<Integer, xbean.RMBGiftBagTierInfo> _e_ : _o_.tiers.entrySet())
/* 612 */         this.tiers.put(_e_.getKey(), new RMBGiftBagTierInfo.Data((xbean.RMBGiftBagTierInfo)_e_.getValue()));
/* 613 */       this.open_server_days = _o_.open_server_days;
/* 614 */       this.send_award_mail_cfgid = _o_.send_award_mail_cfgid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 620 */       _os_.compact_uint32(this.tiers.size());
/* 621 */       for (Map.Entry<Integer, xbean.RMBGiftBagTierInfo> _e_ : this.tiers.entrySet())
/*     */       {
/* 623 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 624 */         ((xbean.RMBGiftBagTierInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 626 */       _os_.marshal(this.open_server_days);
/* 627 */       _os_.marshal(this.send_award_mail_cfgid);
/* 628 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 635 */       int size = _os_.uncompact_uint32();
/* 636 */       if (size >= 12)
/*     */       {
/* 638 */         this.tiers = new HashMap(size * 2);
/*     */       }
/* 640 */       for (; size > 0; size--)
/*     */       {
/* 642 */         int _k_ = 0;
/* 643 */         _k_ = _os_.unmarshal_int();
/* 644 */         xbean.RMBGiftBagTierInfo _v_ = xbean.Pod.newRMBGiftBagTierInfoData();
/* 645 */         _v_.unmarshal(_os_);
/* 646 */         this.tiers.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 649 */       this.open_server_days = _os_.unmarshal_int();
/* 650 */       this.send_award_mail_cfgid = _os_.unmarshal_int();
/* 651 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 657 */       int _size_ = 0;
/* 658 */       for (Map.Entry<Integer, xbean.RMBGiftBagTierInfo> _e_ : this.tiers.entrySet())
/*     */       {
/* 660 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 661 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 663 */       _size_ += CodedOutputStream.computeInt32Size(2, this.open_server_days);
/* 664 */       _size_ += CodedOutputStream.computeInt32Size(3, this.send_award_mail_cfgid);
/* 665 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 673 */         for (Map.Entry<Integer, xbean.RMBGiftBagTierInfo> _e_ : this.tiers.entrySet())
/*     */         {
/* 675 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 676 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 678 */         _output_.writeInt32(2, this.open_server_days);
/* 679 */         _output_.writeInt32(3, this.send_award_mail_cfgid);
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
/* 706 */             int _k_ = 0;
/* 707 */             _k_ = _input_.readInt32();
/* 708 */             int readTag = _input_.readTag();
/* 709 */             if (10 != readTag)
/*     */             {
/* 711 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 713 */             xbean.RMBGiftBagTierInfo _v_ = xbean.Pod.newRMBGiftBagTierInfoData();
/* 714 */             _input_.readMessage(_v_);
/* 715 */             this.tiers.put(Integer.valueOf(_k_), _v_);
/* 716 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 720 */             this.open_server_days = _input_.readInt32();
/* 721 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 725 */             this.send_award_mail_cfgid = _input_.readInt32();
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
/*     */     public xbean.RMBGiftBagActivityInfo copy()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RMBGiftBagActivityInfo toData()
/*     */     {
/* 759 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RMBGiftBagActivityInfo toBean()
/*     */     {
/* 764 */       return new RMBGiftBagActivityInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RMBGiftBagActivityInfo toDataIf()
/*     */     {
/* 770 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RMBGiftBagActivityInfo toBeanIf()
/*     */     {
/* 775 */       return new RMBGiftBagActivityInfo(this, null, null);
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
/*     */     public Map<Integer, xbean.RMBGiftBagTierInfo> getTiers()
/*     */     {
/* 812 */       return this.tiers;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.RMBGiftBagTierInfo> getTiersAsData()
/*     */     {
/* 819 */       return this.tiers;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getOpen_server_days()
/*     */     {
/* 826 */       return this.open_server_days;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSend_award_mail_cfgid()
/*     */     {
/* 833 */       return this.send_award_mail_cfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOpen_server_days(int _v_)
/*     */     {
/* 840 */       this.open_server_days = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSend_award_mail_cfgid(int _v_)
/*     */     {
/* 847 */       this.send_award_mail_cfgid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 853 */       if (!(_o1_ instanceof Data)) return false;
/* 854 */       Data _o_ = (Data)_o1_;
/* 855 */       if (!this.tiers.equals(_o_.tiers)) return false;
/* 856 */       if (this.open_server_days != _o_.open_server_days) return false;
/* 857 */       if (this.send_award_mail_cfgid != _o_.send_award_mail_cfgid) return false;
/* 858 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 864 */       int _h_ = 0;
/* 865 */       _h_ += this.tiers.hashCode();
/* 866 */       _h_ += this.open_server_days;
/* 867 */       _h_ += this.send_award_mail_cfgid;
/* 868 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 874 */       StringBuilder _sb_ = new StringBuilder();
/* 875 */       _sb_.append("(");
/* 876 */       _sb_.append(this.tiers);
/* 877 */       _sb_.append(",");
/* 878 */       _sb_.append(this.open_server_days);
/* 879 */       _sb_.append(",");
/* 880 */       _sb_.append(this.send_award_mail_cfgid);
/* 881 */       _sb_.append(")");
/* 882 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RMBGiftBagActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */