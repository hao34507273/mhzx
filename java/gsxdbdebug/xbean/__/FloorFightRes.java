/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class FloorFightRes extends XBean implements xbean.FloorFightRes
/*     */ {
/*     */   private ArrayList<String> names;
/*     */   private int killtime;
/*     */   private int usedtime;
/*     */   private long radioid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.names.clear();
/*  25 */     this.killtime = 0;
/*  26 */     this.usedtime = 0;
/*  27 */     this.radioid = 0L;
/*     */   }
/*     */   
/*     */   FloorFightRes(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.names = new ArrayList();
/*     */   }
/*     */   
/*     */   public FloorFightRes()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FloorFightRes(FloorFightRes _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FloorFightRes(xbean.FloorFightRes _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof FloorFightRes)) { assign((FloorFightRes)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FloorFightRes _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.names = new ArrayList();
/*  59 */     this.names.addAll(_o_.names);
/*  60 */     this.killtime = _o_.killtime;
/*  61 */     this.usedtime = _o_.usedtime;
/*  62 */     this.radioid = _o_.radioid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  67 */     this.names = new ArrayList();
/*  68 */     this.names.addAll(_o_.names);
/*  69 */     this.killtime = _o_.killtime;
/*  70 */     this.usedtime = _o_.usedtime;
/*  71 */     this.radioid = _o_.radioid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  77 */     _xdb_verify_unsafe_();
/*  78 */     _os_.compact_uint32(this.names.size());
/*  79 */     for (String _v_ : this.names)
/*     */     {
/*  81 */       _os_.marshal(_v_, "UTF-16LE");
/*     */     }
/*  83 */     _os_.marshal(this.killtime);
/*  84 */     _os_.marshal(this.usedtime);
/*  85 */     _os_.marshal(this.radioid);
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  95 */       String _v_ = "";
/*  96 */       _v_ = _os_.unmarshal_String("UTF-16LE");
/*  97 */       this.names.add(_v_);
/*     */     }
/*  99 */     this.killtime = _os_.unmarshal_int();
/* 100 */     this.usedtime = _os_.unmarshal_int();
/* 101 */     this.radioid = _os_.unmarshal_long();
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/* 109 */     int _size_ = 0;
/* 110 */     for (String _v_ : this.names)
/*     */     {
/*     */       try
/*     */       {
/* 114 */         _size_ += CodedOutputStream.computeBytesSize(1, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 118 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/*     */     }
/* 121 */     _size_ += CodedOutputStream.computeInt32Size(2, this.killtime);
/* 122 */     _size_ += CodedOutputStream.computeInt32Size(3, this.usedtime);
/* 123 */     _size_ += CodedOutputStream.computeInt64Size(4, this.radioid);
/* 124 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 130 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 133 */       for (String _v_ : this.names)
/*     */       {
/* 135 */         _output_.writeBytes(1, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */       }
/* 137 */       _output_.writeInt32(2, this.killtime);
/* 138 */       _output_.writeInt32(3, this.usedtime);
/* 139 */       _output_.writeInt64(4, this.radioid);
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
/*     */         case 10: 
/* 167 */           String _v_ = "";
/* 168 */           _v_ = _input_.readBytes().toString("UTF-16LE");
/* 169 */           this.names.add(_v_);
/* 170 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 174 */           this.killtime = _input_.readInt32();
/* 175 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 179 */           this.usedtime = _input_.readInt32();
/* 180 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 184 */           this.radioid = _input_.readInt64();
/* 185 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 189 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 191 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 200 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 204 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 206 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FloorFightRes copy()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new FloorFightRes(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FloorFightRes toData()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FloorFightRes toBean()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new FloorFightRes(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FloorFightRes toDataIf()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FloorFightRes toBeanIf()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<String> getNames()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return xdb.Logs.logList(new LogKey(this, "names"), this.names);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<String> getNamesAsData()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/*     */     
/* 262 */     FloorFightRes _o_ = this;
/* 263 */     List<String> names = new ArrayList();
/* 264 */     names.addAll(_o_.names);
/* 265 */     return names;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getKilltime()
/*     */   {
/* 272 */     _xdb_verify_unsafe_();
/* 273 */     return this.killtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getUsedtime()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     return this.usedtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRadioid()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     return this.radioid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setKilltime(int _v_)
/*     */   {
/* 296 */     _xdb_verify_unsafe_();
/* 297 */     xdb.Logs.logIf(new LogKey(this, "killtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 301 */         new xdb.logs.LogInt(this, FloorFightRes.this.killtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 305 */             FloorFightRes.this.killtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 309 */     });
/* 310 */     this.killtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUsedtime(int _v_)
/*     */   {
/* 317 */     _xdb_verify_unsafe_();
/* 318 */     xdb.Logs.logIf(new LogKey(this, "usedtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 322 */         new xdb.logs.LogInt(this, FloorFightRes.this.usedtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 326 */             FloorFightRes.this.usedtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 330 */     });
/* 331 */     this.usedtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRadioid(long _v_)
/*     */   {
/* 338 */     _xdb_verify_unsafe_();
/* 339 */     xdb.Logs.logIf(new LogKey(this, "radioid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 343 */         new xdb.logs.LogLong(this, FloorFightRes.this.radioid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 347 */             FloorFightRes.this.radioid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 351 */     });
/* 352 */     this.radioid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 358 */     _xdb_verify_unsafe_();
/* 359 */     FloorFightRes _o_ = null;
/* 360 */     if ((_o1_ instanceof FloorFightRes)) { _o_ = (FloorFightRes)_o1_;
/* 361 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 362 */       return false;
/* 363 */     if (!this.names.equals(_o_.names)) return false;
/* 364 */     if (this.killtime != _o_.killtime) return false;
/* 365 */     if (this.usedtime != _o_.usedtime) return false;
/* 366 */     if (this.radioid != _o_.radioid) return false;
/* 367 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 373 */     _xdb_verify_unsafe_();
/* 374 */     int _h_ = 0;
/* 375 */     _h_ += this.names.hashCode();
/* 376 */     _h_ += this.killtime;
/* 377 */     _h_ += this.usedtime;
/* 378 */     _h_ = (int)(_h_ + this.radioid);
/* 379 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 385 */     _xdb_verify_unsafe_();
/* 386 */     StringBuilder _sb_ = new StringBuilder();
/* 387 */     _sb_.append("(");
/* 388 */     _sb_.append(this.names);
/* 389 */     _sb_.append(",");
/* 390 */     _sb_.append(this.killtime);
/* 391 */     _sb_.append(",");
/* 392 */     _sb_.append(this.usedtime);
/* 393 */     _sb_.append(",");
/* 394 */     _sb_.append(this.radioid);
/* 395 */     _sb_.append(")");
/* 396 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 402 */     ListenableBean lb = new ListenableBean();
/* 403 */     lb.add(new ListenableChanged().setVarName("names"));
/* 404 */     lb.add(new ListenableChanged().setVarName("killtime"));
/* 405 */     lb.add(new ListenableChanged().setVarName("usedtime"));
/* 406 */     lb.add(new ListenableChanged().setVarName("radioid"));
/* 407 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FloorFightRes {
/*     */     private Const() {}
/*     */     
/*     */     FloorFightRes nThis() {
/* 414 */       return FloorFightRes.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 420 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FloorFightRes copy()
/*     */     {
/* 426 */       return FloorFightRes.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FloorFightRes toData()
/*     */     {
/* 432 */       return FloorFightRes.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FloorFightRes toBean()
/*     */     {
/* 437 */       return FloorFightRes.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FloorFightRes toDataIf()
/*     */     {
/* 443 */       return FloorFightRes.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FloorFightRes toBeanIf()
/*     */     {
/* 448 */       return FloorFightRes.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<String> getNames()
/*     */     {
/* 455 */       FloorFightRes.this._xdb_verify_unsafe_();
/* 456 */       return xdb.Consts.constList(FloorFightRes.this.names);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<String> getNamesAsData()
/*     */     {
/* 462 */       FloorFightRes.this._xdb_verify_unsafe_();
/*     */       
/* 464 */       FloorFightRes _o_ = FloorFightRes.this;
/* 465 */       List<String> names = new ArrayList();
/* 466 */       names.addAll(_o_.names);
/* 467 */       return names;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getKilltime()
/*     */     {
/* 474 */       FloorFightRes.this._xdb_verify_unsafe_();
/* 475 */       return FloorFightRes.this.killtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getUsedtime()
/*     */     {
/* 482 */       FloorFightRes.this._xdb_verify_unsafe_();
/* 483 */       return FloorFightRes.this.usedtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRadioid()
/*     */     {
/* 490 */       FloorFightRes.this._xdb_verify_unsafe_();
/* 491 */       return FloorFightRes.this.radioid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setKilltime(int _v_)
/*     */     {
/* 498 */       FloorFightRes.this._xdb_verify_unsafe_();
/* 499 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUsedtime(int _v_)
/*     */     {
/* 506 */       FloorFightRes.this._xdb_verify_unsafe_();
/* 507 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRadioid(long _v_)
/*     */     {
/* 514 */       FloorFightRes.this._xdb_verify_unsafe_();
/* 515 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 521 */       FloorFightRes.this._xdb_verify_unsafe_();
/* 522 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 528 */       FloorFightRes.this._xdb_verify_unsafe_();
/* 529 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 535 */       return FloorFightRes.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 541 */       return FloorFightRes.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 547 */       FloorFightRes.this._xdb_verify_unsafe_();
/* 548 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 554 */       return FloorFightRes.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 560 */       return FloorFightRes.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 566 */       FloorFightRes.this._xdb_verify_unsafe_();
/* 567 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 573 */       return FloorFightRes.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 579 */       return FloorFightRes.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 585 */       return FloorFightRes.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 591 */       return FloorFightRes.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 597 */       return FloorFightRes.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 603 */       return FloorFightRes.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 609 */       return FloorFightRes.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FloorFightRes
/*     */   {
/*     */     private ArrayList<String> names;
/*     */     
/*     */     private int killtime;
/*     */     
/*     */     private int usedtime;
/*     */     
/*     */     private long radioid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 627 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 632 */       this.names = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.FloorFightRes _o1_)
/*     */     {
/* 637 */       if ((_o1_ instanceof FloorFightRes)) { assign((FloorFightRes)_o1_);
/* 638 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 639 */       } else if ((_o1_ instanceof FloorFightRes.Const)) assign(((FloorFightRes.Const)_o1_).nThis()); else {
/* 640 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FloorFightRes _o_) {
/* 645 */       this.names = new ArrayList();
/* 646 */       this.names.addAll(_o_.names);
/* 647 */       this.killtime = _o_.killtime;
/* 648 */       this.usedtime = _o_.usedtime;
/* 649 */       this.radioid = _o_.radioid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 654 */       this.names = new ArrayList();
/* 655 */       this.names.addAll(_o_.names);
/* 656 */       this.killtime = _o_.killtime;
/* 657 */       this.usedtime = _o_.usedtime;
/* 658 */       this.radioid = _o_.radioid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 664 */       _os_.compact_uint32(this.names.size());
/* 665 */       for (String _v_ : this.names)
/*     */       {
/* 667 */         _os_.marshal(_v_, "UTF-16LE");
/*     */       }
/* 669 */       _os_.marshal(this.killtime);
/* 670 */       _os_.marshal(this.usedtime);
/* 671 */       _os_.marshal(this.radioid);
/* 672 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 678 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 680 */         String _v_ = "";
/* 681 */         _v_ = _os_.unmarshal_String("UTF-16LE");
/* 682 */         this.names.add(_v_);
/*     */       }
/* 684 */       this.killtime = _os_.unmarshal_int();
/* 685 */       this.usedtime = _os_.unmarshal_int();
/* 686 */       this.radioid = _os_.unmarshal_long();
/* 687 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 693 */       int _size_ = 0;
/* 694 */       for (String _v_ : this.names)
/*     */       {
/*     */         try
/*     */         {
/* 698 */           _size_ += CodedOutputStream.computeBytesSize(1, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */         }
/*     */         catch (java.io.UnsupportedEncodingException e)
/*     */         {
/* 702 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*     */         }
/*     */       }
/* 705 */       _size_ += CodedOutputStream.computeInt32Size(2, this.killtime);
/* 706 */       _size_ += CodedOutputStream.computeInt32Size(3, this.usedtime);
/* 707 */       _size_ += CodedOutputStream.computeInt64Size(4, this.radioid);
/* 708 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 716 */         for (String _v_ : this.names)
/*     */         {
/* 718 */           _output_.writeBytes(1, ppbio.ByteString.copyFrom(_v_, "UTF-16LE"));
/*     */         }
/* 720 */         _output_.writeInt32(2, this.killtime);
/* 721 */         _output_.writeInt32(3, this.usedtime);
/* 722 */         _output_.writeInt64(4, this.radioid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 726 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 728 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 736 */         boolean done = false;
/* 737 */         while (!done)
/*     */         {
/* 739 */           int tag = _input_.readTag();
/* 740 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 744 */             done = true;
/* 745 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 749 */             String _v_ = "";
/* 750 */             _v_ = _input_.readBytes().toString("UTF-16LE");
/* 751 */             this.names.add(_v_);
/* 752 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 756 */             this.killtime = _input_.readInt32();
/* 757 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 761 */             this.usedtime = _input_.readInt32();
/* 762 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 766 */             this.radioid = _input_.readInt64();
/* 767 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 771 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 773 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 782 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 786 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 788 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FloorFightRes copy()
/*     */     {
/* 794 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FloorFightRes toData()
/*     */     {
/* 800 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FloorFightRes toBean()
/*     */     {
/* 805 */       return new FloorFightRes(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FloorFightRes toDataIf()
/*     */     {
/* 811 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FloorFightRes toBeanIf()
/*     */     {
/* 816 */       return new FloorFightRes(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 822 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 826 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 830 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 834 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 838 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 842 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 846 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<String> getNames()
/*     */     {
/* 853 */       return this.names;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<String> getNamesAsData()
/*     */     {
/* 860 */       return this.names;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getKilltime()
/*     */     {
/* 867 */       return this.killtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getUsedtime()
/*     */     {
/* 874 */       return this.usedtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRadioid()
/*     */     {
/* 881 */       return this.radioid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setKilltime(int _v_)
/*     */     {
/* 888 */       this.killtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setUsedtime(int _v_)
/*     */     {
/* 895 */       this.usedtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRadioid(long _v_)
/*     */     {
/* 902 */       this.radioid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 908 */       if (!(_o1_ instanceof Data)) return false;
/* 909 */       Data _o_ = (Data)_o1_;
/* 910 */       if (!this.names.equals(_o_.names)) return false;
/* 911 */       if (this.killtime != _o_.killtime) return false;
/* 912 */       if (this.usedtime != _o_.usedtime) return false;
/* 913 */       if (this.radioid != _o_.radioid) return false;
/* 914 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 920 */       int _h_ = 0;
/* 921 */       _h_ += this.names.hashCode();
/* 922 */       _h_ += this.killtime;
/* 923 */       _h_ += this.usedtime;
/* 924 */       _h_ = (int)(_h_ + this.radioid);
/* 925 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 931 */       StringBuilder _sb_ = new StringBuilder();
/* 932 */       _sb_.append("(");
/* 933 */       _sb_.append(this.names);
/* 934 */       _sb_.append(",");
/* 935 */       _sb_.append(this.killtime);
/* 936 */       _sb_.append(",");
/* 937 */       _sb_.append(this.usedtime);
/* 938 */       _sb_.append(",");
/* 939 */       _sb_.append(this.radioid);
/* 940 */       _sb_.append(")");
/* 941 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FloorFightRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */