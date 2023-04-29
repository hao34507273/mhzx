/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogObject;
/*      */ 
/*      */ public final class QQVipInfo extends XBean implements xbean.QQVipInfo
/*      */ {
/*      */   private int vip_flag;
/*      */   private boolean is_vip;
/*      */   private boolean is_year;
/*      */   private boolean is_luxury;
/*      */   private int level;
/*      */   private int expire_timestamp;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.vip_flag = 0;
/*   29 */     this.is_vip = false;
/*   30 */     this.is_year = false;
/*   31 */     this.is_luxury = false;
/*   32 */     this.level = 0;
/*   33 */     this.expire_timestamp = 0;
/*      */   }
/*      */   
/*      */   QQVipInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*      */   }
/*      */   
/*      */   public QQVipInfo()
/*      */   {
/*   43 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public QQVipInfo(QQVipInfo _o_)
/*      */   {
/*   48 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   QQVipInfo(xbean.QQVipInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     if ((_o1_ instanceof QQVipInfo)) { assign((QQVipInfo)_o1_);
/*   55 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   56 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   57 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(QQVipInfo _o_) {
/*   62 */     _o_._xdb_verify_unsafe_();
/*   63 */     this.vip_flag = _o_.vip_flag;
/*   64 */     this.is_vip = _o_.is_vip;
/*   65 */     this.is_year = _o_.is_year;
/*   66 */     this.is_luxury = _o_.is_luxury;
/*   67 */     this.level = _o_.level;
/*   68 */     this.expire_timestamp = _o_.expire_timestamp;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   73 */     this.vip_flag = _o_.vip_flag;
/*   74 */     this.is_vip = _o_.is_vip;
/*   75 */     this.is_year = _o_.is_year;
/*   76 */     this.is_luxury = _o_.is_luxury;
/*   77 */     this.level = _o_.level;
/*   78 */     this.expire_timestamp = _o_.expire_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   84 */     _xdb_verify_unsafe_();
/*   85 */     _os_.marshal(this.vip_flag);
/*   86 */     _os_.marshal(this.is_vip);
/*   87 */     _os_.marshal(this.is_year);
/*   88 */     _os_.marshal(this.is_luxury);
/*   89 */     _os_.marshal(this.level);
/*   90 */     _os_.marshal(this.expire_timestamp);
/*   91 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*   97 */     _xdb_verify_unsafe_();
/*   98 */     this.vip_flag = _os_.unmarshal_int();
/*   99 */     this.is_vip = _os_.unmarshal_boolean();
/*  100 */     this.is_year = _os_.unmarshal_boolean();
/*  101 */     this.is_luxury = _os_.unmarshal_boolean();
/*  102 */     this.level = _os_.unmarshal_int();
/*  103 */     this.expire_timestamp = _os_.unmarshal_int();
/*  104 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  110 */     _xdb_verify_unsafe_();
/*  111 */     int _size_ = 0;
/*  112 */     _size_ += CodedOutputStream.computeInt32Size(1, this.vip_flag);
/*  113 */     _size_ += CodedOutputStream.computeBoolSize(2, this.is_vip);
/*  114 */     _size_ += CodedOutputStream.computeBoolSize(3, this.is_year);
/*  115 */     _size_ += CodedOutputStream.computeBoolSize(4, this.is_luxury);
/*  116 */     _size_ += CodedOutputStream.computeInt32Size(5, this.level);
/*  117 */     _size_ += CodedOutputStream.computeInt32Size(6, this.expire_timestamp);
/*  118 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  124 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  127 */       _output_.writeInt32(1, this.vip_flag);
/*  128 */       _output_.writeBool(2, this.is_vip);
/*  129 */       _output_.writeBool(3, this.is_year);
/*  130 */       _output_.writeBool(4, this.is_luxury);
/*  131 */       _output_.writeInt32(5, this.level);
/*  132 */       _output_.writeInt32(6, this.expire_timestamp);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  136 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  138 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  147 */       boolean done = false;
/*  148 */       while (!done)
/*      */       {
/*  150 */         int tag = _input_.readTag();
/*  151 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  155 */           done = true;
/*  156 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  160 */           this.vip_flag = _input_.readInt32();
/*  161 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  165 */           this.is_vip = _input_.readBool();
/*  166 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  170 */           this.is_year = _input_.readBool();
/*  171 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  175 */           this.is_luxury = _input_.readBool();
/*  176 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  180 */           this.level = _input_.readInt32();
/*  181 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  185 */           this.expire_timestamp = _input_.readInt32();
/*  186 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  190 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  192 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  201 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  205 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  207 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.QQVipInfo copy()
/*      */   {
/*  213 */     _xdb_verify_unsafe_();
/*  214 */     return new QQVipInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.QQVipInfo toData()
/*      */   {
/*  220 */     _xdb_verify_unsafe_();
/*  221 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.QQVipInfo toBean()
/*      */   {
/*  226 */     _xdb_verify_unsafe_();
/*  227 */     return new QQVipInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.QQVipInfo toDataIf()
/*      */   {
/*  233 */     _xdb_verify_unsafe_();
/*  234 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.QQVipInfo toBeanIf()
/*      */   {
/*  239 */     _xdb_verify_unsafe_();
/*  240 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  246 */     _xdb_verify_unsafe_();
/*  247 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getVip_flag()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return this.vip_flag;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIs_vip()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return this.is_vip;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIs_year()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return this.is_year;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIs_luxury()
/*      */   {
/*  278 */     _xdb_verify_unsafe_();
/*  279 */     return this.is_luxury;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLevel()
/*      */   {
/*  286 */     _xdb_verify_unsafe_();
/*  287 */     return this.level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getExpire_timestamp()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return this.expire_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setVip_flag(int _v_)
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     Logs.logIf(new LogKey(this, "vip_flag")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  307 */         new LogInt(this, QQVipInfo.this.vip_flag)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  311 */             QQVipInfo.this.vip_flag = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  315 */     });
/*  316 */     this.vip_flag = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIs_vip(boolean _v_)
/*      */   {
/*  323 */     _xdb_verify_unsafe_();
/*  324 */     Logs.logIf(new LogKey(this, "is_vip")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  328 */         new LogObject(this, Boolean.valueOf(QQVipInfo.this.is_vip))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  332 */             QQVipInfo.this.is_vip = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  336 */     });
/*  337 */     this.is_vip = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIs_year(boolean _v_)
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*  345 */     Logs.logIf(new LogKey(this, "is_year")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  349 */         new LogObject(this, Boolean.valueOf(QQVipInfo.this.is_year))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  353 */             QQVipInfo.this.is_year = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  357 */     });
/*  358 */     this.is_year = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIs_luxury(boolean _v_)
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*  366 */     Logs.logIf(new LogKey(this, "is_luxury")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  370 */         new LogObject(this, Boolean.valueOf(QQVipInfo.this.is_luxury))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  374 */             QQVipInfo.this.is_luxury = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  378 */     });
/*  379 */     this.is_luxury = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLevel(int _v_)
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*  387 */     Logs.logIf(new LogKey(this, "level")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  391 */         new LogInt(this, QQVipInfo.this.level)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  395 */             QQVipInfo.this.level = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  399 */     });
/*  400 */     this.level = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExpire_timestamp(int _v_)
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*  408 */     Logs.logIf(new LogKey(this, "expire_timestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  412 */         new LogInt(this, QQVipInfo.this.expire_timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  416 */             QQVipInfo.this.expire_timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  420 */     });
/*  421 */     this.expire_timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     QQVipInfo _o_ = null;
/*  429 */     if ((_o1_ instanceof QQVipInfo)) { _o_ = (QQVipInfo)_o1_;
/*  430 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  431 */       return false;
/*  432 */     if (this.vip_flag != _o_.vip_flag) return false;
/*  433 */     if (this.is_vip != _o_.is_vip) return false;
/*  434 */     if (this.is_year != _o_.is_year) return false;
/*  435 */     if (this.is_luxury != _o_.is_luxury) return false;
/*  436 */     if (this.level != _o_.level) return false;
/*  437 */     if (this.expire_timestamp != _o_.expire_timestamp) return false;
/*  438 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  444 */     _xdb_verify_unsafe_();
/*  445 */     int _h_ = 0;
/*  446 */     _h_ += this.vip_flag;
/*  447 */     _h_ += (this.is_vip ? 1231 : 1237);
/*  448 */     _h_ += (this.is_year ? 1231 : 1237);
/*  449 */     _h_ += (this.is_luxury ? 1231 : 1237);
/*  450 */     _h_ += this.level;
/*  451 */     _h_ += this.expire_timestamp;
/*  452 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  458 */     _xdb_verify_unsafe_();
/*  459 */     StringBuilder _sb_ = new StringBuilder();
/*  460 */     _sb_.append("(");
/*  461 */     _sb_.append(this.vip_flag);
/*  462 */     _sb_.append(",");
/*  463 */     _sb_.append(this.is_vip);
/*  464 */     _sb_.append(",");
/*  465 */     _sb_.append(this.is_year);
/*  466 */     _sb_.append(",");
/*  467 */     _sb_.append(this.is_luxury);
/*  468 */     _sb_.append(",");
/*  469 */     _sb_.append(this.level);
/*  470 */     _sb_.append(",");
/*  471 */     _sb_.append(this.expire_timestamp);
/*  472 */     _sb_.append(")");
/*  473 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  479 */     ListenableBean lb = new ListenableBean();
/*  480 */     lb.add(new ListenableChanged().setVarName("vip_flag"));
/*  481 */     lb.add(new ListenableChanged().setVarName("is_vip"));
/*  482 */     lb.add(new ListenableChanged().setVarName("is_year"));
/*  483 */     lb.add(new ListenableChanged().setVarName("is_luxury"));
/*  484 */     lb.add(new ListenableChanged().setVarName("level"));
/*  485 */     lb.add(new ListenableChanged().setVarName("expire_timestamp"));
/*  486 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.QQVipInfo {
/*      */     private Const() {}
/*      */     
/*      */     QQVipInfo nThis() {
/*  493 */       return QQVipInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  499 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.QQVipInfo copy()
/*      */     {
/*  505 */       return QQVipInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.QQVipInfo toData()
/*      */     {
/*  511 */       return QQVipInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.QQVipInfo toBean()
/*      */     {
/*  516 */       return QQVipInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.QQVipInfo toDataIf()
/*      */     {
/*  522 */       return QQVipInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.QQVipInfo toBeanIf()
/*      */     {
/*  527 */       return QQVipInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVip_flag()
/*      */     {
/*  534 */       QQVipInfo.this._xdb_verify_unsafe_();
/*  535 */       return QQVipInfo.this.vip_flag;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_vip()
/*      */     {
/*  542 */       QQVipInfo.this._xdb_verify_unsafe_();
/*  543 */       return QQVipInfo.this.is_vip;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_year()
/*      */     {
/*  550 */       QQVipInfo.this._xdb_verify_unsafe_();
/*  551 */       return QQVipInfo.this.is_year;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_luxury()
/*      */     {
/*  558 */       QQVipInfo.this._xdb_verify_unsafe_();
/*  559 */       return QQVipInfo.this.is_luxury;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/*  566 */       QQVipInfo.this._xdb_verify_unsafe_();
/*  567 */       return QQVipInfo.this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExpire_timestamp()
/*      */     {
/*  574 */       QQVipInfo.this._xdb_verify_unsafe_();
/*  575 */       return QQVipInfo.this.expire_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVip_flag(int _v_)
/*      */     {
/*  582 */       QQVipInfo.this._xdb_verify_unsafe_();
/*  583 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_vip(boolean _v_)
/*      */     {
/*  590 */       QQVipInfo.this._xdb_verify_unsafe_();
/*  591 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_year(boolean _v_)
/*      */     {
/*  598 */       QQVipInfo.this._xdb_verify_unsafe_();
/*  599 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_luxury(boolean _v_)
/*      */     {
/*  606 */       QQVipInfo.this._xdb_verify_unsafe_();
/*  607 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/*  614 */       QQVipInfo.this._xdb_verify_unsafe_();
/*  615 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExpire_timestamp(int _v_)
/*      */     {
/*  622 */       QQVipInfo.this._xdb_verify_unsafe_();
/*  623 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  629 */       QQVipInfo.this._xdb_verify_unsafe_();
/*  630 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  636 */       QQVipInfo.this._xdb_verify_unsafe_();
/*  637 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  643 */       return QQVipInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  649 */       return QQVipInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  655 */       QQVipInfo.this._xdb_verify_unsafe_();
/*  656 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  662 */       return QQVipInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  668 */       return QQVipInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  674 */       QQVipInfo.this._xdb_verify_unsafe_();
/*  675 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  681 */       return QQVipInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  687 */       return QQVipInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  693 */       return QQVipInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  699 */       return QQVipInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  705 */       return QQVipInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  711 */       return QQVipInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  717 */       return QQVipInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.QQVipInfo
/*      */   {
/*      */     private int vip_flag;
/*      */     
/*      */     private boolean is_vip;
/*      */     
/*      */     private boolean is_year;
/*      */     
/*      */     private boolean is_luxury;
/*      */     
/*      */     private int level;
/*      */     
/*      */     private int expire_timestamp;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  739 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Data() {}
/*      */     
/*      */ 
/*      */     Data(xbean.QQVipInfo _o1_)
/*      */     {
/*  748 */       if ((_o1_ instanceof QQVipInfo)) { assign((QQVipInfo)_o1_);
/*  749 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  750 */       } else if ((_o1_ instanceof QQVipInfo.Const)) assign(((QQVipInfo.Const)_o1_).nThis()); else {
/*  751 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(QQVipInfo _o_) {
/*  756 */       this.vip_flag = _o_.vip_flag;
/*  757 */       this.is_vip = _o_.is_vip;
/*  758 */       this.is_year = _o_.is_year;
/*  759 */       this.is_luxury = _o_.is_luxury;
/*  760 */       this.level = _o_.level;
/*  761 */       this.expire_timestamp = _o_.expire_timestamp;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  766 */       this.vip_flag = _o_.vip_flag;
/*  767 */       this.is_vip = _o_.is_vip;
/*  768 */       this.is_year = _o_.is_year;
/*  769 */       this.is_luxury = _o_.is_luxury;
/*  770 */       this.level = _o_.level;
/*  771 */       this.expire_timestamp = _o_.expire_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  777 */       _os_.marshal(this.vip_flag);
/*  778 */       _os_.marshal(this.is_vip);
/*  779 */       _os_.marshal(this.is_year);
/*  780 */       _os_.marshal(this.is_luxury);
/*  781 */       _os_.marshal(this.level);
/*  782 */       _os_.marshal(this.expire_timestamp);
/*  783 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  789 */       this.vip_flag = _os_.unmarshal_int();
/*  790 */       this.is_vip = _os_.unmarshal_boolean();
/*  791 */       this.is_year = _os_.unmarshal_boolean();
/*  792 */       this.is_luxury = _os_.unmarshal_boolean();
/*  793 */       this.level = _os_.unmarshal_int();
/*  794 */       this.expire_timestamp = _os_.unmarshal_int();
/*  795 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  801 */       int _size_ = 0;
/*  802 */       _size_ += CodedOutputStream.computeInt32Size(1, this.vip_flag);
/*  803 */       _size_ += CodedOutputStream.computeBoolSize(2, this.is_vip);
/*  804 */       _size_ += CodedOutputStream.computeBoolSize(3, this.is_year);
/*  805 */       _size_ += CodedOutputStream.computeBoolSize(4, this.is_luxury);
/*  806 */       _size_ += CodedOutputStream.computeInt32Size(5, this.level);
/*  807 */       _size_ += CodedOutputStream.computeInt32Size(6, this.expire_timestamp);
/*  808 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  816 */         _output_.writeInt32(1, this.vip_flag);
/*  817 */         _output_.writeBool(2, this.is_vip);
/*  818 */         _output_.writeBool(3, this.is_year);
/*  819 */         _output_.writeBool(4, this.is_luxury);
/*  820 */         _output_.writeInt32(5, this.level);
/*  821 */         _output_.writeInt32(6, this.expire_timestamp);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  825 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  827 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  835 */         boolean done = false;
/*  836 */         while (!done)
/*      */         {
/*  838 */           int tag = _input_.readTag();
/*  839 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  843 */             done = true;
/*  844 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  848 */             this.vip_flag = _input_.readInt32();
/*  849 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  853 */             this.is_vip = _input_.readBool();
/*  854 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  858 */             this.is_year = _input_.readBool();
/*  859 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  863 */             this.is_luxury = _input_.readBool();
/*  864 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  868 */             this.level = _input_.readInt32();
/*  869 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  873 */             this.expire_timestamp = _input_.readInt32();
/*  874 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  878 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  880 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  889 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  893 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  895 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.QQVipInfo copy()
/*      */     {
/*  901 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.QQVipInfo toData()
/*      */     {
/*  907 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.QQVipInfo toBean()
/*      */     {
/*  912 */       return new QQVipInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.QQVipInfo toDataIf()
/*      */     {
/*  918 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.QQVipInfo toBeanIf()
/*      */     {
/*  923 */       return new QQVipInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  929 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  933 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  937 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  941 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  945 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  949 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  953 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVip_flag()
/*      */     {
/*  960 */       return this.vip_flag;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_vip()
/*      */     {
/*  967 */       return this.is_vip;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_year()
/*      */     {
/*  974 */       return this.is_year;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_luxury()
/*      */     {
/*  981 */       return this.is_luxury;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/*  988 */       return this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExpire_timestamp()
/*      */     {
/*  995 */       return this.expire_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVip_flag(int _v_)
/*      */     {
/* 1002 */       this.vip_flag = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_vip(boolean _v_)
/*      */     {
/* 1009 */       this.is_vip = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_year(boolean _v_)
/*      */     {
/* 1016 */       this.is_year = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_luxury(boolean _v_)
/*      */     {
/* 1023 */       this.is_luxury = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/* 1030 */       this.level = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExpire_timestamp(int _v_)
/*      */     {
/* 1037 */       this.expire_timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1043 */       if (!(_o1_ instanceof Data)) return false;
/* 1044 */       Data _o_ = (Data)_o1_;
/* 1045 */       if (this.vip_flag != _o_.vip_flag) return false;
/* 1046 */       if (this.is_vip != _o_.is_vip) return false;
/* 1047 */       if (this.is_year != _o_.is_year) return false;
/* 1048 */       if (this.is_luxury != _o_.is_luxury) return false;
/* 1049 */       if (this.level != _o_.level) return false;
/* 1050 */       if (this.expire_timestamp != _o_.expire_timestamp) return false;
/* 1051 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1057 */       int _h_ = 0;
/* 1058 */       _h_ += this.vip_flag;
/* 1059 */       _h_ += (this.is_vip ? 1231 : 1237);
/* 1060 */       _h_ += (this.is_year ? 1231 : 1237);
/* 1061 */       _h_ += (this.is_luxury ? 1231 : 1237);
/* 1062 */       _h_ += this.level;
/* 1063 */       _h_ += this.expire_timestamp;
/* 1064 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1070 */       StringBuilder _sb_ = new StringBuilder();
/* 1071 */       _sb_.append("(");
/* 1072 */       _sb_.append(this.vip_flag);
/* 1073 */       _sb_.append(",");
/* 1074 */       _sb_.append(this.is_vip);
/* 1075 */       _sb_.append(",");
/* 1076 */       _sb_.append(this.is_year);
/* 1077 */       _sb_.append(",");
/* 1078 */       _sb_.append(this.is_luxury);
/* 1079 */       _sb_.append(",");
/* 1080 */       _sb_.append(this.level);
/* 1081 */       _sb_.append(",");
/* 1082 */       _sb_.append(this.expire_timestamp);
/* 1083 */       _sb_.append(")");
/* 1084 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\QQVipInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */