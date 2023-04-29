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
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class Basic extends XBean implements xbean.Basic
/*      */ {
/*      */   private String user_id;
/*      */   private long qqid;
/*      */   private String name;
/*      */   private int gender;
/*      */   private int occupationid;
/*      */   private long createtime;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.user_id = "";
/*   29 */     this.qqid = 0L;
/*   30 */     this.name = "";
/*   31 */     this.gender = 0;
/*   32 */     this.occupationid = 0;
/*   33 */     this.createtime = 0L;
/*      */   }
/*      */   
/*      */   Basic(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.user_id = "";
/*   40 */     this.name = "";
/*      */   }
/*      */   
/*      */   public Basic()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Basic(Basic _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Basic(xbean.Basic _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof Basic)) { assign((Basic)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Basic _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.user_id = _o_.user_id;
/*   66 */     this.qqid = _o_.qqid;
/*   67 */     this.name = _o_.name;
/*   68 */     this.gender = _o_.gender;
/*   69 */     this.occupationid = _o_.occupationid;
/*   70 */     this.createtime = _o_.createtime;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   75 */     this.user_id = _o_.user_id;
/*   76 */     this.qqid = _o_.qqid;
/*   77 */     this.name = _o_.name;
/*   78 */     this.gender = _o_.gender;
/*   79 */     this.occupationid = _o_.occupationid;
/*   80 */     this.createtime = _o_.createtime;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   86 */     _xdb_verify_unsafe_();
/*   87 */     _os_.marshal(this.user_id, "UTF-16LE");
/*   88 */     _os_.marshal(this.qqid);
/*   89 */     _os_.marshal(this.name, "UTF-16LE");
/*   90 */     _os_.marshal(this.gender);
/*   91 */     _os_.marshal(this.occupationid);
/*   92 */     _os_.marshal(this.createtime);
/*   93 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*   99 */     _xdb_verify_unsafe_();
/*  100 */     this.user_id = _os_.unmarshal_String("UTF-16LE");
/*  101 */     this.qqid = _os_.unmarshal_long();
/*  102 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*  103 */     this.gender = _os_.unmarshal_int();
/*  104 */     this.occupationid = _os_.unmarshal_int();
/*  105 */     this.createtime = _os_.unmarshal_long();
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
/*  116 */       _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.user_id, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  120 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  122 */     _size_ += CodedOutputStream.computeInt64Size(2, this.qqid);
/*      */     try
/*      */     {
/*  125 */       _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  129 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  131 */     _size_ += CodedOutputStream.computeInt32Size(4, this.gender);
/*  132 */     _size_ += CodedOutputStream.computeInt32Size(5, this.occupationid);
/*  133 */     _size_ += CodedOutputStream.computeInt64Size(6, this.createtime);
/*  134 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  140 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  143 */       _output_.writeBytes(1, ByteString.copyFrom(this.user_id, "UTF-16LE"));
/*  144 */       _output_.writeInt64(2, this.qqid);
/*  145 */       _output_.writeBytes(3, ByteString.copyFrom(this.name, "UTF-16LE"));
/*  146 */       _output_.writeInt32(4, this.gender);
/*  147 */       _output_.writeInt32(5, this.occupationid);
/*  148 */       _output_.writeInt64(6, this.createtime);
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
/*  176 */           this.user_id = _input_.readBytes().toString("UTF-16LE");
/*  177 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  181 */           this.qqid = _input_.readInt64();
/*  182 */           break;
/*      */         
/*      */ 
/*      */         case 26: 
/*  186 */           this.name = _input_.readBytes().toString("UTF-16LE");
/*  187 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  191 */           this.gender = _input_.readInt32();
/*  192 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  196 */           this.occupationid = _input_.readInt32();
/*  197 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  201 */           this.createtime = _input_.readInt64();
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
/*      */   public xbean.Basic copy()
/*      */   {
/*  229 */     _xdb_verify_unsafe_();
/*  230 */     return new Basic(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Basic toData()
/*      */   {
/*  236 */     _xdb_verify_unsafe_();
/*  237 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Basic toBean()
/*      */   {
/*  242 */     _xdb_verify_unsafe_();
/*  243 */     return new Basic(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Basic toDataIf()
/*      */   {
/*  249 */     _xdb_verify_unsafe_();
/*  250 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Basic toBeanIf()
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
/*      */   public String getUser_id()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return this.user_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getUser_idOctets()
/*      */   {
/*  278 */     _xdb_verify_unsafe_();
/*  279 */     return Octets.wrap(getUser_id(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getQqid()
/*      */   {
/*  286 */     _xdb_verify_unsafe_();
/*  287 */     return this.qqid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getName()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return this.name;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getNameOctets()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return Octets.wrap(getName(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGender()
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*  311 */     return this.gender;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getOccupationid()
/*      */   {
/*  318 */     _xdb_verify_unsafe_();
/*  319 */     return this.occupationid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCreatetime()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*  327 */     return this.createtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUser_id(String _v_)
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     if (null == _v_)
/*  336 */       throw new NullPointerException();
/*  337 */     xdb.Logs.logIf(new LogKey(this, "user_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  341 */         new xdb.logs.LogString(this, Basic.this.user_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  345 */             Basic.this.user_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  349 */     });
/*  350 */     this.user_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUser_idOctets(Octets _v_)
/*      */   {
/*  357 */     _xdb_verify_unsafe_();
/*  358 */     setUser_id(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setQqid(long _v_)
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*  366 */     xdb.Logs.logIf(new LogKey(this, "qqid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  370 */         new xdb.logs.LogLong(this, Basic.this.qqid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  374 */             Basic.this.qqid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  378 */     });
/*  379 */     this.qqid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName(String _v_)
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*  387 */     if (null == _v_)
/*  388 */       throw new NullPointerException();
/*  389 */     xdb.Logs.logIf(new LogKey(this, "name")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  393 */         new xdb.logs.LogString(this, Basic.this.name)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  397 */             Basic.this.name = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  401 */     });
/*  402 */     this.name = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNameOctets(Octets _v_)
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     setName(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGender(int _v_)
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     xdb.Logs.logIf(new LogKey(this, "gender")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  422 */         new xdb.logs.LogInt(this, Basic.this.gender)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  426 */             Basic.this.gender = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  430 */     });
/*  431 */     this.gender = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOccupationid(int _v_)
/*      */   {
/*  438 */     _xdb_verify_unsafe_();
/*  439 */     xdb.Logs.logIf(new LogKey(this, "occupationid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  443 */         new xdb.logs.LogInt(this, Basic.this.occupationid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  447 */             Basic.this.occupationid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  451 */     });
/*  452 */     this.occupationid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCreatetime(long _v_)
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*  460 */     xdb.Logs.logIf(new LogKey(this, "createtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  464 */         new xdb.logs.LogLong(this, Basic.this.createtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  468 */             Basic.this.createtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  472 */     });
/*  473 */     this.createtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  479 */     _xdb_verify_unsafe_();
/*  480 */     Basic _o_ = null;
/*  481 */     if ((_o1_ instanceof Basic)) { _o_ = (Basic)_o1_;
/*  482 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  483 */       return false;
/*  484 */     if (!this.user_id.equals(_o_.user_id)) return false;
/*  485 */     if (this.qqid != _o_.qqid) return false;
/*  486 */     if (!this.name.equals(_o_.name)) return false;
/*  487 */     if (this.gender != _o_.gender) return false;
/*  488 */     if (this.occupationid != _o_.occupationid) return false;
/*  489 */     if (this.createtime != _o_.createtime) return false;
/*  490 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  496 */     _xdb_verify_unsafe_();
/*  497 */     int _h_ = 0;
/*  498 */     _h_ += this.user_id.hashCode();
/*  499 */     _h_ = (int)(_h_ + this.qqid);
/*  500 */     _h_ += this.name.hashCode();
/*  501 */     _h_ += this.gender;
/*  502 */     _h_ += this.occupationid;
/*  503 */     _h_ = (int)(_h_ + this.createtime);
/*  504 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  510 */     _xdb_verify_unsafe_();
/*  511 */     StringBuilder _sb_ = new StringBuilder();
/*  512 */     _sb_.append("(");
/*  513 */     _sb_.append("'").append(this.user_id).append("'");
/*  514 */     _sb_.append(",");
/*  515 */     _sb_.append(this.qqid);
/*  516 */     _sb_.append(",");
/*  517 */     _sb_.append("'").append(this.name).append("'");
/*  518 */     _sb_.append(",");
/*  519 */     _sb_.append(this.gender);
/*  520 */     _sb_.append(",");
/*  521 */     _sb_.append(this.occupationid);
/*  522 */     _sb_.append(",");
/*  523 */     _sb_.append(this.createtime);
/*  524 */     _sb_.append(")");
/*  525 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  531 */     ListenableBean lb = new ListenableBean();
/*  532 */     lb.add(new ListenableChanged().setVarName("user_id"));
/*  533 */     lb.add(new ListenableChanged().setVarName("qqid"));
/*  534 */     lb.add(new ListenableChanged().setVarName("name"));
/*  535 */     lb.add(new ListenableChanged().setVarName("gender"));
/*  536 */     lb.add(new ListenableChanged().setVarName("occupationid"));
/*  537 */     lb.add(new ListenableChanged().setVarName("createtime"));
/*  538 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Basic {
/*      */     private Const() {}
/*      */     
/*      */     Basic nThis() {
/*  545 */       return Basic.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  551 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Basic copy()
/*      */     {
/*  557 */       return Basic.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Basic toData()
/*      */     {
/*  563 */       return Basic.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Basic toBean()
/*      */     {
/*  568 */       return Basic.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Basic toDataIf()
/*      */     {
/*  574 */       return Basic.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Basic toBeanIf()
/*      */     {
/*  579 */       return Basic.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getUser_id()
/*      */     {
/*  586 */       Basic.this._xdb_verify_unsafe_();
/*  587 */       return Basic.this.user_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getUser_idOctets()
/*      */     {
/*  594 */       Basic.this._xdb_verify_unsafe_();
/*  595 */       return Basic.this.getUser_idOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getQqid()
/*      */     {
/*  602 */       Basic.this._xdb_verify_unsafe_();
/*  603 */       return Basic.this.qqid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName()
/*      */     {
/*  610 */       Basic.this._xdb_verify_unsafe_();
/*  611 */       return Basic.this.name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNameOctets()
/*      */     {
/*  618 */       Basic.this._xdb_verify_unsafe_();
/*  619 */       return Basic.this.getNameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGender()
/*      */     {
/*  626 */       Basic.this._xdb_verify_unsafe_();
/*  627 */       return Basic.this.gender;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOccupationid()
/*      */     {
/*  634 */       Basic.this._xdb_verify_unsafe_();
/*  635 */       return Basic.this.occupationid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreatetime()
/*      */     {
/*  642 */       Basic.this._xdb_verify_unsafe_();
/*  643 */       return Basic.this.createtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUser_id(String _v_)
/*      */     {
/*  650 */       Basic.this._xdb_verify_unsafe_();
/*  651 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUser_idOctets(Octets _v_)
/*      */     {
/*  658 */       Basic.this._xdb_verify_unsafe_();
/*  659 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setQqid(long _v_)
/*      */     {
/*  666 */       Basic.this._xdb_verify_unsafe_();
/*  667 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName(String _v_)
/*      */     {
/*  674 */       Basic.this._xdb_verify_unsafe_();
/*  675 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNameOctets(Octets _v_)
/*      */     {
/*  682 */       Basic.this._xdb_verify_unsafe_();
/*  683 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGender(int _v_)
/*      */     {
/*  690 */       Basic.this._xdb_verify_unsafe_();
/*  691 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOccupationid(int _v_)
/*      */     {
/*  698 */       Basic.this._xdb_verify_unsafe_();
/*  699 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreatetime(long _v_)
/*      */     {
/*  706 */       Basic.this._xdb_verify_unsafe_();
/*  707 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  713 */       Basic.this._xdb_verify_unsafe_();
/*  714 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  720 */       Basic.this._xdb_verify_unsafe_();
/*  721 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  727 */       return Basic.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  733 */       return Basic.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  739 */       Basic.this._xdb_verify_unsafe_();
/*  740 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  746 */       return Basic.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  752 */       return Basic.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  758 */       Basic.this._xdb_verify_unsafe_();
/*  759 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  765 */       return Basic.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  771 */       return Basic.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  777 */       return Basic.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  783 */       return Basic.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  789 */       return Basic.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  795 */       return Basic.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  801 */       return Basic.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Basic
/*      */   {
/*      */     private String user_id;
/*      */     
/*      */     private long qqid;
/*      */     
/*      */     private String name;
/*      */     
/*      */     private int gender;
/*      */     
/*      */     private int occupationid;
/*      */     
/*      */     private long createtime;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  823 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  828 */       this.user_id = "";
/*  829 */       this.name = "";
/*      */     }
/*      */     
/*      */     Data(xbean.Basic _o1_)
/*      */     {
/*  834 */       if ((_o1_ instanceof Basic)) { assign((Basic)_o1_);
/*  835 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  836 */       } else if ((_o1_ instanceof Basic.Const)) assign(((Basic.Const)_o1_).nThis()); else {
/*  837 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Basic _o_) {
/*  842 */       this.user_id = _o_.user_id;
/*  843 */       this.qqid = _o_.qqid;
/*  844 */       this.name = _o_.name;
/*  845 */       this.gender = _o_.gender;
/*  846 */       this.occupationid = _o_.occupationid;
/*  847 */       this.createtime = _o_.createtime;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  852 */       this.user_id = _o_.user_id;
/*  853 */       this.qqid = _o_.qqid;
/*  854 */       this.name = _o_.name;
/*  855 */       this.gender = _o_.gender;
/*  856 */       this.occupationid = _o_.occupationid;
/*  857 */       this.createtime = _o_.createtime;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  863 */       _os_.marshal(this.user_id, "UTF-16LE");
/*  864 */       _os_.marshal(this.qqid);
/*  865 */       _os_.marshal(this.name, "UTF-16LE");
/*  866 */       _os_.marshal(this.gender);
/*  867 */       _os_.marshal(this.occupationid);
/*  868 */       _os_.marshal(this.createtime);
/*  869 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  875 */       this.user_id = _os_.unmarshal_String("UTF-16LE");
/*  876 */       this.qqid = _os_.unmarshal_long();
/*  877 */       this.name = _os_.unmarshal_String("UTF-16LE");
/*  878 */       this.gender = _os_.unmarshal_int();
/*  879 */       this.occupationid = _os_.unmarshal_int();
/*  880 */       this.createtime = _os_.unmarshal_long();
/*  881 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  887 */       int _size_ = 0;
/*      */       try
/*      */       {
/*  890 */         _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.user_id, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/*  894 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*  896 */       _size_ += CodedOutputStream.computeInt64Size(2, this.qqid);
/*      */       try
/*      */       {
/*  899 */         _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/*  903 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*  905 */       _size_ += CodedOutputStream.computeInt32Size(4, this.gender);
/*  906 */       _size_ += CodedOutputStream.computeInt32Size(5, this.occupationid);
/*  907 */       _size_ += CodedOutputStream.computeInt64Size(6, this.createtime);
/*  908 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  916 */         _output_.writeBytes(1, ByteString.copyFrom(this.user_id, "UTF-16LE"));
/*  917 */         _output_.writeInt64(2, this.qqid);
/*  918 */         _output_.writeBytes(3, ByteString.copyFrom(this.name, "UTF-16LE"));
/*  919 */         _output_.writeInt32(4, this.gender);
/*  920 */         _output_.writeInt32(5, this.occupationid);
/*  921 */         _output_.writeInt64(6, this.createtime);
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
/*  948 */             this.user_id = _input_.readBytes().toString("UTF-16LE");
/*  949 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  953 */             this.qqid = _input_.readInt64();
/*  954 */             break;
/*      */           
/*      */ 
/*      */           case 26: 
/*  958 */             this.name = _input_.readBytes().toString("UTF-16LE");
/*  959 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  963 */             this.gender = _input_.readInt32();
/*  964 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  968 */             this.occupationid = _input_.readInt32();
/*  969 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  973 */             this.createtime = _input_.readInt64();
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
/*      */     public xbean.Basic copy()
/*      */     {
/* 1001 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Basic toData()
/*      */     {
/* 1007 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Basic toBean()
/*      */     {
/* 1012 */       return new Basic(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Basic toDataIf()
/*      */     {
/* 1018 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Basic toBeanIf()
/*      */     {
/* 1023 */       return new Basic(this, null, null);
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
/*      */     public String getUser_id()
/*      */     {
/* 1060 */       return this.user_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getUser_idOctets()
/*      */     {
/* 1067 */       return Octets.wrap(getUser_id(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getQqid()
/*      */     {
/* 1074 */       return this.qqid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName()
/*      */     {
/* 1081 */       return this.name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNameOctets()
/*      */     {
/* 1088 */       return Octets.wrap(getName(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGender()
/*      */     {
/* 1095 */       return this.gender;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOccupationid()
/*      */     {
/* 1102 */       return this.occupationid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreatetime()
/*      */     {
/* 1109 */       return this.createtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUser_id(String _v_)
/*      */     {
/* 1116 */       if (null == _v_)
/* 1117 */         throw new NullPointerException();
/* 1118 */       this.user_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUser_idOctets(Octets _v_)
/*      */     {
/* 1125 */       setUser_id(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setQqid(long _v_)
/*      */     {
/* 1132 */       this.qqid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName(String _v_)
/*      */     {
/* 1139 */       if (null == _v_)
/* 1140 */         throw new NullPointerException();
/* 1141 */       this.name = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNameOctets(Octets _v_)
/*      */     {
/* 1148 */       setName(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGender(int _v_)
/*      */     {
/* 1155 */       this.gender = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOccupationid(int _v_)
/*      */     {
/* 1162 */       this.occupationid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreatetime(long _v_)
/*      */     {
/* 1169 */       this.createtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1175 */       if (!(_o1_ instanceof Data)) return false;
/* 1176 */       Data _o_ = (Data)_o1_;
/* 1177 */       if (!this.user_id.equals(_o_.user_id)) return false;
/* 1178 */       if (this.qqid != _o_.qqid) return false;
/* 1179 */       if (!this.name.equals(_o_.name)) return false;
/* 1180 */       if (this.gender != _o_.gender) return false;
/* 1181 */       if (this.occupationid != _o_.occupationid) return false;
/* 1182 */       if (this.createtime != _o_.createtime) return false;
/* 1183 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1189 */       int _h_ = 0;
/* 1190 */       _h_ += this.user_id.hashCode();
/* 1191 */       _h_ = (int)(_h_ + this.qqid);
/* 1192 */       _h_ += this.name.hashCode();
/* 1193 */       _h_ += this.gender;
/* 1194 */       _h_ += this.occupationid;
/* 1195 */       _h_ = (int)(_h_ + this.createtime);
/* 1196 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1202 */       StringBuilder _sb_ = new StringBuilder();
/* 1203 */       _sb_.append("(");
/* 1204 */       _sb_.append("'").append(this.user_id).append("'");
/* 1205 */       _sb_.append(",");
/* 1206 */       _sb_.append(this.qqid);
/* 1207 */       _sb_.append(",");
/* 1208 */       _sb_.append("'").append(this.name).append("'");
/* 1209 */       _sb_.append(",");
/* 1210 */       _sb_.append(this.gender);
/* 1211 */       _sb_.append(",");
/* 1212 */       _sb_.append(this.occupationid);
/* 1213 */       _sb_.append(",");
/* 1214 */       _sb_.append(this.createtime);
/* 1215 */       _sb_.append(")");
/* 1216 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Basic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */