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
/*     */ public final class RoleFeedInfo extends XBean implements xbean.RoleFeedInfo
/*     */ {
/*     */   private long roleid;
/*     */   private long feed_timestamp;
/*     */   private String role_name;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.roleid = 0L;
/*  23 */     this.feed_timestamp = 0L;
/*  24 */     this.role_name = "";
/*     */   }
/*     */   
/*     */   RoleFeedInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.role_name = "";
/*     */   }
/*     */   
/*     */   public RoleFeedInfo()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoleFeedInfo(RoleFeedInfo _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoleFeedInfo(xbean.RoleFeedInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof RoleFeedInfo)) { assign((RoleFeedInfo)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoleFeedInfo _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.roleid = _o_.roleid;
/*  56 */     this.feed_timestamp = _o_.feed_timestamp;
/*  57 */     this.role_name = _o_.role_name;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  62 */     this.roleid = _o_.roleid;
/*  63 */     this.feed_timestamp = _o_.feed_timestamp;
/*  64 */     this.role_name = _o_.role_name;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.roleid);
/*  72 */     _os_.marshal(this.feed_timestamp);
/*  73 */     _os_.marshal(this.role_name, "UTF-16LE");
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.roleid = _os_.unmarshal_long();
/*  82 */     this.feed_timestamp = _os_.unmarshal_long();
/*  83 */     this.role_name = _os_.unmarshal_String("UTF-16LE");
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     int _size_ = 0;
/*  92 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*  93 */     _size_ += CodedOutputStream.computeInt64Size(2, this.feed_timestamp);
/*     */     try
/*     */     {
/*  96 */       _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e)
/*     */     {
/* 100 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*     */     }
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt64(1, this.roleid);
/* 112 */       _output_.writeInt64(2, this.feed_timestamp);
/* 113 */       _output_.writeBytes(3, ByteString.copyFrom(this.role_name, "UTF-16LE"));
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
/*     */         case 8: 
/* 141 */           this.roleid = _input_.readInt64();
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 146 */           this.feed_timestamp = _input_.readInt64();
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 26: 
/* 151 */           this.role_name = _input_.readBytes().toString("UTF-16LE");
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
/*     */   public xbean.RoleFeedInfo copy()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new RoleFeedInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleFeedInfo toData()
/*     */   {
/* 186 */     _xdb_verify_unsafe_();
/* 187 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleFeedInfo toBean()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new RoleFeedInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoleFeedInfo toDataIf()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoleFeedInfo toBeanIf()
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
/*     */   public long getRoleid()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.roleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getFeed_timestamp()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.feed_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getRole_name()
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     return this.role_name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getRole_nameOctets()
/*     */   {
/* 244 */     _xdb_verify_unsafe_();
/* 245 */     return Octets.wrap(getRole_name(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoleid(long _v_)
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     xdb.Logs.logIf(new LogKey(this, "roleid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 257 */         new xdb.logs.LogLong(this, RoleFeedInfo.this.roleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 261 */             RoleFeedInfo.this.roleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 265 */     });
/* 266 */     this.roleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFeed_timestamp(long _v_)
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     xdb.Logs.logIf(new LogKey(this, "feed_timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 278 */         new xdb.logs.LogLong(this, RoleFeedInfo.this.feed_timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 282 */             RoleFeedInfo.this.feed_timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 286 */     });
/* 287 */     this.feed_timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRole_name(String _v_)
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/* 295 */     if (null == _v_)
/* 296 */       throw new NullPointerException();
/* 297 */     xdb.Logs.logIf(new LogKey(this, "role_name")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 301 */         new xdb.logs.LogString(this, RoleFeedInfo.this.role_name)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 305 */             RoleFeedInfo.this.role_name = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 309 */     });
/* 310 */     this.role_name = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRole_nameOctets(Octets _v_)
/*     */   {
/* 317 */     _xdb_verify_unsafe_();
/* 318 */     setRole_name(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     RoleFeedInfo _o_ = null;
/* 326 */     if ((_o1_ instanceof RoleFeedInfo)) { _o_ = (RoleFeedInfo)_o1_;
/* 327 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 328 */       return false;
/* 329 */     if (this.roleid != _o_.roleid) return false;
/* 330 */     if (this.feed_timestamp != _o_.feed_timestamp) return false;
/* 331 */     if (!this.role_name.equals(_o_.role_name)) return false;
/* 332 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 338 */     _xdb_verify_unsafe_();
/* 339 */     int _h_ = 0;
/* 340 */     _h_ = (int)(_h_ + this.roleid);
/* 341 */     _h_ = (int)(_h_ + this.feed_timestamp);
/* 342 */     _h_ += this.role_name.hashCode();
/* 343 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 349 */     _xdb_verify_unsafe_();
/* 350 */     StringBuilder _sb_ = new StringBuilder();
/* 351 */     _sb_.append("(");
/* 352 */     _sb_.append(this.roleid);
/* 353 */     _sb_.append(",");
/* 354 */     _sb_.append(this.feed_timestamp);
/* 355 */     _sb_.append(",");
/* 356 */     _sb_.append("'").append(this.role_name).append("'");
/* 357 */     _sb_.append(")");
/* 358 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 364 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 365 */     lb.add(new ListenableChanged().setVarName("roleid"));
/* 366 */     lb.add(new ListenableChanged().setVarName("feed_timestamp"));
/* 367 */     lb.add(new ListenableChanged().setVarName("role_name"));
/* 368 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoleFeedInfo {
/*     */     private Const() {}
/*     */     
/*     */     RoleFeedInfo nThis() {
/* 375 */       return RoleFeedInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 381 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFeedInfo copy()
/*     */     {
/* 387 */       return RoleFeedInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFeedInfo toData()
/*     */     {
/* 393 */       return RoleFeedInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoleFeedInfo toBean()
/*     */     {
/* 398 */       return RoleFeedInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFeedInfo toDataIf()
/*     */     {
/* 404 */       return RoleFeedInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoleFeedInfo toBeanIf()
/*     */     {
/* 409 */       return RoleFeedInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleid()
/*     */     {
/* 416 */       RoleFeedInfo.this._xdb_verify_unsafe_();
/* 417 */       return RoleFeedInfo.this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFeed_timestamp()
/*     */     {
/* 424 */       RoleFeedInfo.this._xdb_verify_unsafe_();
/* 425 */       return RoleFeedInfo.this.feed_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getRole_name()
/*     */     {
/* 432 */       RoleFeedInfo.this._xdb_verify_unsafe_();
/* 433 */       return RoleFeedInfo.this.role_name;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getRole_nameOctets()
/*     */     {
/* 440 */       RoleFeedInfo.this._xdb_verify_unsafe_();
/* 441 */       return RoleFeedInfo.this.getRole_nameOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 448 */       RoleFeedInfo.this._xdb_verify_unsafe_();
/* 449 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFeed_timestamp(long _v_)
/*     */     {
/* 456 */       RoleFeedInfo.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRole_name(String _v_)
/*     */     {
/* 464 */       RoleFeedInfo.this._xdb_verify_unsafe_();
/* 465 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRole_nameOctets(Octets _v_)
/*     */     {
/* 472 */       RoleFeedInfo.this._xdb_verify_unsafe_();
/* 473 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 479 */       RoleFeedInfo.this._xdb_verify_unsafe_();
/* 480 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 486 */       RoleFeedInfo.this._xdb_verify_unsafe_();
/* 487 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 493 */       return RoleFeedInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 499 */       return RoleFeedInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 505 */       RoleFeedInfo.this._xdb_verify_unsafe_();
/* 506 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 512 */       return RoleFeedInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 518 */       return RoleFeedInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 524 */       RoleFeedInfo.this._xdb_verify_unsafe_();
/* 525 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 531 */       return RoleFeedInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 537 */       return RoleFeedInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 543 */       return RoleFeedInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 549 */       return RoleFeedInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 555 */       return RoleFeedInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 561 */       return RoleFeedInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 567 */       return RoleFeedInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoleFeedInfo
/*     */   {
/*     */     private long roleid;
/*     */     
/*     */     private long feed_timestamp;
/*     */     
/*     */     private String role_name;
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
/*     */     Data(xbean.RoleFeedInfo _o1_)
/*     */     {
/* 593 */       if ((_o1_ instanceof RoleFeedInfo)) { assign((RoleFeedInfo)_o1_);
/* 594 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 595 */       } else if ((_o1_ instanceof RoleFeedInfo.Const)) assign(((RoleFeedInfo.Const)_o1_).nThis()); else {
/* 596 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoleFeedInfo _o_) {
/* 601 */       this.roleid = _o_.roleid;
/* 602 */       this.feed_timestamp = _o_.feed_timestamp;
/* 603 */       this.role_name = _o_.role_name;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 608 */       this.roleid = _o_.roleid;
/* 609 */       this.feed_timestamp = _o_.feed_timestamp;
/* 610 */       this.role_name = _o_.role_name;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 616 */       _os_.marshal(this.roleid);
/* 617 */       _os_.marshal(this.feed_timestamp);
/* 618 */       _os_.marshal(this.role_name, "UTF-16LE");
/* 619 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 625 */       this.roleid = _os_.unmarshal_long();
/* 626 */       this.feed_timestamp = _os_.unmarshal_long();
/* 627 */       this.role_name = _os_.unmarshal_String("UTF-16LE");
/* 628 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 634 */       int _size_ = 0;
/* 635 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/* 636 */       _size_ += CodedOutputStream.computeInt64Size(2, this.feed_timestamp);
/*     */       try
/*     */       {
/* 639 */         _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.role_name, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 643 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/* 645 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 653 */         _output_.writeInt64(1, this.roleid);
/* 654 */         _output_.writeInt64(2, this.feed_timestamp);
/* 655 */         _output_.writeBytes(3, ByteString.copyFrom(this.role_name, "UTF-16LE"));
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
/*     */           case 8: 
/* 682 */             this.roleid = _input_.readInt64();
/* 683 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 687 */             this.feed_timestamp = _input_.readInt64();
/* 688 */             break;
/*     */           
/*     */ 
/*     */           case 26: 
/* 692 */             this.role_name = _input_.readBytes().toString("UTF-16LE");
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
/*     */     public xbean.RoleFeedInfo copy()
/*     */     {
/* 720 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFeedInfo toData()
/*     */     {
/* 726 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoleFeedInfo toBean()
/*     */     {
/* 731 */       return new RoleFeedInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoleFeedInfo toDataIf()
/*     */     {
/* 737 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoleFeedInfo toBeanIf()
/*     */     {
/* 742 */       return new RoleFeedInfo(this, null, null);
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
/*     */     public long getRoleid()
/*     */     {
/* 779 */       return this.roleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getFeed_timestamp()
/*     */     {
/* 786 */       return this.feed_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getRole_name()
/*     */     {
/* 793 */       return this.role_name;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getRole_nameOctets()
/*     */     {
/* 800 */       return Octets.wrap(getRole_name(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleid(long _v_)
/*     */     {
/* 807 */       this.roleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFeed_timestamp(long _v_)
/*     */     {
/* 814 */       this.feed_timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRole_name(String _v_)
/*     */     {
/* 821 */       if (null == _v_)
/* 822 */         throw new NullPointerException();
/* 823 */       this.role_name = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRole_nameOctets(Octets _v_)
/*     */     {
/* 830 */       setRole_name(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 836 */       if (!(_o1_ instanceof Data)) return false;
/* 837 */       Data _o_ = (Data)_o1_;
/* 838 */       if (this.roleid != _o_.roleid) return false;
/* 839 */       if (this.feed_timestamp != _o_.feed_timestamp) return false;
/* 840 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 841 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 847 */       int _h_ = 0;
/* 848 */       _h_ = (int)(_h_ + this.roleid);
/* 849 */       _h_ = (int)(_h_ + this.feed_timestamp);
/* 850 */       _h_ += this.role_name.hashCode();
/* 851 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 857 */       StringBuilder _sb_ = new StringBuilder();
/* 858 */       _sb_.append("(");
/* 859 */       _sb_.append(this.roleid);
/* 860 */       _sb_.append(",");
/* 861 */       _sb_.append(this.feed_timestamp);
/* 862 */       _sb_.append(",");
/* 863 */       _sb_.append("'").append(this.role_name).append("'");
/* 864 */       _sb_.append(")");
/* 865 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleFeedInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */