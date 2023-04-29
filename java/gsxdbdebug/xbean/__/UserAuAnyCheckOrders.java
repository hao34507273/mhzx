/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class UserAuAnyCheckOrders extends XBean implements xbean.UserAuAnyCheckOrders
/*      */ {
/*      */   private int offset;
/*      */   private int sn;
/*      */   private int check_status;
/*      */   private ArrayList<xbean.AuAnyCheckOrderInfo> orders;
/*      */   private long magic_num;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.offset = 0;
/*   27 */     this.sn = 0;
/*   28 */     this.check_status = 1;
/*   29 */     this.orders.clear();
/*   30 */     this.magic_num = -1L;
/*      */   }
/*      */   
/*      */   UserAuAnyCheckOrders(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.offset = 0;
/*   37 */     this.sn = 0;
/*   38 */     this.check_status = 1;
/*   39 */     this.orders = new ArrayList();
/*   40 */     this.magic_num = -1L;
/*      */   }
/*      */   
/*      */   public UserAuAnyCheckOrders()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public UserAuAnyCheckOrders(UserAuAnyCheckOrders _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   UserAuAnyCheckOrders(xbean.UserAuAnyCheckOrders _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof UserAuAnyCheckOrders)) { assign((UserAuAnyCheckOrders)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(UserAuAnyCheckOrders _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.offset = _o_.offset;
/*   66 */     this.sn = _o_.sn;
/*   67 */     this.check_status = _o_.check_status;
/*   68 */     this.orders = new ArrayList();
/*   69 */     for (xbean.AuAnyCheckOrderInfo _v_ : _o_.orders)
/*   70 */       this.orders.add(new AuAnyCheckOrderInfo(_v_, this, "orders"));
/*   71 */     this.magic_num = _o_.magic_num;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   76 */     this.offset = _o_.offset;
/*   77 */     this.sn = _o_.sn;
/*   78 */     this.check_status = _o_.check_status;
/*   79 */     this.orders = new ArrayList();
/*   80 */     for (xbean.AuAnyCheckOrderInfo _v_ : _o_.orders)
/*   81 */       this.orders.add(new AuAnyCheckOrderInfo(_v_, this, "orders"));
/*   82 */     this.magic_num = _o_.magic_num;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   88 */     _xdb_verify_unsafe_();
/*   89 */     _os_.marshal(this.offset);
/*   90 */     _os_.marshal(this.sn);
/*   91 */     _os_.marshal(this.check_status);
/*   92 */     _os_.compact_uint32(this.orders.size());
/*   93 */     for (xbean.AuAnyCheckOrderInfo _v_ : this.orders)
/*      */     {
/*   95 */       _v_.marshal(_os_);
/*      */     }
/*   97 */     _os_.marshal(this.magic_num);
/*   98 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  104 */     _xdb_verify_unsafe_();
/*  105 */     this.offset = _os_.unmarshal_int();
/*  106 */     this.sn = _os_.unmarshal_int();
/*  107 */     this.check_status = _os_.unmarshal_int();
/*  108 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  110 */       xbean.AuAnyCheckOrderInfo _v_ = new AuAnyCheckOrderInfo(0, this, "orders");
/*  111 */       _v_.unmarshal(_os_);
/*  112 */       this.orders.add(_v_);
/*      */     }
/*  114 */     this.magic_num = _os_.unmarshal_long();
/*  115 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  121 */     _xdb_verify_unsafe_();
/*  122 */     int _size_ = 0;
/*  123 */     _size_ += CodedOutputStream.computeInt32Size(1, this.offset);
/*  124 */     _size_ += CodedOutputStream.computeInt32Size(2, this.sn);
/*  125 */     _size_ += CodedOutputStream.computeInt32Size(3, this.check_status);
/*  126 */     for (xbean.AuAnyCheckOrderInfo _v_ : this.orders)
/*      */     {
/*  128 */       _size_ += CodedOutputStream.computeMessageSize(4, _v_);
/*      */     }
/*  130 */     _size_ += CodedOutputStream.computeInt64Size(5, this.magic_num);
/*  131 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  137 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  140 */       _output_.writeInt32(1, this.offset);
/*  141 */       _output_.writeInt32(2, this.sn);
/*  142 */       _output_.writeInt32(3, this.check_status);
/*  143 */       for (xbean.AuAnyCheckOrderInfo _v_ : this.orders)
/*      */       {
/*  145 */         _output_.writeMessage(4, _v_);
/*      */       }
/*  147 */       _output_.writeInt64(5, this.magic_num);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  151 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  153 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  159 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  162 */       boolean done = false;
/*  163 */       while (!done)
/*      */       {
/*  165 */         int tag = _input_.readTag();
/*  166 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  170 */           done = true;
/*  171 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  175 */           this.offset = _input_.readInt32();
/*  176 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  180 */           this.sn = _input_.readInt32();
/*  181 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  185 */           this.check_status = _input_.readInt32();
/*  186 */           break;
/*      */         
/*      */ 
/*      */         case 34: 
/*  190 */           xbean.AuAnyCheckOrderInfo _v_ = new AuAnyCheckOrderInfo(0, this, "orders");
/*  191 */           _input_.readMessage(_v_);
/*  192 */           this.orders.add(_v_);
/*  193 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  197 */           this.magic_num = _input_.readInt64();
/*  198 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  202 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  204 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  213 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  217 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  219 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.UserAuAnyCheckOrders copy()
/*      */   {
/*  225 */     _xdb_verify_unsafe_();
/*  226 */     return new UserAuAnyCheckOrders(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.UserAuAnyCheckOrders toData()
/*      */   {
/*  232 */     _xdb_verify_unsafe_();
/*  233 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.UserAuAnyCheckOrders toBean()
/*      */   {
/*  238 */     _xdb_verify_unsafe_();
/*  239 */     return new UserAuAnyCheckOrders(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.UserAuAnyCheckOrders toDataIf()
/*      */   {
/*  245 */     _xdb_verify_unsafe_();
/*  246 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.UserAuAnyCheckOrders toBeanIf()
/*      */   {
/*  251 */     _xdb_verify_unsafe_();
/*  252 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  258 */     _xdb_verify_unsafe_();
/*  259 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getOffset()
/*      */   {
/*  266 */     _xdb_verify_unsafe_();
/*  267 */     return this.offset;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getSn()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return this.sn;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCheck_status()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return this.check_status;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.AuAnyCheckOrderInfo> getOrders()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     return xdb.Logs.logList(new LogKey(this, "orders"), this.orders);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.AuAnyCheckOrderInfo> getOrdersAsData()
/*      */   {
/*  297 */     _xdb_verify_unsafe_();
/*      */     
/*  299 */     UserAuAnyCheckOrders _o_ = this;
/*  300 */     List<xbean.AuAnyCheckOrderInfo> orders = new ArrayList();
/*  301 */     for (xbean.AuAnyCheckOrderInfo _v_ : _o_.orders)
/*  302 */       orders.add(new AuAnyCheckOrderInfo.Data(_v_));
/*  303 */     return orders;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMagic_num()
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*  311 */     return this.magic_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOffset(int _v_)
/*      */   {
/*  318 */     _xdb_verify_unsafe_();
/*  319 */     xdb.Logs.logIf(new LogKey(this, "offset")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  323 */         new LogInt(this, UserAuAnyCheckOrders.this.offset)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  327 */             UserAuAnyCheckOrders.this.offset = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  331 */     });
/*  332 */     this.offset = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSn(int _v_)
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     xdb.Logs.logIf(new LogKey(this, "sn")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  344 */         new LogInt(this, UserAuAnyCheckOrders.this.sn)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  348 */             UserAuAnyCheckOrders.this.sn = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  352 */     });
/*  353 */     this.sn = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCheck_status(int _v_)
/*      */   {
/*  360 */     _xdb_verify_unsafe_();
/*  361 */     xdb.Logs.logIf(new LogKey(this, "check_status")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  365 */         new LogInt(this, UserAuAnyCheckOrders.this.check_status)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  369 */             UserAuAnyCheckOrders.this.check_status = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  373 */     });
/*  374 */     this.check_status = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMagic_num(long _v_)
/*      */   {
/*  381 */     _xdb_verify_unsafe_();
/*  382 */     xdb.Logs.logIf(new LogKey(this, "magic_num")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  386 */         new xdb.logs.LogLong(this, UserAuAnyCheckOrders.this.magic_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  390 */             UserAuAnyCheckOrders.this.magic_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  394 */     });
/*  395 */     this.magic_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  401 */     _xdb_verify_unsafe_();
/*  402 */     UserAuAnyCheckOrders _o_ = null;
/*  403 */     if ((_o1_ instanceof UserAuAnyCheckOrders)) { _o_ = (UserAuAnyCheckOrders)_o1_;
/*  404 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  405 */       return false;
/*  406 */     if (this.offset != _o_.offset) return false;
/*  407 */     if (this.sn != _o_.sn) return false;
/*  408 */     if (this.check_status != _o_.check_status) return false;
/*  409 */     if (!this.orders.equals(_o_.orders)) return false;
/*  410 */     if (this.magic_num != _o_.magic_num) return false;
/*  411 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     int _h_ = 0;
/*  419 */     _h_ += this.offset;
/*  420 */     _h_ += this.sn;
/*  421 */     _h_ += this.check_status;
/*  422 */     _h_ += this.orders.hashCode();
/*  423 */     _h_ = (int)(_h_ + this.magic_num);
/*  424 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  430 */     _xdb_verify_unsafe_();
/*  431 */     StringBuilder _sb_ = new StringBuilder();
/*  432 */     _sb_.append("(");
/*  433 */     _sb_.append(this.offset);
/*  434 */     _sb_.append(",");
/*  435 */     _sb_.append(this.sn);
/*  436 */     _sb_.append(",");
/*  437 */     _sb_.append(this.check_status);
/*  438 */     _sb_.append(",");
/*  439 */     _sb_.append(this.orders);
/*  440 */     _sb_.append(",");
/*  441 */     _sb_.append(this.magic_num);
/*  442 */     _sb_.append(")");
/*  443 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  449 */     ListenableBean lb = new ListenableBean();
/*  450 */     lb.add(new ListenableChanged().setVarName("offset"));
/*  451 */     lb.add(new ListenableChanged().setVarName("sn"));
/*  452 */     lb.add(new ListenableChanged().setVarName("check_status"));
/*  453 */     lb.add(new ListenableChanged().setVarName("orders"));
/*  454 */     lb.add(new ListenableChanged().setVarName("magic_num"));
/*  455 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.UserAuAnyCheckOrders {
/*      */     private Const() {}
/*      */     
/*      */     UserAuAnyCheckOrders nThis() {
/*  462 */       return UserAuAnyCheckOrders.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  468 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.UserAuAnyCheckOrders copy()
/*      */     {
/*  474 */       return UserAuAnyCheckOrders.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.UserAuAnyCheckOrders toData()
/*      */     {
/*  480 */       return UserAuAnyCheckOrders.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.UserAuAnyCheckOrders toBean()
/*      */     {
/*  485 */       return UserAuAnyCheckOrders.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.UserAuAnyCheckOrders toDataIf()
/*      */     {
/*  491 */       return UserAuAnyCheckOrders.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.UserAuAnyCheckOrders toBeanIf()
/*      */     {
/*  496 */       return UserAuAnyCheckOrders.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOffset()
/*      */     {
/*  503 */       UserAuAnyCheckOrders.this._xdb_verify_unsafe_();
/*  504 */       return UserAuAnyCheckOrders.this.offset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSn()
/*      */     {
/*  511 */       UserAuAnyCheckOrders.this._xdb_verify_unsafe_();
/*  512 */       return UserAuAnyCheckOrders.this.sn;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCheck_status()
/*      */     {
/*  519 */       UserAuAnyCheckOrders.this._xdb_verify_unsafe_();
/*  520 */       return UserAuAnyCheckOrders.this.check_status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.AuAnyCheckOrderInfo> getOrders()
/*      */     {
/*  527 */       UserAuAnyCheckOrders.this._xdb_verify_unsafe_();
/*  528 */       return xdb.Consts.constList(UserAuAnyCheckOrders.this.orders);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.AuAnyCheckOrderInfo> getOrdersAsData()
/*      */     {
/*  534 */       UserAuAnyCheckOrders.this._xdb_verify_unsafe_();
/*      */       
/*  536 */       UserAuAnyCheckOrders _o_ = UserAuAnyCheckOrders.this;
/*  537 */       List<xbean.AuAnyCheckOrderInfo> orders = new ArrayList();
/*  538 */       for (xbean.AuAnyCheckOrderInfo _v_ : _o_.orders)
/*  539 */         orders.add(new AuAnyCheckOrderInfo.Data(_v_));
/*  540 */       return orders;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMagic_num()
/*      */     {
/*  547 */       UserAuAnyCheckOrders.this._xdb_verify_unsafe_();
/*  548 */       return UserAuAnyCheckOrders.this.magic_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOffset(int _v_)
/*      */     {
/*  555 */       UserAuAnyCheckOrders.this._xdb_verify_unsafe_();
/*  556 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSn(int _v_)
/*      */     {
/*  563 */       UserAuAnyCheckOrders.this._xdb_verify_unsafe_();
/*  564 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCheck_status(int _v_)
/*      */     {
/*  571 */       UserAuAnyCheckOrders.this._xdb_verify_unsafe_();
/*  572 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMagic_num(long _v_)
/*      */     {
/*  579 */       UserAuAnyCheckOrders.this._xdb_verify_unsafe_();
/*  580 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  586 */       UserAuAnyCheckOrders.this._xdb_verify_unsafe_();
/*  587 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  593 */       UserAuAnyCheckOrders.this._xdb_verify_unsafe_();
/*  594 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  600 */       return UserAuAnyCheckOrders.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  606 */       return UserAuAnyCheckOrders.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  612 */       UserAuAnyCheckOrders.this._xdb_verify_unsafe_();
/*  613 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  619 */       return UserAuAnyCheckOrders.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  625 */       return UserAuAnyCheckOrders.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  631 */       UserAuAnyCheckOrders.this._xdb_verify_unsafe_();
/*  632 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  638 */       return UserAuAnyCheckOrders.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  644 */       return UserAuAnyCheckOrders.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  650 */       return UserAuAnyCheckOrders.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  656 */       return UserAuAnyCheckOrders.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  662 */       return UserAuAnyCheckOrders.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  668 */       return UserAuAnyCheckOrders.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  674 */       return UserAuAnyCheckOrders.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.UserAuAnyCheckOrders
/*      */   {
/*      */     private int offset;
/*      */     
/*      */     private int sn;
/*      */     
/*      */     private int check_status;
/*      */     
/*      */     private ArrayList<xbean.AuAnyCheckOrderInfo> orders;
/*      */     
/*      */     private long magic_num;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  694 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  699 */       this.offset = 0;
/*  700 */       this.sn = 0;
/*  701 */       this.check_status = 1;
/*  702 */       this.orders = new ArrayList();
/*  703 */       this.magic_num = -1L;
/*      */     }
/*      */     
/*      */     Data(xbean.UserAuAnyCheckOrders _o1_)
/*      */     {
/*  708 */       if ((_o1_ instanceof UserAuAnyCheckOrders)) { assign((UserAuAnyCheckOrders)_o1_);
/*  709 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  710 */       } else if ((_o1_ instanceof UserAuAnyCheckOrders.Const)) assign(((UserAuAnyCheckOrders.Const)_o1_).nThis()); else {
/*  711 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(UserAuAnyCheckOrders _o_) {
/*  716 */       this.offset = _o_.offset;
/*  717 */       this.sn = _o_.sn;
/*  718 */       this.check_status = _o_.check_status;
/*  719 */       this.orders = new ArrayList();
/*  720 */       for (xbean.AuAnyCheckOrderInfo _v_ : _o_.orders)
/*  721 */         this.orders.add(new AuAnyCheckOrderInfo.Data(_v_));
/*  722 */       this.magic_num = _o_.magic_num;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  727 */       this.offset = _o_.offset;
/*  728 */       this.sn = _o_.sn;
/*  729 */       this.check_status = _o_.check_status;
/*  730 */       this.orders = new ArrayList();
/*  731 */       for (xbean.AuAnyCheckOrderInfo _v_ : _o_.orders)
/*  732 */         this.orders.add(new AuAnyCheckOrderInfo.Data(_v_));
/*  733 */       this.magic_num = _o_.magic_num;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  739 */       _os_.marshal(this.offset);
/*  740 */       _os_.marshal(this.sn);
/*  741 */       _os_.marshal(this.check_status);
/*  742 */       _os_.compact_uint32(this.orders.size());
/*  743 */       for (xbean.AuAnyCheckOrderInfo _v_ : this.orders)
/*      */       {
/*  745 */         _v_.marshal(_os_);
/*      */       }
/*  747 */       _os_.marshal(this.magic_num);
/*  748 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  754 */       this.offset = _os_.unmarshal_int();
/*  755 */       this.sn = _os_.unmarshal_int();
/*  756 */       this.check_status = _os_.unmarshal_int();
/*  757 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  759 */         xbean.AuAnyCheckOrderInfo _v_ = xbean.Pod.newAuAnyCheckOrderInfoData();
/*  760 */         _v_.unmarshal(_os_);
/*  761 */         this.orders.add(_v_);
/*      */       }
/*  763 */       this.magic_num = _os_.unmarshal_long();
/*  764 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  770 */       int _size_ = 0;
/*  771 */       _size_ += CodedOutputStream.computeInt32Size(1, this.offset);
/*  772 */       _size_ += CodedOutputStream.computeInt32Size(2, this.sn);
/*  773 */       _size_ += CodedOutputStream.computeInt32Size(3, this.check_status);
/*  774 */       for (xbean.AuAnyCheckOrderInfo _v_ : this.orders)
/*      */       {
/*  776 */         _size_ += CodedOutputStream.computeMessageSize(4, _v_);
/*      */       }
/*  778 */       _size_ += CodedOutputStream.computeInt64Size(5, this.magic_num);
/*  779 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  787 */         _output_.writeInt32(1, this.offset);
/*  788 */         _output_.writeInt32(2, this.sn);
/*  789 */         _output_.writeInt32(3, this.check_status);
/*  790 */         for (xbean.AuAnyCheckOrderInfo _v_ : this.orders)
/*      */         {
/*  792 */           _output_.writeMessage(4, _v_);
/*      */         }
/*  794 */         _output_.writeInt64(5, this.magic_num);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  798 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  800 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  808 */         boolean done = false;
/*  809 */         while (!done)
/*      */         {
/*  811 */           int tag = _input_.readTag();
/*  812 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  816 */             done = true;
/*  817 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  821 */             this.offset = _input_.readInt32();
/*  822 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  826 */             this.sn = _input_.readInt32();
/*  827 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  831 */             this.check_status = _input_.readInt32();
/*  832 */             break;
/*      */           
/*      */ 
/*      */           case 34: 
/*  836 */             xbean.AuAnyCheckOrderInfo _v_ = xbean.Pod.newAuAnyCheckOrderInfoData();
/*  837 */             _input_.readMessage(_v_);
/*  838 */             this.orders.add(_v_);
/*  839 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  843 */             this.magic_num = _input_.readInt64();
/*  844 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  848 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  850 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  859 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  863 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  865 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.UserAuAnyCheckOrders copy()
/*      */     {
/*  871 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.UserAuAnyCheckOrders toData()
/*      */     {
/*  877 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.UserAuAnyCheckOrders toBean()
/*      */     {
/*  882 */       return new UserAuAnyCheckOrders(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.UserAuAnyCheckOrders toDataIf()
/*      */     {
/*  888 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.UserAuAnyCheckOrders toBeanIf()
/*      */     {
/*  893 */       return new UserAuAnyCheckOrders(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  899 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  903 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  907 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  911 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  915 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  919 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  923 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOffset()
/*      */     {
/*  930 */       return this.offset;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSn()
/*      */     {
/*  937 */       return this.sn;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCheck_status()
/*      */     {
/*  944 */       return this.check_status;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.AuAnyCheckOrderInfo> getOrders()
/*      */     {
/*  951 */       return this.orders;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.AuAnyCheckOrderInfo> getOrdersAsData()
/*      */     {
/*  958 */       return this.orders;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMagic_num()
/*      */     {
/*  965 */       return this.magic_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOffset(int _v_)
/*      */     {
/*  972 */       this.offset = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSn(int _v_)
/*      */     {
/*  979 */       this.sn = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCheck_status(int _v_)
/*      */     {
/*  986 */       this.check_status = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMagic_num(long _v_)
/*      */     {
/*  993 */       this.magic_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/*  999 */       if (!(_o1_ instanceof Data)) return false;
/* 1000 */       Data _o_ = (Data)_o1_;
/* 1001 */       if (this.offset != _o_.offset) return false;
/* 1002 */       if (this.sn != _o_.sn) return false;
/* 1003 */       if (this.check_status != _o_.check_status) return false;
/* 1004 */       if (!this.orders.equals(_o_.orders)) return false;
/* 1005 */       if (this.magic_num != _o_.magic_num) return false;
/* 1006 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1012 */       int _h_ = 0;
/* 1013 */       _h_ += this.offset;
/* 1014 */       _h_ += this.sn;
/* 1015 */       _h_ += this.check_status;
/* 1016 */       _h_ += this.orders.hashCode();
/* 1017 */       _h_ = (int)(_h_ + this.magic_num);
/* 1018 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1024 */       StringBuilder _sb_ = new StringBuilder();
/* 1025 */       _sb_.append("(");
/* 1026 */       _sb_.append(this.offset);
/* 1027 */       _sb_.append(",");
/* 1028 */       _sb_.append(this.sn);
/* 1029 */       _sb_.append(",");
/* 1030 */       _sb_.append(this.check_status);
/* 1031 */       _sb_.append(",");
/* 1032 */       _sb_.append(this.orders);
/* 1033 */       _sb_.append(",");
/* 1034 */       _sb_.append(this.magic_num);
/* 1035 */       _sb_.append(")");
/* 1036 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\UserAuAnyCheckOrders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */