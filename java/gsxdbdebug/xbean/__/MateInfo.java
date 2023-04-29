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
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class MateInfo extends XBean implements xbean.MateInfo
/*     */ {
/*     */   private String role_name;
/*     */   private int animal_cfgid;
/*     */   private long mate_time;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.role_name = "";
/*  23 */     this.animal_cfgid = 0;
/*  24 */     this.mate_time = 0L;
/*     */   }
/*     */   
/*     */   MateInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.role_name = "";
/*     */   }
/*     */   
/*     */   public MateInfo()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MateInfo(MateInfo _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MateInfo(xbean.MateInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof MateInfo)) { assign((MateInfo)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MateInfo _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.role_name = _o_.role_name;
/*  56 */     this.animal_cfgid = _o_.animal_cfgid;
/*  57 */     this.mate_time = _o_.mate_time;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  62 */     this.role_name = _o_.role_name;
/*  63 */     this.animal_cfgid = _o_.animal_cfgid;
/*  64 */     this.mate_time = _o_.mate_time;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.role_name, "UTF-16LE");
/*  72 */     _os_.marshal(this.animal_cfgid);
/*  73 */     _os_.marshal(this.mate_time);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.role_name = _os_.unmarshal_String("UTF-16LE");
/*  82 */     this.animal_cfgid = _os_.unmarshal_int();
/*  83 */     this.mate_time = _os_.unmarshal_long();
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     int _size_ = 0;
/*     */     try
/*     */     {
/*  94 */       _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e)
/*     */     {
/*  98 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*     */     }
/* 100 */     _size_ += CodedOutputStream.computeInt32Size(2, this.animal_cfgid);
/* 101 */     _size_ += CodedOutputStream.computeInt64Size(3, this.mate_time);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeBytes(1, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/* 112 */       _output_.writeInt32(2, this.animal_cfgid);
/* 113 */       _output_.writeInt64(3, this.mate_time);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 117 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 119 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 125 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 128 */       boolean done = false;
/* 129 */       while (!done)
/*     */       {
/* 131 */         int tag = _input_.readTag();
/* 132 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 136 */           done = true;
/* 137 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 141 */           this.role_name = _input_.readBytes().toString("UTF-16LE");
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 146 */           this.animal_cfgid = _input_.readInt32();
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 151 */           this.mate_time = _input_.readInt64();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 156 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 158 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 167 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 171 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 173 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MateInfo copy()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new MateInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MateInfo toData()
/*     */   {
/* 186 */     _xdb_verify_unsafe_();
/* 187 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MateInfo toBean()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new MateInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MateInfo toDataIf()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MateInfo toBeanIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getRole_name()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.role_name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getRole_nameOctets()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return Octets.wrap(getRole_name(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getAnimal_cfgid()
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     return this.animal_cfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getMate_time()
/*     */   {
/* 244 */     _xdb_verify_unsafe_();
/* 245 */     return this.mate_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRole_name(String _v_)
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     if (null == _v_)
/* 254 */       throw new NullPointerException();
/* 255 */     xdb.Logs.logIf(new LogKey(this, "role_name")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 259 */         new xdb.logs.LogString(this, MateInfo.this.role_name)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 263 */             MateInfo.this.role_name = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 267 */     });
/* 268 */     this.role_name = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRole_nameOctets(Octets _v_)
/*     */   {
/* 275 */     _xdb_verify_unsafe_();
/* 276 */     setRole_name(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAnimal_cfgid(int _v_)
/*     */   {
/* 283 */     _xdb_verify_unsafe_();
/* 284 */     xdb.Logs.logIf(new LogKey(this, "animal_cfgid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 288 */         new xdb.logs.LogInt(this, MateInfo.this.animal_cfgid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 292 */             MateInfo.this.animal_cfgid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 296 */     });
/* 297 */     this.animal_cfgid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMate_time(long _v_)
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     xdb.Logs.logIf(new LogKey(this, "mate_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 309 */         new xdb.logs.LogLong(this, MateInfo.this.mate_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 313 */             MateInfo.this.mate_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 317 */     });
/* 318 */     this.mate_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     MateInfo _o_ = null;
/* 326 */     if ((_o1_ instanceof MateInfo)) { _o_ = (MateInfo)_o1_;
/* 327 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 328 */       return false;
/* 329 */     if (!this.role_name.equals(_o_.role_name)) return false;
/* 330 */     if (this.animal_cfgid != _o_.animal_cfgid) return false;
/* 331 */     if (this.mate_time != _o_.mate_time) return false;
/* 332 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 338 */     _xdb_verify_unsafe_();
/* 339 */     int _h_ = 0;
/* 340 */     _h_ += this.role_name.hashCode();
/* 341 */     _h_ += this.animal_cfgid;
/* 342 */     _h_ = (int)(_h_ + this.mate_time);
/* 343 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 349 */     _xdb_verify_unsafe_();
/* 350 */     StringBuilder _sb_ = new StringBuilder();
/* 351 */     _sb_.append("(");
/* 352 */     _sb_.append("'").append(this.role_name).append("'");
/* 353 */     _sb_.append(",");
/* 354 */     _sb_.append(this.animal_cfgid);
/* 355 */     _sb_.append(",");
/* 356 */     _sb_.append(this.mate_time);
/* 357 */     _sb_.append(")");
/* 358 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 364 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 365 */     lb.add(new ListenableChanged().setVarName("role_name"));
/* 366 */     lb.add(new ListenableChanged().setVarName("animal_cfgid"));
/* 367 */     lb.add(new ListenableChanged().setVarName("mate_time"));
/* 368 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MateInfo {
/*     */     private Const() {}
/*     */     
/*     */     MateInfo nThis() {
/* 375 */       return MateInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 381 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MateInfo copy()
/*     */     {
/* 387 */       return MateInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MateInfo toData()
/*     */     {
/* 393 */       return MateInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MateInfo toBean()
/*     */     {
/* 398 */       return MateInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MateInfo toDataIf()
/*     */     {
/* 404 */       return MateInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MateInfo toBeanIf()
/*     */     {
/* 409 */       return MateInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getRole_name()
/*     */     {
/* 416 */       MateInfo.this._xdb_verify_unsafe_();
/* 417 */       return MateInfo.this.role_name;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getRole_nameOctets()
/*     */     {
/* 424 */       MateInfo.this._xdb_verify_unsafe_();
/* 425 */       return MateInfo.this.getRole_nameOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAnimal_cfgid()
/*     */     {
/* 432 */       MateInfo.this._xdb_verify_unsafe_();
/* 433 */       return MateInfo.this.animal_cfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getMate_time()
/*     */     {
/* 440 */       MateInfo.this._xdb_verify_unsafe_();
/* 441 */       return MateInfo.this.mate_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRole_name(String _v_)
/*     */     {
/* 448 */       MateInfo.this._xdb_verify_unsafe_();
/* 449 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRole_nameOctets(Octets _v_)
/*     */     {
/* 456 */       MateInfo.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAnimal_cfgid(int _v_)
/*     */     {
/* 464 */       MateInfo.this._xdb_verify_unsafe_();
/* 465 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMate_time(long _v_)
/*     */     {
/* 472 */       MateInfo.this._xdb_verify_unsafe_();
/* 473 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 479 */       MateInfo.this._xdb_verify_unsafe_();
/* 480 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 486 */       MateInfo.this._xdb_verify_unsafe_();
/* 487 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 493 */       return MateInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 499 */       return MateInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 505 */       MateInfo.this._xdb_verify_unsafe_();
/* 506 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 512 */       return MateInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 518 */       return MateInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 524 */       MateInfo.this._xdb_verify_unsafe_();
/* 525 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 531 */       return MateInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 537 */       return MateInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 543 */       return MateInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 549 */       return MateInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 555 */       return MateInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 561 */       return MateInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 567 */       return MateInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MateInfo
/*     */   {
/*     */     private String role_name;
/*     */     
/*     */     private int animal_cfgid;
/*     */     
/*     */     private long mate_time;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 583 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 588 */       this.role_name = "";
/*     */     }
/*     */     
/*     */     Data(xbean.MateInfo _o1_)
/*     */     {
/* 593 */       if ((_o1_ instanceof MateInfo)) { assign((MateInfo)_o1_);
/* 594 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 595 */       } else if ((_o1_ instanceof MateInfo.Const)) assign(((MateInfo.Const)_o1_).nThis()); else {
/* 596 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MateInfo _o_) {
/* 601 */       this.role_name = _o_.role_name;
/* 602 */       this.animal_cfgid = _o_.animal_cfgid;
/* 603 */       this.mate_time = _o_.mate_time;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 608 */       this.role_name = _o_.role_name;
/* 609 */       this.animal_cfgid = _o_.animal_cfgid;
/* 610 */       this.mate_time = _o_.mate_time;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 616 */       _os_.marshal(this.role_name, "UTF-16LE");
/* 617 */       _os_.marshal(this.animal_cfgid);
/* 618 */       _os_.marshal(this.mate_time);
/* 619 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 625 */       this.role_name = _os_.unmarshal_String("UTF-16LE");
/* 626 */       this.animal_cfgid = _os_.unmarshal_int();
/* 627 */       this.mate_time = _os_.unmarshal_long();
/* 628 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 634 */       int _size_ = 0;
/*     */       try
/*     */       {
/* 637 */         _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 641 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/* 643 */       _size_ += CodedOutputStream.computeInt32Size(2, this.animal_cfgid);
/* 644 */       _size_ += CodedOutputStream.computeInt64Size(3, this.mate_time);
/* 645 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 653 */         _output_.writeBytes(1, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/* 654 */         _output_.writeInt32(2, this.animal_cfgid);
/* 655 */         _output_.writeInt64(3, this.mate_time);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 659 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 661 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 669 */         boolean done = false;
/* 670 */         while (!done)
/*     */         {
/* 672 */           int tag = _input_.readTag();
/* 673 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 677 */             done = true;
/* 678 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 682 */             this.role_name = _input_.readBytes().toString("UTF-16LE");
/* 683 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 687 */             this.animal_cfgid = _input_.readInt32();
/* 688 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 692 */             this.mate_time = _input_.readInt64();
/* 693 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 697 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 699 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 708 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 712 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 714 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MateInfo copy()
/*     */     {
/* 720 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MateInfo toData()
/*     */     {
/* 726 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MateInfo toBean()
/*     */     {
/* 731 */       return new MateInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MateInfo toDataIf()
/*     */     {
/* 737 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MateInfo toBeanIf()
/*     */     {
/* 742 */       return new MateInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 748 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 752 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 756 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 760 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 764 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 768 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 772 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getRole_name()
/*     */     {
/* 779 */       return this.role_name;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getRole_nameOctets()
/*     */     {
/* 786 */       return Octets.wrap(getRole_name(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAnimal_cfgid()
/*     */     {
/* 793 */       return this.animal_cfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getMate_time()
/*     */     {
/* 800 */       return this.mate_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRole_name(String _v_)
/*     */     {
/* 807 */       if (null == _v_)
/* 808 */         throw new NullPointerException();
/* 809 */       this.role_name = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRole_nameOctets(Octets _v_)
/*     */     {
/* 816 */       setRole_name(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAnimal_cfgid(int _v_)
/*     */     {
/* 823 */       this.animal_cfgid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMate_time(long _v_)
/*     */     {
/* 830 */       this.mate_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 836 */       if (!(_o1_ instanceof Data)) return false;
/* 837 */       Data _o_ = (Data)_o1_;
/* 838 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 839 */       if (this.animal_cfgid != _o_.animal_cfgid) return false;
/* 840 */       if (this.mate_time != _o_.mate_time) return false;
/* 841 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 847 */       int _h_ = 0;
/* 848 */       _h_ += this.role_name.hashCode();
/* 849 */       _h_ += this.animal_cfgid;
/* 850 */       _h_ = (int)(_h_ + this.mate_time);
/* 851 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 857 */       StringBuilder _sb_ = new StringBuilder();
/* 858 */       _sb_.append("(");
/* 859 */       _sb_.append("'").append(this.role_name).append("'");
/* 860 */       _sb_.append(",");
/* 861 */       _sb_.append(this.animal_cfgid);
/* 862 */       _sb_.append(",");
/* 863 */       _sb_.append(this.mate_time);
/* 864 */       _sb_.append(")");
/* 865 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */