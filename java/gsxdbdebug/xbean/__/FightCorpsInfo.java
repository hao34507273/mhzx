/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.IOException;
/*     */ import ppbio.ByteString;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class FightCorpsInfo extends XBean implements xbean.FightCorpsInfo
/*     */ {
/*     */   private long corps_id;
/*     */   private int corps_zone_id;
/*     */   private String corps_name;
/*     */   private int corps_badge_id;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.corps_id = 0L;
/*  25 */     this.corps_zone_id = 0;
/*  26 */     this.corps_name = "";
/*  27 */     this.corps_badge_id = 0;
/*     */   }
/*     */   
/*     */   FightCorpsInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.corps_name = "";
/*     */   }
/*     */   
/*     */   public FightCorpsInfo()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FightCorpsInfo(FightCorpsInfo _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FightCorpsInfo(xbean.FightCorpsInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof FightCorpsInfo)) { assign((FightCorpsInfo)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FightCorpsInfo _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.corps_id = _o_.corps_id;
/*  59 */     this.corps_zone_id = _o_.corps_zone_id;
/*  60 */     this.corps_name = _o_.corps_name;
/*  61 */     this.corps_badge_id = _o_.corps_badge_id;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  66 */     this.corps_id = _o_.corps_id;
/*  67 */     this.corps_zone_id = _o_.corps_zone_id;
/*  68 */     this.corps_name = _o_.corps_name;
/*  69 */     this.corps_badge_id = _o_.corps_badge_id;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     _os_.marshal(this.corps_id);
/*  77 */     _os_.marshal(this.corps_zone_id);
/*  78 */     _os_.marshal(this.corps_name, "UTF-16LE");
/*  79 */     _os_.marshal(this.corps_badge_id);
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  86 */     _xdb_verify_unsafe_();
/*  87 */     this.corps_id = _os_.unmarshal_long();
/*  88 */     this.corps_zone_id = _os_.unmarshal_int();
/*  89 */     this.corps_name = _os_.unmarshal_String("UTF-16LE");
/*  90 */     this.corps_badge_id = _os_.unmarshal_int();
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  97 */     _xdb_verify_unsafe_();
/*  98 */     int _size_ = 0;
/*  99 */     _size_ += CodedOutputStream.computeInt64Size(1, this.corps_id);
/* 100 */     _size_ += CodedOutputStream.computeInt32Size(3, this.corps_zone_id);
/*     */     try
/*     */     {
/* 103 */       _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.corps_name, "UTF-16LE"));
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e)
/*     */     {
/* 107 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*     */     }
/* 109 */     _size_ += CodedOutputStream.computeInt32Size(5, this.corps_badge_id);
/* 110 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 119 */       _output_.writeInt64(1, this.corps_id);
/* 120 */       _output_.writeInt32(3, this.corps_zone_id);
/* 121 */       _output_.writeBytes(4, ByteString.copyFrom(this.corps_name, "UTF-16LE"));
/* 122 */       _output_.writeInt32(5, this.corps_badge_id);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 126 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 128 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 134 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 137 */       boolean done = false;
/* 138 */       while (!done)
/*     */       {
/* 140 */         int tag = _input_.readTag();
/* 141 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 145 */           done = true;
/* 146 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 150 */           this.corps_id = _input_.readInt64();
/* 151 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 155 */           this.corps_zone_id = _input_.readInt32();
/* 156 */           break;
/*     */         
/*     */ 
/*     */         case 34: 
/* 160 */           this.corps_name = _input_.readBytes().toString("UTF-16LE");
/* 161 */           break;
/*     */         
/*     */ 
/*     */         case 40: 
/* 165 */           this.corps_badge_id = _input_.readInt32();
/* 166 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 170 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 172 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 181 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 185 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 187 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightCorpsInfo copy()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return new FightCorpsInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightCorpsInfo toData()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FightCorpsInfo toBean()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new FightCorpsInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FightCorpsInfo toDataIf()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FightCorpsInfo toBeanIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getCorps_id()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.corps_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCorps_zone_id()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.corps_zone_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCorps_name()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.corps_name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getCorps_nameOctets()
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     return Octets.wrap(getCorps_name(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCorps_badge_id()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     return this.corps_badge_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCorps_id(long _v_)
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     xdb.Logs.logIf(new LogKey(this, "corps_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 279 */         new xdb.logs.LogLong(this, FightCorpsInfo.this.corps_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 283 */             FightCorpsInfo.this.corps_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 287 */     });
/* 288 */     this.corps_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCorps_zone_id(int _v_)
/*     */   {
/* 295 */     _xdb_verify_unsafe_();
/* 296 */     xdb.Logs.logIf(new LogKey(this, "corps_zone_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 300 */         new xdb.logs.LogInt(this, FightCorpsInfo.this.corps_zone_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 304 */             FightCorpsInfo.this.corps_zone_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 308 */     });
/* 309 */     this.corps_zone_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCorps_name(String _v_)
/*     */   {
/* 316 */     _xdb_verify_unsafe_();
/* 317 */     if (null == _v_)
/* 318 */       throw new NullPointerException();
/* 319 */     xdb.Logs.logIf(new LogKey(this, "corps_name")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 323 */         new xdb.logs.LogString(this, FightCorpsInfo.this.corps_name)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 327 */             FightCorpsInfo.this.corps_name = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 331 */     });
/* 332 */     this.corps_name = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCorps_nameOctets(Octets _v_)
/*     */   {
/* 339 */     _xdb_verify_unsafe_();
/* 340 */     setCorps_name(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCorps_badge_id(int _v_)
/*     */   {
/* 347 */     _xdb_verify_unsafe_();
/* 348 */     xdb.Logs.logIf(new LogKey(this, "corps_badge_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 352 */         new xdb.logs.LogInt(this, FightCorpsInfo.this.corps_badge_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 356 */             FightCorpsInfo.this.corps_badge_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 360 */     });
/* 361 */     this.corps_badge_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 367 */     _xdb_verify_unsafe_();
/* 368 */     FightCorpsInfo _o_ = null;
/* 369 */     if ((_o1_ instanceof FightCorpsInfo)) { _o_ = (FightCorpsInfo)_o1_;
/* 370 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 371 */       return false;
/* 372 */     if (this.corps_id != _o_.corps_id) return false;
/* 373 */     if (this.corps_zone_id != _o_.corps_zone_id) return false;
/* 374 */     if (!this.corps_name.equals(_o_.corps_name)) return false;
/* 375 */     if (this.corps_badge_id != _o_.corps_badge_id) return false;
/* 376 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 382 */     _xdb_verify_unsafe_();
/* 383 */     int _h_ = 0;
/* 384 */     _h_ = (int)(_h_ + this.corps_id);
/* 385 */     _h_ += this.corps_zone_id;
/* 386 */     _h_ += this.corps_name.hashCode();
/* 387 */     _h_ += this.corps_badge_id;
/* 388 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 394 */     _xdb_verify_unsafe_();
/* 395 */     StringBuilder _sb_ = new StringBuilder();
/* 396 */     _sb_.append("(");
/* 397 */     _sb_.append(this.corps_id);
/* 398 */     _sb_.append(",");
/* 399 */     _sb_.append(this.corps_zone_id);
/* 400 */     _sb_.append(",");
/* 401 */     _sb_.append("'").append(this.corps_name).append("'");
/* 402 */     _sb_.append(",");
/* 403 */     _sb_.append(this.corps_badge_id);
/* 404 */     _sb_.append(")");
/* 405 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 411 */     ListenableBean lb = new ListenableBean();
/* 412 */     lb.add(new ListenableChanged().setVarName("corps_id"));
/* 413 */     lb.add(new ListenableChanged().setVarName("corps_zone_id"));
/* 414 */     lb.add(new ListenableChanged().setVarName("corps_name"));
/* 415 */     lb.add(new ListenableChanged().setVarName("corps_badge_id"));
/* 416 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FightCorpsInfo {
/*     */     private Const() {}
/*     */     
/*     */     FightCorpsInfo nThis() {
/* 423 */       return FightCorpsInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 429 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCorpsInfo copy()
/*     */     {
/* 435 */       return FightCorpsInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCorpsInfo toData()
/*     */     {
/* 441 */       return FightCorpsInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FightCorpsInfo toBean()
/*     */     {
/* 446 */       return FightCorpsInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCorpsInfo toDataIf()
/*     */     {
/* 452 */       return FightCorpsInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FightCorpsInfo toBeanIf()
/*     */     {
/* 457 */       return FightCorpsInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCorps_id()
/*     */     {
/* 464 */       FightCorpsInfo.this._xdb_verify_unsafe_();
/* 465 */       return FightCorpsInfo.this.corps_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCorps_zone_id()
/*     */     {
/* 472 */       FightCorpsInfo.this._xdb_verify_unsafe_();
/* 473 */       return FightCorpsInfo.this.corps_zone_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getCorps_name()
/*     */     {
/* 480 */       FightCorpsInfo.this._xdb_verify_unsafe_();
/* 481 */       return FightCorpsInfo.this.corps_name;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getCorps_nameOctets()
/*     */     {
/* 488 */       FightCorpsInfo.this._xdb_verify_unsafe_();
/* 489 */       return FightCorpsInfo.this.getCorps_nameOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCorps_badge_id()
/*     */     {
/* 496 */       FightCorpsInfo.this._xdb_verify_unsafe_();
/* 497 */       return FightCorpsInfo.this.corps_badge_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCorps_id(long _v_)
/*     */     {
/* 504 */       FightCorpsInfo.this._xdb_verify_unsafe_();
/* 505 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCorps_zone_id(int _v_)
/*     */     {
/* 512 */       FightCorpsInfo.this._xdb_verify_unsafe_();
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCorps_name(String _v_)
/*     */     {
/* 520 */       FightCorpsInfo.this._xdb_verify_unsafe_();
/* 521 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCorps_nameOctets(Octets _v_)
/*     */     {
/* 528 */       FightCorpsInfo.this._xdb_verify_unsafe_();
/* 529 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCorps_badge_id(int _v_)
/*     */     {
/* 536 */       FightCorpsInfo.this._xdb_verify_unsafe_();
/* 537 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 543 */       FightCorpsInfo.this._xdb_verify_unsafe_();
/* 544 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 550 */       FightCorpsInfo.this._xdb_verify_unsafe_();
/* 551 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 557 */       return FightCorpsInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 563 */       return FightCorpsInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 569 */       FightCorpsInfo.this._xdb_verify_unsafe_();
/* 570 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 576 */       return FightCorpsInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 582 */       return FightCorpsInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 588 */       FightCorpsInfo.this._xdb_verify_unsafe_();
/* 589 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 595 */       return FightCorpsInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 601 */       return FightCorpsInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 607 */       return FightCorpsInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 613 */       return FightCorpsInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 619 */       return FightCorpsInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 625 */       return FightCorpsInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 631 */       return FightCorpsInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FightCorpsInfo
/*     */   {
/*     */     private long corps_id;
/*     */     
/*     */     private int corps_zone_id;
/*     */     
/*     */     private String corps_name;
/*     */     
/*     */     private int corps_badge_id;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 649 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 654 */       this.corps_name = "";
/*     */     }
/*     */     
/*     */     Data(xbean.FightCorpsInfo _o1_)
/*     */     {
/* 659 */       if ((_o1_ instanceof FightCorpsInfo)) { assign((FightCorpsInfo)_o1_);
/* 660 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 661 */       } else if ((_o1_ instanceof FightCorpsInfo.Const)) assign(((FightCorpsInfo.Const)_o1_).nThis()); else {
/* 662 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FightCorpsInfo _o_) {
/* 667 */       this.corps_id = _o_.corps_id;
/* 668 */       this.corps_zone_id = _o_.corps_zone_id;
/* 669 */       this.corps_name = _o_.corps_name;
/* 670 */       this.corps_badge_id = _o_.corps_badge_id;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 675 */       this.corps_id = _o_.corps_id;
/* 676 */       this.corps_zone_id = _o_.corps_zone_id;
/* 677 */       this.corps_name = _o_.corps_name;
/* 678 */       this.corps_badge_id = _o_.corps_badge_id;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 684 */       _os_.marshal(this.corps_id);
/* 685 */       _os_.marshal(this.corps_zone_id);
/* 686 */       _os_.marshal(this.corps_name, "UTF-16LE");
/* 687 */       _os_.marshal(this.corps_badge_id);
/* 688 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 694 */       this.corps_id = _os_.unmarshal_long();
/* 695 */       this.corps_zone_id = _os_.unmarshal_int();
/* 696 */       this.corps_name = _os_.unmarshal_String("UTF-16LE");
/* 697 */       this.corps_badge_id = _os_.unmarshal_int();
/* 698 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 704 */       int _size_ = 0;
/* 705 */       _size_ += CodedOutputStream.computeInt64Size(1, this.corps_id);
/* 706 */       _size_ += CodedOutputStream.computeInt32Size(3, this.corps_zone_id);
/*     */       try
/*     */       {
/* 709 */         _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.corps_name, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 713 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/* 715 */       _size_ += CodedOutputStream.computeInt32Size(5, this.corps_badge_id);
/* 716 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 724 */         _output_.writeInt64(1, this.corps_id);
/* 725 */         _output_.writeInt32(3, this.corps_zone_id);
/* 726 */         _output_.writeBytes(4, ByteString.copyFrom(this.corps_name, "UTF-16LE"));
/* 727 */         _output_.writeInt32(5, this.corps_badge_id);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 731 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 733 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 741 */         boolean done = false;
/* 742 */         while (!done)
/*     */         {
/* 744 */           int tag = _input_.readTag();
/* 745 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 749 */             done = true;
/* 750 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 754 */             this.corps_id = _input_.readInt64();
/* 755 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 759 */             this.corps_zone_id = _input_.readInt32();
/* 760 */             break;
/*     */           
/*     */ 
/*     */           case 34: 
/* 764 */             this.corps_name = _input_.readBytes().toString("UTF-16LE");
/* 765 */             break;
/*     */           
/*     */ 
/*     */           case 40: 
/* 769 */             this.corps_badge_id = _input_.readInt32();
/* 770 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 774 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 776 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 785 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 789 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 791 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCorpsInfo copy()
/*     */     {
/* 797 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCorpsInfo toData()
/*     */     {
/* 803 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FightCorpsInfo toBean()
/*     */     {
/* 808 */       return new FightCorpsInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FightCorpsInfo toDataIf()
/*     */     {
/* 814 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FightCorpsInfo toBeanIf()
/*     */     {
/* 819 */       return new FightCorpsInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 825 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 829 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 833 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 837 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 841 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 845 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 849 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCorps_id()
/*     */     {
/* 856 */       return this.corps_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCorps_zone_id()
/*     */     {
/* 863 */       return this.corps_zone_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getCorps_name()
/*     */     {
/* 870 */       return this.corps_name;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getCorps_nameOctets()
/*     */     {
/* 877 */       return Octets.wrap(getCorps_name(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCorps_badge_id()
/*     */     {
/* 884 */       return this.corps_badge_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCorps_id(long _v_)
/*     */     {
/* 891 */       this.corps_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCorps_zone_id(int _v_)
/*     */     {
/* 898 */       this.corps_zone_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCorps_name(String _v_)
/*     */     {
/* 905 */       if (null == _v_)
/* 906 */         throw new NullPointerException();
/* 907 */       this.corps_name = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCorps_nameOctets(Octets _v_)
/*     */     {
/* 914 */       setCorps_name(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCorps_badge_id(int _v_)
/*     */     {
/* 921 */       this.corps_badge_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 927 */       if (!(_o1_ instanceof Data)) return false;
/* 928 */       Data _o_ = (Data)_o1_;
/* 929 */       if (this.corps_id != _o_.corps_id) return false;
/* 930 */       if (this.corps_zone_id != _o_.corps_zone_id) return false;
/* 931 */       if (!this.corps_name.equals(_o_.corps_name)) return false;
/* 932 */       if (this.corps_badge_id != _o_.corps_badge_id) return false;
/* 933 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 939 */       int _h_ = 0;
/* 940 */       _h_ = (int)(_h_ + this.corps_id);
/* 941 */       _h_ += this.corps_zone_id;
/* 942 */       _h_ += this.corps_name.hashCode();
/* 943 */       _h_ += this.corps_badge_id;
/* 944 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 950 */       StringBuilder _sb_ = new StringBuilder();
/* 951 */       _sb_.append("(");
/* 952 */       _sb_.append(this.corps_id);
/* 953 */       _sb_.append(",");
/* 954 */       _sb_.append(this.corps_zone_id);
/* 955 */       _sb_.append(",");
/* 956 */       _sb_.append("'").append(this.corps_name).append("'");
/* 957 */       _sb_.append(",");
/* 958 */       _sb_.append(this.corps_badge_id);
/* 959 */       _sb_.append(")");
/* 960 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FightCorpsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */