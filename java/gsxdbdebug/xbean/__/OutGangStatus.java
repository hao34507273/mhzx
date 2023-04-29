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
/*     */ public final class OutGangStatus extends XBean implements xbean.OutGangStatus
/*     */ {
/*     */   private String groupopenid;
/*     */   private long gangid;
/*     */   private long createtime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.groupopenid = "";
/*  23 */     this.gangid = 0L;
/*  24 */     this.createtime = 0L;
/*     */   }
/*     */   
/*     */   OutGangStatus(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.groupopenid = "";
/*     */   }
/*     */   
/*     */   public OutGangStatus()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public OutGangStatus(OutGangStatus _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   OutGangStatus(xbean.OutGangStatus _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof OutGangStatus)) { assign((OutGangStatus)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(OutGangStatus _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.groupopenid = _o_.groupopenid;
/*  56 */     this.gangid = _o_.gangid;
/*  57 */     this.createtime = _o_.createtime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  62 */     this.groupopenid = _o_.groupopenid;
/*  63 */     this.gangid = _o_.gangid;
/*  64 */     this.createtime = _o_.createtime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.groupopenid, "UTF-16LE");
/*  72 */     _os_.marshal(this.gangid);
/*  73 */     _os_.marshal(this.createtime);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.groupopenid = _os_.unmarshal_String("UTF-16LE");
/*  82 */     this.gangid = _os_.unmarshal_long();
/*  83 */     this.createtime = _os_.unmarshal_long();
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
/*  94 */       _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.groupopenid, "UTF-16LE"));
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e)
/*     */     {
/*  98 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*     */     }
/* 100 */     _size_ += CodedOutputStream.computeInt64Size(4, this.gangid);
/* 101 */     _size_ += CodedOutputStream.computeInt64Size(5, this.createtime);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeBytes(2, ByteString.copyFrom(this.groupopenid, "UTF-16LE"));
/* 112 */       _output_.writeInt64(4, this.gangid);
/* 113 */       _output_.writeInt64(5, this.createtime);
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
/*     */         case 18: 
/* 141 */           this.groupopenid = _input_.readBytes().toString("UTF-16LE");
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 146 */           this.gangid = _input_.readInt64();
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 40: 
/* 151 */           this.createtime = _input_.readInt64();
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
/*     */   public xbean.OutGangStatus copy()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new OutGangStatus(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.OutGangStatus toData()
/*     */   {
/* 186 */     _xdb_verify_unsafe_();
/* 187 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.OutGangStatus toBean()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new OutGangStatus(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.OutGangStatus toDataIf()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.OutGangStatus toBeanIf()
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
/*     */   public String getGroupopenid()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.groupopenid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getGroupopenidOctets()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return Octets.wrap(getGroupopenid(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getGangid()
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     return this.gangid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getCreatetime()
/*     */   {
/* 244 */     _xdb_verify_unsafe_();
/* 245 */     return this.createtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGroupopenid(String _v_)
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     if (null == _v_)
/* 254 */       throw new NullPointerException();
/* 255 */     xdb.Logs.logIf(new LogKey(this, "groupopenid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 259 */         new xdb.logs.LogString(this, OutGangStatus.this.groupopenid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 263 */             OutGangStatus.this.groupopenid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 267 */     });
/* 268 */     this.groupopenid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGroupopenidOctets(Octets _v_)
/*     */   {
/* 275 */     _xdb_verify_unsafe_();
/* 276 */     setGroupopenid(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGangid(long _v_)
/*     */   {
/* 283 */     _xdb_verify_unsafe_();
/* 284 */     xdb.Logs.logIf(new LogKey(this, "gangid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 288 */         new xdb.logs.LogLong(this, OutGangStatus.this.gangid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 292 */             OutGangStatus.this.gangid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 296 */     });
/* 297 */     this.gangid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreatetime(long _v_)
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     xdb.Logs.logIf(new LogKey(this, "createtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 309 */         new xdb.logs.LogLong(this, OutGangStatus.this.createtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 313 */             OutGangStatus.this.createtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 317 */     });
/* 318 */     this.createtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     OutGangStatus _o_ = null;
/* 326 */     if ((_o1_ instanceof OutGangStatus)) { _o_ = (OutGangStatus)_o1_;
/* 327 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 328 */       return false;
/* 329 */     if (!this.groupopenid.equals(_o_.groupopenid)) return false;
/* 330 */     if (this.gangid != _o_.gangid) return false;
/* 331 */     if (this.createtime != _o_.createtime) return false;
/* 332 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 338 */     _xdb_verify_unsafe_();
/* 339 */     int _h_ = 0;
/* 340 */     _h_ += this.groupopenid.hashCode();
/* 341 */     _h_ = (int)(_h_ + this.gangid);
/* 342 */     _h_ = (int)(_h_ + this.createtime);
/* 343 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 349 */     _xdb_verify_unsafe_();
/* 350 */     StringBuilder _sb_ = new StringBuilder();
/* 351 */     _sb_.append("(");
/* 352 */     _sb_.append("'").append(this.groupopenid).append("'");
/* 353 */     _sb_.append(",");
/* 354 */     _sb_.append(this.gangid);
/* 355 */     _sb_.append(",");
/* 356 */     _sb_.append(this.createtime);
/* 357 */     _sb_.append(")");
/* 358 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 364 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 365 */     lb.add(new ListenableChanged().setVarName("groupopenid"));
/* 366 */     lb.add(new ListenableChanged().setVarName("gangid"));
/* 367 */     lb.add(new ListenableChanged().setVarName("createtime"));
/* 368 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.OutGangStatus {
/*     */     private Const() {}
/*     */     
/*     */     OutGangStatus nThis() {
/* 375 */       return OutGangStatus.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 381 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.OutGangStatus copy()
/*     */     {
/* 387 */       return OutGangStatus.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.OutGangStatus toData()
/*     */     {
/* 393 */       return OutGangStatus.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.OutGangStatus toBean()
/*     */     {
/* 398 */       return OutGangStatus.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.OutGangStatus toDataIf()
/*     */     {
/* 404 */       return OutGangStatus.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.OutGangStatus toBeanIf()
/*     */     {
/* 409 */       return OutGangStatus.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getGroupopenid()
/*     */     {
/* 416 */       OutGangStatus.this._xdb_verify_unsafe_();
/* 417 */       return OutGangStatus.this.groupopenid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getGroupopenidOctets()
/*     */     {
/* 424 */       OutGangStatus.this._xdb_verify_unsafe_();
/* 425 */       return OutGangStatus.this.getGroupopenidOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getGangid()
/*     */     {
/* 432 */       OutGangStatus.this._xdb_verify_unsafe_();
/* 433 */       return OutGangStatus.this.gangid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCreatetime()
/*     */     {
/* 440 */       OutGangStatus.this._xdb_verify_unsafe_();
/* 441 */       return OutGangStatus.this.createtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGroupopenid(String _v_)
/*     */     {
/* 448 */       OutGangStatus.this._xdb_verify_unsafe_();
/* 449 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGroupopenidOctets(Octets _v_)
/*     */     {
/* 456 */       OutGangStatus.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGangid(long _v_)
/*     */     {
/* 464 */       OutGangStatus.this._xdb_verify_unsafe_();
/* 465 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCreatetime(long _v_)
/*     */     {
/* 472 */       OutGangStatus.this._xdb_verify_unsafe_();
/* 473 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 479 */       OutGangStatus.this._xdb_verify_unsafe_();
/* 480 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 486 */       OutGangStatus.this._xdb_verify_unsafe_();
/* 487 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 493 */       return OutGangStatus.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 499 */       return OutGangStatus.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 505 */       OutGangStatus.this._xdb_verify_unsafe_();
/* 506 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 512 */       return OutGangStatus.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 518 */       return OutGangStatus.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 524 */       OutGangStatus.this._xdb_verify_unsafe_();
/* 525 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 531 */       return OutGangStatus.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 537 */       return OutGangStatus.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 543 */       return OutGangStatus.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 549 */       return OutGangStatus.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 555 */       return OutGangStatus.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 561 */       return OutGangStatus.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 567 */       return OutGangStatus.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.OutGangStatus
/*     */   {
/*     */     private String groupopenid;
/*     */     
/*     */     private long gangid;
/*     */     
/*     */     private long createtime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 583 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 588 */       this.groupopenid = "";
/*     */     }
/*     */     
/*     */     Data(xbean.OutGangStatus _o1_)
/*     */     {
/* 593 */       if ((_o1_ instanceof OutGangStatus)) { assign((OutGangStatus)_o1_);
/* 594 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 595 */       } else if ((_o1_ instanceof OutGangStatus.Const)) assign(((OutGangStatus.Const)_o1_).nThis()); else {
/* 596 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(OutGangStatus _o_) {
/* 601 */       this.groupopenid = _o_.groupopenid;
/* 602 */       this.gangid = _o_.gangid;
/* 603 */       this.createtime = _o_.createtime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 608 */       this.groupopenid = _o_.groupopenid;
/* 609 */       this.gangid = _o_.gangid;
/* 610 */       this.createtime = _o_.createtime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 616 */       _os_.marshal(this.groupopenid, "UTF-16LE");
/* 617 */       _os_.marshal(this.gangid);
/* 618 */       _os_.marshal(this.createtime);
/* 619 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 625 */       this.groupopenid = _os_.unmarshal_String("UTF-16LE");
/* 626 */       this.gangid = _os_.unmarshal_long();
/* 627 */       this.createtime = _os_.unmarshal_long();
/* 628 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 634 */       int _size_ = 0;
/*     */       try
/*     */       {
/* 637 */         _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.groupopenid, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 641 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/* 643 */       _size_ += CodedOutputStream.computeInt64Size(4, this.gangid);
/* 644 */       _size_ += CodedOutputStream.computeInt64Size(5, this.createtime);
/* 645 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 653 */         _output_.writeBytes(2, ByteString.copyFrom(this.groupopenid, "UTF-16LE"));
/* 654 */         _output_.writeInt64(4, this.gangid);
/* 655 */         _output_.writeInt64(5, this.createtime);
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
/*     */           case 18: 
/* 682 */             this.groupopenid = _input_.readBytes().toString("UTF-16LE");
/* 683 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 687 */             this.gangid = _input_.readInt64();
/* 688 */             break;
/*     */           
/*     */ 
/*     */           case 40: 
/* 692 */             this.createtime = _input_.readInt64();
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
/*     */     public xbean.OutGangStatus copy()
/*     */     {
/* 720 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.OutGangStatus toData()
/*     */     {
/* 726 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.OutGangStatus toBean()
/*     */     {
/* 731 */       return new OutGangStatus(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.OutGangStatus toDataIf()
/*     */     {
/* 737 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.OutGangStatus toBeanIf()
/*     */     {
/* 742 */       return new OutGangStatus(this, null, null);
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
/*     */     public String getGroupopenid()
/*     */     {
/* 779 */       return this.groupopenid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getGroupopenidOctets()
/*     */     {
/* 786 */       return Octets.wrap(getGroupopenid(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getGangid()
/*     */     {
/* 793 */       return this.gangid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCreatetime()
/*     */     {
/* 800 */       return this.createtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGroupopenid(String _v_)
/*     */     {
/* 807 */       if (null == _v_)
/* 808 */         throw new NullPointerException();
/* 809 */       this.groupopenid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGroupopenidOctets(Octets _v_)
/*     */     {
/* 816 */       setGroupopenid(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGangid(long _v_)
/*     */     {
/* 823 */       this.gangid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCreatetime(long _v_)
/*     */     {
/* 830 */       this.createtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 836 */       if (!(_o1_ instanceof Data)) return false;
/* 837 */       Data _o_ = (Data)_o1_;
/* 838 */       if (!this.groupopenid.equals(_o_.groupopenid)) return false;
/* 839 */       if (this.gangid != _o_.gangid) return false;
/* 840 */       if (this.createtime != _o_.createtime) return false;
/* 841 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 847 */       int _h_ = 0;
/* 848 */       _h_ += this.groupopenid.hashCode();
/* 849 */       _h_ = (int)(_h_ + this.gangid);
/* 850 */       _h_ = (int)(_h_ + this.createtime);
/* 851 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 857 */       StringBuilder _sb_ = new StringBuilder();
/* 858 */       _sb_.append("(");
/* 859 */       _sb_.append("'").append(this.groupopenid).append("'");
/* 860 */       _sb_.append(",");
/* 861 */       _sb_.append(this.gangid);
/* 862 */       _sb_.append(",");
/* 863 */       _sb_.append(this.createtime);
/* 864 */       _sb_.append(")");
/* 865 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\OutGangStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */