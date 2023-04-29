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
/*     */ public final class GangAnnouncement extends XBean implements xbean.GangAnnouncement
/*     */ {
/*     */   private String announcement;
/*     */   private long modifytime;
/*     */   private long modifierid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.announcement = "";
/*  23 */     this.modifytime = 0L;
/*  24 */     this.modifierid = 0L;
/*     */   }
/*     */   
/*     */   GangAnnouncement(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.announcement = "";
/*     */   }
/*     */   
/*     */   public GangAnnouncement()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GangAnnouncement(GangAnnouncement _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GangAnnouncement(xbean.GangAnnouncement _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof GangAnnouncement)) { assign((GangAnnouncement)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GangAnnouncement _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.announcement = _o_.announcement;
/*  56 */     this.modifytime = _o_.modifytime;
/*  57 */     this.modifierid = _o_.modifierid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  62 */     this.announcement = _o_.announcement;
/*  63 */     this.modifytime = _o_.modifytime;
/*  64 */     this.modifierid = _o_.modifierid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.announcement, "UTF-16LE");
/*  72 */     _os_.marshal(this.modifytime);
/*  73 */     _os_.marshal(this.modifierid);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.announcement = _os_.unmarshal_String("UTF-16LE");
/*  82 */     this.modifytime = _os_.unmarshal_long();
/*  83 */     this.modifierid = _os_.unmarshal_long();
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
/*  94 */       _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.announcement, "UTF-16LE"));
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e)
/*     */     {
/*  98 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*     */     }
/* 100 */     _size_ += CodedOutputStream.computeInt64Size(2, this.modifytime);
/* 101 */     _size_ += CodedOutputStream.computeInt64Size(3, this.modifierid);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeBytes(1, ByteString.copyFrom(this.announcement, "UTF-16LE"));
/* 112 */       _output_.writeInt64(2, this.modifytime);
/* 113 */       _output_.writeInt64(3, this.modifierid);
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
/* 141 */           this.announcement = _input_.readBytes().toString("UTF-16LE");
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 146 */           this.modifytime = _input_.readInt64();
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 151 */           this.modifierid = _input_.readInt64();
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
/*     */   public xbean.GangAnnouncement copy()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new GangAnnouncement(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangAnnouncement toData()
/*     */   {
/* 186 */     _xdb_verify_unsafe_();
/* 187 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GangAnnouncement toBean()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new GangAnnouncement(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GangAnnouncement toDataIf()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GangAnnouncement toBeanIf()
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
/*     */   public String getAnnouncement()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.announcement;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getAnnouncementOctets()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return Octets.wrap(getAnnouncement(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getModifytime()
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     return this.modifytime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getModifierid()
/*     */   {
/* 244 */     _xdb_verify_unsafe_();
/* 245 */     return this.modifierid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAnnouncement(String _v_)
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     if (null == _v_)
/* 254 */       throw new NullPointerException();
/* 255 */     xdb.Logs.logIf(new LogKey(this, "announcement")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 259 */         new xdb.logs.LogString(this, GangAnnouncement.this.announcement)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 263 */             GangAnnouncement.this.announcement = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 267 */     });
/* 268 */     this.announcement = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAnnouncementOctets(Octets _v_)
/*     */   {
/* 275 */     _xdb_verify_unsafe_();
/* 276 */     setAnnouncement(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setModifytime(long _v_)
/*     */   {
/* 283 */     _xdb_verify_unsafe_();
/* 284 */     xdb.Logs.logIf(new LogKey(this, "modifytime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 288 */         new xdb.logs.LogLong(this, GangAnnouncement.this.modifytime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 292 */             GangAnnouncement.this.modifytime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 296 */     });
/* 297 */     this.modifytime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setModifierid(long _v_)
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     xdb.Logs.logIf(new LogKey(this, "modifierid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 309 */         new xdb.logs.LogLong(this, GangAnnouncement.this.modifierid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 313 */             GangAnnouncement.this.modifierid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 317 */     });
/* 318 */     this.modifierid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     GangAnnouncement _o_ = null;
/* 326 */     if ((_o1_ instanceof GangAnnouncement)) { _o_ = (GangAnnouncement)_o1_;
/* 327 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 328 */       return false;
/* 329 */     if (!this.announcement.equals(_o_.announcement)) return false;
/* 330 */     if (this.modifytime != _o_.modifytime) return false;
/* 331 */     if (this.modifierid != _o_.modifierid) return false;
/* 332 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 338 */     _xdb_verify_unsafe_();
/* 339 */     int _h_ = 0;
/* 340 */     _h_ += this.announcement.hashCode();
/* 341 */     _h_ = (int)(_h_ + this.modifytime);
/* 342 */     _h_ = (int)(_h_ + this.modifierid);
/* 343 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 349 */     _xdb_verify_unsafe_();
/* 350 */     StringBuilder _sb_ = new StringBuilder();
/* 351 */     _sb_.append("(");
/* 352 */     _sb_.append("'").append(this.announcement).append("'");
/* 353 */     _sb_.append(",");
/* 354 */     _sb_.append(this.modifytime);
/* 355 */     _sb_.append(",");
/* 356 */     _sb_.append(this.modifierid);
/* 357 */     _sb_.append(")");
/* 358 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 364 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 365 */     lb.add(new ListenableChanged().setVarName("announcement"));
/* 366 */     lb.add(new ListenableChanged().setVarName("modifytime"));
/* 367 */     lb.add(new ListenableChanged().setVarName("modifierid"));
/* 368 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GangAnnouncement {
/*     */     private Const() {}
/*     */     
/*     */     GangAnnouncement nThis() {
/* 375 */       return GangAnnouncement.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 381 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangAnnouncement copy()
/*     */     {
/* 387 */       return GangAnnouncement.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangAnnouncement toData()
/*     */     {
/* 393 */       return GangAnnouncement.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GangAnnouncement toBean()
/*     */     {
/* 398 */       return GangAnnouncement.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangAnnouncement toDataIf()
/*     */     {
/* 404 */       return GangAnnouncement.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GangAnnouncement toBeanIf()
/*     */     {
/* 409 */       return GangAnnouncement.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getAnnouncement()
/*     */     {
/* 416 */       GangAnnouncement.this._xdb_verify_unsafe_();
/* 417 */       return GangAnnouncement.this.announcement;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getAnnouncementOctets()
/*     */     {
/* 424 */       GangAnnouncement.this._xdb_verify_unsafe_();
/* 425 */       return GangAnnouncement.this.getAnnouncementOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getModifytime()
/*     */     {
/* 432 */       GangAnnouncement.this._xdb_verify_unsafe_();
/* 433 */       return GangAnnouncement.this.modifytime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getModifierid()
/*     */     {
/* 440 */       GangAnnouncement.this._xdb_verify_unsafe_();
/* 441 */       return GangAnnouncement.this.modifierid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAnnouncement(String _v_)
/*     */     {
/* 448 */       GangAnnouncement.this._xdb_verify_unsafe_();
/* 449 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAnnouncementOctets(Octets _v_)
/*     */     {
/* 456 */       GangAnnouncement.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setModifytime(long _v_)
/*     */     {
/* 464 */       GangAnnouncement.this._xdb_verify_unsafe_();
/* 465 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setModifierid(long _v_)
/*     */     {
/* 472 */       GangAnnouncement.this._xdb_verify_unsafe_();
/* 473 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 479 */       GangAnnouncement.this._xdb_verify_unsafe_();
/* 480 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 486 */       GangAnnouncement.this._xdb_verify_unsafe_();
/* 487 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 493 */       return GangAnnouncement.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 499 */       return GangAnnouncement.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 505 */       GangAnnouncement.this._xdb_verify_unsafe_();
/* 506 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 512 */       return GangAnnouncement.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 518 */       return GangAnnouncement.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 524 */       GangAnnouncement.this._xdb_verify_unsafe_();
/* 525 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 531 */       return GangAnnouncement.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 537 */       return GangAnnouncement.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 543 */       return GangAnnouncement.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 549 */       return GangAnnouncement.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 555 */       return GangAnnouncement.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 561 */       return GangAnnouncement.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 567 */       return GangAnnouncement.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GangAnnouncement
/*     */   {
/*     */     private String announcement;
/*     */     
/*     */     private long modifytime;
/*     */     
/*     */     private long modifierid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 583 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 588 */       this.announcement = "";
/*     */     }
/*     */     
/*     */     Data(xbean.GangAnnouncement _o1_)
/*     */     {
/* 593 */       if ((_o1_ instanceof GangAnnouncement)) { assign((GangAnnouncement)_o1_);
/* 594 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 595 */       } else if ((_o1_ instanceof GangAnnouncement.Const)) assign(((GangAnnouncement.Const)_o1_).nThis()); else {
/* 596 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GangAnnouncement _o_) {
/* 601 */       this.announcement = _o_.announcement;
/* 602 */       this.modifytime = _o_.modifytime;
/* 603 */       this.modifierid = _o_.modifierid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 608 */       this.announcement = _o_.announcement;
/* 609 */       this.modifytime = _o_.modifytime;
/* 610 */       this.modifierid = _o_.modifierid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 616 */       _os_.marshal(this.announcement, "UTF-16LE");
/* 617 */       _os_.marshal(this.modifytime);
/* 618 */       _os_.marshal(this.modifierid);
/* 619 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 625 */       this.announcement = _os_.unmarshal_String("UTF-16LE");
/* 626 */       this.modifytime = _os_.unmarshal_long();
/* 627 */       this.modifierid = _os_.unmarshal_long();
/* 628 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 634 */       int _size_ = 0;
/*     */       try
/*     */       {
/* 637 */         _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.announcement, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 641 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/* 643 */       _size_ += CodedOutputStream.computeInt64Size(2, this.modifytime);
/* 644 */       _size_ += CodedOutputStream.computeInt64Size(3, this.modifierid);
/* 645 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 653 */         _output_.writeBytes(1, ByteString.copyFrom(this.announcement, "UTF-16LE"));
/* 654 */         _output_.writeInt64(2, this.modifytime);
/* 655 */         _output_.writeInt64(3, this.modifierid);
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
/* 682 */             this.announcement = _input_.readBytes().toString("UTF-16LE");
/* 683 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 687 */             this.modifytime = _input_.readInt64();
/* 688 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 692 */             this.modifierid = _input_.readInt64();
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
/*     */     public xbean.GangAnnouncement copy()
/*     */     {
/* 720 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangAnnouncement toData()
/*     */     {
/* 726 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GangAnnouncement toBean()
/*     */     {
/* 731 */       return new GangAnnouncement(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GangAnnouncement toDataIf()
/*     */     {
/* 737 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GangAnnouncement toBeanIf()
/*     */     {
/* 742 */       return new GangAnnouncement(this, null, null);
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
/*     */     public String getAnnouncement()
/*     */     {
/* 779 */       return this.announcement;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getAnnouncementOctets()
/*     */     {
/* 786 */       return Octets.wrap(getAnnouncement(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getModifytime()
/*     */     {
/* 793 */       return this.modifytime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getModifierid()
/*     */     {
/* 800 */       return this.modifierid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAnnouncement(String _v_)
/*     */     {
/* 807 */       if (null == _v_)
/* 808 */         throw new NullPointerException();
/* 809 */       this.announcement = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAnnouncementOctets(Octets _v_)
/*     */     {
/* 816 */       setAnnouncement(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setModifytime(long _v_)
/*     */     {
/* 823 */       this.modifytime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setModifierid(long _v_)
/*     */     {
/* 830 */       this.modifierid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 836 */       if (!(_o1_ instanceof Data)) return false;
/* 837 */       Data _o_ = (Data)_o1_;
/* 838 */       if (!this.announcement.equals(_o_.announcement)) return false;
/* 839 */       if (this.modifytime != _o_.modifytime) return false;
/* 840 */       if (this.modifierid != _o_.modifierid) return false;
/* 841 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 847 */       int _h_ = 0;
/* 848 */       _h_ += this.announcement.hashCode();
/* 849 */       _h_ = (int)(_h_ + this.modifytime);
/* 850 */       _h_ = (int)(_h_ + this.modifierid);
/* 851 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 857 */       StringBuilder _sb_ = new StringBuilder();
/* 858 */       _sb_.append("(");
/* 859 */       _sb_.append("'").append(this.announcement).append("'");
/* 860 */       _sb_.append(",");
/* 861 */       _sb_.append(this.modifytime);
/* 862 */       _sb_.append(",");
/* 863 */       _sb_.append(this.modifierid);
/* 864 */       _sb_.append(")");
/* 865 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GangAnnouncement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */