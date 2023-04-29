/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class BuyYuanBaoOrder extends XBean implements xbean.BuyYuanBaoOrder
/*      */ {
/*      */   private String userid;
/*      */   private long roleid;
/*      */   private String servername;
/*      */   private long cashnum;
/*      */   private long yuanbaonum;
/*      */   private long buytime;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.userid = "";
/*   29 */     this.roleid = 0L;
/*   30 */     this.servername = "";
/*   31 */     this.cashnum = 0L;
/*   32 */     this.yuanbaonum = 0L;
/*   33 */     this.buytime = 0L;
/*      */   }
/*      */   
/*      */   BuyYuanBaoOrder(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.userid = "";
/*   40 */     this.servername = "";
/*      */   }
/*      */   
/*      */   public BuyYuanBaoOrder()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public BuyYuanBaoOrder(BuyYuanBaoOrder _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   BuyYuanBaoOrder(xbean.BuyYuanBaoOrder _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof BuyYuanBaoOrder)) { assign((BuyYuanBaoOrder)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(BuyYuanBaoOrder _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.userid = _o_.userid;
/*   66 */     this.roleid = _o_.roleid;
/*   67 */     this.servername = _o_.servername;
/*   68 */     this.cashnum = _o_.cashnum;
/*   69 */     this.yuanbaonum = _o_.yuanbaonum;
/*   70 */     this.buytime = _o_.buytime;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   75 */     this.userid = _o_.userid;
/*   76 */     this.roleid = _o_.roleid;
/*   77 */     this.servername = _o_.servername;
/*   78 */     this.cashnum = _o_.cashnum;
/*   79 */     this.yuanbaonum = _o_.yuanbaonum;
/*   80 */     this.buytime = _o_.buytime;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   86 */     _xdb_verify_unsafe_();
/*   87 */     _os_.marshal(this.userid, "UTF-16LE");
/*   88 */     _os_.marshal(this.roleid);
/*   89 */     _os_.marshal(this.servername, "UTF-16LE");
/*   90 */     _os_.marshal(this.cashnum);
/*   91 */     _os_.marshal(this.yuanbaonum);
/*   92 */     _os_.marshal(this.buytime);
/*   93 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*   99 */     _xdb_verify_unsafe_();
/*  100 */     this.userid = _os_.unmarshal_String("UTF-16LE");
/*  101 */     this.roleid = _os_.unmarshal_long();
/*  102 */     this.servername = _os_.unmarshal_String("UTF-16LE");
/*  103 */     this.cashnum = _os_.unmarshal_long();
/*  104 */     this.yuanbaonum = _os_.unmarshal_long();
/*  105 */     this.buytime = _os_.unmarshal_long();
/*  106 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  112 */     _xdb_verify_unsafe_();
/*  113 */     int _size_ = 0;
/*      */     try
/*      */     {
/*  116 */       _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.userid, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  120 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  122 */     _size_ += CodedOutputStream.computeInt64Size(2, this.roleid);
/*      */     try
/*      */     {
/*  125 */       _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.servername, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  129 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  131 */     _size_ += CodedOutputStream.computeInt64Size(4, this.cashnum);
/*  132 */     _size_ += CodedOutputStream.computeInt64Size(5, this.yuanbaonum);
/*  133 */     _size_ += CodedOutputStream.computeInt64Size(6, this.buytime);
/*  134 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  140 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  143 */       _output_.writeBytes(1, ByteString.copyFrom(this.userid, "UTF-16LE"));
/*  144 */       _output_.writeInt64(2, this.roleid);
/*  145 */       _output_.writeBytes(3, ByteString.copyFrom(this.servername, "UTF-16LE"));
/*  146 */       _output_.writeInt64(4, this.cashnum);
/*  147 */       _output_.writeInt64(5, this.yuanbaonum);
/*  148 */       _output_.writeInt64(6, this.buytime);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  152 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  154 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  160 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  163 */       boolean done = false;
/*  164 */       while (!done)
/*      */       {
/*  166 */         int tag = _input_.readTag();
/*  167 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  171 */           done = true;
/*  172 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  176 */           this.userid = _input_.readBytes().toString("UTF-16LE");
/*  177 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  181 */           this.roleid = _input_.readInt64();
/*  182 */           break;
/*      */         
/*      */ 
/*      */         case 26: 
/*  186 */           this.servername = _input_.readBytes().toString("UTF-16LE");
/*  187 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  191 */           this.cashnum = _input_.readInt64();
/*  192 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  196 */           this.yuanbaonum = _input_.readInt64();
/*  197 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  201 */           this.buytime = _input_.readInt64();
/*  202 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  206 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  208 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  217 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  221 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  223 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BuyYuanBaoOrder copy()
/*      */   {
/*  229 */     _xdb_verify_unsafe_();
/*  230 */     return new BuyYuanBaoOrder(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BuyYuanBaoOrder toData()
/*      */   {
/*  236 */     _xdb_verify_unsafe_();
/*  237 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BuyYuanBaoOrder toBean()
/*      */   {
/*  242 */     _xdb_verify_unsafe_();
/*  243 */     return new BuyYuanBaoOrder(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BuyYuanBaoOrder toDataIf()
/*      */   {
/*  249 */     _xdb_verify_unsafe_();
/*  250 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BuyYuanBaoOrder toBeanIf()
/*      */   {
/*  255 */     _xdb_verify_unsafe_();
/*  256 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getUserid()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return this.userid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getUseridOctets()
/*      */   {
/*  278 */     _xdb_verify_unsafe_();
/*  279 */     return Octets.wrap(getUserid(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleid()
/*      */   {
/*  286 */     _xdb_verify_unsafe_();
/*  287 */     return this.roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getServername()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return this.servername;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getServernameOctets()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return Octets.wrap(getServername(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCashnum()
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*  311 */     return this.cashnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getYuanbaonum()
/*      */   {
/*  318 */     _xdb_verify_unsafe_();
/*  319 */     return this.yuanbaonum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBuytime()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*  327 */     return this.buytime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUserid(String _v_)
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     if (null == _v_)
/*  336 */       throw new NullPointerException();
/*  337 */     xdb.Logs.logIf(new LogKey(this, "userid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  341 */         new xdb.logs.LogString(this, BuyYuanBaoOrder.this.userid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  345 */             BuyYuanBaoOrder.this.userid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  349 */     });
/*  350 */     this.userid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUseridOctets(Octets _v_)
/*      */   {
/*  357 */     _xdb_verify_unsafe_();
/*  358 */     setUserid(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleid(long _v_)
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*  366 */     xdb.Logs.logIf(new LogKey(this, "roleid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  370 */         new LogLong(this, BuyYuanBaoOrder.this.roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  374 */             BuyYuanBaoOrder.this.roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  378 */     });
/*  379 */     this.roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setServername(String _v_)
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*  387 */     if (null == _v_)
/*  388 */       throw new NullPointerException();
/*  389 */     xdb.Logs.logIf(new LogKey(this, "servername")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  393 */         new xdb.logs.LogString(this, BuyYuanBaoOrder.this.servername)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  397 */             BuyYuanBaoOrder.this.servername = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  401 */     });
/*  402 */     this.servername = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setServernameOctets(Octets _v_)
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     setServername(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCashnum(long _v_)
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     xdb.Logs.logIf(new LogKey(this, "cashnum")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  422 */         new LogLong(this, BuyYuanBaoOrder.this.cashnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  426 */             BuyYuanBaoOrder.this.cashnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  430 */     });
/*  431 */     this.cashnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setYuanbaonum(long _v_)
/*      */   {
/*  438 */     _xdb_verify_unsafe_();
/*  439 */     xdb.Logs.logIf(new LogKey(this, "yuanbaonum")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  443 */         new LogLong(this, BuyYuanBaoOrder.this.yuanbaonum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  447 */             BuyYuanBaoOrder.this.yuanbaonum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  451 */     });
/*  452 */     this.yuanbaonum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBuytime(long _v_)
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*  460 */     xdb.Logs.logIf(new LogKey(this, "buytime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  464 */         new LogLong(this, BuyYuanBaoOrder.this.buytime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  468 */             BuyYuanBaoOrder.this.buytime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  472 */     });
/*  473 */     this.buytime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  479 */     _xdb_verify_unsafe_();
/*  480 */     BuyYuanBaoOrder _o_ = null;
/*  481 */     if ((_o1_ instanceof BuyYuanBaoOrder)) { _o_ = (BuyYuanBaoOrder)_o1_;
/*  482 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  483 */       return false;
/*  484 */     if (!this.userid.equals(_o_.userid)) return false;
/*  485 */     if (this.roleid != _o_.roleid) return false;
/*  486 */     if (!this.servername.equals(_o_.servername)) return false;
/*  487 */     if (this.cashnum != _o_.cashnum) return false;
/*  488 */     if (this.yuanbaonum != _o_.yuanbaonum) return false;
/*  489 */     if (this.buytime != _o_.buytime) return false;
/*  490 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  496 */     _xdb_verify_unsafe_();
/*  497 */     int _h_ = 0;
/*  498 */     _h_ += this.userid.hashCode();
/*  499 */     _h_ = (int)(_h_ + this.roleid);
/*  500 */     _h_ += this.servername.hashCode();
/*  501 */     _h_ = (int)(_h_ + this.cashnum);
/*  502 */     _h_ = (int)(_h_ + this.yuanbaonum);
/*  503 */     _h_ = (int)(_h_ + this.buytime);
/*  504 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  510 */     _xdb_verify_unsafe_();
/*  511 */     StringBuilder _sb_ = new StringBuilder();
/*  512 */     _sb_.append("(");
/*  513 */     _sb_.append("'").append(this.userid).append("'");
/*  514 */     _sb_.append(",");
/*  515 */     _sb_.append(this.roleid);
/*  516 */     _sb_.append(",");
/*  517 */     _sb_.append("'").append(this.servername).append("'");
/*  518 */     _sb_.append(",");
/*  519 */     _sb_.append(this.cashnum);
/*  520 */     _sb_.append(",");
/*  521 */     _sb_.append(this.yuanbaonum);
/*  522 */     _sb_.append(",");
/*  523 */     _sb_.append(this.buytime);
/*  524 */     _sb_.append(")");
/*  525 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  531 */     ListenableBean lb = new ListenableBean();
/*  532 */     lb.add(new ListenableChanged().setVarName("userid"));
/*  533 */     lb.add(new ListenableChanged().setVarName("roleid"));
/*  534 */     lb.add(new ListenableChanged().setVarName("servername"));
/*  535 */     lb.add(new ListenableChanged().setVarName("cashnum"));
/*  536 */     lb.add(new ListenableChanged().setVarName("yuanbaonum"));
/*  537 */     lb.add(new ListenableChanged().setVarName("buytime"));
/*  538 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.BuyYuanBaoOrder {
/*      */     private Const() {}
/*      */     
/*      */     BuyYuanBaoOrder nThis() {
/*  545 */       return BuyYuanBaoOrder.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  551 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BuyYuanBaoOrder copy()
/*      */     {
/*  557 */       return BuyYuanBaoOrder.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BuyYuanBaoOrder toData()
/*      */     {
/*  563 */       return BuyYuanBaoOrder.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.BuyYuanBaoOrder toBean()
/*      */     {
/*  568 */       return BuyYuanBaoOrder.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BuyYuanBaoOrder toDataIf()
/*      */     {
/*  574 */       return BuyYuanBaoOrder.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.BuyYuanBaoOrder toBeanIf()
/*      */     {
/*  579 */       return BuyYuanBaoOrder.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getUserid()
/*      */     {
/*  586 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  587 */       return BuyYuanBaoOrder.this.userid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getUseridOctets()
/*      */     {
/*  594 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  595 */       return BuyYuanBaoOrder.this.getUseridOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/*  602 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  603 */       return BuyYuanBaoOrder.this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getServername()
/*      */     {
/*  610 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  611 */       return BuyYuanBaoOrder.this.servername;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getServernameOctets()
/*      */     {
/*  618 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  619 */       return BuyYuanBaoOrder.this.getServernameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCashnum()
/*      */     {
/*  626 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  627 */       return BuyYuanBaoOrder.this.cashnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getYuanbaonum()
/*      */     {
/*  634 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  635 */       return BuyYuanBaoOrder.this.yuanbaonum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBuytime()
/*      */     {
/*  642 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  643 */       return BuyYuanBaoOrder.this.buytime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUserid(String _v_)
/*      */     {
/*  650 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  651 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUseridOctets(Octets _v_)
/*      */     {
/*  658 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  659 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/*  666 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  667 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setServername(String _v_)
/*      */     {
/*  674 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  675 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setServernameOctets(Octets _v_)
/*      */     {
/*  682 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  683 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCashnum(long _v_)
/*      */     {
/*  690 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  691 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setYuanbaonum(long _v_)
/*      */     {
/*  698 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  699 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBuytime(long _v_)
/*      */     {
/*  706 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  707 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  713 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  714 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  720 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  721 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  727 */       return BuyYuanBaoOrder.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  733 */       return BuyYuanBaoOrder.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  739 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  740 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  746 */       return BuyYuanBaoOrder.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  752 */       return BuyYuanBaoOrder.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  758 */       BuyYuanBaoOrder.this._xdb_verify_unsafe_();
/*  759 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  765 */       return BuyYuanBaoOrder.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  771 */       return BuyYuanBaoOrder.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  777 */       return BuyYuanBaoOrder.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  783 */       return BuyYuanBaoOrder.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  789 */       return BuyYuanBaoOrder.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  795 */       return BuyYuanBaoOrder.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  801 */       return BuyYuanBaoOrder.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.BuyYuanBaoOrder
/*      */   {
/*      */     private String userid;
/*      */     
/*      */     private long roleid;
/*      */     
/*      */     private String servername;
/*      */     
/*      */     private long cashnum;
/*      */     
/*      */     private long yuanbaonum;
/*      */     
/*      */     private long buytime;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  823 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  828 */       this.userid = "";
/*  829 */       this.servername = "";
/*      */     }
/*      */     
/*      */     Data(xbean.BuyYuanBaoOrder _o1_)
/*      */     {
/*  834 */       if ((_o1_ instanceof BuyYuanBaoOrder)) { assign((BuyYuanBaoOrder)_o1_);
/*  835 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  836 */       } else if ((_o1_ instanceof BuyYuanBaoOrder.Const)) assign(((BuyYuanBaoOrder.Const)_o1_).nThis()); else {
/*  837 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(BuyYuanBaoOrder _o_) {
/*  842 */       this.userid = _o_.userid;
/*  843 */       this.roleid = _o_.roleid;
/*  844 */       this.servername = _o_.servername;
/*  845 */       this.cashnum = _o_.cashnum;
/*  846 */       this.yuanbaonum = _o_.yuanbaonum;
/*  847 */       this.buytime = _o_.buytime;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  852 */       this.userid = _o_.userid;
/*  853 */       this.roleid = _o_.roleid;
/*  854 */       this.servername = _o_.servername;
/*  855 */       this.cashnum = _o_.cashnum;
/*  856 */       this.yuanbaonum = _o_.yuanbaonum;
/*  857 */       this.buytime = _o_.buytime;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  863 */       _os_.marshal(this.userid, "UTF-16LE");
/*  864 */       _os_.marshal(this.roleid);
/*  865 */       _os_.marshal(this.servername, "UTF-16LE");
/*  866 */       _os_.marshal(this.cashnum);
/*  867 */       _os_.marshal(this.yuanbaonum);
/*  868 */       _os_.marshal(this.buytime);
/*  869 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  875 */       this.userid = _os_.unmarshal_String("UTF-16LE");
/*  876 */       this.roleid = _os_.unmarshal_long();
/*  877 */       this.servername = _os_.unmarshal_String("UTF-16LE");
/*  878 */       this.cashnum = _os_.unmarshal_long();
/*  879 */       this.yuanbaonum = _os_.unmarshal_long();
/*  880 */       this.buytime = _os_.unmarshal_long();
/*  881 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  887 */       int _size_ = 0;
/*      */       try
/*      */       {
/*  890 */         _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.userid, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/*  894 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*  896 */       _size_ += CodedOutputStream.computeInt64Size(2, this.roleid);
/*      */       try
/*      */       {
/*  899 */         _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.servername, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/*  903 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*  905 */       _size_ += CodedOutputStream.computeInt64Size(4, this.cashnum);
/*  906 */       _size_ += CodedOutputStream.computeInt64Size(5, this.yuanbaonum);
/*  907 */       _size_ += CodedOutputStream.computeInt64Size(6, this.buytime);
/*  908 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  916 */         _output_.writeBytes(1, ByteString.copyFrom(this.userid, "UTF-16LE"));
/*  917 */         _output_.writeInt64(2, this.roleid);
/*  918 */         _output_.writeBytes(3, ByteString.copyFrom(this.servername, "UTF-16LE"));
/*  919 */         _output_.writeInt64(4, this.cashnum);
/*  920 */         _output_.writeInt64(5, this.yuanbaonum);
/*  921 */         _output_.writeInt64(6, this.buytime);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  925 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  927 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  935 */         boolean done = false;
/*  936 */         while (!done)
/*      */         {
/*  938 */           int tag = _input_.readTag();
/*  939 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  943 */             done = true;
/*  944 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/*  948 */             this.userid = _input_.readBytes().toString("UTF-16LE");
/*  949 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  953 */             this.roleid = _input_.readInt64();
/*  954 */             break;
/*      */           
/*      */ 
/*      */           case 26: 
/*  958 */             this.servername = _input_.readBytes().toString("UTF-16LE");
/*  959 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  963 */             this.cashnum = _input_.readInt64();
/*  964 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  968 */             this.yuanbaonum = _input_.readInt64();
/*  969 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  973 */             this.buytime = _input_.readInt64();
/*  974 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  978 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  980 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  989 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  993 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  995 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BuyYuanBaoOrder copy()
/*      */     {
/* 1001 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BuyYuanBaoOrder toData()
/*      */     {
/* 1007 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.BuyYuanBaoOrder toBean()
/*      */     {
/* 1012 */       return new BuyYuanBaoOrder(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BuyYuanBaoOrder toDataIf()
/*      */     {
/* 1018 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.BuyYuanBaoOrder toBeanIf()
/*      */     {
/* 1023 */       return new BuyYuanBaoOrder(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1029 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1033 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1037 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1041 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1045 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1049 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1053 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getUserid()
/*      */     {
/* 1060 */       return this.userid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getUseridOctets()
/*      */     {
/* 1067 */       return Octets.wrap(getUserid(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/* 1074 */       return this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getServername()
/*      */     {
/* 1081 */       return this.servername;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getServernameOctets()
/*      */     {
/* 1088 */       return Octets.wrap(getServername(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCashnum()
/*      */     {
/* 1095 */       return this.cashnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getYuanbaonum()
/*      */     {
/* 1102 */       return this.yuanbaonum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBuytime()
/*      */     {
/* 1109 */       return this.buytime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUserid(String _v_)
/*      */     {
/* 1116 */       if (null == _v_)
/* 1117 */         throw new NullPointerException();
/* 1118 */       this.userid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUseridOctets(Octets _v_)
/*      */     {
/* 1125 */       setUserid(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/* 1132 */       this.roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setServername(String _v_)
/*      */     {
/* 1139 */       if (null == _v_)
/* 1140 */         throw new NullPointerException();
/* 1141 */       this.servername = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setServernameOctets(Octets _v_)
/*      */     {
/* 1148 */       setServername(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCashnum(long _v_)
/*      */     {
/* 1155 */       this.cashnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setYuanbaonum(long _v_)
/*      */     {
/* 1162 */       this.yuanbaonum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBuytime(long _v_)
/*      */     {
/* 1169 */       this.buytime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1175 */       if (!(_o1_ instanceof Data)) return false;
/* 1176 */       Data _o_ = (Data)_o1_;
/* 1177 */       if (!this.userid.equals(_o_.userid)) return false;
/* 1178 */       if (this.roleid != _o_.roleid) return false;
/* 1179 */       if (!this.servername.equals(_o_.servername)) return false;
/* 1180 */       if (this.cashnum != _o_.cashnum) return false;
/* 1181 */       if (this.yuanbaonum != _o_.yuanbaonum) return false;
/* 1182 */       if (this.buytime != _o_.buytime) return false;
/* 1183 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1189 */       int _h_ = 0;
/* 1190 */       _h_ += this.userid.hashCode();
/* 1191 */       _h_ = (int)(_h_ + this.roleid);
/* 1192 */       _h_ += this.servername.hashCode();
/* 1193 */       _h_ = (int)(_h_ + this.cashnum);
/* 1194 */       _h_ = (int)(_h_ + this.yuanbaonum);
/* 1195 */       _h_ = (int)(_h_ + this.buytime);
/* 1196 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1202 */       StringBuilder _sb_ = new StringBuilder();
/* 1203 */       _sb_.append("(");
/* 1204 */       _sb_.append("'").append(this.userid).append("'");
/* 1205 */       _sb_.append(",");
/* 1206 */       _sb_.append(this.roleid);
/* 1207 */       _sb_.append(",");
/* 1208 */       _sb_.append("'").append(this.servername).append("'");
/* 1209 */       _sb_.append(",");
/* 1210 */       _sb_.append(this.cashnum);
/* 1211 */       _sb_.append(",");
/* 1212 */       _sb_.append(this.yuanbaonum);
/* 1213 */       _sb_.append(",");
/* 1214 */       _sb_.append(this.buytime);
/* 1215 */       _sb_.append(")");
/* 1216 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\BuyYuanBaoOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */